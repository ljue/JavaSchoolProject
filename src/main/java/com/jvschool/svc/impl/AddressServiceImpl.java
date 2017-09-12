package com.jvschool.svc.impl;

import com.jvschool.dao.api.AddressDAO;
import com.jvschool.model.AddressEntity;
import com.jvschool.svc.api.AddressService;
import com.jvschool.dto.AddressAttribute;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressEntity getAddressById(long id) {
        return addressDAO.getAddressById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AddressAttribute> getAllAddressesByUserId(long id) {
        List<AddressAttribute> laa = new ArrayList<>();
        addressDAO.getAllAddressesByUserId(id)
                .stream().forEachOrdered(ae -> laa.add(new AddressAttribute(ae)));
        return laa;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAddress(long id) {
        addressDAO.removeAddress(id);
    }


}
