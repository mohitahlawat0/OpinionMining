/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstInterface;

import com.sun.prism.paint.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import connection.Createconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import opinionmining.OpinionMining;
import secondInterface.Homepage;

/**
 *
 * @author Nick Hacker
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        double width=screensize.getWidth();
        double height=screensize.getHeight();
       // JOptionPane.showMessageDialog(this, height+" "+widht);
       setTitle("Login Page");
        setSize((int)width, (int)height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(java.awt.Color.DARK_GRAY);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 190, 220, 40);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password  : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 260, 220, 40);

        jPasswordField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(290, 260, 350, 40);

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 350, 160, 40);

        jTextField1.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(290, 190, 350, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Sign Up");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 350, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/a58b9cb413dd2f4a8fa78a5268cea32a.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAutoscrolls(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1404, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String username=null,password=null;
        username=jTextField1.getText().trim();
        password=jPasswordField1.getText().trim();
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(this, "Field is Empty...!!!");
        }
        else{
            String query="select * from usertable where username=? && password=?";
            try{
        if(con==null)
           con= Createconnection.Connect();
        
            
            ps=con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs=ps.executeQuery();
            
            if(rs.next()){
                
                if(rs.getString("username").equalsIgnoreCase(username) && rs.getString("password").equals(password)){
                    OpinionMining.login_id=rs.getInt("id");
                    OpinionMining.name=rs.getString("username");
                    Homepage hmpg=new Homepage();
                    this.setVisible(false);
                    hmpg.setVisible(true);
                }
                
            }
            else{
                    JOptionPane.showMessageDialog(this, "Username or password is incorrect...!!!");
                    jTextField1.setText("");
                    jPasswordField1.setText("");
                }
        }catch(SQLException e){}
            finally{
                try{
                    if(ps!=null)
                    ps.close();
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
                }catch(SQLException ex){}
                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new Signup().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}