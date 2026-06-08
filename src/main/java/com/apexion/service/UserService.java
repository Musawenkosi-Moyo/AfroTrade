package com.apexion.service;

import com.apexion.model.User;

public interface UserService {

    User findUserByJwtToken(String jwt) throws Exception;

    User findUserByEmail(String email) throws Exception;

}
