package com.factulink.fkb.api.implement;


import com.factulink.fkb.api.model.Province;
import com.factulink.fkb.api.repository.ProvinceRepository;
import com.factulink.fkb.api.service.ProvinceService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProvinceRepository dao;

    @Override
    public ResponseEntity<Object> getProvinces() {
        List<Province> provinces = dao.findAll();
        if (!provinces.isEmpty()) {
            return new ResponseEntity<>(provinces, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No existen registros",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Object> addProvinces(Province province) {
        Province savedProvince = dao.save(province);
        return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Object> getProvincesById(Integer id) {
        Optional<Province> province = dao.findById(id);
        if (province.isPresent()) {
            return new ResponseEntity<>(province.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("El id no ha sido encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updateProvinces(Province province, Integer id) {
        Optional<Province> provinceExist = dao.findById(id);
        if (provinceExist.isPresent()){
            Province province1 = provinceExist.get();
            province1.setNameProvince(province1.getNameProvince());
            dao.save(province1);
            return new ResponseEntity<>("Datos actualizados", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Sin registros con ID:" + id,HttpStatus.NOT_FOUND);
        }
    }
}
