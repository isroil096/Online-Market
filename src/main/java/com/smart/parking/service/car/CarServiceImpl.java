package com.smart.parking.service.car;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.exception.NotFoundException;
import com.smart.parking.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    public void save(CarRequest request) {
        var car = Car.builder()
                .id(request.getId())
                .carName(request.getCarName())
                .numberPlate(request.getNumberPlate())
                .build();
        repository.save(car);
    }

    public CarRequest findByNumberPlate(String numberPlate) {
        Optional<Car> car = repository.findByLicense(numberPlate);
        if (car.isPresent()) {
            return CarRequest.builder()
                    .id(car.get().getId())
                    .carName(car.get().getCarName())
                    .numberPlate(car.get().getNumberPlate())
                    .build();
        } else {
            throw new NotFoundException("Car not found");
        }
    }

    public void update(Integer user_id, CarRequest request) {
        Optional<Car> car = repository.findByUserId(user_id);
        if (car.isPresent()) {
            Car carEntity = car.get();
            carEntity.setCarName(request.getCarName());
            carEntity.setNumberPlate(request.getNumberPlate());
            repository.save(carEntity);
        } else {
            throw new NotFoundException("Car not found");
        }
    }

    public List<Car> findAll() {
        return repository.findAll();
    }
}
