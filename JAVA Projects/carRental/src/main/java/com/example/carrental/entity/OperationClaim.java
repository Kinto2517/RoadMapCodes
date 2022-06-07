package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "operation_claim")
public class OperationClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private int claimId;

    @Column(name = "claim_name")
    private String claimName;

    @OneToOne
    @JsonIgnore
    private Customer customer;
}