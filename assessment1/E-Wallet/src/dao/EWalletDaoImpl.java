package dao;

import entities.EWallet;
import exceptions.CustomerNotFoundException;

import java.util.*;

public class EWalletDaoImpl implements IEWalletDao {
    private Map<String, EWallet> store = new HashMap<>();

    public Map<String, EWallet> getStore() {
        return store;
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
    public Set<EWallet> allCustomers() {
        Collection<EWallet> customers = store.values();
        Set<EWallet> customerSet = new HashSet<>(customers);
        return customerSet;
    }

    @Override
    public double transferAmount(EWallet c1, EWallet c2, double amount) {
        double balance1 = c1.getBalance();
        if ((balance1 - amount) > 0) {
            return c2.addAmount(amount);
        } else {
            return 0;
        }
    }
}
