package com.jvschool.svc.Impl;

import com.jvschool.dao.RegionDAO;
import com.jvschool.entities.RegionEntity;
import com.jvschool.svc.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDAO regionDAO;

    @Override
    public List<RegionEntity> getAllRegions() {
        return regionDAO.getAllRegions();
    }
}
