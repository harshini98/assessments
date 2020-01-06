package service;

import entities.EWallet;

import java.util.Set;

public interface ICustomerService {
    void addCustomer(EWallet c);

    EWallet findCustomerByMobileno(String mobileno);

    Set<EWallet> allCustomers();

    double transferAmount(EWallet c1, EWallet c2, double amount);
}

