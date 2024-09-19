package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.District;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DistrictService {
    public ResponseEntity<Object> getDistricts();
    public ResponseEntity<Object> addDistrict(District district);
    public ResponseEntity<Object> getDistrictById(Integer id);
    public ResponseEntity<Object> updateDistrict(District dist, Integer id);
}
