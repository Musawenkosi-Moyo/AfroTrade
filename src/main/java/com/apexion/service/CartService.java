package com.apexion.service;

import com.apexion.model.Cart;
import com.apexion.model.CartItems;
import com.apexion.model.Product;
import com.apexion.model.User;

public interface CartService {

    public CartItems addCartItem(
        User user,
        Product product,
        String size,
        int quantity
        );

    public Cart findUserCart(User user);

}
