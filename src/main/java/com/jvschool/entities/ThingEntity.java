package com.jvschool.entities;

import javax.persistence.*;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Thing", schema = "myshop_schema", catalog = "")
public class ThingEntity {
    private long thingId;
    private String thingName;
    private int count;
    private int cost;
    private String image;
    private long category;
    private String visibility;
    private String size;
    private CameraEntity cameraByCamera;

    @Id
    @Column(name = "ThingId", nullable = false)
    public long getThingId() {
        return thingId;
    }

    public void setThingId(long thingId) {
        this.thingId = thingId;
    }

    @Basic
    @Column(name = "ThingName", nullable = false, length = 255)
    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
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
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "Image", nullable = false, length = 30)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "Category", nullable = false)
    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    @Basic
    @Column(name = "Visibility", nullable = true, length = 50)
    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Basic
    @Column(name = "Size", nullable = true, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThingEntity that = (ThingEntity) o;

        if (thingId != that.thingId) return false;
        if (count != that.count) return false;
        if (cost != that.cost) return false;
        if (category != that.category) return false;
        if (thingName != null ? !thingName.equals(that.thingName) : that.thingName != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (visibility != null ? !visibility.equals(that.visibility) : that.visibility != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (thingId ^ (thingId >>> 32));
        result = 31 * result + (thingName != null ? thingName.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + cost;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (int) (category ^ (category >>> 32));
        result = 31 * result + (visibility != null ? visibility.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Camera", referencedColumnName = "CameraId")
    public CameraEntity getCameraByCamera() {
        return cameraByCamera;
    }

    public void setCameraByCamera(CameraEntity cameraByCamera) {
        this.cameraByCamera = cameraByCamera;
    }
}
