package junit;

import com.jvschool.dao.api.BucketDAO;
import com.jvschool.dao.api.ProductDAO;
import com.jvschool.dto.ProductAttribute;
import com.jvschool.model.BucketEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.svc.api.ProductService;
import com.jvschool.svc.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductDAO productDAO;

    @Mock
    private BucketDAO bucketDAO;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        List<BucketEntity> buckets = new ArrayList<>();
        BucketEntity bucketEntity1 = new BucketEntity();
        BucketEntity bucketEntity2 = new BucketEntity();
        bucketEntity1.setCountProduct(5);
        bucketEntity2.setCountProduct(5);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(1);
        bucketEntity1.setProductId(productEntity);
        bucketEntity2.setProductId(productEntity);
        buckets.add(bucketEntity1);
        buckets.add(bucketEntity2);
        List<ProductEntity> products = new ArrayList<>();
        products.add(productEntity);

        when(bucketDAO.getBucketsByProductId(1)).thenReturn(buckets);
        when(productDAO.getTopProducts()).thenReturn(products);


    }

    @Test
    public void testGetTopProducts() {
        List<ProductAttribute> productAttributes = productService.getTopProducts();
        Assert.assertEquals(10, productAttributes.get(0).getSumCount());
    }
}
