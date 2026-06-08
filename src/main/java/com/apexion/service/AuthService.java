package com.apexion.service;

import com.apexion.domain.USER_ROLE;
import com.apexion.request.LoginRequest;
import com.apexion.response.AuthResponse;
import com.apexion.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email, USER_ROLE role) throws Exception;

    String createUser(SignupRequest req) throws Exception;

    AuthResponse signing(LoginRequest req) throws Exception;

}
