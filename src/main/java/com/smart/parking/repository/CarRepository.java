package com.smart.parking.repository;

import com.smart.parking.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE number_plate =:licence")
    Optional<Car> findByLicense(@Param("licence") String license);

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE user_id =:user_id")
    Optional<Car> findByUserId(@Param("user_id") Integer userId);
}
