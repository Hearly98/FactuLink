package com.factulink.fkb.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StateService {
    public ResponseEntity<Object> getStates();
}
