package com.apexion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apexion.domain.AccountStatus;
import com.apexion.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);

    List<Seller> findByAccountStatus(AccountStatus status);

}
