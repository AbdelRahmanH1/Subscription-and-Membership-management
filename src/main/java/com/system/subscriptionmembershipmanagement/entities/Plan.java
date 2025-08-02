package com.system.subscriptionmembershipmanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    private int duration_in_days;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
