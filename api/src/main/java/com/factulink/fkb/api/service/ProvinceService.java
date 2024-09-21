package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Province;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    public ResponseEntity<Object> getProvinces();
    public ResponseEntity<Object> addProvinces(Province province);
    public ResponseEntity<Object> getProvincesById(Integer id);
    public ResponseEntity<Object> updateProvinces(Province province, Integer id);
}
