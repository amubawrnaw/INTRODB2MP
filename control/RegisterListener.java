/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import model.DBConnection;
import view.RegisterFrame;

/**
 *
 * @author amiel
 */
public class RegisterListener implements ActionListener{
    
    private LoginListener ll;
    private RegisterFrame rf;
    private DBConnection dbc;
    public RegisterListener(LoginListener ll){
        this.ll = ll;
        rf = new RegisterFrame();
        dbc = new DBConnection();
        dbc.getConnection();
        
        rf.getConfirmBtn().addActionListener(this);
        rf.getReturnBtn().addActionListener(this);
    }
    private void createAccount(){
        String fName = rf.getFirstField().getText();
        String lName = rf.getLastField().getText();
        String contactNo = rf.getContactField().getText();
        String username = rf.getUserNameField().getText();
        String password = rf.getPassField().getText();
        String email = rf.getEmailField().getText();
        
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO account(firstName, lastName, contactNo, username,password,email) ");
        sb.append("VALUES ('");
        sb.append(fName + "','");
        sb.append(lName + "','");
        sb.append(contactNo + "','");
        sb.append(username + "','");
        sb.append(password + "','");
        sb.append(email + "')");
        
        try{
            Statement statement = dbc.getConnection().createStatement();
            statement.executeUpdate(sb.toString());
            System.out.println("Register successful!");
            JOptionPane.showMessageDialog(null, "Register success!");
            done();
        }catch(Exception e){
            System.out.println("Register failed!");
            e.printStackTrace();
        }
    }
    private void done(){
        rf.setVisible(false);
        rf.dispose();
        ll.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //check if confirm button was pressed
        if(ae.getActionCommand().compareToIgnoreCase("Confirm") == 0){
            String username = rf.getUserNameField().getText();
            String email = rf.getEmailField().getText();
            System.out.println("Confirm Btn Pressed!");
            
            String queryCheck = "SELECT * FROM account WHERE username = \"" + username + "\" OR email = \"" + email + "\"";
            try{
                Statement statement = dbc.getConnection().createStatement();
                ResultSet rsCheck = statement.executeQuery(queryCheck);
                //if username/email exists, an error message will pop up and the account will not be created
                if(rsCheck.next()){
                    JOptionPane.showMessageDialog(null, "username/email is already taken!");
                }
                else{
                    createAccount();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Return Btn Pressed!");
            done();
        }
    }
    
}
