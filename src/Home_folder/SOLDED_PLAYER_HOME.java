/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_folder;

import Bidding_folder.*;
import player_bidding.registration.*;
import TeamOwner_folder.*;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 01957
 */
public class SOLDED_PLAYER_HOME extends javax.swing.JFrame {

  // String total_match;
    /**
     * Creates new form Player_Registration
     */
    String pvemail,pvpass;int selectorpage;
    public SOLDED_PLAYER_HOME() throws ClassNotFoundException {
        initComponents();
        this.setVisible(true);
        this.setSize(1200,1000);
        this.setLocationRelativeTo(null);
        playerList();
         show_usersS();
        
    }
public void selectorpage( int checkhome){
    this.selectorpage=selectorpage;
}


   public void profile(String pvemail,String pvpass )
    {
        this.pvemail=pvemail;
        this.pvpass=pvpass;
    }
   /*
       public  PLAYER(String NAME,String DEPARTMENT_NAME,String CATEGORY ,int  PROPOSAL_PRICE,String EMAIL,byte[]IMAGE,int TOTAL_RUN,
    int TOTAL_MATCH ,int TOTAL_WICKET,int AVG_RUN  )
*/
   //SHOWING DATA IN TABLE
  public void show_usersS() throws ClassNotFoundException
   {
      ArrayList<SOLDED> list=playerList();
      DefaultTableModel model=(DefaultTableModel) myTable.getModel();
     Object[]row =new Object[7];
     //     public SOLDED(int ID, String NAME, String EMAIL, String CATEGORY, String DEPARTMENT_NAME, String TEAM_NAME, int PRICE) {

     for(int i=0;i<list.size();i++)
     {
          row[0]=list.get(i).getID();
       row[1]=list.get(i).getNAME();
        row[2]=list.get(i).getEMAIL();
         row[3]=list.get(i).getCATEGORY();
        row[4]=list.get(i).getDEPARTMENT_NAME();
        row[5]=list.get(i).getTEAM_NAME();
        row[6]=list.get(i).getPRICE();
          
         
        
 
       
       model.addRow(row);
     }
   }

  //ADDING DATA IN ARRAYLIST
   public ArrayList<SOLDED> playerList(){
       
       ArrayList<SOLDED>  playerList=new ArrayList<>();
       try {
          
         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://SADDAMNVN:1433;databaseName=Player_bidding;integratedSecurity=true;";
            java.sql.Connection  con =DriverManager.getConnection(url);
           
            String querymax=" SELECT  P.ID,P.NAME,P.EMAIL,P.CATEGORY,P.DEPARTMENT_NAME,B.TEAM_NAME,B.PRICE FROM PLAYER_REGISTRATION P RIGHT JOIN BIDDING_TABLE B ON P.ID = B.PLAYER_ID;";
            Statement state=con.createStatement();
            ResultSet rrr= state.executeQuery(querymax);
            SOLDED player;
          
          while(rrr.next()){
              player=new SOLDED(rrr.getInt("ID"),rrr.getString("NAME"),rrr.getString("EMAIL"),rrr.getString("CATEGORY"),rrr.getString("DEPARTMENT_NAME"), rrr.getString("TEAM_NAME"),rrr.getInt("PRICE"));
          playerList.add(player);
          }

    
            System.out.println("Connection created");

        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Sorry bro");
        } 
       return playerList;
       
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("SOLDED PLAYERS");

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 100);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "EMAIL", "CATEGORY", "DEPT_NAME", "TEAM_NAME", "BIDDED PRICE"
            }
        ));
        jScrollPane1.setViewportView(myTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 100, 1280, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        SL_VIEWS_ADMIN SV=new SL_VIEWS_ADMIN();
          dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SOLDED_PLAYER_HOME().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SOLDED_PLAYER_HOME.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTable;
    // End of variables declaration//GEN-END:variables
}