package com.apexion.service;

import com.apexion.request.LoginRequest;
import com.apexion.response.AuthResponse;
import com.apexion.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email) throws Exception;

    String createUser(SignupRequest req) throws Exception;

    AuthResponse signing(LoginRequest req);

}
