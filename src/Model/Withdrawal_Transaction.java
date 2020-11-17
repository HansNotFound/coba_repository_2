/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author HansNotFound
 */
public class Withdrawal_Transaction extends Transaction {
    private double Amount;
    
    public Withdrawal_Transaction(double Amount, String TransactionID, Date DateTime) {
        super(TransactionID, DateTime);
        this.Amount = Amount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    @Override
    public String toString() {
        return "Withdrawal_Transaction{" + "Amount=" + Amount + '}';
    }
    
    
}
