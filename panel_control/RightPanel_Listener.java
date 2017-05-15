/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel_control;

import control.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import view.MainFrame;

/**
 *
 * @author amiel
 */
public class RightPanel_Listener implements ActionListener{
    private JToggleButton profile;
    private JToggleButton settings;
    private JToggleButton cart;
    private JButton logout;
    private MainFrame_Listener mfl;
    public RightPanel_Listener(MainFrame_Listener mfl){
        this.mfl = mfl;
        MainFrame mf = mfl.getMainFrame();
        profile = mf.getRightPanel().getProfileBtn();
        settings = mf.getRightPanel().getSettingsBtn();
        cart = mf.getRightPanel().getCartBtn();
        logout = mf.getRightPanel().getLogoutBtn();
        
        profile.addActionListener(this);
        settings.addActionListener(this);
        cart.addActionListener(this);
        logout.addActionListener(this);
    }
    private void profileBtnPressed(){
        profile.setSelected(true);
        System.out.println("Profile btn Pressed!");
        mfl.setVisible("Profile");
    }
    private void settingBtnPressed(){
        settings.setSelected(true);
        System.out.println("settings btn Pressed!");
        mfl.setVisible("Setting");
    }
    private void cartBtnPressed(){
        cart.setSelected(true);
        System.out.println("cart btn Pressed!");
        mfl.setVisible("Cart");
    }
    private void logoutBtnPressed(){
        System.out.println("logout btn Pressed!");
        mfl.getMainFrame().dispose();
        new LoginListener(new Driver());
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        mfl.resetButtons();
        switch(ae.getActionCommand()){
            case "Profile":profileBtnPressed();break;
            case "Settings":settingBtnPressed();break;
            case "Cart":cartBtnPressed();break;
            case "Logout":logoutBtnPressed();break;
        }
    }
    
}
