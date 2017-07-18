package com.jvschool.dao;



import com.jvschool.entities.CountryEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Людмила on 14.07.2017.
 */
public interface CountryDAO {
    CountryEntity getCountryById(Long id) ;
    List<CountryEntity> getAllCountries() ;
}
