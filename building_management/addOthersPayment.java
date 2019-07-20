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

public class addOthersPayment extends javax.swing.JFrame {

    boolean state;
    JFrame invoke;
    int other_id = 0;
    String[] fields = {"amount", "receipt_name", "receipt_no", "other_id", "notice", "date_","buildno"};
    String tableName = "payment_others_records";
    String tableKey = "others_re_id";
    String resultquery = "SELECT "
            + " payment_others_records.date_  as " + '"' + "التاريخ " + '"'
            + ", payment_others_records.amount  as " + '"' + "الدفعة " + '"'
            + ", payment_others_records.receipt_name as " + '"' + "المستلم" + '"'
            + ", payment_others_records.receipt_no as " + '"' + "رقم الايصال" + '"'
            + ", others_.desc_ as " + '"' + "الاحضار" + '"'
            + ", payment_others_records.notice as " + '"' + "ملاحظات" + '"'
            + " FROM payment_others_records  "
            + "   join others_ on payment_others_records.other_id=others_.other_id"
            + " where  others_re_id =";

    connect conn;
    Statement stmt;
    int payement_id=0;
    String bldno;
  
    private final Image img;

    public addOthersPayment(javax.swing.JFrame mainFram,String bldno,int payment_id) throws SQLException {
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

        this.setSize(650, 180);
        this.setLocation((temp_width - 650) / 2, (temp_height - 180) / 2);
        this.setIconImage(img);
        this.setTitle("اضافة دفعة لأعمال مختلفة المحضر رقم "+bldno);
        this.bldno=bldno;

        fillTypeCombo();

        Date currentDate = new Date();
        inDate.setDate(currentDate);
        othersComboBox.grabFocus();
        
        if(payment_id>0)
        {
            
            getPaymentInfos(payment_id);
            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        othersComboBox = new javax.swing.JComboBox();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("الدفعات");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        othersComboBox.setNextFocusableComponent(inDate);
        othersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("قيمة الدفعة");

        inValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inValue.setNextFocusableComponent(reicept_name);
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
        inDate.setNextFocusableComponent(inValue);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("التاريخ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("اسم العمل");

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
        notice.setNextFocusableComponent(savein);
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
        reicept_name.setNextFocusableComponent(reicept_no);
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
        reicept_no.setNextFocusableComponent(notice);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(othersComboBox, 0, 110, Short.MAX_VALUE)
                            .addComponent(reicept_name)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(savein)
                        .addGap(5, 5, 5)
                        .addComponent(notice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(othersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reicept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, othersComboBox});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if(payement_id>0)
            {
              status=  UpdateRecord();
            }else
            {
            status=SaveInRecord();
            }

            if(status) this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            othersComboBox.setBackground(Color.red);
        }

    }//GEN-LAST:event_saveinActionPerformed

    private void inValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValueKeyReleased

    }//GEN-LAST:event_inValueKeyReleased

    private void inValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValueActionPerformed


    }//GEN-LAST:event_inValueActionPerformed

    private void othersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_othersComboBoxActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JTextField inValue;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField notice;
    private javax.swing.JComboBox othersComboBox;
    private javax.swing.JTextField reicept_name;
    private javax.swing.JTextField reicept_no;
    private javax.swing.JButton savein;
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

        other_id = conn.getIDByDesc("others_", othersComboBox.getSelectedItem().toString(), "desc_", "other_id");
        
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "other_id", "notice", "date_","buildno"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + other_id + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
            "'" + bldno + "'"};
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

        other_id = conn.getIDByDesc("others_", othersComboBox.getSelectedItem().toString(), "desc_", "other_id");
        
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "other_id", "notice", "date_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + other_id + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
            "'" + bldno + "'"
            };
        conn.updateTable(tableName, fields, values,tableKey,""+payement_id);
        emptyinFields();
        return true;


    }


    private void emptyinFields() {
        inValue.setText("");
        reicept_name.setText("");
        reicept_no.setText("");
        notice.setText("");
    }

    private void fillTypeCombo() throws SQLException {
        conn.fillComboBox("others_", "desc_", othersComboBox);

    }

    private void getPaymentInfos(int payment_id) {
       this.payement_id=payment_id;
       this.setTitle("تعديل دفعة أعمال مختلفة للمحضر رقم "+bldno);
        try{
          String query=resultquery+ payment_id;
         
         System.out.println(query);
            Statement recordsStmt = conn.conn.createStatement();
            ResultSet recordsResultSet = recordsStmt.executeQuery(query);
            
          while (recordsResultSet.next()) {
              
              inDate.setDate(Functions.StringToDate(recordsResultSet.getString(1)));
              inValue.setText(recordsResultSet.getString(2));
              reicept_name.setText(recordsResultSet.getString(3));
              reicept_no.setText(recordsResultSet.getString(4));
              othersComboBox.setSelectedItem(recordsResultSet.getString(5));
              notice.setText(recordsResultSet.getString(6));
              
              
                          }
        } catch (SQLException ex) {
            Logger.getLogger(addOthersPayment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
