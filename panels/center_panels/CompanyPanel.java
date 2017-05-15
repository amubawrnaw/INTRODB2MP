/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels.center_panels;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import model.DBConnection;
import panel_control.CenterPanel_Listener;
import view.MainFrame;

/**
 *
 * @author amiel
 */
public class CompanyPanel extends javax.swing.JPanel {
    private CenterPanel_Listener cpl;
    /**
     * Creates new form companyPanel
     */
    public CompanyPanel(CenterPanel_Listener cpl) {
        this.cpl = cpl;
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        companyLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        searchBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        companyLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        companyLabel.setText("COMPANIES");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(companyLabel)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(companyLabel)
                .addGap(26, 26, 26))
        );

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = cpl.getCompanies();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list);
        list.setVisibleRowCount(16);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        searchBtn.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        cpl.getMfl().resetButtons();
        DBConnection dbc = new DBConnection();
        String item = list.getSelectedValue();
        ResultSet rs = dbc.executeQuery("SELECT itemName FROM items WHERE companyID = (SELECT companyID FROM company WHERE companyname = '" + item + "')");
        ArrayList<String> str = new ArrayList<>();
        try{
            while(rs.next()){
                str.add(rs.getString("itemName"));
                System.out.println(rs.getString("itemName") + " found!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        cpl.getMfl().setResults(str);
        cpl.getMfl().setVisible("Search");
    }//GEN-LAST:event_searchBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}