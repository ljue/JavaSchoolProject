package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PAY_WAY", schema = "MYSHOP_SCHEMA")
public class PayWayEntity  implements Serializable {

    @Id
    @Column(name = "PAY_WAY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payWayId;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String payWayName;

}
