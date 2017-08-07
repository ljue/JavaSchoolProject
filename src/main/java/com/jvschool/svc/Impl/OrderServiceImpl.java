package com.jvschool.svc.Impl;

import com.jvschool.dao.*;
import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.DeliveryStatusEntity;
import com.jvschool.entities.OrderEntity;
import com.jvschool.svc.DeliveryStatusService;
import com.jvschool.svc.DeliveryWayService;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.BucketAttribute;
import com.jvschool.util.Attributes.OrderAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;



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
        if(oa.getOrderId()!=0) {
            oe.setOrderId(oa.getOrderId());
        }
        oe.setAddress(addressDAO.getAddressById(oa.getAddressId()));
        oe.setUser(userDAO.getUserById(oa.getUserId()));
        oe.setDateTimeOrder(oa.getDateTimeOrder());
        oe.setPayWay(payWayDAO.getPayWayByName(oa.getPayWay()));
        oe.setDeliveryWay(deliveryWayService.getDeliveryWayByName(oa.getDeliveryWay()));

        if(oa.getDeliveryStatus()==null) {
            DeliveryStatusEntity deliveryStatusEntity = deliveryStatusService.getDeliveryStatusByName("Await");
            if(deliveryStatusEntity==null) {
                deliveryStatusEntity = new DeliveryStatusEntity();
                deliveryStatusEntity.setDeliveryStatusName("Await");
            }
            oe.setDeliveryStatus(deliveryStatusEntity);
        }
        else oe.setDeliveryStatus(deliveryStatusService.getDeliveryStatusByName(oa.getDeliveryStatus()));

        List<BucketAttribute> lba = oa.getBuckets();
        List<BucketEntity> lbe = new ArrayList<>();
        for (BucketAttribute ba : lba) {
            BucketEntity be = new BucketEntity();
            be.setCountProduct(ba.getCountProduct());
            be.setProductId(productService.getProductById(ba.getProductId()));
            lbe.add(be);
        }
        oe.setBuckets(lbe);

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

    }

    @Override
    public OrderAttribute getOrderById(long id) {
        return new OrderAttribute(orderDAO.getOrderById(id));
    }

    @Override
    public List<OrderAttribute> getOrdersByUserId(long id) {
        List<OrderEntity> loe = orderDAO.getOrdersByUserId(id);
        List<OrderAttribute> loa = new ArrayList<>();
        if(!loe.isEmpty()) {
            for(OrderEntity oe : loe) {
                loa.add(new OrderAttribute(oe));
            }
        }
        return loa;
    }

    @Override
    public double getWeekProceed() {
        return orderDAO.getWeekProceed();
    }

    @Override
    public double getMonthProceed() {
        return orderDAO.getMonthProceed();
    }

}
