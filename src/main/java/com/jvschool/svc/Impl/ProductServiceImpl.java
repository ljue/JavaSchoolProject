package com.jvschool.svc.Impl;

import com.jvschool.dao.BucketDAO;
import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.PicturesEntity;
import com.jvschool.entities.CategoryEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.CategoryService;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.FilterAttribute;
import com.jvschool.util.Attributes.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private BucketDAO bucketDAO;
    @Autowired
    private CategoryService categoryService;


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
    public void addProduct(ProductAttribute pa) {

        ProductEntity pe = new ProductEntity();

        pe.setProductName(pa.getProductName());
        pe.setCost(pa.getCost());
        pe.setCost(pa.getCount());
        pe.setBattery(pa.getBattery());
        pe.setDistance(pa.getDistance());
        pe.setFlyTime(pa.getFlyTime());
        pe.setSize(pa.getSize());
        pe.setDescription(pa.getDescription());

        CategoryEntity pce = categoryService.getProductCategoryByName(pa.getCategory());
        if (pce == null) {
            pce = new CategoryEntity();
            pce.setCategoryName(pa.getCategory());
        }
        pe.setCategory(pce);

        for (String picPath : pa.getPicturesPath()) {
            PicturesEntity pice = new PicturesEntity();
            pice.setPicName(picPath);
            pe.getPictures().add(pice);
        }

        productDAO.addProduct(pe);
    }
}
