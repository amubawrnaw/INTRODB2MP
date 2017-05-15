/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel_control;

import control.MainFrame_Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import model.DBConnection;
import view.ResultFrame;

/**
 *
 * @author amiel
 */
public class LeftPanel_Listener implements ActionListener{
    private JToggleButton categories;
    private JToggleButton companies;
    private JButton search, admin;
    private MainFrame_Listener mfl;
    private JTextField field;
    public LeftPanel_Listener(MainFrame_Listener mfl){
        this.mfl = mfl;
        categories = mfl.getMainFrame().getLeftPanel().getCategoryBtn();
        companies = mfl.getMainFrame().getLeftPanel().getCompaniesBtn();
        search = mfl.getMainFrame().getLeftPanel().getSearchBtn();
        field = mfl.getMainFrame().getLeftPanel().getSearchField();
        admin = mfl.getMainFrame().getLeftPanel().getAdminBtn();
        
        admin.addActionListener(this);
        categories.addActionListener(this);
        companies.addActionListener(this);
        search.addActionListener(this);
    }
    private void categoryBtnPressed(){
        categories.setSelected(true);
        System.out.println("cateogry btn Pressed!");
        mfl.setVisible("Category");
    }
    private void companyBtnPressed(){
        companies.setSelected(true);
        System.out.println("company btn Pressed!");
        mfl.setVisible("Company");
    }
    private void searchBtnPressed(){
        System.out.println("search btn Pressed!");
        
        DBConnection dbc = new DBConnection();
        ResultSet rs = dbc.executeQuery("SELECT itemName FROM items WHERE itemName LIKE '%" + field.getText() +"%'");
        ArrayList<String> str = new ArrayList<>();
        try{
            while(rs.next()){
                str.add(rs.getString("itemName"));
                System.out.println(rs.getString("itemName") + " found!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        mfl.setResults(str);
        mfl.setVisible("Search");
    }
    private void profitBtnPressed(){
        System.out.println("admin btn Pressed!");
        new ResultFrame(mfl);
        mfl.getMainFrame().setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        mfl.resetButtons();
        switch(ae.getActionCommand()){
            case "Categories": categoryBtnPressed();break;
            case "Companies": companyBtnPressed();break;
            case "Search": searchBtnPressed();break;
            case "Profit View": profitBtnPressed();break;
        }
    }
    
}
