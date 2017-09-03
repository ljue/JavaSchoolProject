package com.jvschool.dto;

import com.jvschool.model.AddressEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressAttribute {

    private long addressId;
    private String streetAddress;
    private String postIndex;

    private Long userId;

    private String country;
    private String region;
    private String city;

    public AddressAttribute(AddressEntity ae) {
        this.addressId = ae.getAddressId();
        this.streetAddress = ae.getStreetAddress();
        this.postIndex = ae.getPostIndex();
        this.userId = ae.getUserId();
        this.country = ae.getCountry();
        this.region = ae.getRegion();
        this.city = ae.getCity();
    }

    public AddressAttribute() {

    }

}
