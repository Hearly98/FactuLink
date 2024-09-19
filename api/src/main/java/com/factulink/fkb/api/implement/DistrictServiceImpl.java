package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.District;
import com.factulink.fkb.api.repository.DistrictRepository;
import com.factulink.fkb.api.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private DistrictRepository dao;

    @Override
    public ResponseEntity<Object> getDistricts(){
        List<District> district = dao.findAll();
        if(!district.isEmpty()){
            return new ResponseEntity<>(district, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No existen registros", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> addDistrict(District district){
        District saveDistrict = dao.save(district);
        return new ResponseEntity<>(saveDistrict, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getDistrictById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateDistrict(District dist, Integer id) {
        return null;
    }
}
