package com.youcode.client_management_b2c.services;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.repositories.ClientRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest

class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientService clientService;


    @Test
    void save() {
        Client client=new Client (1L,"testtesting@gmail.com","0654321896","testing",23,"F",true);

        when(clientRepository.save(client)).thenReturn(client);
        assertEquals(client, clientService.save(client));
    }

    @Test
    void getClients() {
        Client client1=new Client (1L,"testtesting2@gmail.com","0654321896","testing1",23,"F",true);
        Client client2=new Client (2L,"testtesting1@gmail.com","0654321896","testing2",23,"M",true);

        List<Client> list = new ArrayList<Client>();
        list.add(client1);
        list.add(client2);


        when(clientRepository.findAll()).thenReturn(list);
        assertEquals(2, clientService.getClients().size());
    }

    @Test
    void getClientById() {
        Optional<Client> client = Optional.of(new Client (1L,"testtesting@gmail.com","0654321896","testing",26,"F",true));


        when(clientRepository.findById(1L)).thenReturn(client);
        assertEquals(client, clientService.getClientById(1L));
    }

    @Test
    void getClientByEmail() {
        Optional<Client> client = Optional.of(new Client (1L,"testtesting@gmail.com","0654321896","testing",23,"F",true));


        when(clientRepository.findByEmail("testtesting@gmail.com")).thenReturn(client);
        assertEquals(client, clientService.getClientByEmail("testtesting@gmail.com"));
    }

    @Test
    void deleteClient() {
        Optional<Client> client = Optional.of(new Client (1L,"testtesting@gmail.com","0654321896","testing",26,"F",true));


        when(clientRepository.findById(1L)).thenReturn(client);
        clientService.deleteClient(1L);
    }

    @Test
    void updateClient() {
        Optional<Client> client = Optional.of(new Client (1L,"testtesting@gmail.com","0654321896","testing",23,"F",true));
        Client clientUpdate = new Client();

        clientUpdate.setEmail("testtestingu@gmail.com");
        clientUpdate.setFullName("test");
        clientUpdate.setGender("F");
        clientUpdate.setPhone("0654321896");
        clientUpdate.setAge(26);
        clientUpdate.setActive(true);
        clientService.updateClient(1L, clientUpdate);
    }
}