package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Bucket", schema = "myshop_schema")
public class BucketEntity implements Serializable {
    private long bucketId;
    private List<ThingEntity> thingByThing;

    @Id
    @Column(name = "BucketId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getBucketId() {
        return bucketId;
    }

    public void setBucketId(long bucketId) {
        this.bucketId = bucketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BucketEntity that = (BucketEntity) o;

        if (bucketId != that.bucketId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (bucketId ^ (bucketId >>> 32));
    }

    @OneToMany
    @JoinColumn(name = "ThingID", referencedColumnName = "ThingId")
    public List<ThingEntity> getThingByThing() {
        return thingByThing;
    }

    public void setThingByThing(List<ThingEntity> thingByThing) {
        this.thingByThing = thingByThing;
    }
}