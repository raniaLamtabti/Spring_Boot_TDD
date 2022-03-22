package com.youcode.client_management_b2c.repositories;

import com.youcode.client_management_b2c.entities.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;


    @Test
    void findByEmail() {
        Client client1 = new Client(1L, "test1@gmail.com","0659697087","test1",12,"F",true);
        Mockito.when(clientRepository.findByEmail("test1@gmail.com")).thenReturn(Optional.of(client1));
        assertThat(clientRepository.findByEmail("test1@gmail.com").get().getEmail()).isEqualTo("test1@gmail.com");
    }

   /* @Test
    void findByGender() {
        Client client1 = new Client(1L, "test1@gmail.com","0659697087","test1",12,"F",true);
        Client client2 = new Client(1L, "test1@gmail.com","0659697087","test1",12,"F",true);

        List<Client> list = new ArrayList<Client>();
        list.add(client1);
        list.add(client2);

        Mockito.when(clientRepository.findByGender("F")).thenReturn(Optional.of(list));
        assertThat(clientRepository.findByGender("F").getGender()).isEqualTo("F");
    }*/
}