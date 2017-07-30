package com.jvschool.svc.Impl;

import com.jvschool.dao.api.AddressDAO;
import com.jvschool.entities.AddressEntity;
import com.jvschool.svc.api.AddressService;
import com.jvschool.dto.AddressAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Service
@Transactional
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

    @Override
    public AddressEntity getAddressById(long id) {
        return addressDAO.getAddressById(id);
    }


    @Override
    public List<AddressAttribute> getAllAddressesByUserIdS(long id) {
        List<AddressAttribute> lae = new ArrayList<>();
        for(AddressEntity ae:addressDAO.getAllAddressesByUserId(id)) {
            lae.add(new AddressAttribute(ae));
        }
        return lae;
    }

    @Override
    public void addNewAddress(AddressAttribute aa) {
        AddressEntity ae = new AddressEntity();
        ae.setUserId(aa.getUserId());
        ae.setStreetAddress(aa.getStreetAddress());
        ae.setPostIndex(aa.getPostIndex());
        ae.setCity(aa.getCity());
        ae.setRegion(aa.getRegion());
        ae.setCountry(aa.getCountry());
        addressDAO.addNewAddress(ae);
    }


}
