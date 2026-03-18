package com.apexion.controller;

import org.springframework.web.bind.annotation.RestController;

import com.apexion.response.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping
    public ApiResponse HomeControllerHandler() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to the Apexion MultiVendor");
        return apiResponse;
    }
}
