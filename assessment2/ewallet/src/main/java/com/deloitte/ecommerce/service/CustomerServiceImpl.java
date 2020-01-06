package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.dao.IEWalletDao;
import com.deloitte.ecommerce.exceptions.IncorrectMobilenoException;
import com.deloitte.ecommerce.entities.EWallet;

import java.util.Map;
import java.util.Set;

public class CustomerServiceImpl implements ICustomerService {
    private IEWalletDao dao;

    public CustomerServiceImpl(IEWalletDao dao) {
        this.dao = dao;
    }

    @Override
    public void addCustomer(EWallet c) {
        dao.addCustomer(c);
    }

    @Override
    public EWallet findCustomerByMobileno(String mobileno) {
        if (mobileno == null || mobileno.length() != 10) {
            throw new IncorrectMobilenoException("Mobile no enetered is not correct" );
        }
        EWallet c=dao.findCustomerByMobileno(mobileno);
        return c;
    }
    @Override
    public boolean credentialsCorrect(String username, String password) {
        boolean correct = dao.credentialsCorrect(username, password);
        return correct;
    }
}
