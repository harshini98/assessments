package com.deloitte.ecommerce.entities;

public class EWallet {
    private String mobileno;
    private String name;
    private double balance;
    private String password;

    public EWallet() {
        this("", "");
    }

    public EWallet(String mobileno, String password) {
        this.mobileno = mobileno;
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double addAmount(double amount) {

        balance = balance + amount;
        return balance;
    }

    @Override
    public String toString() {
        String display = mobileno + " " + name + " " + balance;
        return display;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof EWallet)) {
            return false;
        }
        EWallet e = (EWallet) obj;
        return (e.mobileno).equals(this.mobileno);
    }


    @Override
    public int hashCode() {
        return mobileno.hashCode();
    }
}
