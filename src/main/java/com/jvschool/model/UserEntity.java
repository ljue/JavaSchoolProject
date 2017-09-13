package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "USER", schema = "MYSHOP_SCHEMA")
public class UserEntity  implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Basic
    @Column(name = "PASSWORD", nullable = false)
    private String pass;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME")
    private String secondName;

    @Basic
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//mappedBy = "userByUserId",
    @JoinColumn(name = "USER_ID")
    private List<AddressEntity> addresses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    private RoleEntity roleByRole;

    @Transient
    private double sumTotal;
    @Transient
    private int sumCountProduct;

}
