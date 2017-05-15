/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.CardLayout;
import java.util.ArrayList;
import model.Account;
import view.*;
import panel_control.*;
/**
 *
 * @author amiel
 */
public class MainFrame_Listener {
    private MainFrame mf;
    private Account account;
    private LeftPanel_Listener lpl;
    private RightPanel_Listener rpl;
    
    private CenterPanel_Listener cpl;
    
    public MainFrame_Listener(Account account){
        this.account = account;
        cpl = new CenterPanel_Listener(this);
        mf = new MainFrame(this);
        System.out.println("Main program starting...");
        System.out.println("Account loaded: " + account.toString());
        addListeners();
    }
    public void setVisible(String s){
        CardLayout cl = (CardLayout) mf.getCenterPanel().getLayout();
        cl.show(mf.getCenterPanel(), s);
    }
    public CenterPanel_Listener getCenterPanelListener(){
        return cpl;
    }
    public void addListeners(){
        lpl = new LeftPanel_Listener(this);
        rpl = new RightPanel_Listener(this);
        System.out.println("Listeners added!");
        mf.revalidate();
    }
    public MainFrame getMainFrame(){
        return mf;
    }
    public void resetButtons(){
        mf.getLeftPanel().resetButtons();
        mf.getRightPanel().resetButtons();
    }
    public Account getAccount(){
        return account;
    }
    public void setResults(String[] s){
        mf.getCenterPanel().getSearchPanel().setResults(s);
        System.out.println("Resutls updated!");
    }
    public void setResults(ArrayList<String> s){
       String[] str = new String[s.size()];
       for(int i = 0 ; i < s.size() ; i ++){
           str[i] = s.get(i);
       } 
       this.setResults(str);
    }
}
