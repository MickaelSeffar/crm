package com.seffar.crm;

import com.seffar.crm.dao.ClientState;
import com.seffar.crm.dao.entity.Client;
import com.seffar.crm.dao.repository.ClientRepository;
import com.seffar.crm.dao.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClientRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;


    @Test
    void testFindAll(){
        System.out.println(clientRepository.findAll());
    }
    @Test
    void testSaveClient(){
        Client client = new Client("Sopra","Mickaël","Seffar","mickael@gmail.com","0688118751","21 Bd Babin Chevaye","44200","Nantes","France", ClientState.INACTIVE);
            clientRepository.save(client);
    }


}
