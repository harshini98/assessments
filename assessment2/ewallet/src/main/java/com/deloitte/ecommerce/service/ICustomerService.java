package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.entities.EWallet;

import java.util.Set;

public interface ICustomerService {
    void addCustomer(EWallet c);

    EWallet findCustomerByMobileno(String mobileno);

    boolean credentialsCorrect(String username, String password);
}

