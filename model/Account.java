/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author amiel
 */
public class Account {
    private String username;
    private String fName;
    private String lName;
    private int userId;
    private String contactNo;
    private String email;
    public Account(ResultSet rs){
        toAccount(rs);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(username + ", ");
        sb.append(fName + ", ");
        sb.append(lName + ", ");
        sb.append(userId + ", ");
        sb.append(contactNo + ", ");
        sb.append(email);
        return sb.toString();
    }
    public Account(String username, String fName, String lName, int userId, String contactNo, String email) {
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.userId = userId;
        this.contactNo = contactNo;
        this.email = email;
    }
    public void toAccount(ResultSet rs){
        try{
            username = rs.getString("username");
            fName = rs.getString("firstName");
            contactNo = rs.getString("contactNo");
            email = rs.getString("email");
            userId = Integer.parseInt(rs.getString("accountID"));
            lName = rs.getString("lastName");
        }catch(Exception e){
            System.out.println("account loading failed!");
            e.printStackTrace();
        }
        
    }
    public String getUsername() {
        return username;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getUserId() {
        return userId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
