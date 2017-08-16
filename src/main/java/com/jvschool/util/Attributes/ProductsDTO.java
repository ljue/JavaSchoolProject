package com.jvschool.util.Attributes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductsDTO implements Serializable {
    List<ProductDTO> products;

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "products=" + products +
                '}';
    }
}
