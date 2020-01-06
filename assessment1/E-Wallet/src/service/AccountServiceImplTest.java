package service;

import dao.EWalletDaoImpl;
import service.CustomerServiceImpl;
import entities.EWallet;

import org.junit.*;

import java.util.Map;

public class AccountServiceImplTest {
@Test
public void testCreateAccount_1(){
    CustomerServiceImpl service=new CustomerServiceImpl(new EWalletDaoImpl());
    String mobileno="";
    double balance=1000;
    String name="ashdasuj";
    EWallet e1=new EWallet(mobileno,name);
    e1.setBalance(balance);
    service.addCustomer(e1);
    Assert.assertNotNull(e1);
    double resultBalance=e1.getBalance();
    Assert.assertEquals(balance, resultBalance,0);
    Assert.assertEquals(name, e1.getName());
    Map<String,EWallet> store=service.getCustomerDao().getStore();
    EWallet expected=store.get(mobileno);
    Assert.assertNotNull(expected);
    Assert.assertEquals(expected,e1);
}
}
