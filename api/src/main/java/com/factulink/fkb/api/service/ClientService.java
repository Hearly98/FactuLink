package com.factulink.fkb.api.service;


import com.factulink.fkb.api.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    public ResponseEntity<Object> getClients();
    public ResponseEntity<Object> addClient(Client client);
    public ResponseEntity<Object> getClientById(Integer id);
    public ResponseEntity<Object> updateClient(Client client, Integer id);
    public ResponseEntity<Object> deleteClient(Integer id);

}
