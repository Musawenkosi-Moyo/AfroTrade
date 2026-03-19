package com.apexion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankDetails {

    private String accountNumber;
    private String accountHolder;
    // private String bankName;
    private String ifscCode;

}
