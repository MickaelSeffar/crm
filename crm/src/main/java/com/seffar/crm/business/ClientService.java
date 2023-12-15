package com.seffar.crm.business;

import com.seffar.crm.dao.entity.Client;
import com.seffar.crm.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getclients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    // Attention si l'id dans l'objet cadeau n'existe pas
    // dans la table SQL alors Hibernate va faire un INSERT
    public Client update(Client client) {
        clientRepository.save(client);
        return client;
    }

}
