package com.apexion.controller;

import com.apexion.domain.OrderStatus;
import com.apexion.model.Order;
import com.apexion.model.Seller;
import com.apexion.service.OrderService;
import com.apexion.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seller/orders")
public class SellerOrderController {

    private final OrderService orderService;
    private final SellerService sellerService;

    // Lists all the orders related to the specific seller
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrderHandler(
            @RequestHeader("Authorization") String jwt) throws Exception {

        Seller sellers = sellerService.getSellerProfile(jwt);
        List<Order> orders = orderService.sellersOrder(sellers.getId());

        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }

    @PatchMapping("{orderId}/status/{orderStatus}")
    public ResponseEntity<Order> updateOrderHandler(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId,
            @PathVariable OrderStatus orderStatus) throws Exception {

        Order order = orderService.updateOrderStatus(orderId, orderStatus);

        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }
}
