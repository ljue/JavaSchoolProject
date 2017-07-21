package com.jvschool.util;

import com.jvschool.entities.AddressEntity;
import com.jvschool.entities.UserEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 20.07.2017.
 */
public class SessionUser implements Serializable {

    private long id;
    private String login;
    private String pass;
    private String email;
    private String firstName;
    private String secondName;
    private Date birthday;
    private List<Long> addressId;
    private String role;

    public SessionUser(long id, String login, String pass, String email, String firstName, String secondName, Date birthday, List<Long> addressId, String role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.addressId = addressId;
        this.role = role;
    }

    public SessionUser() {
        this.role = "ROLE_ANONYM";
    }

    public SessionUser(UserEntity ue) {
        this.id = ue.getId();
        this.login = ue.getLogin();
        this.pass = ue.getPass();
        this.email = ue.getEmail();
        this.firstName = ue.getFirstName();
        this.secondName = ue.getSecondName();
        this.birthday = ue.getBirthday();
        this.role = ue.getRoleByRole().getName();

        if (ue.getAddressByAddress()!=null) {
            List<AddressEntity> list = new ArrayList(ue.getAddressByAddress());

                for (AddressEntity adr : list) {
                    this.addressId.add(adr.getAddressId());
                }

        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Long> getAddressId() {
        return addressId;
    }

    public void setAddressId(List<Long> addressId) {
        this.addressId = addressId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}
