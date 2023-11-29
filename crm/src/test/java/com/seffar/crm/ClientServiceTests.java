package com.seffar.crm;

import com.seffar.crm.business.ClientService;
import com.seffar.crm.dao.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ClientServiceTests {

    @Autowired
    ClientService clientService;

    @Test
    public void testFindById(){
        Optional<Client> optionalOrder = clientService.getClientById(1);
        if (optionalOrder.isPresent()){
            Client client = optionalOrder.get();
            System.out.println(client);
        }
    }
}
