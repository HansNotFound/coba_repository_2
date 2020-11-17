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
public class Transfer_Transaction extends Transaction {
    private String Destination_num;
    private double Amount;

    public Transfer_Transaction(String Destination_num, double Amount, String TransactionID, Date DateTime) {
        super(TransactionID, DateTime);
        this.Destination_num = Destination_num;
        this.Amount = Amount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getDestination_num() {
        return Destination_num;
    }

    public void setDestination_num(String Destination_num) {
        this.Destination_num = Destination_num;
    }

    @Override
    public String toString() {
        return "Transfer_Transaction{" +"Transaction ID " + super.getTransactionID() +"Transaction Date = " +super.getDateTime() +"Destination_num=" + Destination_num + ", Amount=" + Amount + '}';
    }
    
}
