package com.smart.parking.repository;

import com.smart.parking.entity.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM car_parking WHERE car_id =:car_id")
    List<ParkingPlace> findByCarId(@Param("car_id") Long car_id);
}
