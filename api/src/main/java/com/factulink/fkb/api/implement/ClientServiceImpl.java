package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Client;
import com.factulink.fkb.api.repository.ClientRepository;
import com.factulink.fkb.api.service.ClientService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ClientRepository dao;


    @Override
    public ResponseEntity<Object> getClients() {
        List<Client> clients = dao.findAll();
        if (!clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> addClient(Client client) {
        Client savedClient = dao.save(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getClientById(Integer id) {
        Optional<Client> client = dao.findById(id);
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updateClient(Client client, Integer id) {

        Optional<Client> clientExist = dao.findById(id);
        if (clientExist.isPresent()){
            Client client1 = clientExist.get();
            client1.setNameClient(client1.getNameClient());
            dao.save(client1);
            return new ResponseEntity<>("Datos actualizados", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> deleteClient(Integer id) {
        Optional<Client> clientExist = dao.findById(id);
        if (clientExist.isPresent()) {
            dao.deleteById(id);
            return new ResponseEntity<>("Cliente eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    }




