/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player_bidding.registration;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 01957
 */
public class IMAGES extends javax.swing.JFrame {

   
    String filename=null;
        byte[] person_image=null;/**
     * Creates new form IMAGES
     */
    public IMAGES() {
        initComponents();
        this.setVisible(true);
        this.setSize(1200,1000);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IMAGES_SHOW = new javax.swing.JLabel();
        SELECT_IMAGE = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        SHOW = new javax.swing.JButton();
        IMAGES_SHOW1 = new javax.swing.JLabel();
        ENTER_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IMAGES_SHOW.setText("jLabel1");

        SELECT_IMAGE.setText("SELECT IMAGES");
        SELECT_IMAGE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SELECT_IMAGEMouseClicked(evt);
            }
        });
        SELECT_IMAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SELECT_IMAGEActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        SHOW.setText("SHOW");
        SHOW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHOWMouseClicked(evt);
            }
        });
        SHOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SHOWActionPerformed(evt);
            }
        });

        IMAGES_SHOW1.setText("jLabel1");
        IMAGES_SHOW1.setMaximumSize(new java.awt.Dimension(50, 50));
        IMAGES_SHOW1.setMinimumSize(new java.awt.Dimension(50, 50));
        IMAGES_SHOW1.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel1.setText("ENTER ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SELECT_IMAGE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ENTER_ID, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(SHOW)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 675, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IMAGES_SHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAGES_SHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(258, 258, 258))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(SELECT_IMAGE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IMAGES_SHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(ENTER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(SHOW))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(IMAGES_SHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SELECT_IMAGEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SELECT_IMAGEMouseClicked
       JFileChooser chooser=new JFileChooser(); 
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
         filename=f.getAbsolutePath();
         ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance( IMAGES_SHOW.getWidth(), IMAGES_SHOW.getHeight(),Image.SCALE_SMOOTH));
         IMAGES_SHOW.setIcon(imageIcon);
         try{
             File image=new File(filename);
             FileInputStream fts=new  FileInputStream(image);
             ByteArrayOutputStream bos=new   ByteArrayOutputStream();
             byte[]buf=new byte[1024];
             for(int readNum;(readNum=fts.read(buf))!=-1;){
                 bos.write(buf,0,readNum);
             }
             person_image=bos.toByteArray();
             
         }
         catch(Exception e)
                 {
                   JOptionPane.showMessageDialog(null,e);
                 }
           
        //IMAGE.setText(filename);
        
// TODO add your handling code here:
    }//GEN-LAST:event_SELECT_IMAGEMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://SADDAMNVN:1433;databaseName=Player_bidding;integratedSecurity=true;";
            java.sql.Connection  con =DriverManager.getConnection(url);
            String query="INSERT INTO IMAGES VALUES(?)";
           // String query="select * from PLAYER_REGISTRATION";
            PreparedStatement pst=con.prepareStatement(query);
           
             
               pst.setBytes(1,person_image);
              
               
               // System.out.println(AVG);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"Inserted SuccessFully");
               
                     
            System.out.println("Connection created");

        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Sorry bro");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void SELECT_IMAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SELECT_IMAGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SELECT_IMAGEActionPerformed

    private void SHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SHOWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SHOWActionPerformed

    private void SHOWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHOWMouseClicked
 
        
try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://SADDAMNVN:1433;databaseName=Player_bidding;integratedSecurity=true;";
            java.sql.Connection  con =DriverManager.getConnection(url);
         
            String query="select IMAGES FROM IMAGES WHERE ID='"+ENTER_ID.getText()+"'";

            //String query="select NAME,DEPARTMENT_NAME,CATEGORY,PROPOSAL_PRICE,EMAIL,IMAGE,TOTAL_RUN,TOTAL_MATCH,TOTAL_WICKET,AVG_RUN,ID from PLAYER_REGISTRATION";
              Statement state=con.createStatement();
            ResultSet rs= state.executeQuery(query);
            while(rs.next())
            {
               byte[]img=rs.getBytes("IMAGES");
               ImageIcon image=new ImageIcon(img);
               Image im=image.getImage();
              // Image myImg=im.getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
              // Image myImg=im.getScaledInstance(IMAGES_SHOW1.getWidth(),IMAGES_SHOW1.getHeight(),Image.SCALE_SMOOTH);

               Image myImg=im.getScaledInstance(400,400,Image.SCALE_SMOOTH);
               ImageIcon newImage=new ImageIcon(myImg);
               IMAGES_SHOW1.setIcon(image);
               
            }
          
           
        } catch (SQLException ex) {
            Logger.getLogger(PL_VIEWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IMAGES.class.getName()).log(Level.SEVERE, null, ex);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_SHOWMouseClicked

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
            java.util.logging.Logger.getLogger(IMAGES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMAGES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMAGES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMAGES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IMAGES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ENTER_ID;
    private javax.swing.JLabel IMAGES_SHOW;
    private javax.swing.JLabel IMAGES_SHOW1;
    private javax.swing.JButton SELECT_IMAGE;
    private javax.swing.JButton SHOW;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
