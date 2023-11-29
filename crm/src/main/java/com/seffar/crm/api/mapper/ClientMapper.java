package com.seffar.crm.api.mapper;

import com.seffar.crm.api.dtos.ClientDTO;
import com.seffar.crm.dao.entity.Client;

public class ClientMapper {

    private static ClientDTO convertToDto(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCompany_name(client.getCompany_name());
        clientDTO.setFirst_name(client.getFirst_name());
        clientDTO.setLast_name(client.getLast_name());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone_number(client.getPhone_number());
        clientDTO.setAdress(client.getAdress());
        clientDTO.setZip_code(client.getZip_code());
        clientDTO.setCity(client.getCity());
        clientDTO.setCountry(client.getCountry());
        clientDTO.setState(client.getState());
        return clientDTO;
    }

    public static Client convertToEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setCompany_name(clientDTO.getCompany_name());
        client.setFirst_name(clientDTO.getFirst_name());
        client.setLast_name(clientDTO.getLast_name());
        client.setEmail(client.getEmail());
        client.setPhone_number(clientDTO.getPhone_number());
        client.setAdress(clientDTO.getAdress());
        client.setZip_code(clientDTO.getZip_code());
        client.setCity(clientDTO.getCity());
        client.setCountry(clientDTO.getCountry());
        client.setState(clientDTO.getState());
        return client;
    }
}
