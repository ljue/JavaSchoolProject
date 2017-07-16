package com.jvschool.util;

import com.jvschool.dao.ClientDAO;
import com.jvschool.dao.CountryDAO;
import com.jvschool.dao.Impl.ClientDAOImpl;
import com.jvschool.dao.Impl.CountryDAOImpl;


/**
 * Created by Людмила on 12.07.2017.
 */
public class Factory {

    private static Factory instance = null;
    private static ClientDAO clientDAO = null;
    private static CountryDAO countryDAO = null;


    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public ClientDAO getClientDAO(){
        if (clientDAO == null){
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    public CountryDAO getCountryDAO(){
        if (countryDAO == null){
            countryDAO = new CountryDAOImpl();
        }
        return countryDAO;
    }
}
