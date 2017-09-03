package com.jvschool.dto;

import com.jvschool.model.PicturesEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.model.PropertyEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductAttribute  implements Serializable {

    private long productId;
    private String productName;
    private String presentProductName;
    private int count;
    private double cost;
    private String size;
    private String battery;
    private int flyTime;
    private int distance;
    private String description;
    private String category;

    private List<MultipartFile> images = new ArrayList<>();
    private List<String> picturesPath = new ArrayList<>();
    private String presentPic;
    private List<String> saveProperties = new ArrayList<>();
    private Map<String, List<String>> properties = new HashMap<>();

    private int sumCount;

    public ProductAttribute() {
    }

    public ProductAttribute(ProductEntity productEntity) {

        this.productId = productEntity.getProductId();
        this.productName = productEntity.getProductName();

        this.presentProductName = this.productName.substring(0, this.productName.substring(0,60).lastIndexOf(' ')) + "...";

        this.count = productEntity.getCount();
        this.cost = productEntity.getCost();
        this.size = productEntity.getSize();
        this.battery = productEntity.getBattery();
        this.flyTime = productEntity.getFlyTime();
        this.distance = productEntity.getDistance();
        this.description = productEntity.getDescription();
        this.category = productEntity.getCategory().getCategoryName();

        for (PropertyEntity propertyEntity : productEntity.getProperties()) {
            properties.computeIfAbsent(propertyEntity.getPropertyGroup().getPropertyGroupName(),
                    v -> new ArrayList<>()).add(propertyEntity.getPropertyName());
        }

        if(!productEntity.getPictures().isEmpty()) {
            presentPic=productEntity.getPictures().get(0).getPicName();

            for(PicturesEntity picPath:productEntity.getPictures()) {
                picturesPath.add(picPath.getPicName());
            }
        }
    }

}
