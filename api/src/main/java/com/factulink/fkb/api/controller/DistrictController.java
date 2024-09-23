package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.District;
import com.factulink.fkb.api.model.Province;
import com.factulink.fkb.api.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/districts")
@AllArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping()
    public ResponseEntity<Object> getAllDistricts(){
        return districtService.getDistricts();
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveDistrict(@RequestBody District district){
        return districtService.addDistrict(district);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDistrictById(@PathVariable("id")Integer id){
        return districtService.getDistrictById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDistrictById(@PathVariable("id") Integer id, @RequestBody District district, @RequestBody Province province){
        return districtService.updateDistrict(district, id, province);
    }
}
