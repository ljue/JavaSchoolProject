package com.jvschool.util.Attributes;

import com.jvschool.entities.AddressEntity;
import com.jvschool.entities.UserEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SessionUser implements Serializable {

    private long id;
    private String login;
    private String pass;
    private String email;
    private String firstName;
    private String secondName;
    private Date birthday;
    private List<Long> listAddress= new ArrayList<>();
    private String role;
    private Map<Long,Integer> products = new HashMap<>();


    public SessionUser() {
        this.role = "ROLE_ANONYM";
    }

    public SessionUser(UserEntity ue, Map<Long,Integer> products) {
        this.id = ue.getId();
        this.login = ue.getLogin();
        this.pass = ue.getPass();
        this.email = ue.getEmail();
        this.firstName = ue.getFirstName();
        this.secondName = ue.getSecondName();
        this.birthday = ue.getBirthday();
        this.role = ue.getRoleByRole().getName();

        this.products = products;

        if (ue.getAddresses()!=null) {
            List<AddressEntity> list = ue.getAddresses();
                for (AddressEntity adr : list) {
                    this.listAddress.add(adr.getAddressId());
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

    public List<Long> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Long> listAddress) {
        this.listAddress = listAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Integer> products) {
        this.products = products;
    }
}
