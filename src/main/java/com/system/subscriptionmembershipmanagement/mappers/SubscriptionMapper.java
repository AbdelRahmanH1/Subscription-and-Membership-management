package com.system.subscriptionmembershipmanagement.mappers;

import com.system.subscriptionmembershipmanagement.dtos.PaymentResponse;
import com.system.subscriptionmembershipmanagement.dtos.SubscriptionResponse;
import com.system.subscriptionmembershipmanagement.entities.Payment;
import com.system.subscriptionmembershipmanagement.entities.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    @Mapping(source = "plan.name", target = "planName")
    SubscriptionResponse toDto(Subscription subscription);

    default SubscriptionResponse toDto(Subscription subscription, Payment payment) {
        if (subscription == null) {
            return null; // Or throw an exception if this shouldn't happen
        }

        SubscriptionResponse response = toDto(subscription);

        if (response != null && payment != null) {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setAmount(payment.getAmount());
            paymentResponse.setStatus(payment.getStatus());
            response.setPayment(paymentResponse);
        }

        return response;
    }
}
