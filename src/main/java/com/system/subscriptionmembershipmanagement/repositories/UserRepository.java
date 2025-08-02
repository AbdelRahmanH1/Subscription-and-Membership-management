package com.system.subscriptionmembershipmanagement.repositories;

import com.system.subscriptionmembershipmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
