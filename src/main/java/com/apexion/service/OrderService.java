package com.apexion.service;



import com.apexion.domain.OrderStatus;
import com.apexion.model.*;

import java.util.List;
import java.util.Set;

public interface OrderService {

    Set<Order> createOrder(User user, Address shippingAddress, Cart cart);

    Order findOrderById(long id) throws Exception;
    List<Order>  userOrderHistory(long userId);
    List<Order>  sellersOrder(long sellerId);

    Order updateOrderStatus(Long orderId, OrderStatus orderStatus) throws Exception;
    Order cancelOrder(Long orderId, User user) throws Exception;

    OrderItem getOrderItemById(Long id) throws Exception;

}
