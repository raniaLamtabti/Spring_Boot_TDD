package com.youcode.client_management_b2c.controllers;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.services.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(MockitoJUnitRunner.Silent.class)
@WebMvcTest(ClientController.class)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    void addClients() throws Exception {
        Client client = new Client(1L, "test1@gmail.com", "0659697087", "test1", 12, "F", true);

        when(clientService.save(client))
                .thenReturn(client);

        mockMvc.perform(post("/api/clients/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(client)))
                .andExpect(status().isOk());
    }

    @Test
    void getClients() throws Exception {
        Client client = new Client(1L, "test1@gmail.com", "0654321785", "test1", 23, "F", true);
        Client client1 = new Client(2L, "test2@gmail.com", "0654321785", "test2", 23, "M", true);

        List<Client> list = new ArrayList<>();

        list.add(client);
        list.add(client1);

        when(clientService.getClients()).thenReturn(list);
        mockMvc.perform(get("/api/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void getClientById() throws Exception {
        Client client = new Client(1L, "test1@gmail.com", "+212659697087", "test1", 12, "female", true);
        when(clientService.getClientById(client.getId())).thenReturn(java.util.Optional.of(client));
        mockMvc.perform(get("/api/clients/" + client.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClientByEmail() throws Exception {
        Client client = new Client(1L, "test1@gmail.com","+212659697087","test1",12,"male",true);
        when(clientService.getClientByEmail(client.getEmail())).thenReturn(java.util.Optional.of(client));
        mockMvc.perform(get("/api/clients/" + client.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClientsByGender() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void updateClient() {
    }
}