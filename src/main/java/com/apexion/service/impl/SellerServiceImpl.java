package com.apexion.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apexion.config.JwtProvider;
import com.apexion.domain.AccountStatus;
import com.apexion.domain.USER_ROLE;
import com.apexion.model.Address;
import com.apexion.model.Seller;
import com.apexion.repository.AddressRepository;
import com.apexion.repository.SellerRepository;
import com.apexion.service.SellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;

    @Override
    public Seller getSellerProfile(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);

        return this.getSellerByEmail(email);
    }

    @Override
    public Seller createSeller(Seller seller) throws Exception {

        // Check of seller to create already exists or not
        Seller existingSeller = this.sellerRepository.findByEmail(seller.getEmail());
        if (existingSeller != null) {
            throw new Exception("Seller already exists");
        }

        // Set a pickup address for collection of products
        Address address = addressRepository.save(seller.getPickupAddress());

        // Creating the seller profile if seller does not exist
        Seller newSeller = new Seller();
        newSeller.setSellerName(seller.getSellerName());
        newSeller.setEmail(seller.getEmail());
        newSeller.setPassword(passwordEncoder.encode(seller.getPassword()));
        newSeller.setMobile(seller.getMobile());
        newSeller.setPickupAddress(address);
        newSeller.setVAT(seller.getVAT());
        newSeller.setRole(USER_ROLE.ROLE_SELLER);
        newSeller.setBankDetails(seller.getBankDetails());
        newSeller.setBusinessDetails(seller.getBusinessDetails());

        return sellerRepository.save(newSeller);
    }

    @Override
    public Seller getSellerById(Long id) throws Exception {

        return sellerRepository.findById(id).orElseThrow(() -> new Exception("Seller not found"));
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) throws Exception {

        // Check if the seller we want to update exists or not
        Seller existingSeller = this.getSellerById(id);

        // Update seller details if not null

        if (seller.getSellerName() != null) {
            existingSeller.setSellerName(seller.getSellerName());
        }

        if (seller.getMobile() != null) {
            existingSeller.setMobile(seller.getMobile());
        }

        if (seller.getEmail() != null) {
            existingSeller.setEmail(seller.getEmail());
        }

        if (seller.getBusinessDetails() != null && seller.getBusinessDetails().getBusinessName() != null) {
            existingSeller.getBusinessDetails().setBusinessName(seller.getBusinessDetails().getBusinessName());
        }

        // Update bank details
        if (seller.getBankDetails() != null
                && seller.getBankDetails().getAccountHolder() != null
                && seller.getBankDetails().getIfscCode() != null
                && seller.getBankDetails().getAccountNumber() != null) {
            existingSeller.getBankDetails().setAccountHolder(seller.getBankDetails().getAccountHolder());
            existingSeller.getBankDetails().setAccountNumber(seller.getBankDetails().getAccountNumber());
            existingSeller.getBankDetails().setIfscCode(seller.getBankDetails().getIfscCode());
        }

        // Update pickup address
        if (seller.getPickupAddress() != null
                && seller.getPickupAddress().getAddress() != null
                && seller.getPickupAddress().getMobile() != null
                && seller.getPickupAddress().getCity() != null
                && seller.getPickupAddress().getState() != null) {
            existingSeller.getPickupAddress().setAddress(seller.getPickupAddress().getAddress());
            existingSeller.getPickupAddress().setMobile(seller.getPickupAddress().getMobile());
            existingSeller.getPickupAddress().setCity(seller.getPickupAddress().getCity());
            existingSeller.getPickupAddress().setState(seller.getPickupAddress().getState());
            existingSeller.getPickupAddress().setPinCode(seller.getPickupAddress().getPinCode());
        }

        if (seller.getVAT() != null) {
            existingSeller.setVAT(seller.getVAT());
        }

        return sellerRepository.save(existingSeller);
    }

    @Override
    public Seller getSellerByEmail(String email) throws Exception {
        Seller seller = sellerRepository.findByEmail(email);

        if (seller == null) {
            throw new Exception("Seller not found");
        }
        return seller;
    }

    @Override
    public List<Seller> getAllSellers(AccountStatus status) {

        // Enables the searching of sellers using the status of their account
        return sellerRepository.findByAccountStatus(status);
    }

    @Override
    public void deleteSeller(Long id) throws Exception {

        Seller seller = getSellerById(id);
        sellerRepository.delete(seller);

    }

    @Override
    public Seller verifyEmail(String email, String otp) throws Exception {

        Seller seller = getSellerByEmail(email);
        seller.setIsEmailVerified(true);
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) throws Exception {
        Seller seller = getSellerById(sellerId);
        seller.setAccountStatus(status);
        return sellerRepository.save(seller);
    }
}
