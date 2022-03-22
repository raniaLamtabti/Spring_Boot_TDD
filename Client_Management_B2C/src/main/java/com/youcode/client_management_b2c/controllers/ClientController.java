package com.youcode.client_management_b2c.controllers;

import com.youcode.client_management_b2c.entities.Client;
import com.youcode.client_management_b2c.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<Client> getClients(){

        return clientService.getClients();
    }

    @GetMapping("{clientId:^\\d+$}")
    public Optional<Client> getClientById(@PathVariable("clientId") Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("{email:.+@.+\\..+}")
    public Optional<Client> getClientByEmail(@PathVariable("email") String email) {
        return clientService.getClientByEmail(email);
    }
}
