package com.youcode.client_management_b2c.controllers;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @PostMapping("/save")
    public void addClients(@RequestBody List<Client> clients){
        for (Client client : clients) {
            clientService.save(client);
        }
    }
}
