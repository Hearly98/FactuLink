package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.District;
import com.factulink.fkb.api.model.Province;
import com.factulink.fkb.api.repository.DistrictRepository;
import com.factulink.fkb.api.service.DistrictService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        Optional<District> district = dao.findById(id);
        if(district.isPresent()){
            return new ResponseEntity<>(district.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("El id " +  id + " no ha sido encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updateDistrict(District dist, Integer id, Province province) {
        return null;
    }
}