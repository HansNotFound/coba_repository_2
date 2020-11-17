/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.ActiveEnum;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author HansNotFound
 */
public class DummyData {
    private ArrayList<Account> listAcc = new ArrayList<>();
    private ArrayList<ATM_Machine> listATM = new ArrayList<>();
    private ArrayList<Withdrawal_Transaction> listWithDraw = new ArrayList<>();
    private ArrayList<Transfer_Transaction> listTransfer = new ArrayList<>();
    
    public DummyData(){
        ATM_Card kartuATM_1 = new ATM_Card("1234567890","123456");
        Account acc = new Account("041101","Hans","Jl. DU",1000000,kartuATM_1);
        listAcc.add(acc);
        ATM_Card kartuATM_2 = new ATM_Card("0987654321","654321");
        acc = new Account("011104","Patrick","Jl. DUI",2000000,kartuATM_2);
        listAcc.add(acc);
        ATM_Machine machine = new ATM_Machine("ATM_01",10000000,ActiveEnum.ACTIVE);
        listATM.add(machine);
        machine = new ATM_Machine("ATM_02",10000000,ActiveEnum.INACTIVE);
        listATM.add(machine);
        Date now = new Date();
        Withdrawal_Transaction withdraw = new Withdrawal_Transaction(0,"001",now);
        listWithDraw.add(withdraw);
        Transfer_Transaction trans = new Transfer_Transaction("1234567890",500000,"002",now);
    }

    public ArrayList<Account> getListAcc() {
        return listAcc;
    }

    public void setListAcc(ArrayList<Account> listAcc) {
        this.listAcc = listAcc;
    }

    public ArrayList<ATM_Machine> getListATM() {
        return listATM;
    }

    public void setListATM(ArrayList<ATM_Machine> listATM) {
        this.listATM = listATM;
    }

    public ArrayList<Withdrawal_Transaction> getListWithDraw() {
        return listWithDraw;
    }

    public void setListWithDraw(ArrayList<Withdrawal_Transaction> listWithDraw) {
        this.listWithDraw = listWithDraw;
    }

    public ArrayList<Transfer_Transaction> getListTransfer() {
        return listTransfer;
    }

    public void setListTransfer(ArrayList<Transfer_Transaction> listTransfer) {
        this.listTransfer = listTransfer;
    }
}
