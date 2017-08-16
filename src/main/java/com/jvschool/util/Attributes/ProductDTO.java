package com.jvschool.util.Attributes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDTO  implements Serializable {

    private long productId;
    private String productName;
    private String presentProductName;
    private double cost;
    private String description;
    private String category;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", presentProductName='" + presentProductName + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
