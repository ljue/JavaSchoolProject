package com.jvschool.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EditForm {

    private String current;
    private String edit;
    private String type;
    private String add;
    private String remove;
    private String returns;

}
