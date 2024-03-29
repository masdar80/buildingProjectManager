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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author masdar
 */
public class elements_list extends javax.swing.JFrame {

    /**
     * Creates new form elements
     * @param bldno
     */
    String[] fields = { "quantity", "price", "total_price", "date_", "element_id","worker_id","buildno","notice"};
    String tableName = "rec_elements";
    String tableKey = "re_id";
    String resultquery ="SELECT  units.desc_ as \"الواحدة\","
            + " elements_.desc_ as \"اسم العنصر\","
            + " elements_.element_id  as \"ID\""
            + "FROM elements_  "
            + "left join units on units.id_ =elements_.unit_id  ";
    
    JFrame invoke ;
    String bldno,bld_desc;
   
    connect conn;
    public elements_list(javax.swing.JFrame mainFram,String bldno,String bld_desc) throws SQLException {
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
        this.setSize(589, 483);
        this.setLocation((temp_width - 589) / 2, (temp_height - 483) / 2);
        this.setIconImage(img);
        this.bldno=bldno;
        this.bld_desc=bld_desc;
        
        this.setTitle("اختيار عمل مهني لاضافته للمحضر    "+bld_desc);
        bldlbl.setText(bld_desc);
        resultquery=resultquery;
        ShowResuls();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputsRecordsjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bldlbl = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("اختيار عمل مهني لاضافته للمحضر  ");

        bldlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bldlbl.setForeground(new java.awt.Color(51, 51, 255));
        bldlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Files-New-File-icon 24.png"))); // NOI18N
        add.setText("اضافة بيان لنوع العمل المحدد ");
        add.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        msg.setForeground(new java.awt.Color(0, 102, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(272, 272, 272))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bldlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(657, 657, 657))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(636, 636, 636))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bldlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        jMenu2.setText("الدفعات");

        jMenuItem3.setText("اضافة دفعة");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("عرض الدفعات");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem1.setText("كشف حساب");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("احصائيات");

        jMenuItem2.setText("كميات وكلف");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.setText("حساب المهنيين");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem10.setText("محصلة");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem5.setText("تفصيل مبالغ مستحقة");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("تفصيل مبالغ مدفوعة");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("تفصيل باقي المستحقات");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenu3.add(jMenu1);

        jMenuItem8.setText("تقرير عمل محدد");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("تقرير مهني محدد");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true);
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
            ShowResuls();
         
    }//GEN-LAST:event_formWindowActivated

    private void inputsRecordsjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputsRecordsjTableMouseClicked

    }//GEN-LAST:event_inputsRecordsjTableMouseClicked

    private void inputsRecordsjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyPressed

    }//GEN-LAST:event_inputsRecordsjTableKeyPressed

    private void inputsRecordsjTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyReleased

    }//GEN-LAST:event_inputsRecordsjTableKeyReleased

    private String getselectedRecordID()
{
   int  selectedRow = inputsRecordsjTable.getSelectedRow();
        if(selectedRow<0)
        {
            //showMessage("يجب تحديد سطر لحذفه",false);
            return "";
        }
        
        return inputsRecordsjTable.getValueAt(selectedRow, 2).toString();
      
   
       
}
     private String getselectedRecordDesc()
{
   int  selectedRow = inputsRecordsjTable.getSelectedRow();
        if(selectedRow<0)
        {
            
            return "";
        }
        
        return inputsRecordsjTable.getValueAt(selectedRow, 1).toString();
      
   
       
}  
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

  try {
      if(getselectedRecordID().equals(""))
          showMessage("يجب تحديد سطر أولا",false);
      else
      {new elements(this,bldno,bld_desc,getselectedRecordID(),getselectedRecordDesc()).setVisible(true);
      showMessage("",false);
      }  
         } catch(SQLException ex)
         {
             
         }
 
    }//GEN-LAST:event_addActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
            new addElementPayment(this,this.bldno,bld_desc,0).setVisible(true);

        }catch(SQLException e)
        {

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try{
            new elementsPaymentsDetails(this,this.bldno,bld_desc).setVisible(true);

        }catch(SQLException e)
        {

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        try {
            new elementPricesReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            new elementPaymentReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            new element_balances_report(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new elementQuantityReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            new elementHistoricalReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
         try {
            new workersHistoricalReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        try {
            new AllElementsPaymentReport(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         
        
         try {
            new select_worker(this,this.bldno,this.bld_desc).setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(referenciesPaymentsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel bldlbl;
    private static javax.swing.JTable inputsRecordsjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel msg;
    // End of variables declaration//GEN-END:variables

   
    private void ShowResuls() {
        try {
       
            conn.QueryTable(resultquery, inputsRecordsjTable);
        }catch (NullPointerException ex) {
            
        }
            
        
        
       // conn.QueryTable(recordsquery, cardRecordsjTable);
    }
     private void showMessage(String message, boolean state) {
        if (state) {
            msg.setForeground(Color.GREEN);

        } else {
            msg.setForeground(Color.red);
        }
        msg.setText(message);
    }
}
