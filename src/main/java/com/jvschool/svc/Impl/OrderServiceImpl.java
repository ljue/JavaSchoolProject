package com.jvschool.svc.Impl;

import com.jvschool.dao.*;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.DeliveryWayService;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.OrderAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Людмила on 28.07.2017.
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PayWayDAO payWayDAO;
    @Autowired
    private DeliveryWayService deliveryWayService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DeliveryStatusDAO deliveryStatusDAO;

    @Override
    public void saveOrder(OrderAttribute oa) {
        OrderEntity oe = new OrderEntity();
        oe.setAddress(addressDAO.getAddressById(oa.getAddressId()));
        oe.setUser(userDAO.getUserById(oa.getUserId()));
        oe.setDateTimeOrder(oa.getDateTimeOrder());
        oe.setPayWay(payWayDAO.getPayWayByName(oa.getPayWay()));
        oe.setDeliveryWay(deliveryWayService.getDeliveryWayByName(oa.getDeliveryWay()));

        oe.setDeliveryStatus(deliveryStatusDAO.getDeliveryStatusByName("Await"));

        for(Long product : oa.getProducts()) {
            oe.getProducts().add(productService.getProductById(product));
        }

        orderDAO.saveOrder(oe);
    }
}
