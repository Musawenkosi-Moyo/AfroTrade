package com.apexion.repository;

import com.apexion.model.Cart;
import com.apexion.model.CartItems;
import com.apexion.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepositiory extends JpaRepository<CartItems, Long> {

    CartItems findByCartAndProductAndSize(Cart cart, Product product, String size);
}
