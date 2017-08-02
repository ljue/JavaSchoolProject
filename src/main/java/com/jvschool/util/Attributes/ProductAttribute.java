package com.jvschool.util.Attributes;

import com.jvschool.entities.PicturesEntity;
import com.jvschool.entities.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProductAttribute  implements Serializable {

    private long productId;
    private String productName;
    private int count;
    private double cost;
    private String size;
    private String battery;
    private String flyTime;
    private String distance;
    private String description;
    //private OrderEntity bucketByProductId;
    private String productCategoryByCategory;

    private List<MultipartFile> images;
    private List<String> picturesPath= new ArrayList<>();
    private String presentPic;

    private int sumCount;

    public ProductAttribute() {
    }

    public ProductAttribute(ProductEntity productEntity) {

        this.productId = productEntity.getProductId();
        this.productName = productEntity.getProductName();
        this.count = productEntity.getCount();
        this.cost = productEntity.getCost();
        this.size = productEntity.getSize();
        this.battery = productEntity.getBattery();
        this.flyTime = productEntity.getFlyTime();
        this.distance = productEntity.getDistance();
        this.description = productEntity.getDescription();
        this.productCategoryByCategory = productEntity.getProductCategoryByCategory().getCategoryName();


        if(!productEntity.getPicturesByProductId().isEmpty()) {
            presentPic=productEntity.getPicturesByProductId().get(0).getPicName();

            for(PicturesEntity picPath:productEntity.getPicturesByProductId()) {
                picturesPath.add(picPath.getPicName());
            }
        }
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(String flyTime) {
        this.flyTime = flyTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCategoryByCategory() {
        return productCategoryByCategory;
    }

    public void setProductCategoryByCategory(String productCategoryByCategory) {
        this.productCategoryByCategory = productCategoryByCategory;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public List<String> getPicturesPath() {
        return picturesPath;
    }

    public void setPicturesPath(List<String> picturesPath) {
        this.picturesPath = picturesPath;
    }

    public String getPresentPic() {
        return presentPic;
    }

    public void setPresentPic(String presentPic) {
        this.presentPic = presentPic;
    }

    public int getSumCount() {
        return sumCount;
    }

    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
    }
}
