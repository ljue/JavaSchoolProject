package com.jvschool.svc.Impl;



import com.jvschool.dao.CountryDAO;

import com.jvschool.entities.CountryEntity;
import com.jvschool.svc.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Людмила on 14.07.2017.
 */

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;


    @Override
    @Transactional
    public List<CountryEntity> getAllCountries(){
        return countryDAO.getAllCountries();
    }
}
