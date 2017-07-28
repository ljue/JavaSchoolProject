package com.jvschool.svc;

import com.jvschool.entities.AddressEntity;
import com.jvschool.util.Attributes.AddressAttribute;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
public interface AddressService {

    List<AddressEntity> getAllAddressesByUserId(long id);
    void addNewAddress(AddressEntity addressEntity);
    AddressEntity getAddressById(long id);


    List<AddressAttribute> getAllAddressesByUserIdS(long id);
    void addNewAddress(AddressAttribute addressAttribute);
}
