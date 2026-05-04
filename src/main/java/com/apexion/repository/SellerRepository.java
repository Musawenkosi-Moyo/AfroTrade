package com.apexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apexion.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);

}
