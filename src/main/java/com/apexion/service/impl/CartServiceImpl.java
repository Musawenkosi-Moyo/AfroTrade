package com.apexion.service.impl;

import com.apexion.model.Cart;
import com.apexion.model.CartItems;
import com.apexion.model.Product;
import com.apexion.model.User;
import com.apexion.repository.CartItemRepositiory;
import com.apexion.repository.CartRepository;
import com.apexion.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CartServiceImpl implements CartService {

    private final CartItemRepositiory cartItemRepositiory;
    private final CartRepository cartRepository;

    @Override
    public CartItems addCartItem(User user, Product product, String size, int quantity) {

        Cart cart = findUserCart(user);

        CartItems isPresent = cartItemRepositiory.findByCartAndProductAndSize(cart, product, size);

        if(isPresent == null){
            CartItems cartItems = new CartItems();
            cartItems.setProduct(product);
            cartItems.setSize(size);
            cartItems.setQuantity(quantity);
            cartItems.setUserId(user.getId());

            int totalPrice = quantity*product.getSellingPrice();
            cartItems.setSellingPrice(totalPrice);
            cartItems.setMrpPrice(quantity*product.getMrpPrice());
            cart.getCartItems().add(cartItems);
            cartItems.setCart(cart);

            return cartItemRepositiory.save(cartItems);
        }
        return isPresent;
    }

    @Override
    public Cart findUserCart(User user) {
        Cart cart = cartRepository.findByUserId(user.getId());

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for(CartItems cartItems: cart.getCartItems()){
            totalPrice += cartItems.getMrpPrice();
            totalDiscountedPrice += cartItems.getSellingPrice();
            totalItem += cartItems.getQuantity();
        }

        cart.setTotalMrpPrice(totalPrice);
        cart.setTotalItem(totalItem);
        cart.setTotalSellingPrice(totalDiscountedPrice);
        cart.setDiscount(calculateDiscountPercentage(totalPrice, totalDiscountedPrice));

        return cart;
    }

    private int calculateDiscountPercentage(int mrpPrice, int sellingPrice) {

        if (mrpPrice <= 0){
            return 0;
        }

        double discount = mrpPrice-sellingPrice;

        double discountPercentage = (discount/mrpPrice)*100;

        return (int)discountPercentage;
    }

}
