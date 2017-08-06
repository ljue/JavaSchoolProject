package com.jvschool.dao;

import com.jvschool.entities.AddressEntity;

import java.util.List;


public interface AddressDAO {

    List<AddressEntity> getAllAddressesByUserId(long id);
    void addNewAddress(AddressEntity addressEntity);
    AddressEntity getAddressById(long id);

}
