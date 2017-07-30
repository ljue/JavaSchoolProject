package com.jvschool.dto;

import com.jvschool.entities.AddressEntity;

/**
 * Created by Людмила on 28.07.2017.
 */
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


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
