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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.data.category.DefaultCategoryDataset;

public class elementHistoricalReport extends javax.swing.JFrame {

    JFrame invoke;
    String tableName = "rec_elements";
    String tableKey = "re_id";

    String quantityPerReferenceQuery = "";

    String bldno,bld_desc;
    connect conn;
    JFrame frame ;
    private final Image img;

    public elementHistoricalReport(javax.swing.JFrame mainFram, String bldno, String bld_desc) throws SQLException {
        invoke = mainFram;
        invoke.setEnabled(false);
        frame = this;
        conn = new connect();
        conn.newConnection();
         this.bldno = bldno;
          this.bld_desc = bld_desc;
       
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(953, 658);
        this.setLocation((temp_width - 953) / 2, (temp_height - 658) / 2);
        this.setIconImage(img);

       
        this.setTitle("نقرير عمل  محدد للمحضر  " + bld_desc);
        jLabel2.setText("نقرير عمل  محدد للمحضر  " + bld_desc);
        /*inputs*/
        conn.fillComboBox("elements_", "desc_", ReferenceComboBox);
       // showResults(quantityPerReferenceQuery, inputsRecordsjTable, conn);

        // conn.QueryTable(recordsquery, cardRecordsjTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputsRecordsjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ReferenceComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("تقرير تفصيلي لاعمال الحفريات");
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

        jLabel5.setText("تحديد العمل  :");

        ReferenceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferenceComboBoxActionPerformed(evt);
            }
        });

        jButton2.setText("إظهار");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addGap(4, 4, 4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 306, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(ReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReferenceComboBox)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public static void showResults(String recordsquery, JTable RecordsjTable, connect conn) {
        System.out.println(recordsquery);
        conn.QueryTable(recordsquery, RecordsjTable);

    }

  
    private JPanel showBarChartQuantity() {

        conn.newConnection();
        int type_id;
        try {
            type_id = conn.getIDByDesc("elements_", ReferenceComboBox.getSelectedItem().toString(), "desc_", "element_id");

            Statement stmt = null;
            DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
           String unit="";
            stmt = conn.conn.createStatement();
            ResultSet res = stmt.executeQuery(quantityPerReferenceQuery);
            while (res.next()) {

                barDataset.setValue(new Double(res.getDouble(3)), res.getDate(4), "("+res.getDouble(1)+")-"+res.getDate(4));
               unit=res.getString(2);
            } 
            return Functions.createBarChartPanel(ReferenceComboBox.getSelectedItem().toString(), "تاريخ(قيمة)", "كميات"+" ("+unit+")", barDataset, this.getWidth() / 2, 300);

        } catch (SQLException ex) {
           return null;
        }catch(NullPointerException ex) {
           return new JPanel();
        }
       

    }

    
    private void showSelectedTypeResults() throws SQLException {

        int type_id = conn.getIDByDesc("elements_", ReferenceComboBox.getSelectedItem().toString(), "desc_", "element_id");

        quantityPerReferenceQuery = "SELECT "
            + "sum (rec_elements.total_price ) as"+ '"' + "مجموع التكالبف" + '"'+","
            + " units.desc_  as"+ '"' + "الواحدة" + '"'+", "
            + "sum (rec_elements.quantity )  as"+ '"' + "مجموع الكميات" + '"'+","
            + "rec_elements.date_  as \"التاريخ\", "
            +" workers.worker_name  as " + '"' + "المهني" + '"'+","
            + " elements_.desc_  as"+ '"' + "بيان العمل" + '"'+" "
            + "FROM rec_elements "
            + "left join  elements_ on rec_elements.element_id = elements_.element_id "
            + " left join  workers on rec_elements.worker_id = workers.worker_id "
            + "left join  units on elements_.unit_id = units.id_ "
            + " where buildno='"+this.bldno+"'"
            + " and rec_elements.element_id= " + type_id
            + "   group by date_,elements_.desc_,workers.worker_name,units.desc_  order by  date_";

        showResults(quantityPerReferenceQuery, inputsRecordsjTable, conn);
       
        jPanel2.removeAll();
        CardLayout cl = new CardLayout();
       jPanel2.setLayout(cl);
      
         jPanel2.add(showBarChartQuantity());
         jPanel2.setVisible(true);
         
         jPanel2.revalidate();
        jPanel2.repaint();
        frame.pack();

        System.out.println(quantityPerReferenceQuery);

    }
}
