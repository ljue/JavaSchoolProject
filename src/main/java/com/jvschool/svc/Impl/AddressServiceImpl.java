package com.jvschool.svc.Impl;

import com.jvschool.dao.AddressDAO;
import com.jvschool.entities.AddressEntity;
import com.jvschool.svc.AddressService;
import com.jvschool.util.Attributes.AddressAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


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
        List<AddressAttribute> laa = new ArrayList<>();
        addressDAO.getAllAddressesByUserId(id)
                .stream().forEachOrdered((ae) -> laa.add(new AddressAttribute(ae)));
        return laa;
    }

    @Override
    public void addNewAddress(final AddressAttribute addressAttribute) {
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUserId(addressAttribute.getUserId());
        addressEntity.setStreetAddress(addressAttribute.getStreetAddress());
        addressEntity.setPostIndex(addressAttribute.getPostIndex());
        addressEntity.setCity(addressAttribute.getCity());
        addressEntity.setRegion(addressAttribute.getRegion());
        addressEntity.setCountry(addressAttribute.getCountry());
        addressDAO.addNewAddress(addressEntity);
    }


}
