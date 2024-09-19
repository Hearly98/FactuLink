package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.State;
import com.factulink.fkb.api.repository.StateRepository;
import com.factulink.fkb.api.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StateRepository dao;

    @Override
    public ResponseEntity<Object> getStates(){
        List<State> state = dao.findAll();
        if(!state.isEmpty()){
            return new ResponseEntity<>(state, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No existen registros", HttpStatus.NOT_FOUND);
        }
    }
}
