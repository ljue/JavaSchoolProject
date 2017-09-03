package com.jvschool.dao.api;

import com.jvschool.model.BucketEntity;

import java.util.List;

public interface BucketDAO {
    List<BucketEntity> getBucketsByProductId(long id);
}
