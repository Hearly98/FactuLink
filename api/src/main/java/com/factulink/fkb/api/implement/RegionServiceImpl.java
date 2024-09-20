package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Region;
import com.factulink.fkb.api.repository.RegionRepository;
import com.factulink.fkb.api.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region getRegionById(Integer id) {
        Optional<Region> region = regionRepository.findById(id);
        return region.orElse(null);
    }

    @Override
    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public void deleteRegion(Integer id) {
        regionRepository.deleteById(id);
    }
}