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
public class ATM_Card {
    private String Card_num;
    private String PIN;

    public ATM_Card(String Card_num, String PIN) {
        this.Card_num = Card_num;
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getCard_num() {
        return Card_num;
    }

    public void setCard_num(String Card_num) {
        this.Card_num = Card_num;
    }
    
}
