package com.smart.parking.service;

import com.smart.parking.dto.ClientDto;
import com.smart.parking.entity.Client;
import com.smart.parking.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void addClient(ClientDto clientDto) {
        Client client = dtoClient(clientDto);
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setPhone(clientDto.getPhone());
        clientRepository.save(client);
    }

    @Override
    public void updateClient(ClientDto clientDto, Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }



    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
    public Client dtoClient(ClientDto clientDto) {
        Client client = new Client();
        client.setEmail(clientDto.getEmail());
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        return client;
    }
}
