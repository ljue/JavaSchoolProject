package com.jvschool.svc.Impl;

import com.jvschool.dao.api.BucketDAO;
import com.jvschool.dao.api.ProductDAO;
import com.jvschool.model.*;
import com.jvschool.svc.api.CategoryService;
import com.jvschool.svc.api.PropertyService;
import com.jvschool.svc.api.ProductService;
import com.jvschool.dto.FilterAttribute;
import com.jvschool.dto.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private BucketDAO bucketDAO;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PropertyService propertyService;


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

        List<ProductAttribute> lpa = new ArrayList<>();
        productDAO.getAllProducts()
                .stream().forEachOrdered(productEntity -> lpa.add(new ProductAttribute(productEntity)));
        return lpa;
    }


    @Override
    public List<ProductAttribute> getProductsByCategory(String category) {

        CategoryEntity pce = categoryService.getProductCategoryByName(category);
        List<ProductAttribute> lpa = new ArrayList<>();
        if (pce != null) {
            productDAO.getProductsByCategory(pce)
                    .stream().forEachOrdered(productEntity -> lpa.add(new ProductAttribute(productEntity)));
        }
        return lpa;
    }


    @Override
    public List<ProductAttribute> getTopProducts() {

        List<ProductEntity> lpe = productDAO.getTopProducts();
        List<ProductAttribute> lpa = new ArrayList<>();

        for (ProductEntity pe : lpe) {
            ProductAttribute pa = new ProductAttribute(pe);
            List<BucketEntity> lbe = bucketDAO.getBucketsByProductId(pe.getProductId());

            for (BucketEntity be : lbe) {
                pa.setSumCount(pa.getSumCount() + be.getCountProduct());
            }

            lpa.add(pa);
        }


        return lpa;
    }

    @Override
    public List<ProductAttribute> getProductsWithFilter(FilterAttribute filterAttribute) {

        List<ProductAttribute> lpa = new ArrayList<>();
        productDAO.getProductsWithFilter(filterAttribute)
                .stream().forEachOrdered(productEntity -> lpa.add(new ProductAttribute(productEntity)));
        return lpa;
    }


    @Override
    public void addProduct(ProductAttribute productAttribute) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductName(productAttribute.getProductName());
        productEntity.setCost(productAttribute.getCost());
        productEntity.setCost(productAttribute.getCount());
        productEntity.setBattery(productAttribute.getBattery());
        productEntity.setDistance(productAttribute.getDistance());
        productEntity.setFlyTime(productAttribute.getFlyTime());
        productEntity.setSize(productAttribute.getSize());
        productEntity.setDescription(productAttribute.getDescription());

        Set<PropertyEntity> propertyEntities = new HashSet<>();
        for (String property : productAttribute.getSaveProperties()) {
            PropertyEntity propertyEntity = propertyService.getPropertyByName(property);
            if (propertyEntity != null)
                propertyEntities.add(propertyEntity);
        }
        productEntity.setProperties(propertyEntities);

        CategoryEntity pce = categoryService.getProductCategoryByName(productAttribute.getCategory());
        if (pce == null) {
            pce = new CategoryEntity();
            pce.setCategoryName(productAttribute.getCategory());
        }
        productEntity.setCategory(pce);

        for (String picPath : productAttribute.getPicturesPath()) {
            PicturesEntity pice = new PicturesEntity();
            pice.setPicName(picPath);
            productEntity.getPictures().add(pice);
        }

        productDAO.addProduct(productEntity);
    }

    @Override
    public long getCountProducts() {
        return productDAO.getCountProducts();
    }

    @Override
    public List<ProductAttribute> getProductsFromTo(int page, int count) {
        List<ProductAttribute> lpa = new ArrayList<>();
        productDAO.getProductsFromTo(page, count)
                .stream().forEachOrdered(productEntity -> lpa.add(new ProductAttribute(productEntity)));
        return lpa;
    }

    @Override
    public Map<Integer, List<ProductAttribute>>  getProductsByFilterFromTo(int page, int count, FilterAttribute filterAttribute) {

        List<ProductAttribute> lpa = new ArrayList<>();
        List<ProductEntity> productEntityList = productDAO.getProductsWithFilter(filterAttribute);
        int from = (page - 1) * count;
        int to = page * count;
        to = (to > productEntityList.size()) ? productEntityList.size() : to;
        productEntityList.subList(from, to)
                .stream().forEachOrdered(productEntity -> lpa.add(new ProductAttribute(productEntity)));

        Map<Integer, List<ProductAttribute>> map = new HashMap<>();
        map.put(productEntityList.size(),lpa);
        return map;

    }

}
