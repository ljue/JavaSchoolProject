package com.jvschool.svc.impl;

import com.jvschool.dao.api.AddressDAO;
import com.jvschool.dao.api.OrderDAO;
import com.jvschool.dao.api.PayWayDAO;
import com.jvschool.dao.api.UserDAO;
import com.jvschool.model.BucketEntity;
import com.jvschool.model.DeliveryStatusEntity;
import com.jvschool.model.OrderEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.svc.api.DeliveryStatusService;
import com.jvschool.svc.api.DeliveryWayService;
import com.jvschool.svc.api.OrderService;
import com.jvschool.svc.api.ProductService;
import com.jvschool.dto.BucketAttribute;
import com.jvschool.dto.OrderAttribute;
import com.jvschool.dto.ProductAttribute;
import com.jvschool.util.senders.EmailSenderOrder;
import com.jvschool.util.senders.Sender;
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
            ProductEntity productEntity = productService.getProductById(bucketAttribute.getProductId());
            bucketEntity.setProductId(productEntity);
            bucketEntity.setCostProduct(productEntity.getCost());
            lbe.add(bucketEntity);
        }
        orderEntity.setBuckets(lbe);

        List<ProductAttribute> productAttributesBefore = productService.getTopProducts();

        orderDAO.saveOrder(orderEntity);

        List<ProductAttribute> productAttributesAfter = productService.getTopProducts();

        if(!productAttributesAfter.equals(productAttributesBefore)) {
            new Sender().send();
        }

        Runnable r = new EmailSenderOrder(orderEntity);
        new Thread(r).start();
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
