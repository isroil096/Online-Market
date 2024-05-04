package com.smart.parking.service.car;

import com.smart.parking.dto.car.CarGetRequest;
import com.smart.parking.dto.car.CarPostRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;

import java.util.List;

public interface CarService {

    void save(CarGetRequest request, User user);

    CarGetRequest findByNumberPlate(String numberPlate);

    void update(Long carId, CarPostRequest request);

    List<Car> findAll();

    void saveCar(CarPostRequest carRequest, User user);

    void delete(String numberPlate);

    List<CarGetRequest> userCars(Long userId);

}
