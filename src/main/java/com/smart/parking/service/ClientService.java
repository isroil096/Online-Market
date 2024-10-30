package com.smart.parking.service;

import com.smart.parking.dto.ClientDto;
import com.smart.parking.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    void addClient(ClientDto clientDto);

    void updateClient(ClientDto clientDto, Long id);

    void deleteClient(Long id);

    List<Client> getAll();
}
