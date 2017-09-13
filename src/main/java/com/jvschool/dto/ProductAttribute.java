package com.jvschool.dto;

import com.jvschool.model.PicturesEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.model.PropertyEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
public class ProductAttribute  implements Serializable, Comparable {

    private long productId;
    private String productName;
    private String presentProductName;
    private String productCartName;
    private int count;
    private String cost;
    private String size;
    private String battery;
    private int flyTime;
    private int distance;
    private String description;
    private String category;
    private boolean visible;

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
        if(productEntity.getProductName()!=null) {
            this.productName = productEntity.getProductName();
            if (this.productName.length() > 60) {
                this.presentProductName = this.productName.substring(0, this.productName.substring(0, 60).lastIndexOf(' ')) + "...";
                this.productCartName = this.productName.substring(0, this.productName.substring(0, 20).lastIndexOf(' ')) + "...";
            } else if (this.productName.length() > 20) {
                this.presentProductName = this.productName;
                this.productCartName = this.productName.substring(0, this.productName.substring(0, 20).lastIndexOf(' ')) + "...";
            } else {
                this.presentProductName = this.productName;
                this.productCartName = this.productName;
            }
        }
        this.count = productEntity.getCount();
        this.cost = String.format(Locale.US, "%.2f", productEntity.getCost());
        this.size = productEntity.getSize();
        this.battery = productEntity.getBattery();
        this.flyTime = productEntity.getFlyTime();
        this.distance = productEntity.getDistance();
        this.description = productEntity.getDescription();
        if(productEntity.getCategory()!=null) {
            this.category = productEntity.getCategory().getCategoryName();
        }
        this.visible = productEntity.isVisible();

        for (PropertyEntity propertyEntity : productEntity.getProperties()) {
            properties.computeIfAbsent(propertyEntity.getPropertyGroup().getPropertyGroupName(),
                    v -> new ArrayList<>()).add(propertyEntity.getPropertyName());
        }

        if(!productEntity.getPictures().isEmpty()) {
            presentPic=productEntity.getPictures().get(0).getPicName();

            for(PicturesEntity picPath:productEntity.getPictures()) {
                picturesPath.add(picPath.getPicName());
            }
        } else {
            presentPic="default-copter.png";
        }
    }

    @Override
    public int compareTo(Object o) {
        ProductAttribute productAttribute = (ProductAttribute) o;
        if(this.productId>productAttribute.productId)
            return 1;
        else if(this.productId<productAttribute.productId)
            return -1;
        else
            return this.productName.compareTo(productAttribute.productName);
    }
}
