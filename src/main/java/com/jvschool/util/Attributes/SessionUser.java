package com.jvschool.util.Attributes;

import com.jvschool.entities.AddressEntity;
import com.jvschool.entities.UserEntity;
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
        this.role = ue.getRoleByRole().getRoleName();

        if (!ue.getAddresses().isEmpty()) {
            List<AddressEntity> list = ue.getAddresses();
            for (AddressEntity adr : list) {
                this.listAddress.add(adr.getAddressId());
            }
        }
    }

}
