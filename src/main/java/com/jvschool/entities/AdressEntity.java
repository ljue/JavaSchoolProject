package com.jvschool.entities;

import javax.persistence.*;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Adress", schema = "myshop_schema", catalog = "")
public class AdressEntity {
    private long adressId;
    private String streetAdress;
    private String postIndex;

    @Id
    @Column(name = "AdressId", nullable = false)
    public long getAdressId() {
        return adressId;
    }

    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    @Basic
    @Column(name = "StreetAdress", nullable = false, length = 255)
    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
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

        AdressEntity that = (AdressEntity) o;

        if (adressId != that.adressId) return false;
        if (streetAdress != null ? !streetAdress.equals(that.streetAdress) : that.streetAdress != null) return false;
        if (postIndex != null ? !postIndex.equals(that.postIndex) : that.postIndex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (adressId ^ (adressId >>> 32));
        result = 31 * result + (streetAdress != null ? streetAdress.hashCode() : 0);
        result = 31 * result + (postIndex != null ? postIndex.hashCode() : 0);
        return result;
    }
}
