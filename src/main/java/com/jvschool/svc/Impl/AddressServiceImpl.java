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
        List<AddressEntity> lae = addressDAO.getAllAddressesByUserId(id);
        if(!lae.isEmpty()) {
            //lae.stream().forEachOrdered((ae) -> laa.add(new AddressAttribute(ae)));
            for (AddressEntity ae : lae) {
                laa.add(new AddressAttribute(ae));
            }
        }
        return laa;
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
