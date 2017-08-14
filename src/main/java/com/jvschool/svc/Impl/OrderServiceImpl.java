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
    public void saveOrder(final OrderAttribute orderAttribute) {
        final OrderEntity orderEntity = new OrderEntity();

        orderEntity.setAddress(addressDAO.getAddressById(orderAttribute.getAddressId()));
        orderEntity.setUser(userDAO.getUserById(orderAttribute.getUserId()));
        orderEntity.setDateTimeOrder(orderAttribute.getDateTimeOrder());
        orderEntity.setPayWay(payWayDAO.getPayWayByName(orderAttribute.getPayWay()));
        orderEntity.setDeliveryWay(deliveryWayService.getDeliveryWayByName(orderAttribute.getDeliveryWay()));

        DeliveryStatusEntity deliveryStatusEntity = deliveryStatusService.getDeliveryStatusByName("Await");
        if (deliveryStatusEntity == null) {
            deliveryStatusEntity = new DeliveryStatusEntity();
            deliveryStatusEntity.setDeliveryStatusName("Await");
        }
        orderEntity.setDeliveryStatus(deliveryStatusEntity);

        List<BucketAttribute> lba = orderAttribute.getBuckets();
        List<BucketEntity> lbe = new ArrayList<>();
        for (BucketAttribute bucketAttribute : lba) {
            BucketEntity bucketEntity = new BucketEntity();
            bucketEntity.setCountProduct(bucketAttribute.getCountProduct());
            bucketEntity.setProductId(productService.getProductById(bucketAttribute.getProductId()));
            lbe.add(bucketEntity);
        }
        orderEntity.setBuckets(lbe);

        orderDAO.saveOrder(orderEntity);
    }

    @Override
    public void editOrderDeliveryStatus(OrderAttribute orderAttribute) {
        OrderEntity orderEntity = orderDAO.getOrderById(orderAttribute.getOrderId());
        orderEntity.setDeliveryStatus(deliveryStatusService.getDeliveryStatusByName(orderAttribute.getDeliveryStatus()));
        orderDAO.saveOrder(orderEntity);
    }

    @Override
    public List<OrderAttribute> getOrdersGroupByDeliveryStatus() {

        List<OrderEntity> loe = orderDAO.getOrdersGroupByDeliveryStatus();
        List<OrderAttribute> loa = new ArrayList<>();
        for (OrderEntity oe : loe) {
            loa.add(new OrderAttribute(oe));
        }

        return loa;

    }

    @Override
    public OrderAttribute getOrderById(long id) {
        return new OrderAttribute(orderDAO.getOrderById(id));
    }

    @Override
    public List<OrderAttribute> getOrdersByUserId(long id) {
        List<OrderAttribute> loa = new ArrayList<>();
        orderDAO.getOrdersByUserId(id)
                .stream().forEachOrdered(oe -> loa.add(new OrderAttribute(oe)));
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
