package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.EWallet;
import com.deloitte.ecommerce.exceptions.CustomerNotFoundException;

import java.util.*;

public class EWalletDaoImpl implements IEWalletDao {
    private Map<String, EWallet> store = new HashMap<>();

    public Map<String, EWallet> getStore() {
        return store;
    }

    public EWalletDaoImpl(){
        EWallet c1 = new EWallet("9121212112", "chandra");
        EWallet c2 = new EWallet("9121212123", "satya");
        c1.setName("chandra");
        c1.setBalance(1909.67);
        c2.setName("satya");
        c2.setBalance(98.0909);
//        store.put("9121212112",c1);
//        store.put("9121212123",c2);
        addCustomer(c1);
        addCustomer(c2);
    }
    @Override
    public void addCustomer(EWallet c) {
        store.put(c.getMobileno(), c);
    }

    @Override
    public EWallet findCustomerByMobileno(String mobileno) {
        EWallet c = store.get(mobileno);
        if (c == null) {
            throw new CustomerNotFoundException("Customer is not registered:" + mobileno);
        }
        return c;
    }

    @Override
    public boolean credentialsCorrect(String mobileno, String password) {
        EWallet wallet = store.get(mobileno);
        if (wallet == null) {
            return false;
        }
        return wallet.getPassword().equals(password);
    }

}
