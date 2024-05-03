package com.smart.parking.service.car;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.dto.ParkingRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.ParkingPlace;
import com.smart.parking.entity.User;
import com.smart.parking.exception.NotFoundException;
import com.smart.parking.repository.CarRepository;
import com.smart.parking.repository.ParkingPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;
    private final ParkingPlaceRepository parkingPlaceRepository;


    // TODO need to be deleted
    @Override
    public void save(CarRequest request, User user) {
        var car = Car.builder()
                .id(request.getId())
                .carName(request.getCarName())
                .numberPlate(request.getNumberPlate())
                .user(user)
                .build();
        repository.save(car);
    }

    @Override
    public CarRequest findByNumberPlate(String numberPlate) {
        Optional<Car> car = repository.findByLicense(numberPlate, false);
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

    @Override
    public void update(User user, CarRequest request) {
        List<Car> car = repository.findByUserId(user.getId(), false);
        for (Car car1 : car) {
            if (car1.getNumberPlate().equals(request.getNumberPlate())) {
                car1.setCarName(request.getCarName());
                car1.setNumberPlate(request.getNumberPlate());
                repository.save(car1);
            }
            throw new NotFoundException("CAR NOT FOUND");
        }
    }

    @Override
    public List<CarRequest> userCars(Long userId) {
        List<Car> cars = repository.findByUserId(userId, false);
        List<CarRequest> carRequests = new ArrayList<>();
        for (Car car : cars) {
            CarRequest build = CarRequest.builder()
                    .id(car.getId())
                    .carName(car.getCarName())
                    .numberPlate(car.getNumberPlate())
                    .build();
            carRequests.add(build);
        }

        return carRequests;
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll(Boolean.FALSE);
    }

    @Override
    public void saveCar(CarRequest carRequest, User user) {
        Car car = new Car();
        car.setCarName(carRequest.getCarName());
        car.setNumberPlate(carRequest.getNumberPlate());
        car.setUser(user);

        Set<ParkingPlace> parkingPlaces = new HashSet<>();
        Set<Car> cars = new HashSet<>();
        for (ParkingRequest parkingEntity : carRequest.getParking()) {
            ParkingPlace parkingPlace = new ParkingPlace();
            parkingPlace.setParkingName(parkingEntity.getParkingName());
            parkingPlace.setUser(user);
            parkingPlace.setParkedCars(cars);

            cars.add(car);
            parkingPlaces.add(parkingPlace);
            parkingPlaceRepository.save(parkingPlace);
        }

        car.setParkingPlaces(parkingPlaces);
        repository.save(car);
    }

    @Override
    public void delete(String numberPlate) {
        Optional<Car> car = repository.findByLicense(numberPlate, false);
        if (car.isPresent()) {
            car.get().setIsDeleted(true);
            repository.save(car.get());
        } else {
            throw new NotFoundException("Car not found");
        }
    }
}
