package com.jvschool.dao;

import com.jvschool.entities.BucketEntity;

import java.util.List;

public interface BucketDAO {
    List<BucketEntity> getBucketsByProductId(long id);
}
