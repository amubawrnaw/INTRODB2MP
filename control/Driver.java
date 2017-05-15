package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amiel
 */
import control.MainFrame_Listener;
import model.Account;
public class Driver {
    public void start(Account acc){
        new MainFrame_Listener(acc);
    }
    public static void main(String[] args){
        Driver d = new Driver();
        LoginListener ll = new LoginListener(d);
    }
}
