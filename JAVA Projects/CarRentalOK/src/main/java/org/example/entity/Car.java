package org.example.entity;

import java.util.Date;

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "price")
    private double dailyPrice;

    @Column(name = "price_start_day")
    private Date priceStartDay;

    @Column(name = "price_expiration_day")
    private Date priceExpirationDay;

    @ManyToOne
    @JoinColumn(name = "car_type")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "rented_day")
    private CarRentDay carRentDay;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
