/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import Controller.Controller;
import Model.Account;
import Model.DummyData;
import Model.Enum;
/**
 *
 * @author HansNotFound
 */
public class MainScreen {
    public MainScreen(){
        showMain();
    }
    private void showMain(){
        boolean lanjut = true;
        Controller controller = new Controller();
        DummyData dummy = new DummyData();
        int mulai = JOptionPane.showConfirmDialog(null,"Selamat Datang ようこそ\nSilahkan Masukkan kartu");
        if(mulai == 0){
            String kode_ATM = dummy.getListATM().get(0).getKode_ATM();
            Enum.ActiveEnum statusActive = null;
            for(int i = 0; i < dummy.getListATM().size(); i++){
                if(kode_ATM.equals(dummy.getListATM().get(i).getKode_ATM())){
                    statusActive = dummy.getListATM().get(i).getStatus();
                }
            }
            if(statusActive == Enum.ActiveEnum.ACTIVE){
                String inputCardNum = JOptionPane.showInputDialog("Masukkan Card Number anda = ");
                boolean cardNumCocok = controller.InsertCard(inputCardNum);
                if(cardNumCocok){
                    int countCardNum = 0;
                    for(int i = 0; i < dummy.getListAcc().size();i++){
                        if(inputCardNum.equals(dummy.getListAcc().get(i).getKartuATM().getCard_num())){
                           countCardNum = i;
                        }
                    }
                    while(lanjut){
                        int inputmenu = Integer.parseInt(JOptionPane.showInputDialog("Selamat Datang "+ dummy.getListAcc().get(countCardNum).getName() + "\n1.CekSaldo\n2.WithDraw\n3.Transfer\n4.EjectCard\n5.ShowHistoryATM"));
                        switch(inputmenu){
                            case 1 : controller.CekSaldo(countCardNum);
                                break;
                            case 2 : controller.Withdraw(countCardNum,kode_ATM);
                                 break;
                            case 3 : controller.Transfer(countCardNum);
                                break;
                            case 4 : controller.EjectCard();
                                break;
                            case 5 : new ShowHistory();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Card Num atau PIN anda tidak cocok");
                }
            }
        } else{
            JOptionPane.showMessageDialog(null,"Program Celecai !! ありがとうございました");
            System.exit(0);
        }
    }
}
