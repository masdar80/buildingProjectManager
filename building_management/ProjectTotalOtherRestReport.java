

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
public class ProjectTotalOtherRestReport extends javax.swing.JFrame {

 
  


    String quantityPerReferenceQuery = "";
    
    String TOTAL="";

 
     connect inConn;
 
    private final Image img; 
    public ProjectTotalOtherRestReport()throws SQLException {
       
        inConn = new connect();
        inConn.newConnection();

    
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(1200, 700);
        this.setLocation((temp_width - 1200) / 2, (temp_height - 700) / 2);
        this.setIconImage(img);   
    
      
        
         this.setTitle("تقرير باقي المستحقات الكلية للاعمال المتفرقة");
       
        /*inputs*/
        
       
       
       // conn.QueryTable(recordsquery, cardRecordsjTable);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RefjPanel = showProjectpaymentd();
        jPanel2 = showBarProjectPayment();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        RefjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RefjPanel.setMaximumSize(new java.awt.Dimension(445, 328));
        RefjPanel.setPreferredSize(new java.awt.Dimension(445, 2));

        javax.swing.GroupLayout RefjPanelLayout = new javax.swing.GroupLayout(RefjPanel);
        RefjPanel.setLayout(RefjPanelLayout);
        RefjPanelLayout.setHorizontalGroup(
            RefjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        RefjPanelLayout.setVerticalGroup(
            RefjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(RefjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RefjPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public static void showResults(String recordsquery,JTable RecordsjTable,connect conn) {
       System.out.println(recordsquery);
        conn.QueryTable(recordsquery, RecordsjTable);

    }

    
      private JPanel showProjectpaymentd() {
    DefaultPieDataset pieDataset = new DefaultPieDataset();
         String chartQuantityPerReferenceQuery =
                 "SELECT sum(a.amount) AS amount\n" +
"   FROM (       SELECT rec_others.total_price AS amount,\n" +
"                    buildings.desc_\n" +
"                   FROM rec_others\n" +
"              LEFT JOIN buildings ON buildings.id_ = rec_others.buildno\n" +
"        UNION ALL\n" +
"                  SELECT -1*payment_others_records.amount,\n" +
"                    buildings.desc_\n" +
"                   FROM payment_others_records\n" +
"              LEFT JOIN buildings ON buildings.id_ = payment_others_records.buildno\n" +
"                  ) a "; 
         
         
     try {
         inConn.newConnection();
        Statement stmt = null;
        
        stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
        TOTAL=""+res.getDouble("amount");
                 }
        inConn.newConnection();
         stmt = null;
         pieDataset = new DefaultPieDataset();
          chartQuantityPerReferenceQuery =
                 "SELECT sum(a.amount) AS amount,a.desc_" +
"   FROM (       SELECT rec_others.total_price AS amount,\n" +
"                    buildings.desc_\n" +
"                   FROM rec_others\n" +
"              LEFT JOIN buildings ON buildings.id_ = rec_others.buildno\n" +
"        UNION ALL\n" +
"                  SELECT -1*payment_others_records.amount,\n" +
"                    buildings.desc_\n" +
"                   FROM payment_others_records\n" +
"              LEFT JOIN buildings ON buildings.id_ = payment_others_records.buildno\n" +
"                  ) a GROUP BY a.desc_";
        
            stmt = inConn.conn.createStatement();
             res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
         
                pieDataset.setValue(res.getString("desc_") +"("+res.getInt("amount")+")", new Double(res.getDouble("amount")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjectTotalOtherRestReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("", pieDataset,550,550);
    }
       
   
       private JPanel showBarProjectPayment() {
         
        inConn.newConnection();
        Statement stmt = null;
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
                String chartQuantityPerReferenceQuery ="SELECT sum(a.amount) AS amount,a.desc_" +
"   FROM (       SELECT rec_others.total_price AS amount,\n" +
"                    buildings.desc_\n" +
"                   FROM rec_others\n" +
"              LEFT JOIN buildings ON buildings.id_ = rec_others.buildno\n" +
"        UNION ALL\n" +
"                  SELECT -1*payment_others_records.amount,\n" +
"                    buildings.desc_\n" +
"                   FROM payment_others_records\n" +
"              LEFT JOIN buildings ON buildings.id_ = payment_others_records.buildno\n" +
"                  ) a GROUP BY a.desc_";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                barDataset.setValue(new Integer(res.getInt("amount")),res.getString("desc_") +"("+res.getInt("amount")+")",res.getString("desc_"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(____quantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createBarChartPanel("باقي مستحقات الاعمال المتفرقة الكلية ="+TOTAL,"المحضر","القيمة", barDataset,550,680);
    }
}
