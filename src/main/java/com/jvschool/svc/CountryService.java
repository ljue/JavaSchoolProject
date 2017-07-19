package com.jvschool.svc;




import com.jvschool.entities.CountryEntity;

import java.util.List;

/**
 * Created by Людмила on 14.07.2017.
 */
public interface CountryService {
    List<CountryEntity> getAllCountries();
}
