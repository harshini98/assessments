package entities;

public class EWallet {
    private String mobileno;
    private String name;
    private double balance;

    public EWallet() {
        this("", "");
    }

    public EWallet(String mobileno, String name) {
        this.mobileno = mobileno;
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
