package com.system.subscriptionmembershipmanagement.repositories;

import com.system.subscriptionmembershipmanagement.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
