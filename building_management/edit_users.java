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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
public class edit_users extends javax.swing.JFrame {

    Object[][] MyArray = null;
    String[] AttributeNames;
    connect conn;
    Statement stmt;
    JFrame invoke ;
    boolean state ;
    int selectedRow;
    int NumberOfRows, NumberOfColumns;
    private final Image img;
    String[] fields = {"username","password_","role_"};
    String tableName = "users";
    String tableKey = "id_";
    String query="SELECT "
            +"role_  as " +'"'+ "الصلاحية" +'"'
            +", password_ as " +'"'+ "كلمة السر" +'"'
            +", username  as " +'"'+ "اسم المستخدم" +'"'
            +" FROM users ";
    String user_id;
   

    public edit_users(javax.swing.JFrame mainFram,String user_id)throws SQLException {
         invoke =mainFram;
         this.user_id=user_id;
        invoke.setEnabled(false);
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();
       // this.setMaximumSize(new Dimension(680, 530));
      this.setSize(260, 210);
        this.setLocation((temp_width - 260) / 2, (temp_height - 210) / 2);
        this.setIconImage(img);
        username.grabFocus();
       
        conn = new connect();
        conn.newConnection();
        try {
            // Class.forName("org.postgresql.Driver");

            java.sql.Statement s = conn.conn.createStatement();
            stmt = conn.conn.createStatement();
        } catch (Exception e) {
        }
       
getSelectedRecordInfo();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        role = new javax.swing.JComboBox();
        editselected = new javax.swing.JButton();
        msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("تعديل مستخدم");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("الصلاحية :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("اسم المستخدم :");

        username.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        username.setNextFocusableComponent(password);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("كلمة المرور :");

        password.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        role.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "مدير", "مستخدم" }));

        editselected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Text-Edit-icon.png"))); // NOI18N
        editselected.setText("تعديل");
        editselected.setMargin(new java.awt.Insets(2, 1, 2, 1));
        editselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editselectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(editselected, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(role)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(editselected))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {password, username});

        msg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        msg.setForeground(new java.awt.Color(0, 102, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
invoke.setEnabled(true);
invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void editselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editselectedActionPerformed
        
       username.setBackground(Color.white);
        if (!Functions.validation(username.getText(), 3, true)) {
            username.setBackground(Color.red);
            username.grabFocus();
            username.selectAll();
           
            showMessage("يجب ادخال اسم مستخدم",false);
         
            state = false;
            return;
        }

        password.setBackground(Color.white);
        if (!Functions.validation(password.getText(), 3, true)) {
            password.setBackground(Color.red);
            password.grabFocus();
            password.selectAll();
              showMessage("يجب ادخال كلمة سر",false);
           
            state = false;
            return;
        }

      
             
        try {
             String role_=role.getSelectedItem().toString();
        
            String[] values = {"'" + username.getText()+"'",
                "'" + password.getText()+"'","'" +role_+"'"};
            
            
                 conn.updateTable(tableName, fields, values,tableKey,user_id);
                 users.conn.QueryTable(query, users.DataBaseTable);
                 this.dispose();
        
        } catch (SQLException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_editselectedActionPerformed

private void emptyFields() {
        username.setText("");
        password.setText("");
        
       }

  private void showMessage(String message, boolean state) {
        if (state) {
            msg.setForeground(Color.GREEN);

        } else {
            msg.setForeground(Color.red);
        }
        msg.setText(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editselected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField password;
    private javax.swing.JComboBox role;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
private void getSelectedRecordInfo() {
     
        emptyFields();
        
       
         
         Date date;
        
        try {
        
        
          String query="SELECT "
            +"role_  as " +'"'+ "الصلاحية" +'"'
            +", password_ as " +'"'+ "كلمة السر" +'"'
            +", username  as " +'"'+ "اسم المستخدم" +'"'
            +" FROM users where id_="+ user_id;
         
         System.out.println(query);
            Statement recordsStmt = conn.conn.createStatement();
            ResultSet recordsResultSet = recordsStmt.executeQuery(query);
            
          while (recordsResultSet.next()) {
              username.setText(recordsResultSet.getString(3));
              password.setText(recordsResultSet.getString(2));
              role.setSelectedItem(recordsResultSet.getString(1));
              
                          }
        } catch (SQLException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        } 

            
         
         
         
       

         
         
    }

}
