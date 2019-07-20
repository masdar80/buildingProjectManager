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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class addpayment extends javax.swing.JFrame {

    boolean state;
    JFrame invoke;
    int payment_id = 0;
    String[] fields = {"amount", "receipt_name", "receipt_no", "category_id", "notice", "date_","buildno","vendor_id","currency_factor"};
    String tableName = "payments_records";
    String tableKey = "payment_id";
    String resultquery = "SELECT "
                 + " payments_records.notice as " + '"' + "ملاحظات" + '"'
                 + ", vendors.vendor_name as " + '"' + "المورد" + '"'
                 + ", references_categories.desc_ as " + '"' + "نوع الاحضارات" + '"'
                 + ", payments_records.receipt_no as " + '"' + "رقم الايصال" + '"'
                 + ", payments_records.receipt_name as " + '"' + "المستلم" + '"'
                 + ", payments_records.currency_factor as " + '"' + "معامل التحويل" + '"'
                 + ", payments_records.amount  as " + '"' + "الدفعة " + '"'
                 + ", payments_records.date_  as " + '"' + "التاريخ " + '"'
                 + " FROM payments_records  "
                 + "  left join references_categories on payments_records.category_id=references_categories.reference_id "
                 + "  left join vendors on payments_records.vendor_id=vendors.vendor_id "
                 + " where  payment_id =";

    connect conn;
    Statement stmt;
    
    String bldno,bldesc;
  
    private final Image img;

    public addpayment(javax.swing.JFrame mainFram,String bldno,int payment_id,String bldesc) throws SQLException {
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

        this.setSize(650, 230);
        this.setLocation((temp_width - 650) / 2, (temp_height - 230) / 2);
        this.setIconImage(img);
        this.setTitle("اضافة دفعة لاحضارات المحضر  "+bldesc);
        this.bldno=bldno;
        this.bldesc=bldesc;

           conn.fillComboBox("references_categories", "desc_", categoriesComboBox);
         conn.fillComboBox("vendors", "vendor_name", vendorssComboBox1);
     
         

        Date currentDate = new Date();
        inDate.setDate(currentDate);
        
        
        if(payment_id>0)
        {
            
            getPaymentInfos(payment_id);
            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoriesComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        inValue = new javax.swing.JTextField();
        inDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        savein = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        notice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        reicept_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        reicept_no = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        vendorssComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("الدفعات");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        categoriesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("قيمة الدفعة");

        inValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inValueActionPerformed(evt);
            }
        });
        inValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inValueKeyReleased(evt);
            }
        });

        inDate.setDateFormatString("MMM d, yyyy ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("التاريخ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("الاحضار");

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

        notice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noticeActionPerformed(evt);
            }
        });
        notice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noticeKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("المستلم");

        reicept_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reicept_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reicept_nameActionPerformed(evt);
            }
        });
        reicept_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reicept_nameKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("رقم ايصال الاستلام");

        reicept_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reicept_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reicept_noActionPerformed(evt);
            }
        });
        reicept_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reicept_noKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("المورد");

        vendorssComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorssComboBox1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 51, 51));
        jCheckBox1.setText("معامل تحويل للاحضارات بالعملة الصعبة");
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vendorssComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(savein)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notice)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(reicept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(inValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vendorssComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(inDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reicept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true);
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void categoriesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesComboBoxActionPerformed

        try {
            String catID=""+conn.getIDByDesc("references_categories",categoriesComboBox.getSelectedItem().toString() , "desc_", "reference_id");
            if(conn.isCategorInDollar(catID))
            {
                jCheckBox1.setSelected(true);
                jLabel3.setText(connect.dollar_factor_value);
            }else
            {
                jCheckBox1.setSelected(false);
                jLabel3.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_categoriesComboBoxActionPerformed

    private void inValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValueActionPerformed

    }//GEN-LAST:event_inValueActionPerformed

    private void inValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValueKeyReleased

    }//GEN-LAST:event_inValueKeyReleased

    private void saveinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinActionPerformed

        try {

                  Boolean status=true;
            if(payment_id>0)
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
            categoriesComboBox.setBackground(Color.red);
        }
    }//GEN-LAST:event_saveinActionPerformed

    private void noticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noticeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeActionPerformed

    private void noticeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noticeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeKeyReleased

    private void reicept_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_nameActionPerformed

    private void reicept_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_nameKeyReleased

    private void reicept_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_noActionPerformed

    private void reicept_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_noKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_noKeyReleased

    private void vendorssComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorssComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendorssComboBox1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {

            jLabel3.setText(connect.dollar_factor_value);
        }else
        {

            jLabel3.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoriesComboBox;
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JTextField inValue;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField notice;
    private javax.swing.JTextField reicept_name;
    private javax.swing.JTextField reicept_no;
    private javax.swing.JButton savein;
    private javax.swing.JComboBox vendorssComboBox1;
    // End of variables declaration//GEN-END:variables

    private Boolean SaveInRecord() throws SQLException {

          
       inValue.setBackground(Color.white);
        reicept_name.setBackground(Color.white);
        reicept_no.setBackground(Color.white);
        
        if (!Functions.validation(inValue.getText(), 2, true)) {
            inValue.setBackground(Color.red);
            inValue.grabFocus();
            inValue.selectAll();
            
            return false;
        }
        if (!Functions.validation(reicept_name.getText(), 1, true)) {
            reicept_name.setBackground(Color.red);
            reicept_name.grabFocus();
            reicept_name.selectAll(); 
            
            return false;
        }
        if (!Functions.validation(reicept_no.getText(), 1, true)) {
            reicept_no.setBackground(Color.red);
            reicept_no.grabFocus();
            reicept_no.selectAll(); 
            
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

     int category_id = conn.getIDByDesc("references_categories", categoriesComboBox.getSelectedItem().toString(), "desc_", "reference_id");
       int  vendor_id = conn.getIDByDesc("vendors", vendorssComboBox1.getSelectedItem().toString(), "vendor_name", "vendor_id");
            
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "reference_id", "notice", "date_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + category_id + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
            "'" + bldno + "'",
            "'" + vendor_id + "'",
            "'" + (jCheckBox1.isSelected()?jLabel3.getText():"1") + "'"};
        conn.insertIntoTable(tableName, fields, values);
        emptyinFields();
        return true;

    }
     private Boolean UpdateRecord() throws SQLException {

         inValue.setBackground(Color.white);
        reicept_name.setBackground(Color.white);
        reicept_no.setBackground(Color.white);
        
        if (!Functions.validation(inValue.getText(), 2, true)) {
            inValue.setBackground(Color.red);
            inValue.grabFocus();
            inValue.selectAll();
            
            return false;
        }
        if (!Functions.validation(reicept_name.getText(), 1, true)) {
            reicept_name.setBackground(Color.red);
            reicept_name.grabFocus();
            reicept_name.selectAll(); 
            
            return false;
        }
        if (!Functions.validation(reicept_no.getText(), 1, true)) {
            reicept_no.setBackground(Color.red);
            reicept_no.grabFocus();
            reicept_no.selectAll(); 
            
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

     int category_id = conn.getIDByDesc("references_categories", categoriesComboBox.getSelectedItem().toString(), "desc_", "reference_id");
       int  vendor_id = conn.getIDByDesc("vendors", vendorssComboBox1.getSelectedItem().toString(), "vendor_name", "vendor_id");
            
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "reference_id", "notice", "date_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + category_id + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
            "'" + bldno + "'",
            "'" + vendor_id + "'",
            "'" + (jCheckBox1.isSelected()?jLabel3.getText():"1") + "'"};
        conn.updateTable(tableName, fields, values,tableKey,""+payment_id);
        emptyinFields();
        return true;


    }


    private void emptyinFields() {
        inValue.setText("");
        reicept_name.setText("");
        reicept_no.setText("");
        notice.setText("");
    }

   

    private void getPaymentInfos(int payment_id) {
       this.payment_id=payment_id;
       this.setTitle("تعديل دفعة احضارات للمحضر  "+bldesc);
        try{
          String query=resultquery+ payment_id;
         
         System.out.println(query);
            Statement recordsStmt = conn.conn.createStatement();
            ResultSet recordsResultSet = recordsStmt.executeQuery(query);
            
          while (recordsResultSet.next()) {
              
              inDate.setDate(Functions.StringToDate(recordsResultSet.getString(8)));
              inValue.setText(recordsResultSet.getString(7));
              reicept_name.setText(recordsResultSet.getString(5));
              reicept_no.setText(recordsResultSet.getString(4));
              categoriesComboBox.setSelectedItem(recordsResultSet.getString(3));
              vendorssComboBox1.setSelectedItem(recordsResultSet.getString(2));
              notice.setText(recordsResultSet.getString(1));
              
              jLabel3.setText((recordsResultSet.getString(6).equals("1")?"":recordsResultSet.getString(6)));
              
              
                          }
        } catch (SQLException ex) {
            Logger.getLogger(addpayment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
