package com.smart.parking.service;

import com.smart.parking.dto.MotorbikeDto;
import com.smart.parking.entity.Motorbike;
import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MotoService {

    void addMoto(MotorbikeDto motorbikeDto);

    void updateMoto(Long id ,MotorbikeDto motorbikeDto);

    void deleteMoto(Long id);

    List<Motorbike> findAll();

    List<Motorbike> findByColor(MotoColor color);

    List<Motorbike> findByCity(MotoCity city);

    List<Motorbike> findByMake(MotoMake make);

    List<Motorbike> findByMakeAndCity(MotoMake make, MotoCity city);

    List<Motorbike> findByMakeAndColor(MotoMake make, MotoColor color);

    List<Motorbike> findByCityAndColor(MotoCity city, MotoColor color);

    List<Motorbike> findByCityAndColorAndMake(MotoCity city, MotoColor color, MotoMake make);



}
