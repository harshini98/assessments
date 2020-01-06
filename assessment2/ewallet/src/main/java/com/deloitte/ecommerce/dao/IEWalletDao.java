package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.EWallet;

import java.util.Map;
import java.util.Set;

public interface IEWalletDao {
    void addCustomer(EWallet c);

    EWallet findCustomerByMobileno(String mobileno);

    boolean credentialsCorrect(String username, String password);
}
