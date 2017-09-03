//package integration;
//
//import com.jvschool.config.AppConfig;
//import com.jvschool.config.DataBaseConfig;
//import com.jvschool.config.WebAppInitializer;
//import com.jvschool.dao.*;
//import com.jvschool.svc.*;
//import com.jvschool.util.AddressValidator;
//import com.jvschool.util.validators.OrderValidator;
//import com.jvschool.util.validators.ProductValidator;
//import com.jvschool.util.validators.UserValidator;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(Arquillian.class)
////@WebAppConfiguration
////@ContextConfiguration(classes = {AppConfig.class, WebAppInitializer.class, DataBaseConfig.class})
//public class CommonIT extends AbstractJUnit4SpringContextTests {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    private AddressDAO addressDAO;
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private BucketDAO bucketDAO;
//
//    @Autowired
//    private CategoryDAO categoryDAO;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private DeliveryStatusDAO deliveryStatusDAO;
//
//    @Autowired
//    private DeliveryStatusService deliveryStatusService;
//
//    @Autowired
//    private DeliveryWayDAO deliveryWayDAO;
//
//    @Autowired
//    private DeliveryWayService deliveryWayService;
//
//    @Autowired
//    private OrderDAO orderDAO;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private PayWayDAO payWayDAO;
//
//    @Autowired
//    private PayWayService payWayService;
//
//    @Autowired
//    private ProductDAO productDAO;
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private PropertyDAO propertyDAO;
//
//    @Autowired
//    private PropertyService propertyService;
//
//    @Autowired
//    private PropertyGroupDAO propertyGroupDAO;
//
//    @Autowired
//    private PropertyGroupService propertyGroupService;
//
//    @Autowired
//    private RoleDAO roleDAO;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @Autowired
//    private AddressValidator addressValidator;
//
//    @Autowired
//    private OrderValidator orderValidator;
//
//    @Autowired
//    private ProductValidator productValidator;
//
//    @Deployment(testable = false)
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class, "configuration.jar")
//                .addAsResource("persistence-test.xml", "META-INF/persistence.xml")
//                .addClasses(AppConfig.class, DataBaseConfig.class, WebAppInitializer.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//
//    @Test
//    public void EntityManagerTest() {
//        assertNotNull(em);
//    }
//
//    @Test
//    public void AddressDAOTest() {
//        assertNotNull(addressDAO);
//    }
//
//    @Test
//    public void AddressServiceTest() {
//        assertNotNull(addressService);
//    }
//
//    @Test
//    public void BucketDAOTest() {
//        assertNotNull(bucketDAO);
//    }
//
//    @Test
//    public void CategoryDAOTest() {
//        assertNotNull(categoryDAO);
//    }
//
//    @Test
//    public void CategoryServiceTest() {
//        assertNotNull(categoryService);
//    }
//
//    @Test
//    public void DeliveryStatusDAOTest() {
//        assertNotNull(deliveryStatusDAO);
//    }
//
//    @Test
//    public void DeliveryStatusServiceTest() {
//        assertNotNull(deliveryStatusService);
//    }
//
//    @Test
//    public void DeliveryWayDAOTest() {
//        assertNotNull(deliveryWayDAO);
//    }
//
//    @Test
//    public void DeliveryWayServiceTest() {
//        assertNotNull(deliveryWayService);
//    }
//
//    @Test
//    public void OrderDAOTest() {
//        assertNotNull(orderDAO);
//    }
//
//    @Test
//    public void OrderServiceTest() {
//        assertNotNull(orderService);
//    }
//
//    @Test
//    public void PayWayDAOTest() {
//        assertNotNull(payWayDAO);
//    }
//
//    @Test
//    public void PayWayServiceTest() {
//        assertNotNull(payWayService);
//    }
//
//    @Test
//    public void ProductDAOTest() {
//        assertNotNull(productDAO);
//    }
//
//    @Test
//    public void ProductServiceTest() {
//        assertNotNull(productService);
//    }
//
//    @Test
//    public void PropertyGroupDAOTest() {
//        assertNotNull(propertyGroupDAO);
//    }
//
//    @Test
//    public void PropertyGroupServiceTest() {
//        assertNotNull(propertyGroupService);
//    }
//
//    @Test
//    public void PropertyDAOTest() {
//        assertNotNull(propertyDAO);
//    }
//
//    @Test
//    public void PropertyServiceTest() {
//        assertNotNull(propertyService);
//    }
//
//    @Test
//    public void RoleDAOTest() {
//        assertNotNull(roleDAO);
//    }
//
//    @Test
//    public void RoleServiceTest() {
//        assertNotNull(roleService);
//    }
//
//    @Test
//    public void UserDAOTest() {
//        assertNotNull(userDAO);
//    }
//
//    @Test
//    public void UserServiceTest() {
//        assertNotNull(userService);
//    }
//
//    @Test
//    public void AddressValidatorTest() {
//        assertNotNull(addressValidator);
//    }
//
//    @Test
//    public void OrderValidatorTest() {
//        assertNotNull(orderValidator);
//    }
//
//    @Test
//    public void ProductValidatorTest() {
//        assertNotNull(productValidator);
//    }
//
//    @Test
//    public void UserValidatorTest() {
//        assertNotNull(userValidator);
//    }
//
//
//}
