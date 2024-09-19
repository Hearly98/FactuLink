package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Roles;
import com.factulink.fkb.api.repository.RolesRepository;
import com.factulink.fkb.api.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RolesRepository dao;

    @Override
    public ResponseEntity<Object> getRoles(){
        List<Roles> roles = dao.findAll();
        if(!roles.isEmpty()){
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No existen registros", HttpStatus.NOT_FOUND);
        }
    }
}
