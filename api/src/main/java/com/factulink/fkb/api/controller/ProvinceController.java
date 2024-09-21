package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Province;
import com.factulink.fkb.api.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provinces")
@AllArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;


    @GetMapping()
    public ResponseEntity<Object> allProvinces() {return provinceService.getProvinces();}

    @PostMapping("/save")
    public ResponseEntity<Object> saveProvince(@RequestBody Province province) {
        return provinceService.addProvinces(province);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProvinceById(@PathVariable("id") Integer id) {
        return provinceService.getProvincesById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProvince(@PathVariable("id") Integer id, @RequestBody Province province) {
        return provinceService.updateProvinces(province, id);
    }

}
