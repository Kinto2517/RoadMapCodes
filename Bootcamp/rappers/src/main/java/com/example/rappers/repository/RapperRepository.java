package com.example.rappers.repository;

import com.example.rappers.entity.Rapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapperRepository extends JpaRepository<Rapper, Long> {
}