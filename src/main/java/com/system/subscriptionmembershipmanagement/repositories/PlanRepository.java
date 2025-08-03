package com.system.subscriptionmembershipmanagement.repositories;

import com.system.subscriptionmembershipmanagement.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    boolean existsByNameIgnoreCase(String name);

    @Modifying
    @Query("DELETE FROM Plan p where p.id = :planId")
    int deleteByIdIfExists(@Param("planId") Long planId);
}
