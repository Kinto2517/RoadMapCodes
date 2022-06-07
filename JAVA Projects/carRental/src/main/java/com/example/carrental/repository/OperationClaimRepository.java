package com.example.carrental.repository;

import com.example.carrental.entity.OperationClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationClaimRepository extends JpaRepository<OperationClaim, Integer> {

    OperationClaim findByClaimName(String claimName);
}