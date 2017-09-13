package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
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
