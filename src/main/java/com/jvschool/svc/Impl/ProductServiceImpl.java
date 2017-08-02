package com.jvschool.svc.Impl;

import com.jvschool.dao.BucketDAO;
import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private BucketDAO bucketDAO;

    @Override
    public void addProduct(ProductEntity productEntity) {
        productDAO.addProduct(productEntity);
    }

    @Override
    public ProductAttribute getProductAttributeById(long id) {
        return new ProductAttribute(productDAO.getProductById(id));
    }

    @Override
    public ProductEntity getProductById(long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<ProductAttribute> getAllProducts() {
        List<ProductEntity> listEntity = productDAO.getAllProducts();
        List<ProductAttribute> listAttr = new ArrayList<>();
        for(ProductEntity pe:listEntity) {
            listAttr.add(new ProductAttribute(pe));
        }

        return listAttr;
    }

    @Override
    public List<ProductAttribute> getProductsToBuy(Set<Long> list) {
        List<ProductEntity> listEntity = productDAO.getProductsToBuy(list);
        List<ProductAttribute> listAttr = new ArrayList<>();
        for(ProductEntity pe:listEntity) {
            listAttr.add(new ProductAttribute(pe));
        }

        return listAttr;
    }

    @Override
    public List<ProductAttribute> getTopProducts() {

        List<ProductEntity> lpe = productDAO.getTopProducts();
        List<ProductAttribute> lpa = new ArrayList<>();
        if (!lpe.isEmpty()) {
            for (ProductEntity pe : lpe) {
                ProductAttribute pa = new ProductAttribute(pe);
                List<BucketEntity> lbe = bucketDAO.getBucketsByProductId(pe.getProductId());
                if (!lbe.isEmpty()) {
                    for (BucketEntity be : lbe) {
                        pa.setSumCount(pa.getSumCount() + be.getCountProduct());
                    }
                }
                lpa.add(pa);
            }
        }

        return lpa;
    }
}
