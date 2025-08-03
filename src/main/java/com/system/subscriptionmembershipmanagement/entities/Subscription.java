package com.system.subscriptionmembershipmanagement.entities;

import com.system.subscriptionmembershipmanagement.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscriptionStatus status = SubscriptionStatus.ACTIVE;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;


    public void setDatesFromPlan(){
        this.startDate = LocalDate.now();
        this.endDate = this.plan.calculateEndDate(this.startDate);
    }

//    @Transient
//    public boolean isActive() {
//        return status == SubscriptionStatus.ACTIVE && endDate != null && endDate.isAfter(LocalDate.now());
//    }

}
