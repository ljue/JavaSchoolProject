package com.jvschool.dao.api;

import com.jvschool.model.AddressEntity;

import java.util.List;


public interface AddressDAO {

    List<AddressEntity> getAllAddressesByUserId(long id);
    void addNewAddress(AddressEntity addressEntity);
    void removeAddress(long id);
    AddressEntity getAddressById(long id);


}
