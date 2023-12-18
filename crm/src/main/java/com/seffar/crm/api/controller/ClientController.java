package com.seffar.crm.api.controller;

import com.seffar.crm.api.dtos.ClientDTO;
import com.seffar.crm.api.mapper.ClientMapper;
import com.seffar.crm.business.ClientService;
import com.seffar.crm.dao.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public  List<ClientDTO> getAll(){
        List<Client> clients = clientService.getclients();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (Client client : clients)
            clientDTOS.add(ClientMapper.convertToDto(client));
        return clientDTOS;
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<ClientDTO> getOne(@PathVariable("id") Integer id){
        Optional<Client> optionalClient = clientService.getClientById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            ClientDTO clientDto = ClientMapper.convertToDto(client);
            return ResponseEntity.ok(clientDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addClient(@RequestBody ClientDTO clientDto){
        Client client = ClientMapper.convertToEntity(clientDto);
        clientService.addClient(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("id") Integer id){
        Optional<Client> optionalClient = clientService.getClientById(id);
        if (optionalClient.isPresent()){
            clientService.deleteClient(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("clients/{id}")
    public ResponseEntity<Client> UpdateClient(@PathVariable Integer id, @RequestBody Client client) {
        Optional<Client> existingCLient = clientService.getClientById(id);
        return existingCLient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
