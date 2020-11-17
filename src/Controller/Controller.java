/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.DummyData;
import Model.Transfer_Transaction;
import Model.Withdrawal_Transaction;
import View.MainScreen;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author HansNotFound
 */
public class Controller {
    public Controller(){
    
    }
    public boolean InsertCard(String CardNum){
        DummyData dummy = new DummyData();
        boolean cocok = false;
        for(int i = 0; i < dummy.getListAcc().size();i++){
            if(CardNum.equals(dummy.getListAcc().get(i).getKartuATM().getCard_num())){
                cocok = true;
            }
        }
        return cocok;
    }
    public boolean ValidatePIN(int counter, int count){
        DummyData dummy = new DummyData();
        boolean cocok = false;
        String PIN = JOptionPane.showInputDialog("Masukkan PIN anda = ");
        if(PIN.equals(dummy.getListAcc().get(count).getKartuATM().getPIN())){
            cocok = true;
        }
        if(cocok == false){
            if(counter != 3){
                JOptionPane.showMessageDialog(null, "PIN yang anda masukkan salah");
                ValidatePIN(counter+1,count);
            } else {
                JOptionPane.showMessageDialog(null, "Anda sudah 3 kali memasukkan PIN salah, anda akan dikemablikan ke Menu Awal");
                new MainScreen();
            }            
        }
        return cocok;
    }
    public void CekSaldo(int count){
        DummyData dummy = new DummyData();
        boolean cocok;
        cocok = ValidatePIN(0,count);
        if(cocok){
            double saldo = dummy.getListAcc().get(count).getBalance();
            JOptionPane.showMessageDialog(null, "Saldo Anda = " + saldo);
        }
    }
    public void Withdraw(int count, String Kode_ATM){
        DummyData dummy = new DummyData();
        double saldo = dummy.getListAcc().get(count).getBalance();
        double tarik = Double.parseDouble(JOptionPane.showInputDialog("Masukkan jumlah uang yang akan ditarik = "));
        double saldo_ATM = 0;
        int ATM_counter = 0;
        for(int i = 0; i < dummy.getListATM().size(); i++){
            if(Kode_ATM.equals(dummy.getListATM().get(i).getKode_ATM())){
                saldo_ATM = dummy.getListATM().get(i).getCash();
                ATM_counter = i;
            }
        }
        boolean cocok;
        if(tarik <= saldo){
            cocok = ValidatePIN(0,count);
            if(cocok){
                saldo-=tarik;
                JOptionPane.showMessageDialog(null, "Harap Menunggu permintaan anda sedang diproses");
                JOptionPane.showMessageDialog(null, "Harap tarik uang anda dari mesin dan pastikan pas");
                JOptionPane.showMessageDialog(null, "Sisa saldo anda = " + saldo);
                dummy.getListAcc().get(count).setBalance(saldo);
                saldo_ATM-=saldo;
                dummy.getListATM().get(ATM_counter).setCash(saldo_ATM);
                Date now = new Date();
                String id = "00" + dummy.getListAcc().get(count).getAccount_num();
                Withdrawal_Transaction withdraw = new Withdrawal_Transaction(tarik,id,now);
                dummy.getListWithDraw().add(withdraw);
            } else {
                JOptionPane.showMessageDialog(null, "PIN yang anda masukkan salah!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak cukup!!");
        }
    }
    public void Transfer(int count){
        DummyData dummy = new DummyData();
        double saldo = dummy.getListAcc().get(count).getBalance();
        String cardNum = JOptionPane.showInputDialog("Masukkan Card Number yang ingin dituju = ");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Masukkan jumlah uang yang akan ditransfer = "));
        boolean cocok;
        if(amount <= saldo){
            cocok = ValidatePIN(0,count);
            if(cocok){
                JOptionPane.showMessageDialog(null, "Harap Menunggu permintaan anda sedang diproses");
                saldo-=amount;
                dummy.getListAcc().get(count).setBalance(saldo);
                for(int i = 0; i < dummy.getListAcc().size(); i++){
                    if(cardNum.equals(dummy.getListAcc().get(i).getAccount_num())){
                        double balance;
                        balance = dummy.getListAcc().get(i).getBalance() + amount;
                        dummy.getListAcc().get(i).setBalance(balance);
                    }
                }
                Date now = new Date();
                String id = "00" + dummy.getListAcc().get(count).getAccount_num();
                Transfer_Transaction trans = new Transfer_Transaction(cardNum,amount,id,now);
                dummy.getListTransfer().add(trans);
                JOptionPane.showMessageDialog(null, "Proses transfer berhasil!!\nSisa Saldo anda = "+dummy.getListAcc().get(count).getBalance());

            }
        }
    }
    public void EjectCard(){
        JOptionPane.showMessageDialog(null,"Harap Tarik kartu anda dari port kartu!!");
        JOptionPane.showMessageDialog(null,"Terima Kasih Telah Menggunakan Jasa ATM_PT_ITHB");
        System.exit(0);
    }
}
