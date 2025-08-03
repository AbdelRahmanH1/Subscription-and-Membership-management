package com.system.subscriptionmembershipmanagement.services;

import com.system.subscriptionmembershipmanagement.dtos.SubscriptionResponse;
import com.system.subscriptionmembershipmanagement.entities.Payment;
import com.system.subscriptionmembershipmanagement.entities.Plan;
import com.system.subscriptionmembershipmanagement.entities.Subscription;
import com.system.subscriptionmembershipmanagement.entities.User;
import com.system.subscriptionmembershipmanagement.enums.PaymentStatus;
import com.system.subscriptionmembershipmanagement.enums.SubscriptionStatus;
import com.system.subscriptionmembershipmanagement.exceptions.PaymentFailedException;
import com.system.subscriptionmembershipmanagement.exceptions.PlanNotFound;
import com.system.subscriptionmembershipmanagement.exceptions.SubscriptionNotFound;
import com.system.subscriptionmembershipmanagement.exceptions.SubscriptionStillActiveException;
import com.system.subscriptionmembershipmanagement.mappers.SubscriptionMapper;
import com.system.subscriptionmembershipmanagement.repositories.PaymentRepository;
import com.system.subscriptionmembershipmanagement.repositories.PlanRepository;
import com.system.subscriptionmembershipmanagement.repositories.SubscriptionRepository;
import com.system.subscriptionmembershipmanagement.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final PlanRepository planRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final PaymentRepository paymentRepository;

    public SubscriptionResponse subscribe(Long planId) {

        var userId = SecurityUtil.getUserId();
        var user = new User();
        user.setId(userId);

        var plan = planRepository.findById(planId).orElseThrow(PlanNotFound::new);

        var now = LocalDate.now();
        var activeSubscription = subscriptionRepository.findByUserIdAndStatusAndEndDateAfter(userId, SubscriptionStatus.ACTIVE, now);

        if (activeSubscription.isPresent()) {
            throw new SubscriptionStillActiveException();
        }

        Payment payment = simulatePayment(user,plan);
        System.out.println("payment status: " + payment.getStatus());
        if(payment.getStatus() == PaymentStatus.FAILED){
            paymentRepository.save(payment);
            throw new PaymentFailedException();
        }
        Subscription subscription = createSubscription(user,plan);
        linkAndSavePayment(payment,subscription);

        return subscriptionMapper.toDto(subscription,payment);
    }
    private void linkAndSavePayment(Payment payment, Subscription subscription){
        payment.setSubscription(subscription);
        paymentRepository.save(payment);
    }
    private Payment simulatePayment(User user, Plan plan) {
        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(plan.getPrice());

        boolean isSuccess = new Random().nextBoolean();
        payment.setStatus(isSuccess ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        return payment;
    }

    private Subscription createSubscription(User user, Plan plan) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlan(plan);
        subscription.setDatesFromPlan();
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        return subscriptionRepository.save(subscription);
    }

    public SubscriptionResponse cancelSubscription(){
        Long userId = SecurityUtil.getUserId();
        LocalDate now = LocalDate.now();

        Subscription subscription = subscriptionRepository.findByUserIdAndStatusAndEndDateAfter(userId,SubscriptionStatus.ACTIVE,now)
                .orElseThrow(SubscriptionNotFound::new);

        subscription.setStatus(SubscriptionStatus.CANCELLED);
        subscription.setEndDate(now);
        subscriptionRepository.save(subscription);
        return subscriptionMapper.toDto(subscription);
    }
    public SubscriptionResponse getMySubscription() {
        Long userId = SecurityUtil.getUserId();
        LocalDate today = LocalDate.now();

        Subscription subscription = subscriptionRepository
                .findByUserIdAndStatusAndEndDateAfter(userId, SubscriptionStatus.ACTIVE, today)
                .orElseThrow(SubscriptionNotFound::new);

        Payment payment = paymentRepository.findBySubscriptionId(subscription.getId()).orElseThrow(SubscriptionNotFound::new);
        return subscriptionMapper.toDto(subscription,payment);
    }
}
