/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HansNotFound
 */
public class Account {
    private String Account_num;
    private String Name;
    private String Address;
    private double Balance;
    private ATM_Card kartuATM;

    public Account(String Account_num, String Name, String Address, double Balance, ATM_Card kartuATM) {
        this.Account_num = Account_num;
        this.Name = Name;
        this.Address = Address;
        this.Balance = Balance;
        this.kartuATM = kartuATM;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getAccount_num() {
        return Account_num;
    }

    public void setAccount_num(String Account_num) {
        this.Account_num = Account_num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public ATM_Card getKartuATM() {
        return kartuATM;
    }

    public void setKartuATM(ATM_Card kartuATM) {
        this.kartuATM = kartuATM;
    }
    
}
