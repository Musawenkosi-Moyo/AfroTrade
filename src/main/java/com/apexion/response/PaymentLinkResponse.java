package com.apexion.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLinkResponse {

    //Allows the  User to make payment
    private String payment_link_url;
    private String payment_link_id;

}
