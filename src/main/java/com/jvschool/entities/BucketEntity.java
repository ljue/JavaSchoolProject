package com.jvschool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Людмила on 17.07.2017.
 */
@Entity
@Table(name = "Bucket", schema = "myshop_schema", catalog = "")
public class BucketEntity {
    private long bucketId;

    @Id
    @Column(name = "BucketId", nullable = false)
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
}
