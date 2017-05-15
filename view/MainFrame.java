/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import panels.center_panels.ProfilePanel;
import panels.center_panels.*;
import panels.*;
import control.MainFrame_Listener;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author amiel
 */
public class MainFrame extends javax.swing.JFrame {
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private MainFrame_Listener mfl;
    
    private CenterPanel centerPanel;
    //CenterPanel Panels
    
    //yes
    
    public MainFrame(MainFrame_Listener mfl) {
        this.mfl = mfl;
        
        initComponents();
        initPanels();
        this.setVisible(true);
    }
    
    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }
    
    public MainFrame_Listener getMainFrame_Listener(){
        return mfl;
    }
    
    private void initPanels(){
        
        centerPanel = new CenterPanel(mfl.getCenterPanelListener());

        leftPanel = new LeftPanel(this);
        rightPanel = new RightPanel(this);
        
        
        JPanel leftPadding = new JPanel();
        JPanel rightPadding = new JPanel();
        
        leftPadding.setSize(1,500);
        rightPadding.setSize(1,500);
        
        leftPadding.setBackground(new java.awt.Color(255, 204, 255));
        rightPadding.setBackground(new java.awt.Color(255, 204, 255));
        
        mainPanel.setBackground(new java.awt.Color(255, 204, 255));
        
        mainPanel.add(leftPanel);
        mainPanel.add(leftPadding);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPadding);
        mainPanel.add(rightPanel);
        repaint();
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setSize(810,500);
        mainPanel.setMinimumSize(new java.awt.Dimension(802, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(802, 500));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
