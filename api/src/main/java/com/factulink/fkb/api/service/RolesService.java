package com.factulink.fkb.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RolesService {
    public ResponseEntity<Object> getRoles();
}
