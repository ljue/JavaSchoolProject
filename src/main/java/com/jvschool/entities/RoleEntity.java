package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ROLE", schema = "MYSHOP_SCHEMA")
public class RoleEntity  implements Serializable {

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Basic
    @Column(name = "NAME")
    private String roleName;

}
