package com.jvschool.entities;

import javax.persistence.*;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Role", schema = "myshop_schema", catalog = "")
public class RoleEntity {
    private long idRole;
    private String name;

    @Id
    @Column(name = "IdRole", nullable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
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
