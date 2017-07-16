package com.jvschool.dao;



import com.jvschool.entities.ClientEntity;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Людмила on 12.07.2017.
 */
public interface ClientDAO {
    public ClientEntity getClientById(Long id) throws SQLException;
    public Collection getAllClients() throws SQLException;
}
