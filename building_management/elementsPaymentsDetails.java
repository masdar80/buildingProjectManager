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
public class elementsPaymentsDetails extends javax.swing.JFrame {

 
    boolean state;
    JFrame invoke ;
    int worker_id = 0;
    String[] fields = {"amount", "receipt_name", "receipt_no", "worker_id", "notice", "date_","buildno"};
    String tableName = "payment_element_records";
    String tableKey = "element_re_id";
    String resultquery = "";

    connect conn;
    Statement stmt;
    private final Image img;
    String bldno,bld_desc;
    
    
    public elementsPaymentsDetails(javax.swing.JFrame mainFram,String bldno,String bld_desc)throws SQLException {
        invoke = mainFram;
        invoke.setEnabled(false);
       
        conn = new connect();
        conn.newConnection();
 
        java.sql.Statement s = conn.conn.createStatement();
        conn.conn.createStatement();
        this.bldno=bldno;
        this.bld_desc=bld_desc;
    
        resultquery = "SELECT "
            + " payment_element_records.notice as " + '"' + "ملاحظات" + '"'
            + ", workers.worker_name as " + '"' + "المهني" + '"'
            + ", payment_element_records.receipt_no as " + '"' + "رقم الايصال" + '"'
            + ", payment_element_records.receipt_name as " + '"' + "المستلم" + '"'
            + ", payment_element_records.amount  as " + '"' + "الدفعة " + '"'
            + ", payment_element_records.date_  as " + '"' + "التاريخ " + '"'
            + " FROM payment_element_records  "
            + "  left join workers on payment_element_records.worker_id=workers.worker_id "
                + " where buildno='"+this.bldno+"'";
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(630, 500);
        this.setLocation((temp_width - 630) / 2, (temp_height - 500) / 2);
        this.setIconImage(img);   
        
         this.setTitle(" دفعات  المهنيين المحضر  "+bld_desc);
         jLabel2.setText(" دفعات  المهنيين المحضر  "+bld_desc);
        conn.fillComboBox("workers", "worker_name",  workersComboBox);
        
     
        Date currentDate = new Date();
        if(connect.role_.equals("مستخدم"))
        {
            editSelected.setEnabled(false);
            deleteselected.setEnabled(false);
        }
        inDate.setDate(currentDate);
        
       showResults();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputsRecordsjTable = new javax.swing.JTable();
        deleteselected = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        workersComboBox = new javax.swing.JComboBox();
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
        editSelected = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchjTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("الدفعات");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("قائمة الدفعات");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        inputsRecordsjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputsRecordsjTableMouseClicked(evt);
            }
        });
        inputsRecordsjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputsRecordsjTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputsRecordsjTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(inputsRecordsjTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        deleteselected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteselected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-delete-icon24.png"))); // NOI18N
        deleteselected.setText("حذف دفعة");
        deleteselected.setMargin(new java.awt.Insets(2, 1, 2, 1));
        deleteselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteselectedActionPerformed(evt);
            }
        });

        workersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workersComboBoxActionPerformed(evt);
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
        jLabel6.setText("المهني");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(workersComboBox, 0, 110, Short.MAX_VALUE)
                            .addComponent(reicept_name)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(savein)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(workersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        editSelected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit 32.png"))); // NOI18N
        editSelected.setText("تعديل دفعة");
        editSelected.setMargin(new java.awt.Insets(2, 1, 2, 1));
        editSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("بحث  :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prev-icon24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchjTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteselected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteselected)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(searchjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteselected, editSelected});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true); 
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void inputsRecordsjTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyReleased

    }//GEN-LAST:event_inputsRecordsjTableKeyReleased

    private void inputsRecordsjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyPressed

    }//GEN-LAST:event_inputsRecordsjTableKeyPressed

    private void inputsRecordsjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputsRecordsjTableMouseClicked

    }//GEN-LAST:event_inputsRecordsjTableMouseClicked

    private void deleteselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteselectedActionPerformed


          try {
              conn.deleteFromTable(tableName, tableKey, ""+getselectedRecordID());
                showResults();
          } catch (SQLException ex) {
              Logger.getLogger(elementsPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
          }
            
            
            //deleteselected.setEnabled(false);
    }//GEN-LAST:event_deleteselectedActionPerformed

    private void workersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workersComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workersComboBoxActionPerformed

    private void inValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValueActionPerformed

    }//GEN-LAST:event_inValueActionPerformed

    private void inValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValueKeyReleased

    }//GEN-LAST:event_inValueKeyReleased

    private void saveinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinActionPerformed

        try {

            SaveInRecord();
            showResults();


        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            workersComboBox.setBackground(Color.red);
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

    
    private int getselectedRecordID()
{
         int  selectedRow = inputsRecordsjTable.getSelectedRow();
        if(selectedRow<0)
        {
            //showMessage("يجب تحديد سطر لحذفه",false);
            return 0;
        }
        String refereneName = inputsRecordsjTable.getValueAt(selectedRow, 1).toString();
        
        String receiptNo ="";
        if(inputsRecordsjTable.getValueAt(selectedRow, 2)!=null)
        receiptNo= inputsRecordsjTable.getValueAt(selectedRow, 2).toString();
        
        String receiptName ="";
        if(inputsRecordsjTable.getValueAt(selectedRow, 3)!=null)
        receiptName= inputsRecordsjTable.getValueAt(selectedRow, 3).toString();
        
        
        String value_ ="";
        if(inputsRecordsjTable.getValueAt(selectedRow, 4)!=null)
        value_ = inputsRecordsjTable.getValueAt(selectedRow, 4).toString();
        
        String date_ = inputsRecordsjTable.getValueAt(selectedRow, 5).toString();
        
        //if(Functions.deletePrevilege){
            String id = "";

            try {

                id = conn.searchIdwithcondition("workers", "worker_id", "worker_name", refereneName);
            
           
            String[] values = {
            "'" + value_ + "'",
            "'" + receiptName + "'",
            "'" + receiptNo + "'",
            "'" + id + "'",
            "'" + date_ + "'",
            "'" + bldno + "'"};
            
            
            String[] fields1 = {"amount", "receipt_name", "receipt_no", "worker_id",  "date_","buildno"};
       return conn.getIDByCondiotonArray(tableName, fields1, values,tableKey);
           } catch (SQLException ex) {
               
               return 0;
            }
       
}
    
    private void editSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectedActionPerformed
     try {
        new addElementPayment(this,bldno,bld_desc,getselectedRecordID()).setVisible(true);
        } catch (SQLException ex) {
                Logger.getLogger(elementsPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
    }//GEN-LAST:event_editSelectedActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       showResults();
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        String searchtext=searchjTextField1.getText();
        String whereClause = "and (payment_element_records.receipt_name like '%" + searchtext + "%'"
        + " or payment_element_records.receipt_no like '%" + searchtext + "%'"
        + " or payment_element_records.notice like '%" + searchtext + "%'"
        + " or workers.worker_name like '%" + searchtext + "%')  order by payment_element_records.date_ DESC";

        try {
            System.out.println(resultquery+whereClause);
            conn.QueryTable(resultquery+whereClause, inputsRecordsjTable);
        }catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteselected;
    private javax.swing.JButton editSelected;
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JTextField inValue;
    private static javax.swing.JTable inputsRecordsjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField notice;
    private javax.swing.JTextField reicept_name;
    private javax.swing.JTextField reicept_no;
    private javax.swing.JButton savein;
    private javax.swing.JTextField searchjTextField1;
    private javax.swing.JComboBox workersComboBox;
    // End of variables declaration//GEN-END:variables

  
    private void SaveInRecord() throws SQLException {
        
       inValue.setBackground(Color.white);
        reicept_name.setBackground(Color.white);
        reicept_no.setBackground(Color.white);
        
        if (!Functions.validation(inValue.getText(), 2, true)) {
            inValue.setBackground(Color.red);
            inValue.grabFocus();
            inValue.selectAll();
            
            return;
        }
        if (!Functions.validation(reicept_name.getText(), 1, true)) {
            reicept_name.setBackground(Color.red);
            reicept_name.grabFocus();
            reicept_name.selectAll(); 
            
            return;
        }
        if (!Functions.validation(reicept_no.getText(), 1, true)) {
            reicept_no.setBackground(Color.red);
            reicept_no.grabFocus();
            reicept_no.selectAll(); 
            
            return;
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
            
            return;

        }

        worker_id = conn.getIDByDesc("workers", workersComboBox.getSelectedItem().toString(), "worker_name", "worker_id");
        
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "worker_id", "notice", "date_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + worker_id + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
            "'" + bldno + "'"};
        conn.insertIntoTable(tableName, fields, values);
        emptyinFields();
            
    }

  
    
    private void emptyinFields() {
       inValue.setText("");
        reicept_name.setText("");
        reicept_no.setText("");
        notice.setText("");
       
    }
    
   

    private void showResults() {
        try {
       
            conn.QueryTable(resultquery+"  order by payment_element_records.date_ DESC", inputsRecordsjTable);
        }catch (NullPointerException ex) {
            
        }
            
        
        
       // conn.QueryTable(recordsquery, cardRecordsjTable);
    }

}
