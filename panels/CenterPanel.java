/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import panel_control.CenterPanel_Listener;
import panels.center_panels.*;
/**
 *
 * @author amiel
 */
public class CenterPanel extends javax.swing.JPanel {

    /**
     * Creates new form CenterPanel
     */
    private DefaultPanel defaultPanel;
    private CartPanel cartPanel;
    private CategoryPanel categoryPanel;
    private CompanyPanel companyPanel;
    private SearchPanel searchPanel;
    private ProfilePanel profilePanel;
    private SettingsPanel settingPanel;
    
    private CenterPanel_Listener cpl;
    
    public CenterPanel(CenterPanel_Listener cpl) {
        this.cpl = cpl;
        initComponents();
        addPanels();
        setVisible(true);
    }
    private void addPanels(){
        cartPanel = new CartPanel(cpl);
        searchPanel = new SearchPanel(cpl);
        categoryPanel = new CategoryPanel(cpl);
        companyPanel = new CompanyPanel(cpl);
        defaultPanel = new DefaultPanel(cpl);
        settingPanel = new SettingsPanel(cpl);
        profilePanel = new ProfilePanel(cpl);
        
        add(defaultPanel, "Default");
        add(cartPanel, "Cart");
        add(searchPanel, "Search");
        add(categoryPanel, "Category");
        add(companyPanel, "Company");
        add(settingPanel, "Setting");
        add(profilePanel, "Profile");
    }

    public DefaultPanel getDefaultPanel() {
        return defaultPanel;
    }

    public CartPanel getCartPanel() {
        return cartPanel;
    }

    public CategoryPanel getCategoryPanel() {
        return categoryPanel;
    }

    public CompanyPanel getCompanyPanel() {
        return companyPanel;
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public SettingsPanel getSettingPanel() {
        return settingPanel;
    }

    public CenterPanel_Listener getCpl() {
        return cpl;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
