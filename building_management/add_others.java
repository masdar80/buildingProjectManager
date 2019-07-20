/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package building_management;

import static building_management.signin.img;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author masdar
 */
public class add_others extends javax.swing.JFrame {

    /**
     * Creates new form others
     * @param bldno
     */
    String[] fields =  { "quantity", "price", "total_price", "date_", "other_id","buildno","notice"};
    String tableName = "rec_others";
    String tableKey = "re_id";
    String resultquery =  "SELECT "
            + " rec_others.notice as " + '"' + "ملاحظات" + '"'
            + ", rec_others.date_ as " + '"' + "التاريخ" + '"'
            + ", rec_others.total_price as " + '"' + "الاجمالي" + '"'
            + ", rec_others.price as " + '"' + "السعر" + '"'
            + ", others_.unit  as " + '"' + "الواحدة" + '"'
            + ", rec_others.quantity  as " + '"' + "الكمية" + '"'
            + ", others_.desc_  as " + '"' + "بيان العمل" + '"'
            
            + " FROM rec_others  "
            + "   join others_ on rec_others.other_id=others_.other_id "
            + " where re_id = ";
  int other_id=0;
    JFrame invoke ;
    String bldno;
    connect conn;
    public add_others(javax.swing.JFrame mainFram,String bldno,int other_id) throws SQLException {
        invoke =mainFram;
        invoke.setEnabled(false);
        conn = new connect();
        conn.newConnection();

        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();
        // this.setMaximumSize(new Dimension(505, 165));
        this.setSize(600, 200);
        this.setLocation((temp_width - 600) / 2, (temp_height - 200) / 2);
        this.setIconImage(img);
        this.bldno=bldno;
        conn.fillComboBox("others_", "desc_", othersComboBox);
        this.setTitle("اضافة عمل للمحضر رقم  "+bldno);
        bldlbl.setText(bldno);
        othersComboBox.grabFocus();
         if(other_id>0)
        {
            
            getDigingsInfos(other_id);
            
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

        jLabel1 = new javax.swing.JLabel();
        bldlbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        othersComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        inDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        savein = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        noticeTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        totalextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("اضافة عمل للمحضر رقم :");

        bldlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        othersComboBox.setNextFocusableComponent(othersComboBox);
        othersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("السعر");

        priceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceTextField.setNextFocusableComponent(noticeTextField);
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });
        priceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceTextFieldKeyReleased(evt);
            }
        });

        inDate.setDateFormatString("MMM d, yyyy ");
        inDate.setNextFocusableComponent(quantity);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("التاريخ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("اسم  العمل");

        savein.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savein.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Files-New-File-icon 24.png"))); // NOI18N
        savein.setText("حفظ");
        savein.setMargin(new java.awt.Insets(2, 2, 2, 2));
        savein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveinActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ملاحظة");

        noticeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noticeTextField.setNextFocusableComponent(savein);
        noticeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noticeTextFieldActionPerformed(evt);
            }
        });
        noticeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noticeTextFieldKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("الكمية");

        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.setNextFocusableComponent(priceTextField);
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        totalextField.setEditable(false);
        totalextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalextFieldActionPerformed(evt);
            }
        });
        totalextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalextFieldKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("الاجمالي");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/math-add-icon16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(othersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(savein)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noticeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(othersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(bldlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(bldlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true);
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void othersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_othersComboBoxActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed

    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void priceTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTextFieldKeyReleased

     calcTotal();
    }//GEN-LAST:event_priceTextFieldKeyReleased

    private void saveinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinActionPerformed

        try {

            Boolean status=true;
            if(other_id>0)
            {
                status= UpdateRecord();
            }else
            {
               status=  SaveInRecord();
            }
if(status)
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            othersComboBox.setBackground(Color.red);
        }
    }//GEN-LAST:event_saveinActionPerformed

    private void noticeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noticeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeTextFieldActionPerformed

    private void noticeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noticeTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeTextFieldKeyReleased

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        calcTotal();
    }//GEN-LAST:event_quantityKeyReleased

    private void totalextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalextFieldActionPerformed

    private void totalextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_totalextFieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{ 
              new other_types(this).setVisible(true);
          
          }catch(SQLException e)
          {
              
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            String reference=othersComboBox.getSelectedItem().toString();
          
            conn.fillComboBox("others_", "desc_", othersComboBox);
           
            othersComboBox.setSelectedItem(reference);
           
            
             }catch(SQLException e)
          {
              
          }
    }//GEN-LAST:event_formWindowActivated

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bldlbl;
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField noticeTextField;
    private javax.swing.JComboBox othersComboBox;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton savein;
    private javax.swing.JTextField totalextField;
    // End of variables declaration//GEN-END:variables

    
      private Boolean SaveInRecord() throws SQLException {

        quantity.setBackground(Color.white);
        priceTextField.setBackground(Color.white);
        totalextField.setBackground(Color.white);
        
        if (!Functions.validation(quantity.getText(), 2, true)) {
            quantity.setBackground(Color.red);
            quantity.grabFocus();
            quantity.selectAll();
            
            return false;
        }
        if (!Functions.validation(priceTextField.getText(), 2, true)) {
            priceTextField.setBackground(Color.red);
            priceTextField.grabFocus();
            priceTextField.selectAll(); 
            
            return false;
        }
        if (!Functions.validation(totalextField.getText(), 2, true)) {
            totalextField.setBackground(Color.red);
            totalextField.grabFocus();
            totalextField.selectAll(); 
            
            return false;
        }
        
        Format formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd");
        String recorindDate = "";
        try {
            recorindDate = formatter.format(inDate.getCalendar().getTime());
        } catch (NullPointerException te) {
            recorindDate = null;
            inDate.grabFocus();
            inDate.setBackground(Color.red);
            
            return false;

        }

        int other_id = conn.getIDByDesc("others_", othersComboBox.getSelectedItem().toString(), "desc_", "other_id");
         
        String quantity_ = quantity.getText();
        String price = priceTextField.getText();
        String totale = totalextField.getText();
        
       
       //"vendor_id", "quantity", "price", "total_price", "date_", "other_id","buildno","notice"

        String[] values = {
             "'" + quantity_ + "'",
            "'" + price + "'",
            "'" + totale + "'",
            "'" + recorindDate + "'",
            "'" + other_id + "'",
            "'" + bldno + "'",
            "'" + noticeTextField.getText() + "'"
        };
        conn.insertIntoTable(tableName, fields, values);
        
return true;
    }
     private Boolean UpdateRecord() throws SQLException {

        quantity.setBackground(Color.white);
        priceTextField.setBackground(Color.white);
        totalextField.setBackground(Color.white);
        
        if (!Functions.validation(quantity.getText(), 2, true)) {
            quantity.setBackground(Color.red);
            quantity.grabFocus();
            quantity.selectAll();
            
            return false;
        }
        if (!Functions.validation(priceTextField.getText(), 2, true)) {
            priceTextField.setBackground(Color.red);
            priceTextField.grabFocus();
            priceTextField.selectAll(); 
            
            return false;
        }
        if (!Functions.validation(totalextField.getText(), 2, true)) {
            totalextField.setBackground(Color.red);
            totalextField.grabFocus();
            totalextField.selectAll(); 
            
            return false;
        }
        
        Format formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd");
        String recorindDate = "";
        try {
            recorindDate = formatter.format(inDate.getCalendar().getTime());
        } catch (NullPointerException te) {
            recorindDate = null;
            inDate.grabFocus();
            inDate.setBackground(Color.red);
            
            return false;

        }

        int referenc_id = conn.getIDByDesc("others_", othersComboBox.getSelectedItem().toString(), "desc_", "other_id");
      
        String quantity_ = quantity.getText();
        String price = priceTextField.getText();
        String totale = totalextField.getText();
        
       
       //"vendor_id", "quantity", "price", "total_price", "date_", "other_id","buildno","notice"

        String[] values = {
            "'" + quantity_ + "'",
            "'" + price + "'",
            "'" + totale + "'",
            "'" + recorindDate + "'",
            "'" + referenc_id + "'",
            "'" + bldno + "'",
            "'" + noticeTextField.getText() + "'"
        };
        conn.updateTable(tableName, fields, values,tableKey,""+other_id);
        
return true;
    }

    
    private void getDigingsInfos(int other_id) {
      this.other_id=other_id;
       this.setTitle("تعديل عمل للمحضر رقم "+bldno);
       jLabel1.setText("تعديل عمل للمحضر رقم "+bldno);
        try{
          String query=resultquery+ other_id;
         
         System.out.println(query);
            Statement recordsStmt = conn.conn.createStatement();
            ResultSet recordsResultSet = recordsStmt.executeQuery(query);
            /*
            + " rec_references.notice as " + '"' + "ملاحظات" + '"'
            + ", rec_references.date_ as " + '"' + "التاريخ" + '"'
            + ", rec_references.total_price as " + '"' + "الاجمالي" + '"'
            + ", rec_references.price as " + '"' + "السعر" + '"'
            + ", rec_references.quantity  as " + '"' + "الكمية" + '"'
            + ", references_.desc_  as " + '"' + "الاحضار" + '"'
            */
          while (recordsResultSet.next()) {
              
              
              
              
              
              noticeTextField.setText(recordsResultSet.getString(1));
              inDate.setDate(Functions.StringToDate(recordsResultSet.getString(2)));
              totalextField.setText(recordsResultSet.getString(3));
              priceTextField.setText(recordsResultSet.getString(4));
              quantity.setText(recordsResultSet.getString(6));
              othersComboBox.setSelectedItem(recordsResultSet.getString(7));
              
              
                          }
        } catch (SQLException ex) {
            Logger.getLogger(addpayment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void calcTotal() {
           Double price,weight;
         if (!Functions.validation(priceTextField.getText(), 2, true)) {
            price=0.0;
        }
         else 
         {
             price=Double.parseDouble(priceTextField.getText());
         }
        if (!Functions.validation(quantity.getText(), 2, true)) {
            weight=0.0;

        }else{
           weight= Double.parseDouble(quantity.getText());
        }
        
        Double Total=price*weight;
                totalextField.setText(Total+"");
    }

   
 
}
