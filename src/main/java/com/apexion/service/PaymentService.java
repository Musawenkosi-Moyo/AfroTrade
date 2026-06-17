package com.apexion.service;

import com.apexion.model.Order;
import com.apexion.model.PaymentOrder;
import com.apexion.model.User;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

import java.util.Set;

public interface PaymentService {

    PaymentOrder createOrder(User user, Set<Order> order);
    PaymentOrder getPaymentOrderById(Long orderId) throws Exception;
    PaymentOrder getPaymentOrderByPaymentId(String orderId) throws Exception;
    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId, String paymentLinkId) throws RazorpayException;

    PaymentLink createRazorpayPaymentLink(User user, Long amount, Long orderId) throws RazorpayException;

    String createStripePaymentLink(User user,Long amount, Long orderId) throws StripeException;
}
