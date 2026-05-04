package com.apexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apexion.model.VerificationCode;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {

    public VerificationCode findByEmail(String email);

}
