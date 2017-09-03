package com.jvschool.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductsDTO implements Serializable {

    private List<ProductDTO> products;

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "products=" + products +
                '}';
    }
}
