package com.jvschool.svc.Impl;

import com.jvschool.dao.AddressDAO;
import com.jvschool.entities.AddressEntity;
import com.jvschool.svc.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Override
    public List<AddressEntity> getAllAddressesByUserId(long id) {
        return addressDAO.getAllAddressesByUserId(id);
    }

    @Override
    public void addNewAddress(AddressEntity addressEntity) {
        addressDAO.addNewAddress(addressEntity);

    }
}
