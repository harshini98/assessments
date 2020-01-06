package dao;

import entities.EWallet;

import java.util.Map;
import java.util.Set;

public interface IEWalletDao {
    void addCustomer(EWallet c);

    EWallet findCustomerByMobileno(String mobileno);

    Set<EWallet> allCustomers();

    double transferAmount(EWallet c1, EWallet c2, double amount);

    Map<String, EWallet> getStore();


}
