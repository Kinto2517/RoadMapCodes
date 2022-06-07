package com.example.carrental.repository;

import com.example.carrental.entity.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarRentRepository extends JpaRepository<CarRent, Integer> {

    @Query("From CarRent c where c.rentDay = :rentDay and c.returnDay = :returnDay")
    List<CarRent> getCarRentDaysByRentAndReturnDay(Date rentDay, Date returnDay);
    }

