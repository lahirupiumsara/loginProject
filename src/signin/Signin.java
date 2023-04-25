/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package signin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Signin extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    /**
     * Creates new form Sign_in
     */
    public Signin() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        
        con = Db.mycon();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jsign_in_ = new javax.swing.JButton();
        jLabelsignup = new javax.swing.JLabel();
        jpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jusername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 245, 41));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 155, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 155, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("Sign In form");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jsign_in_.setBackground(new java.awt.Color(255, 102, 102));
        jsign_in_.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jsign_in_.setText("Sign In");
        jsign_in_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsign_in_ActionPerformed(evt);
            }
        });
        jPanel1.add(jsign_in_, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, -1));

        jLabelsignup.setBackground(new java.awt.Color(255, 0, 0));
        jLabelsignup.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabelsignup.setText("   Sign up");
        jLabelsignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelsignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelsignupMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 120, 40));

        jpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 245, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signin/pngtree-honeycomb-white-background-picture-image_1151589.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 520, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsign_in_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsign_in_ActionPerformed
        // TODO add your handling code here:
        String username = jusername.getText();
        String password = jpassword.getText();
        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Add the Username");
        }
        else if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Add the Password");
        }
        else{  
            
            Encoder encoder = Base64.getEncoder();
            String pw =  encoder.encodeToString(password.getBytes());
            
        try {
        
            String sql = " SELECT * FROM details WHERE username = ? AND password = ? ";
            ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, pw);
            
            rs = ps.executeQuery();
   
           
            if (rs.next()){
                JOptionPane.showMessageDialog(rootPane, "You're signin....");
            }else    
            {
                JOptionPane.showMessageDialog(rootPane, "Your signin failed");
            }
        } catch (Exception e) {
        }       
    }//GEN-LAST:event_jsign_in_ActionPerformed
    }
    private void jLabelsignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelsignupMouseClicked
        // signing form show:

        Signup su = new Signup();
        su.setVisible(true);
        su.pack();
        su.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelsignupMouseClicked

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelsignup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JButton jsign_in_;
    private javax.swing.JTextField jusername;
    // End of variables declaration//GEN-END:variables
}
