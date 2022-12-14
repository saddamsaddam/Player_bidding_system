/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player_bidding.registration;


import java.awt.Image;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.myTable;
import java.sql.  ResultSetMetaData;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 01957
 */
public class PL_VIEWS extends javax.swing.JFrame {

    /**
     * Creates new form Player_Registration
     */
    //PLAYER SHOW
    public PL_VIEWS() throws ClassNotFoundException {
        initComponents();
            this.setVisible(true);
            this.setSize(1500,1000);
            this.setLocationRelativeTo(null);
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://SADDAMNVN:1433;databaseName=Player_bidding;integratedSecurity=true;";
            java.sql.Connection  con =DriverManager.getConnection(url);
            Statement state=con.createStatement();
                      // String query="select NAME,DEPARTMENT_NAME,CATEGORY,PROPOSAL_PRICE from PLAYER_REGISTRATION";

            String query="select NAME,DEPARTMENT_NAME,CATEGORY,PROPOSAL_PRICE,EMAIL,IMAGE,TOTAL_RUN,TOTAL_MATCH,TOTAL_WICKET,AVG_RUN,ID from PLAYER_REGISTRATION";
           ResultSet rs= state.executeQuery(query);
           //System.out.println(rs.next());
           ResultSetMetaData rsmetadata=rs.getMetaData();
              //System.out.println(rsmetadata);
           int column=rsmetadata.getColumnCount();
           
           DefaultTableModel dtm=new DefaultTableModel();
           Vector column_name=new Vector(column);
           Vector data_rows=new Vector();
           for(int i=1;i<column;i++){
               column_name.addElement(rsmetadata.getCatalogName(i));
           }
           dtm.setColumnIdentifiers(column_name);
           while(rs.next() ){
              data_rows=new Vector(column);
              for(int j=1;j<column;j++){
                  if(j==1){
                                      data_rows.addElement("MD: "+rs.getString(j ) );
  
                  } else if(j==6){
                      byte[]img=rs.getBytes("IMAGE");
                      ImageIcon image=new ImageIcon(img);
                      Image im=image.getImage();
                      Image myImage=im.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
                      ImageIcon newImage=new ImageIcon(myImage);
                      //IMAGE2.setIcon(newImage);
                      System.out.println(newImage);
                      
                      data_rows.addElement(rs.getString(j ) );
                  }
                  else
                  {
                      data_rows.addElement(rs.getString(j ) );
   
                  }
              }
              dtm.addRow(data_rows);
            
           }
            // myTable.setModel(dtm);
            myTable.setModel(dtm);
             
            
            
           
           
              
            
        } catch (SQLException ex) {
            Logger.getLogger(PL_VIEWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "DPT_NAME", "CATEGORY", "PRICE", "EMAIL", "PASSWORD", "IMAGE", "TOTAL_RUN", "TOTAL_MATCH", "TOTAL_WICKET", "AVG_RUN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(null);

        myTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "IMAGE2", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(myTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 90, 1270, 402);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 60, 90, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DEPARTMENT_NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 60, 130, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("AVG_RUN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1160, 60, 100, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("CATEGORY");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 60, 100, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("PROPOSAL_PRICE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 60, 120, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("EMAIL");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(550, 60, 50, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("IMAGE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(680, 60, 50, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("TOTAL_RUN");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(780, 60, 100, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("TOTAL_MATCH");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(910, 60, 100, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("TOTAL_WICKET");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1030, 60, 100, 17);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("PLAYERS VIEWS");
        jPanel1.add(jLabel11);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1090, 50);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jButton2.setText("HOME_BUTTON");
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(1090, 0, 200, 50);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(970, 210, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PL_VIEWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PL_VIEWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PL_VIEWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PL_VIEWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    new PL_VIEWS().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PL_VIEWS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable myTable;
    // End of variables declaration//GEN-END:variables
}
