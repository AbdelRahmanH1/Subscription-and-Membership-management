package com.system.subscriptionmembershipmanagement.repositories;

import com.system.subscriptionmembershipmanagement.entities.Subscription;
import com.system.subscriptionmembershipmanagement.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Optional<Subscription> findByUserIdAndStatusAndEndDateAfter(Long userId, SubscriptionStatus status, LocalDate now);

}
