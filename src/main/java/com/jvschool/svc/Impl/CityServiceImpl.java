package com.jvschool.svc.Impl;

import com.jvschool.dao.CityDAO;
import com.jvschool.entities.CityEntity;
import com.jvschool.svc.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<CityEntity> getAllCities() {
        return cityDAO.getAllCities();
    }
}
