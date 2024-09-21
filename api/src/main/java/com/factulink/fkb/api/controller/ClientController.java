package com.factulink.fkb.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.factulink.fkb.api.model.Client;
import com.factulink.fkb.api.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Object> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable Integer id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }



}
