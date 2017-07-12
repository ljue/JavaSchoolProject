package DAO;

import DAO.Impl.*;
/**
 * Created by Людмила on 12.07.2017.
 */
public class Factory {

    private static Factory instance = null;
    private static ClientDAO clientDAO = null;

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
}
