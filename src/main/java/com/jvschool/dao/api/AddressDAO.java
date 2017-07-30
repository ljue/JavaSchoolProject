package com.jvschool.dao.api;

import com.jvschool.entities.AddressEntity;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
public interface AddressDAO {

    List<AddressEntity> getAllAddressesByUserId(long id);
    void addNewAddress(AddressEntity addressEntity);
    AddressEntity getAddressById(long id);

}
