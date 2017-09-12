package com.jvschool.svc.api;

import com.jvschool.model.AddressEntity;
import com.jvschool.dto.AddressAttribute;

import java.util.List;


public interface AddressService {


    /**
     * Gets {@link AddressEntity} by id.
     * @param id
     * @return address
     */
    AddressEntity getAddressById(long id);

    /**
     * Gets visible users {@link AddressEntity} by user id and convert it to list of {@link AddressAttribute}.
     * @param id user id
     * @return list of address dto
     */
    List<AddressAttribute> getAllAddressesByUserId(long id);

    /**
     * Converts {@link AddressAttribute} to {@link AddressEntity} and save it in database.
     * @param addressAttribute address dto
     */
    void addNewAddress(AddressAttribute addressAttribute);

    /**
     * Calls {@link com.jvschool.dao.impl.AddressDAOImpl#removeAddress(long)}
     * @param id
     */
    void removeAddress(long id);
}
