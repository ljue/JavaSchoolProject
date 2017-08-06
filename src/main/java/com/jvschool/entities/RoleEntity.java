package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ROLE", schema = "MYSHOP_SCHEMA")
public class RoleEntity  implements Serializable {
    private long idRole;
    private String name;

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "NAME", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (idRole != that.idRole) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
