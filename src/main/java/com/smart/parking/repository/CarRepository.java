package com.smart.parking.repository;

import com.smart.parking.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {


    @Query("select u from Car u where u.phone=:phone")
    Optional<Car>findByPhone(@Param("phone") String phone);


    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE user_id =:user_id")
    Optional<List<Car>> findByUserId(@Param("user_id") Long id);



    void deleteByUserId(Long id);


}
