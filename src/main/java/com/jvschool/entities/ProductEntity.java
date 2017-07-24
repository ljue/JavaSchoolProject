package com.jvschool.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "Product", schema = "myshop_schema")
public class ProductEntity  implements Serializable {
    private long productId;
    private String productName;
    private int count;
    private double cost;
    //private String image;
    //private int category;
    //private Long bucketId;
    private String size;
    private String battery;
    private String flyTime;
    private String distance;
    private String description;

    private List<MultipartFile> images;

    private OrderEntity bucketByProductId;
    private List<PicturesEntity> picturesByProductId;
    private ProductCategoryEntity productCategoryByCategory;

    private List<ProductPropertyEntity> properties;
    private List<ProductRadioPropertyEntity> radioProperties;

    @Id
    @Column(name = "ProductId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ProductName", nullable = false, length = 255)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "Count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "Cost", nullable = false)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "Size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "Battery")
    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Basic
    @Column(name = "FlyTime")
    public String getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(String flyTime) {
        this.flyTime = flyTime;
    }

    @Basic
    @Column(name = "Distance")
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    //    @Basic
//    @Column(name = "Image", nullable = false, length = 30)
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

//    @Basic
//    @Column(name = "Category", nullable = false)
//    public int getCategory() {
//        return category;
//    }
//
//    public void setCategory(int category) {
//        this.category = category;
//    }

//    @Basic
//    @Column(name = "BucketId", nullable = true)
//    public Long getBucketId() {
//        return bucketId;
//    }
//
//    public void setBucketId(Long bucketId) {
//        this.bucketId = bucketId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;

        ProductEntity that = (ProductEntity) o;

        if (productId != that.productId) return false;
        if (count != that.count) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (size != that.size) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (battery != null ? !battery.equals(that.battery) : that.battery != null) return false;
        if (flyTime != null ? !flyTime.equals(that.flyTime) : that.flyTime != null) return false;
        return distance != null ? distance.equals(that.distance) : that.distance == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + count;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (size!=null ? size.hashCode() : 0);
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (flyTime != null ? flyTime.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }


    @ManyToOne()
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
    public OrderEntity getBucketByProductId() {
        return bucketByProductId;
    }

    public void setBucketByProductId(OrderEntity bucketByProductId) {
        this.bucketByProductId = bucketByProductId;
    }

    @OneToMany(mappedBy = "productByProductId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "PictureId", referencedColumnName = "PictureId")
    public List<PicturesEntity> getPicturesByProductId() {
        return picturesByProductId;
    }

    public void setPicturesByProductId(List<PicturesEntity> picturesByProductId) {
        this.picturesByProductId = picturesByProductId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Category", referencedColumnName = "CategoryId", nullable = false)
    public ProductCategoryEntity getProductCategoryByCategory() {
        return productCategoryByCategory;
    }

    public void setProductCategoryByCategory(ProductCategoryEntity productCategoryByCategory) {
        this.productCategoryByCategory = productCategoryByCategory;
    }


    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "Prod_Prop",
            joinColumns = @JoinColumn(name = "ProductId"),
            inverseJoinColumns = @JoinColumn(name = "ProductPropertyId"))
    public List<ProductPropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<ProductPropertyEntity> properties) {
        this.properties = properties;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Prod_RadioProp",
            joinColumns = @JoinColumn(name = "ProductId"),
            inverseJoinColumns = @JoinColumn(name = "RadioPropId"))
    public List<ProductRadioPropertyEntity> getRadioProperties() {
        return radioProperties;
    }

    public void setRadioProperties(List<ProductRadioPropertyEntity> radioProperties) {
        this.radioProperties = radioProperties;
    }

    @Transient
    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }


    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
