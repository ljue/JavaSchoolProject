package com.jvschool.util.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

@Getter
@Setter
@Log4j
public class ProductDTO  implements Serializable {

    private long productId;
    private String productName;
    private double cost;
    private String picture;

    final static private String PICTURES_DIR = "D:/JavaSchoolProject/mywebapp/src/main/webapp/resources/Images/";

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", cost=" + cost +
                //", picture='" + picture + '\'' +
                '}';
    }

    public void setPicture(String picture) {

        try {
            File f = new File(PICTURES_DIR + picture);
            byte[] fileContent = Files.readAllBytes(f.toPath());
            String picture64Encoded = DatatypeConverter.printBase64Binary(fileContent);
            this.picture = picture64Encoded;
        } catch (IOException e) {
            this.picture = picture;
            log.error(e.toString());
        }

    }
}
