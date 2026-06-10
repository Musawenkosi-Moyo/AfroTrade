package com.apexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apexion.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(Long id);

}
