package com.apexion.service;

import com.apexion.model.Seller;
import com.apexion.model.SellerReport;

public interface SellerReportService {

    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport(SellerReport sellerReport);
}
