package com.smart.parking.service;

import com.smart.parking.dto.ClientDto;
import com.smart.parking.dto.MotorbikeDto;
import com.smart.parking.entity.Client;
import com.smart.parking.entity.Motorbike;
import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import com.smart.parking.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class MotoServiceImpl implements MotoService {
    private final MotoRepository motoRepository;
    @Override
    public void addMoto(MotorbikeDto motorbikeDto) {
        Motorbike motorbike = dtoMoto(motorbikeDto);
        motorbike.setMake(motorbikeDto.getMake());
        motorbike.setColor(motorbikeDto.getColor());
        motorbike.setYear(motorbikeDto.getYear());
        motorbike.setCity(motorbikeDto.getCity());
        motorbike.setName(motorbikeDto.getName());
        motoRepository.save(motorbike);

    }

    @Override
    public void updateMoto(Long id ,MotorbikeDto motorbikeDto) {
        Motorbike motorbike = motoRepository.findById(id).orElseThrow();
        motorbike.setMake(motorbikeDto.getMake());
        motorbike.setColor(motorbikeDto.getColor());
        motorbike.setYear(motorbikeDto.getYear());
        motorbike.setCity(motorbikeDto.getCity());
        motorbike.setName(motorbikeDto.getName());
        motoRepository.save(motorbike);
    }

    @Override
    public void deleteMoto(Long id) {
        motoRepository.deleteById(id);
    }

    @Override
    public List<Motorbike> findAll() {
        return motoRepository.findAll();
    }

    @Override
    public List<Motorbike> findByColor(MotoColor color) {
        return motoRepository.findByColor(color);
    }

    @Override
    public List<Motorbike> findByCity(MotoCity city) {
        return motoRepository.findByCity(city);
    }

    @Override
    public List<Motorbike> findByMake(MotoMake make) {
        return motoRepository.findByMake(make);
    }

    @Override
    public List<Motorbike> findByMakeAndCity(MotoMake make, MotoCity city) {
        return motoRepository.findByCityAndMake(city, make);
    }

    @Override
    public List<Motorbike> findByMakeAndColor(MotoMake make, MotoColor color) {
        return motoRepository.findByMakeAndColor(make, color);
    }

    @Override
    public List<Motorbike> findByCityAndColor(MotoCity city, MotoColor color) {
        return motoRepository.findByCityAndColor(city, color);
    }

    @Override
    public List<Motorbike> findByCityAndColorAndMake(MotoCity city, MotoColor color, MotoMake make) {
        return motoRepository.findByCityAndColorAndMake(city, color, make);
    }

    public Motorbike dtoMoto(MotorbikeDto motorbikeDto) {
        Motorbike motorbike = new Motorbike();
        motorbike.setYear(motorbikeDto.getYear());
        motorbike.setColor(motorbikeDto.getColor());
        motorbike.setMake(motorbikeDto.getMake());
        motorbike.setName(motorbikeDto.getName());
        motorbike.setCity(motorbikeDto.getCity());
        return motorbike;
    }


}
