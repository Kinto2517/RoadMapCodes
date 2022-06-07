package com.example.carrental.repository;

import com.example.carrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByCarName(String carName, Pageable pageable);

    @Query("From Car c order by c.dailyPrice asc")
    List<Car> getSortedByPrice(Pageable pageable);

    @Query("From Car c where c.carType.car_type_id = :typeId")
    List<Car> getCarsByCarTypeId(int typeId, Pageable pageable);

    @Query("From Car c where c.carRentDate.rentDay < :rentDay and c.carRentDate.returnDay > :returnDay")
    List<Car> getCarsByEmptyDay(Date rentDay, Date returnDay, Pageable pageable);

    @Query("From Car c where c.company.companyId = :companyId")
    List<Car> getCarsByCompanyId(int companyId, Pageable pageable);
}