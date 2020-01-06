package service;

import dao.IEWalletDao;
import exceptions.IncorrectMobilenoException;
import entities.EWallet;

import java.util.Map;
import java.util.Set;

public class CustomerServiceImpl implements ICustomerService {
    private IEWalletDao dao;

    public CustomerServiceImpl(IEWalletDao dao) {
        this.dao = dao;
    }

    public IEWalletDao getCustomerDao() {
        return dao;
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
    public Set<EWallet> allCustomers() {
        Set<EWallet> customerSet=dao.allCustomers();
        return customerSet;
    }

    @Override
    public double transferAmount(EWallet c1, EWallet c2, double amount) {
        return dao.transferAmount(c1, c2, amount);
    }
}
