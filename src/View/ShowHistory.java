/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import Model.DummyData;
/**
 *
 * @author HansNotFound
 */
public class ShowHistory {
    public ShowHistory(){
        show();
    }
    private void show(){
        DummyData dummy = new DummyData();
        String kode = JOptionPane.showInputDialog(null, "Masukkan kode ATM yang ingin dilihat = ");
        for(int i = 0; i < dummy.getListATM().size();i++){
            if(kode.equals(dummy.getListATM().get(i).getKode_ATM())){
                JOptionPane.showMessageDialog(null, "Withdraw trans = " + dummy.getListWithDraw());
            }
        }
    }
}
