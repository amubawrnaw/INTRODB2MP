/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Account;
import model.DBConnection;
import view.LoginFrame;


/**
 *
 * @author amiel
 */
public class LoginListener implements ActionListener{
    private Driver d;
    private LoginFrame lf;
    private DBConnection dbc;
    public LoginListener(Driver d){
        this.d = d;
        lf = new LoginFrame();
        lf.getLoginBtn().addActionListener(this);
        lf.getRegisterBtn().addActionListener(this);
        dbc = new DBConnection();
        dbc.getConnection();
    }
    public void setVisible(boolean b){
        lf.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //check if the button which triggered this action event is the login
        if(ae.getActionCommand().compareToIgnoreCase("Login") == 0){
            System.out.println("login btn pressed");
            
            String username = lf.getUserField().getText();
            String password = lf.getPassField().getText();
            
            ResultSet rs;
            boolean rsFound = false;
            String query = "SELECT * FROM account WHERE username = \"" + username + "\" AND password = \"" + password +"\"";
                    
            try{
                Statement statement = dbc.getConnection().createStatement();
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    rsFound = true;
                    System.out.println("Login Success!");
                    d.start(new Account(rs));
                    lf.dispose();
                    lf.setVisible(false);
                }
                if(!rsFound){
                    JOptionPane.showMessageDialog(null, "Invalid username / password!");
                    System.out.println("Login Failed!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
                
        }
        else{
            System.out.println("reg btn pressed");
            lf.setVisible(false);
            new RegisterListener(this);
        }
    }
}
