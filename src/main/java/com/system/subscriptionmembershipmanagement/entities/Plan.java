package com.system.subscriptionmembershipmanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plans")
@Getter
@Setter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "duration_in_days")
    private int duration;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at",insertable = false,updatable = false)
    private LocalDateTime created_at;

    public LocalDate calculateEndDate(LocalDate startDate) {
        return startDate.plusDays(this.duration);
    }
}
