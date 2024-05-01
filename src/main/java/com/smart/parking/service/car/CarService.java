package com.smart.parking.service.car;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;

import java.util.List;

public interface CarService {

    void save(CarRequest request);

    CarRequest findByNumberPlate(String numberPlate);

    void update(Integer user_id, CarRequest request);

    List<Car> findAll();

}
