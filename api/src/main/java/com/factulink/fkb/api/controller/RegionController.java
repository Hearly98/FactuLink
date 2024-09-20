package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Region;
import com.factulink.fkb.api.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;


    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Integer id) {
        Region region = regionService.getRegionById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(region);
    }


    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return regionService.saveRegion(region);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Integer id, @RequestBody Region regionDetails) {
        Region region = regionService.getRegionById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        region.setCodeRegion(regionDetails.getCodeRegion());
        region.setNameRegion(regionDetails.getNameRegion());
        Region updatedRegion = regionService.saveRegion(region);
        return ResponseEntity.ok(updatedRegion);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        Region region = regionService.getRegionById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        regionService.deleteRegion(id);
        return ResponseEntity.noContent().build();
    }
}