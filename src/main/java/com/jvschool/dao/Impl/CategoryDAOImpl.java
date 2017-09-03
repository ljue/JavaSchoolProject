package com.jvschool.dao.Impl;


import com.jvschool.dao.api.CategoryDAO;
import com.jvschool.model.CategoryEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CategoryEntity> getAllProductCategories() {

        List<CategoryEntity> categories = em.createQuery("FROM CategoryEntity where visible=:visible ")
                .setParameter("visible", true).getResultList();

        return categories;
    }

    @Override
    public CategoryEntity getProductCategoryById(int id) {
        //CategoryEntity category = em.find(CategoryEntity.class, id);
        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryId=:id").setParameter("id", id).getResultList();

        if (list.isEmpty())
            return null;
        else
            return (CategoryEntity) list.get(0);
    }

    @Override
    public CategoryEntity getProductCategoryByName(String name) {

        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryName=:name").setParameter("name", name).getResultList();

        if (list.isEmpty())
            return null;
        else
            return (CategoryEntity) list.get(0);
    }

    @Override
    public void addProductCategory(String name) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity.setVisible(true);

        em.persist(categoryEntity);

    }

    @Override
    public void editCategory(CategoryEntity category) {

        em.merge(category);
    }

    @Override
    public void removeCategory(CategoryEntity category) {

        Query query = em.createQuery("UPDATE CategoryEntity set visible=:visible where categoryId=:categoryId")
                .setParameter("categoryId", category.getCategoryId()).setParameter("visible", false);

        query.executeUpdate();

    }

    @Override
    public List<CategoryEntity> getRemovedCategories() {

        List<CategoryEntity> categories = em.createQuery("FROM CategoryEntity where visible=:visible ")
                .setParameter("visible", false).getResultList();

        return categories;
    }

    @Override
    public void returnCategory(CategoryEntity category) {
        Query query = em.createQuery("UPDATE CategoryEntity set visible=:visible where categoryId=:categoryId")
                .setParameter("categoryId", category.getCategoryId()).setParameter("visible", true);

        query.executeUpdate();

    }


}
