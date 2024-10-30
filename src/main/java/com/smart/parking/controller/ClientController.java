package com.smart.parking.controller;

import com.smart.parking.dto.ClientDto;
import com.smart.parking.entity.Motorbike;
import com.smart.parking.entity.Seller;
import com.smart.parking.entity.Client;
import com.smart.parking.entity.constants.*;
import com.smart.parking.service.MotoService;
import com.smart.parking.service.SellerService;
import com.smart.parking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;
    private final SellerService sellerService;
    private final MotoService motoService;

    @GetMapping("get/all")
    public List<Client> findAll() {
       return clientService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        clientService.addClient(clientDto);
        return ResponseEntity.ok().body(clientDto);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
         clientService.updateClient(clientDto, id);
         return ResponseEntity.ok().body(clientDto);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/get/car/all")
    public List<Seller> getAllCards() {
        return sellerService.findAll();
    }


    @GetMapping("/get/car/city/{city}")
    public List<Seller> getCarByCity(@PathVariable CarCity city) {
        return sellerService.findByCity(city);
    }

    @GetMapping("/get/car/name/{name}")
    public List<Seller> getCarByName(@PathVariable CarName name) {
        return sellerService.findByName(name);
    }

    @GetMapping("/get/car/color/{color}")
    public List<Seller> getCarByColor(@PathVariable CarColor color) {
        return sellerService.findByColor(color);
    }

    // Qo'shimcha o'zgartirishlar
    @GetMapping("/get/car/color/{color}/name/{name}")
    public List<Seller> getCarByColorAndName(@PathVariable CarColor color, @PathVariable CarName name) {
        return sellerService.findByColorAndName(color, name);
    }

    @GetMapping("/get/car/city/{city}/name/{name}")
    public List<Seller> getCarByCityAndName(@PathVariable CarCity city, @PathVariable CarName name) {
        return sellerService.findByCityAndName(city, name);
    }

    @GetMapping("/get/car/city/{city}/color/{color}")
    public List<Seller> getCarByCityAndColor(@PathVariable CarCity city, @PathVariable CarColor color) {
        return sellerService.findByCityAndColor(city, color);
    }

    @GetMapping("/get/car/city/{city}/color/{color}/name/{name}")
    public List<Seller> getCarByCityColorAndName(@PathVariable CarCity city, @PathVariable CarColor color, @PathVariable CarName name) {
        return sellerService.findByCityAndNameAndColor(city, name, color);
    }



    // Moto Get
    @GetMapping("/get/moto/all")
    public List<Motorbike> getAllMoto() {
        return motoService.findAll();
    }

    @GetMapping("/get/moto/color/{color}")
    public List<Motorbike> getMotoByColor(@PathVariable MotoColor color) {
        return motoService.findByColor(color);
    }

    // O'zgartirishlar
    @GetMapping("/get/moto/city/{city}")
    public List<Motorbike> getMotoByCity(@PathVariable MotoCity city) {
        return motoService.findByCity(city);
    }

    @GetMapping("/get/moto/make/{make}")
    public List<Motorbike> getMotoByMake(@PathVariable MotoMake make) {
        return motoService.findByMake(make);
    }

    // Qo'shimcha o'zgartirishlar
    @GetMapping("/get/moto/city/{city}/color/{color}")
    public List<Motorbike> getByCityAndColor(@PathVariable MotoCity city, @PathVariable MotoColor color) {
        return motoService.findByCityAndColor(city, color);
    }

    @GetMapping("/get/moto/city/{city}/make/{make}")
    public List<Motorbike> getByCityAndMake(@PathVariable MotoCity city, @PathVariable MotoMake make) {
        return motoService.findByMakeAndCity(make, city);
    }

    @GetMapping("/get/moto/color/{color}/make/{make}")
    public List<Motorbike> getByColorAndMake(@PathVariable MotoColor color, @PathVariable MotoMake make) {
        return motoService.findByMakeAndColor(make, color);
    }

    @GetMapping("/get/moto/city/{city}/color/{color}/make/{make}")
    public List<Motorbike> getByCityColorAndMake(@PathVariable MotoCity city, @PathVariable MotoColor color, @PathVariable MotoMake make) {
        return motoService.findByCityAndColorAndMake(city, color, make);
    }





}
