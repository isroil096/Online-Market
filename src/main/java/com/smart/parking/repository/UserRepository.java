package com.smart.parking.repository;

import java.util.Optional;

import com.smart.parking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE phone_number =:phone_number")
    Optional<User> findByPhoneNumber(@Param("phone_number") String phoneNumber);

}
