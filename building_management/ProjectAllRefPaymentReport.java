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

public class ProjectAllRefPaymentReport extends javax.swing.JFrame {

    JFrame invoke;
    String tableName = "rec_references";
    String tableKey = "re_id";

    String quantityPerReferenceQuery = "";


    connect inConn;

    private final Image img;

    public ProjectAllRefPaymentReport(javax.swing.JFrame mainFram) throws SQLException {
        invoke = mainFram;
        invoke.setEnabled(false);
        inConn = new connect();
        inConn.newConnection();
  
        quantityPerReferenceQuery = "select\n"
                + "(sum(AA.total_price*AA.currency_factor) - COALESCE(( select sum(payments_records.amount*payments_records.currency_factor) \n"
                + "FROM payments_records    \n"
                + "left join  references_categories on payments_records.category_id = references_categories.reference_id  \n"
                + "left join  vendors on payments_records.vendor_id = vendors.vendor_id \n"
                + " where vendors.vendor_id= AA.vendor_id),0)) as \"باقي المستحقات \",\n"
                + "( select sum(payments_records.amount*payments_records.currency_factor) \n"
                + "FROM payments_records    \n"
                + "left join  references_categories on payments_records.category_id = references_categories.reference_id  \n"
                + "left join  vendors on payments_records.vendor_id = vendors.vendor_id \n"
                + " where  vendors.vendor_id= AA.vendor_id) as \"مجموع المدفوعات \",  \n"
                + "sum(AA .total_price*AA.currency_factor) as \"مجموع المستحقات \",\n"
                + "  vendors.vendor_name as \"المورد\"\n"
                + " from rec_references AA \n"
                + " left join references_ on AA.reference_id=references_.reference_id\n"
                + " left join references_categories on references_.category_id=references_categories.reference_id\n"
                + " left join  vendors on AA.vendor_id = vendors.vendor_id \n"
                + " group by AA.vendor_id,vendors.vendor_name ";

        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(960, 600);
        this.setLocation((temp_width - 960) / 2, (temp_height - 600) / 2);
        this.setIconImage(img);

        this.setTitle(" محصلة الموردين لكل الاحضارات  لكل المحاضر " );
        jLabel2.setText(" محصلة الموردين لكل الاحضارات  لكل المحاضر ");
        /*inputs*/

        inConn.QueryTable(quantityPerReferenceQuery, inputsRecordsjTable);
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
        jPanel2 = showPie1Chart();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = showPie2Chart();
        jPanel4 = showPie3Chart();

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
            .addGap(0, 274, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable inputsRecordsjTable;
    private javax.swing.JLabel jLabel2;
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
            Logger.getLogger(ProjectAllRefPaymentReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProjectAllRefPaymentReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProjectAllRefPaymentReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("المستحقات", pieDataset, this.getWidth() / 3, 320);
    }

}
