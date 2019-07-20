/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * analysers.java
 *
 * Created on Dec 8, 2011, 10:09:31 AM
 */
package building_management;

/**
 *
 * @author masdar
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class addUnit extends javax.swing.JFrame {

    boolean state;
    JFrame invoke;
    int reference_id = 0;
    String[] fields = {"desc_"};
    String tableName = "units";
    String tableKey = "id_";
    String resultquery = "";

    connect conn;
    Statement stmt;
    int _id=0;
   
  
  
    private final Image img;

    public addUnit(javax.swing.JFrame mainFram,int _id) throws SQLException {
        invoke = mainFram;
        invoke.setEnabled(false);

        
        conn = new connect();
        conn.newConnection();

        java.sql.Statement s = conn.conn.createStatement();
        conn.conn.createStatement();

        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();
        
        this._id=_id;
        this.setSize(403, 124);
        this.setLocation((temp_width - 403) / 2, (temp_height - 124) / 2);
        this.setIconImage(img);
        this.setTitle("تعديل اسم واحدة");
        
        
        
        resultquery = "SELECT "
           
            + " desc_ as " + '"' + "اسم الواحدة" + '"'
          + " FROM units  "
            + "  where    id_ ='"+_id+"'";
        
        
      
      
        
        if(_id>0)
        {
            
            getRecordInfos();
            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        savein = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();
        msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("تعديل اسم واحدة");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        savein.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savein.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Files-New-File-icon 24.png"))); // NOI18N
        savein.setText("حفظ");
        savein.setMargin(new java.awt.Insets(2, 2, 2, 2));
        savein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveinActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("الواحدة :");

        reference.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        msg.setForeground(new java.awt.Color(0, 102, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(savein)
                .addGap(145, 145, 145)
                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(savein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true);
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void saveinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinActionPerformed

        try {

            Boolean status=true;
          
              status=  UpdateRecord();
          

            if(status) this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            reference.setBackground(Color.red);
        }

    }//GEN-LAST:event_saveinActionPerformed

    private void referenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_referenceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField reference;
    private javax.swing.JButton savein;
    // End of variables declaration//GEN-END:variables

    private void showMessage(String message, boolean state) {
        if (state) {
            msg.setForeground(Color.GREEN);

        } else {
            msg.setForeground(Color.red);
        }
        msg.setText(message);
    }
    private Boolean UpdateRecord() throws SQLException {

            reference.setBackground(Color.white);

            if (!Functions.validation(reference.getText(), 3, true)) {
                reference.setBackground(Color.red);
                reference.grabFocus();
                reference.selectAll();
                showMessage("يجب ادخال اسم الواحدة",false);
                return false;
                
            }

            try {
                if(conn.checkUniqField("desc_",reference.getText() , tableName))
                {

                    showMessage("يوجد واحدة بنفس الإسم",false);
                    return false;
                }

                String[] values = {"'" + reference.getText()+"'"};

             
conn.updateTable(tableName, fields, values,tableKey,""+_id);
       
        return true;
            } catch (SQLException ex) {
                
                showMessage("لم تتم عملية الادخال بنجاح  ",true);
                return false;
            }
            
            
        



    }


    private void emptyinFields() {
        reference.setText("");

    }

   

    private void getRecordInfos() {
      
        try{
          String query=resultquery;
         
         System.out.println(query);
            Statement recordsStmt = conn.conn.createStatement();
            ResultSet recordsResultSet = recordsStmt.executeQuery(query);
            
          while (recordsResultSet.next()) {
              
              reference.setText(recordsResultSet.getString(1));
            
              
                          }
        } catch (SQLException ex) {
            Logger.getLogger(addGeneralOutlays.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
