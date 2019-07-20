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
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ProjetAllBuildingsReferencePaymentsReport extends javax.swing.JFrame {

    JFrame invoke;
    String tableName = "rec_references";
    String tableKey = "re_id";

    String quantityPerReferenceQuery = "";

   
    connect inConn;
JFrame frame ;
    private final Image img;

    public ProjetAllBuildingsReferencePaymentsReport(javax.swing.JFrame mainFram) throws SQLException {
        frame=this;
        invoke = mainFram;
        invoke.setEnabled(false);
        inConn = new connect();
        inConn.newConnection();
        

        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(1029, 634);
        this.setLocation((temp_width - 1029) / 2, (temp_height - 634) / 2);
        this.setIconImage(img);
        inConn.fillComboBox("vendors", "vendor_name", ReferenceComboBox);
        this.setTitle("احصائية المستحقات التفصيلية لكل المحاضر للمورد " );
        jLabel2.setText("احصائية المستحقات التفصيلية لكل المحاضر للمورد " );
        /*inputs*/

        // conn.QueryTable(recordsquery, cardRecordsjTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputsRecordsjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ReferenceComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("نقرير قيم المبالغ المدفوعة للاحضارات");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("المورد ");

        ReferenceComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReferenceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferenceComboBoxActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("إظهار");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReferenceComboBox)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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

    private void inputsRecordsjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputsRecordsjTableMouseClicked

    }//GEN-LAST:event_inputsRecordsjTableMouseClicked

    private void inputsRecordsjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyPressed

    }//GEN-LAST:event_inputsRecordsjTableKeyPressed

    private void inputsRecordsjTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsRecordsjTableKeyReleased

    }//GEN-LAST:event_inputsRecordsjTableKeyReleased

    private void ReferenceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferenceComboBoxActionPerformed

    }//GEN-LAST:event_ReferenceComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            showSelectedTypeResults();
        } catch (SQLException e) {

        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ReferenceComboBox;
    private static javax.swing.JTable inputsRecordsjTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private JPanel showPie1Chart() {

        inConn.newConnection();
        Statement stmt = null;
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(quantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString(4) + "(" + res.getInt(1) + ")", new Double(res.getDouble(1)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetAllBuildingsReferencePaymentsReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("باقي المستحقات", pieDataset, this.getWidth() / 3, 320);
    }

    private JPanel showPie2Chart() {

        inConn.newConnection();
        Statement stmt = null;
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(quantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString(4) + "(" + res.getInt(2) + ")", new Double(res.getDouble(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetAllBuildingsReferencePaymentsReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("المدفوعات", pieDataset, this.getWidth() / 3, 320);
    }

    private JPanel showPie3Chart() {

        inConn.newConnection();
        Statement stmt = null;
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(quantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString(4) + "(" + res.getInt(3) + ")", new Double(res.getDouble(3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjetAllBuildingsReferencePaymentsReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("المستحقات", pieDataset, this.getWidth() / 3, 320);
    }

    private void showSelectedTypeResults() throws SQLException {
      
         int vendor_id = inConn.getIDByDesc("vendors", ReferenceComboBox.getSelectedItem().toString(), "vendor_name", "vendor_id");

        
        quantityPerReferenceQuery = "select\n"
                + "(sum(AA.total_price*AA.currency_factor) - COALESCE(( select sum(payments_records.amount*payments_records.currency_factor) \n"
                + "FROM payments_records    \n"
                + "left join  references_categories on payments_records.category_id = references_categories.reference_id  \n"
                + "left join  vendors on payments_records.vendor_id = vendors.vendor_id \n"
                + " where payments_records.buildno=AA.buildno "
                + " and vendors.vendor_id= '" + vendor_id + "'),0)) as \"باقي المستحقات \",\n"
                + "( select sum(payments_records.amount*payments_records.currency_factor) \n"
                + "FROM payments_records    \n"
                + "left join  references_categories on payments_records.category_id = references_categories.reference_id  \n"
                + "left join  vendors on payments_records.vendor_id = vendors.vendor_id \n"
                + " where payments_records.buildno=AA.buildno "
                + " and vendors.vendor_id= '" + vendor_id + "') as \"مجموع المدفوعات \",  \n"
                + "sum(AA .total_price*AA.currency_factor) as \"مجموع المستحقات \",\n"
                + "  buildings.desc_ as \"المحضر\"\n"
                + " from rec_references AA \n"
                + " left join references_ on AA.reference_id=references_.reference_id\n"
                + " left join references_categories on references_.category_id=references_categories.reference_id\n"
                + " left join  buildings on AA.buildno = buildings.id_ \n"
                + " where AA.vendor_id='" + vendor_id + "' \n"
                + " group by AA.buildno,buildings.desc_ ";

        inConn.QueryTable(quantityPerReferenceQuery, inputsRecordsjTable);

         this.setTitle("احصائية المستحقات التفصيلية لكل المحاضر للمورد " +  ReferenceComboBox.getSelectedItem().toString());
        jLabel2.setText("احصائية المستحقات التفصيلية لكل المحاضر للمورد " +  ReferenceComboBox.getSelectedItem().toString());
        
        
        jPanel4.removeAll();
        CardLayout c4 = new CardLayout();
        jPanel4.setLayout(c4);

        jPanel4.add(showPie3Chart());
        jPanel4.setVisible(true);

        jPanel4.revalidate();
        jPanel4.repaint();

        jPanel3.removeAll();
        CardLayout c3 = new CardLayout();
        jPanel3.setLayout(c3);

        jPanel3.add(showPie2Chart());
        jPanel3.setVisible(true);

        jPanel3.revalidate();
        jPanel3.repaint();

        jPanel2.removeAll();
        CardLayout cl = new CardLayout();
        jPanel2.setLayout(cl);

        jPanel2.add(showPie1Chart());
        jPanel2.setVisible(true);

        jPanel2.revalidate();
        jPanel2.repaint();
        frame.pack();

    }

}
