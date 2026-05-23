package com.apexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apexion.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
