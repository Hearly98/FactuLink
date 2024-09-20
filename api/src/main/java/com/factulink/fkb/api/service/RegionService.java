package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Region;
import java.util.List;

public interface RegionService {
    List<Region> getAllRegions();
    Region getRegionById(Integer id);
    Region saveRegion(Region region);
    void deleteRegion(Integer id);
}