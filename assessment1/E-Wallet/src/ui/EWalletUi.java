package ui;

import dao.EWalletDaoImpl;
import entities.EWallet;
import service.ICustomerService;
import service.CustomerServiceImpl;

import java.util.Collection;
import java.util.Set;

public class EWalletUi {
    private ICustomerService service = new CustomerServiceImpl(new EWalletDaoImpl());

    public static void main(String[] args) {
        EWalletUi ui = new EWalletUi();
        ui.runUi();
    }

    public void runUi() {
        try {
            EWallet c1 = new EWallet("9121212112", "chandra");
            EWallet c2 = new EWallet("912121212", "satya");
            service.addCustomer(c1);
            service.addCustomer(c2);
            c1.setBalance(7898);
            c2.setBalance(8876);
            EWallet fetched1 = service.findCustomerByMobileno("9121212112");
            EWallet fetched2 = service.findCustomerByMobileno("91212121");
            System.out.println(fetched1.getName());
            System.out.println(fetched2.getName());
            System.out.println("********printing all employees****");
            Set<EWallet> customers = service.allCustomers();
            service.transferAmount(c1, c2, 687);
            print(customers);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }
    }

    void print(Collection<EWallet> customers) {
        for (EWallet c : customers) {
            System.out.println(c.getName());
        }
    }
}
