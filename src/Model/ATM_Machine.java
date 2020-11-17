/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.ActiveEnum;

/**
 *
 * @author HansNotFound
 */
public class ATM_Machine {
    private String Kode_ATM;
    private double cash;
    private ActiveEnum status;
    Withdrawal_Transaction withdraw;

    public ATM_Machine(String Kode_ATM, double cash, ActiveEnum status) {
        this.Kode_ATM = Kode_ATM;
        this.cash = cash;
        this.status = status;
    }

    public ActiveEnum getStatus() {
        return status;
    }

    public void setStatus(ActiveEnum status) {
        this.status = status;
    }

    public String getKode_ATM() {
        return Kode_ATM;
    }

    public void setKode_ATM(String Kode_ATM) {
        this.Kode_ATM = Kode_ATM;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
    
}
