package com.apexion.service;

import java.util.List;

import com.apexion.domain.AccountStatus;
import com.apexion.model.Seller;
import com.apexion.exception.SellerException;


public interface SellerService {

    Seller getSellerProfile(String jwt) throws Exception;

    Seller createSeller(Seller seller) throws Exception;

    Seller getSellerById(Long id) throws SellerException;

    Seller updateSeller(Long id, Seller seller) throws Exception;

    Seller getSellerByEmail(String email) throws Exception;

    List<Seller> getAllSellers(AccountStatus status);

    void deleteSeller(Long id) throws Exception;

    Seller verifyEmail(String email, String otp) throws Exception;

    Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) throws Exception;

}
