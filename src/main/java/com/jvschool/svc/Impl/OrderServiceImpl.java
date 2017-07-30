package com.jvschool.svc.Impl;

import com.jvschool.dao.*;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.DeliveryStatusService;
import com.jvschool.svc.DeliveryWayService;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.OrderAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Людмила on 28.07.2017.
 */
@Service
@Transactional
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
    private DeliveryStatusService deliveryStatusService;

    @Override
    public void saveOrder(OrderAttribute oa) {
        OrderEntity oe = new OrderEntity();
        oe.setAddress(addressDAO.getAddressById(oa.getAddressId()));
        oe.setUser(userDAO.getUserById(oa.getUserId()));
        oe.setDateTimeOrder(oa.getDateTimeOrder());
        oe.setPayWay(payWayDAO.getPayWayByName(oa.getPayWay()));
        oe.setDeliveryWay(deliveryWayService.getDeliveryWayByName(oa.getDeliveryWay()));

        oe.setDeliveryStatus(deliveryStatusService.getDeliveryStatusByName("Await"));

        for(Long product : oa.getProducts()) {
            oe.getProducts().add(productService.getProductById(product));
        }

        orderDAO.saveOrder(oe);
    }

    @Override
    public List<OrderAttribute> getOrdersGroupByDeliveryStatus() {

        List <OrderEntity> loe = orderDAO.getOrdersGroupByDeliveryStatus();
        List <OrderAttribute> loa = new ArrayList<>();
        if (!loe.isEmpty()) {
            for(OrderEntity oe : loe) {
                loa.add(new OrderAttribute(oe));
            }
        }
        return loa;
//        Map<String,List<OrderAttribute>> ordersByDeliveryStatus = new HashMap();
//
//        for (String delivery : deliveries) {
//            List<OrderEntity> loe = orderDAO.getOrdersGroupByDeliveryStatus(delivery);
//            List<OrderAttribute> loa = new ArrayList<>();
//            if (!loe.isEmpty()) {
//                for (OrderEntity oe : loe) {
//                    loa.add(new OrderAttribute(oe));
//                }
//            }
//            ordersByDeliveryStatus.put(delivery, loa);
//        }
//        return ordersByDeliveryStatus;

    }

    @Override
    public OrderAttribute getOrderById(long id) {
        return new OrderAttribute(orderDAO.getOrderById(id));
    }
}
