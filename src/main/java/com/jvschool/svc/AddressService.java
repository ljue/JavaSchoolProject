package com.jvschool.svc;

import com.jvschool.entities.AddressEntity;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
public interface AddressService {

    List<AddressEntity> getAllAddressesByUserId(long id);
    void addNewAddress(AddressEntity addressEntity);

}
