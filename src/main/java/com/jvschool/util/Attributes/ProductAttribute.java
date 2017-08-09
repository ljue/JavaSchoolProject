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
    private int flyTime;
    private int distance;
    private String description;
    private String category;

    private List<MultipartFile> images = new ArrayList<>();
    private List<String> picturesPath = new ArrayList<>();
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
        this.category = productEntity.getCategory().getCategoryName();


        if(!productEntity.getPictures().isEmpty()) {
            presentPic=productEntity.getPictures().get(0).getPicName();

            for(PicturesEntity picPath:productEntity.getPictures()) {
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

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
