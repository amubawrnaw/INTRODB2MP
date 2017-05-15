/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel_control;

import control.MainFrame_Listener;
import java.sql.*;
import java.util.ArrayList;
import model.DBConnection;
import panels.*;

/**
 *
 * @author amiel
 */
public class CenterPanel_Listener{
    private CenterPanel cp;
    private MainFrame_Listener mfl;
    private DBConnection dbc;
    public CenterPanel_Listener(MainFrame_Listener mfl){
        dbc = new DBConnection();
        dbc.getConnection();
        this.mfl = mfl;
    }
    
    public String[] getCompanies(){
        ArrayList<String> companyNames = new ArrayList<>();
        String query = "SELECT * FROM company";
        
        Statement statement;
        try{
            statement = dbc.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                String s = rs.getString("companyName");
                System.out.println(s + " from companies retrieved!");
                companyNames.add(s);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        String[] str = new String[companyNames.size()];
        for(int i = 0 ; i < companyNames.size() ; i ++){
            str[i] = companyNames.get(i);
        }
        return str;
    }
    public String[] getCategories(){
        ArrayList<String> categoryNames = new ArrayList<>();
        String query = "SELECT * FROM category";
        
        try{
            ResultSet rs = dbc.executeQuery(query);
            while(rs.next()){
                categoryNames.add(rs.getString("categoryName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] str = new String[categoryNames.size()];
        for(int i = 0 ; i < categoryNames.size() ; i ++){
            str[i] = categoryNames.get(i);
        }
        return str;
    }
    public String[] getShipping(){
        ArrayList<String> ship = new ArrayList<>();
        String query = "SELECT * FROM shipping";
        
        try{
            ResultSet rs = dbc.executeQuery(query);
            while(rs.next()){
                ship.add(rs.getString("shippingName") + " | P" + rs.getString("shippingPrice") + " | " + rs.getString("days") + " days");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] str = new String[ship.size()];
        for(int i = 0 ; i < ship.size() ; i ++){
            str[i] = ship.get(i);
        }
        return str;
    }
    public String[] getCart(){
        ArrayList<String> cart = new ArrayList<>();
        String query = "SELECT itemName, quantity, itemPrice FROM cart c, items i , accountCart ac WHERE c.cartID = ac.cartID AND ac.accountID = '" + mfl.getAccount().getUserId() + "' AND c.itemId = i.itemId";
        
        try{
            ResultSet rs = dbc.executeQuery(query);
            while(rs.next()){
                cart.add(rs.getString("itemName") + " | " + rs.getString("quantity") + " | P" + (rs.getDouble("itemPrice") * rs.getInt("quantity")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] str = new String[cart.size()];
        for(int i = 0 ; i < cart.size() ; i ++){
            str[i] = cart.get(i);
        }
        if(cart.size() == 0){
            str = new String[]{"You have no items in the cart yet!"};
        }
                
        return str;
    }
    public String[] getAddress(){
        ArrayList<String> add = new ArrayList<>();
        String query = "SELECT * FROM address WHERE accountId = '" + mfl.getAccount().getUserId() + "'" ;
        
        try{
            ResultSet rs = dbc.executeQuery(query);
            while(rs.next()){
                add.add(rs.getString("country") + ", " + rs.getString("City") + ", " + rs.getString("State") + ", "  + rs.getString("Street"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] str = new String[add.size()];
        for(int i = 0 ; i < add.size() ; i ++){
            str[i] = add.get(i);
        }
        if(add.size() == 0){
            str = new String[]{"Add a shipping address in profile first!"};
        }
                
        return str;
    }
    public String[] getOrders(){
        ArrayList<String> ord = new ArrayList<>();
        String query = "SELECT * FROM `order` WHERE userID = '" + mfl.getAccount().getUserId() + "'";
        
        try{
            ResultSet rs = dbc.executeQuery(query);
            while(rs.next()){
                ord.add(rs.getString("orderDate").replaceFirst("00:00:00.0","") + " | " + rs.getString("totalAmt")+ " | " + rs.getString("orderStatus"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] str = new String[ord.size()];
        for(int i = 0 ; i < ord.size() ; i ++){
            str[i] = ord.get(i);
        }
        if(ord.size() == 0){
            str = new String[]{"You have no orders yet!"};
        }
                
        return str;
    }
    public void remove(String tableName, String condition){
        String del = "DELETE FROM "+ tableName + " WHERE "+ condition ;
        try{
            dbc.updateQuery(del);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(String tableName, String condition, String values){
        String update = "UPDATE " + tableName + " SET " + values + " WHERE "+ condition; 
        try{
            dbc.updateQuery(update);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getStringOrder(){
        String[] str = getOrders();
        StringBuilder sb = new StringBuilder();
        //sb.append("Orders: \n\nOrder Date - Amount Paid - Order Status\n\n");
        for(int i = 0 ; i < str.length ; i ++){
            sb.append(str[i] + "\n");
        }
        return sb.toString();
    }
    public MainFrame_Listener getMfl() {
        return mfl;
    }
    
}
