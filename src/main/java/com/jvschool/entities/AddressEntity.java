package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Address", schema = "myshop_schema")
public class AddressEntity implements Serializable {
    private long addressId;
    private String streetAddress;
    private String postIndex;
    private UserEntity userEntity;
    private CountryEntity countryEntity;
    private RegionEntity regionEntity;
    private CityEntity cityEntity;

    @Id
    @Column(name = "AddressId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long adressId) {
        this.addressId = adressId;
    }

    @Basic
    @Column(name = "StreetAddress", nullable = false, length = 255)
    public String getStreetAdress() {
        return streetAddress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAddress = streetAdress;
    }

    @Basic
    @Column(name = "PostIndex", nullable = false, length = 30)
    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (addressId != that.addressId) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null) return false;
        if (postIndex != null ? !postIndex.equals(that.postIndex) : that.postIndex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postIndex != null ? postIndex.hashCode() : 0);
        return result;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @ManyToOne
    @JoinColumn(name = "Country", referencedColumnName = "id")
    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    @ManyToOne
    @JoinColumn(name = "Region", referencedColumnName = "id")
    public RegionEntity getRegionEntity() {
        return regionEntity;
    }

    public void setRegionEntity(RegionEntity regionEntity) {
        this.regionEntity = regionEntity;
    }

    @ManyToOne
    @JoinColumn(name = "City", referencedColumnName = "id")
    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

}
