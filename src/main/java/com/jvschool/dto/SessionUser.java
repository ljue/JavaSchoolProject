package com.jvschool.dto;

import com.jvschool.model.AddressEntity;
import com.jvschool.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
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

    private String confirmPassword;

    private int sumCountProducts;
    private String sumTotal;


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
        if (ue.getRoleByRole() == null) {
            this.role = "ROLE_CLIENT";
        } else {
            this.role = ue.getRoleByRole().getRoleName();
        }

        List<AddressEntity> list = ue.getAddresses();
        for (AddressEntity adr : list) {
            this.listAddress.add(adr.getAddressId());
        }
    }

}
