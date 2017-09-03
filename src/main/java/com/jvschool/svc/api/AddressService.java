package com.jvschool.svc.api;

import com.jvschool.model.AddressEntity;
import com.jvschool.dto.AddressAttribute;

import java.util.List;


public interface AddressService {


    /**
     * Get address entity by id.
     * @param id
     * @return
     */
    AddressEntity getAddressById(long id);

    /**
     * Get all address model by user id and convert it to list of address dto.
     * @param id
     * @return
     */
    List<AddressAttribute> getAllAddressesByUserId(long id);

    /**
     * Convert address dto to address entity and save it in database.
     * @param addressAttribute
     */
    void addNewAddress(AddressAttribute addressAttribute);

    /**
     * Set 'false' to field 'visible' in address entity where addressId = id.
     * @param id
     */
    void removeAddress(long id);
}
