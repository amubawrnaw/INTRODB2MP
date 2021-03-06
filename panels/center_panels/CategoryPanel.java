/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels.center_panels;

import control.MainFrame_Listener;
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.DBConnection;
import panel_control.CenterPanel_Listener;

/**
 *
 * @author amiel
 */
public class CategoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form CategoryPanel
     */
    private CenterPanel_Listener cpl;
    public CategoryPanel(CenterPanel_Listener cpl) {
        this.cpl = cpl;
        initComponents();
        setVisible(true);
    }
    public JPanel getCenterCardPane() {
        return centerCardPane;
    }


    public JPanel getHeaderPane() {
        return headerPane;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        centerCardPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        searchBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));

        headerPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jLabel1.setText("CATEGORIES");

        javax.swing.GroupLayout headerPaneLayout = new javax.swing.GroupLayout(headerPane);
        headerPane.setLayout(headerPaneLayout);
        headerPaneLayout.setHorizontalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        headerPaneLayout.setVerticalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = cpl.getCategories();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout centerCardPaneLayout = new javax.swing.GroupLayout(centerCardPane);
        centerCardPane.setLayout(centerCardPaneLayout);
        centerCardPaneLayout.setHorizontalGroup(
            centerCardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        centerCardPaneLayout.setVerticalGroup(
            centerCardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(centerCardPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(151, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerCardPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(searchBtn)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        cpl.getMfl().resetButtons();
        DBConnection dbc = new DBConnection();
        String item = list.getSelectedValue();
        ResultSet rs = dbc.executeQuery("SELECT itemName FROM items WHERE categoryID = (SELECT categoryID FROM category WHERE categoryName = '" + item + "')");
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
    private javax.swing.JPanel centerCardPane;
    private javax.swing.JPanel headerPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
