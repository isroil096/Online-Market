package com.smart.parking.service;

import com.smart.parking.dto.SellerRequest;
import com.smart.parking.dto.SellerRequestDto;
import com.smart.parking.entity.Seller;
import com.smart.parking.entity.User;
import com.smart.parking.entity.constants.CarCity;
import com.smart.parking.entity.constants.CarColor;
import com.smart.parking.entity.constants.CarName;
import com.smart.parking.exception.BadRequest;
import com.smart.parking.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor

public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public void addCar(SellerRequestDto sellerRequestDto, User user) {
        Seller seller = dtoCard(sellerRequestDto);
        seller.setColor(sellerRequestDto.getColor());
        seller.setName(sellerRequestDto.getName());
        seller.setCity(sellerRequestDto.getCity());
        seller.setPhone(sellerRequestDto.getPhone());
        seller.setYear(sellerRequestDto.getYear());
        seller.setPrice(sellerRequestDto.getPrice());
        seller.setModel(sellerRequestDto.getModel());
        seller.setType(sellerRequestDto.getType());
        seller.setUser(user);
        sellerRepository.save(seller);
    }


    @Override
    public void updateCar(Long id, SellerRequestDto sellerRequestDto) {
        Seller seller = sellerRepository.findById(id).orElseThrow();
        seller.setColor(sellerRequestDto.getColor());
        seller.setName(sellerRequestDto.getName());
        seller.setCity(sellerRequestDto.getCity());
        seller.setPhone(sellerRequestDto.getPhone());
        seller.setYear(sellerRequestDto.getYear());
        seller.setPrice(sellerRequestDto.getPrice());
        seller.setModel(sellerRequestDto.getModel());
        seller.setType(sellerRequestDto.getType());
        sellerRepository.save(seller);
    }


    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }



    @Override
    public void deleteCar(Long id) {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (byId.isEmpty()){
            throw new BadRequest("card Not Found");
        }else {
            sellerRepository.delete(byId.get());
        }

    }

    @Override
    public SellerRequest seller(Seller seller) {
        return SellerRequest.builder()
                .id(seller.getId())
                .city(seller.getCity())
                .name(seller.getName())
                .year(seller.getYear())
                .type(seller.getType())
                .color(seller.getColor())
                .model(seller.getModel())
                .price(seller.getPrice()).build();
    }

    @Override
    public Optional<List<Seller>> findByUserId(Long id) {
        return sellerRepository.findByUserId(id);
    }

    public List<Seller> findByName(CarName name){
        return sellerRepository.findByName(name);
    }

    @Override
    public List<Seller> findByColor(CarColor color) {
        return sellerRepository.findByColor(color);
    }

    @Override
    public List<Seller> findByCity(CarCity city) {
        return sellerRepository.findByCity(city);
    }

    @Override
    public List<Seller> findByCityAndColor(CarCity city, CarColor color) {
        return sellerRepository.findByCityAndColor(city, color);
    }

    @Override
    public List<Seller> findByCityAndName(CarCity city, CarName name) {
        return sellerRepository.findByCityAndName(city, name);
    }

    @Override
    public List<Seller> findByColorAndName(CarColor color, CarName name) {
        return sellerRepository.findByColorAndName(color, name);
    }

    @Override
    public List<Seller> findByCityAndNameAndColor(CarCity city, CarName name, CarColor color) {
        return sellerRepository.findByCityAndColorAndName(city, color, name);
    }

    public Seller dtoCard(SellerRequestDto sellerRequestDto) {
        Seller seller = new Seller();
        seller.setColor(sellerRequestDto.getColor());
        seller.setCity(sellerRequestDto.getCity());
        seller.setName(sellerRequestDto.getName());
        seller.setPhone(sellerRequestDto.getPhone());
        seller.setYear(sellerRequestDto.getYear());
        seller.setPrice(sellerRequestDto.getPrice());
        seller.setModel(sellerRequestDto.getModel());
        seller.setType(sellerRequestDto.getType());
        return seller;
    }
}
