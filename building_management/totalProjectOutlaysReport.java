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
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class totalProjectOutlaysReport extends javax.swing.JFrame {

 
  


    String quantityPerReferenceQuery = "";
    
    

 DecimalFormat df;
 
     connect inConn;
 BigDecimal TOTAL;
     
 
    private final Image img; 
    public totalProjectOutlaysReport()throws SQLException {
       
        inConn = new connect();
        inConn.newConnection();
df= new DecimalFormat("#.#");
    
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(900, 666);
        this.setLocation((temp_width - 900) / 2, (temp_height - 666) / 2);
        this.setIconImage(img);   
    
      
        
         this.setTitle("نقرير مصروفات المشروع");
       
        /*inputs*/
        
       
       
       // conn.QueryTable(recordsquery, cardRecordsjTable);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ProjectOjPanel = showProjectOutlays();
        RefjPanel = showCategoriesOutlays();
        RefjPanel1 = showAllRefrenciesOutlays();
        jPanel2 = showBarChartDetailedRefrenciesOutlays();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        ProjectOjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ProjectOjPanel.setMaximumSize(new java.awt.Dimension(449, 328));

        javax.swing.GroupLayout ProjectOjPanelLayout = new javax.swing.GroupLayout(ProjectOjPanel);
        ProjectOjPanel.setLayout(ProjectOjPanelLayout);
        ProjectOjPanelLayout.setHorizontalGroup(
            ProjectOjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        ProjectOjPanelLayout.setVerticalGroup(
            ProjectOjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        RefjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RefjPanel.setMaximumSize(new java.awt.Dimension(445, 328));
        RefjPanel.setPreferredSize(new java.awt.Dimension(445, 2));

        javax.swing.GroupLayout RefjPanelLayout = new javax.swing.GroupLayout(RefjPanel);
        RefjPanel.setLayout(RefjPanelLayout);
        RefjPanelLayout.setHorizontalGroup(
            RefjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        RefjPanelLayout.setVerticalGroup(
            RefjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        RefjPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RefjPanel1.setMaximumSize(new java.awt.Dimension(445, 328));
        RefjPanel1.setPreferredSize(new java.awt.Dimension(445, 2));

        javax.swing.GroupLayout RefjPanel1Layout = new javax.swing.GroupLayout(RefjPanel1);
        RefjPanel1.setLayout(RefjPanel1Layout);
        RefjPanel1Layout.setHorizontalGroup(
            RefjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        RefjPanel1Layout.setVerticalGroup(
            RefjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(RefjPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(RefjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(ProjectOjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ProjectOjPanel, RefjPanel, RefjPanel1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(RefjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(ProjectOjPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ProjectOjPanel, RefjPanel, RefjPanel1});

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
    private javax.swing.JPanel ProjectOjPanel;
    private javax.swing.JPanel RefjPanel;
    private javax.swing.JPanel RefjPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public static void showResults(String recordsquery,JTable RecordsjTable,connect conn) {
       System.out.println(recordsquery);
        conn.QueryTable(recordsquery, RecordsjTable);

    }

    
 

    private JPanel showProjectOutlays() {
    DefaultPieDataset pieDataset = new DefaultPieDataset();
         String chartQuantityPerReferenceQuery =
                 "SELECT sum(amount) as amount FROM total_outlays_records  "; 
         
         String type_="";
     try {
         inConn.newConnection();
        Statement stmt = null;
        
        stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
               // res.getBigDecimal("amount")
        TOTAL=res.getBigDecimal("amount");
                 }
        inConn.newConnection();
         stmt = null;
         pieDataset = new DefaultPieDataset();
          chartQuantityPerReferenceQuery =
                 "SELECT sum(amount) as amount, type_ FROM total_outlays_records group by type_ ";
        
            stmt = inConn.conn.createStatement();
             res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
                if(res.getString("type_").equals("G"))
                    type_="مصاريف عامة";
                else
                    type_="مصاريف إدارية";
                   
                pieDataset.setValue(type_ +"("+res.getInt("amount")+")", new Double(res.getDouble("amount")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(totalProjectOutlaysReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("اجمالي مصروفات المشروع  = "+df.format(TOTAL), pieDataset,this.getWidth()/3,280);
    }

    private JPanel showAllRefrenciesOutlays() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        String chartQuantityPerReferenceQuery
                = "SELECT sum(amount) as amount FROM outlays_records  ";
        
        String type_ = "";
        try {
            inConn.newConnection();
            Statement stmt = null;

            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
                TOTAL = res.getBigDecimal("amount");
            }
            inConn.newConnection();
            stmt = null;
            pieDataset = new DefaultPieDataset();
            chartQuantityPerReferenceQuery
                    = "SELECT sum(amount) as amount, type_ FROM outlays_records group by type_ ";

            stmt = inConn.conn.createStatement();
            res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
                if (res.getString("type_").equals("G")) {
                    type_ = "مصاريف عامة";
                } else {
                    type_ = "مصاريف إدارية";
                }
                pieDataset.setValue(type_ + "(" + res.getInt("amount") + ")", new Double(res.getDouble("amount")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(totalProjectOutlaysReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("اجمالي مصروفات المحاضر  = " + df.format(TOTAL), pieDataset, this.getWidth() / 3, 280);
    }

    private JPanel showDetailedRefrenciesOutlays() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        String chartQuantityPerReferenceQuery = "";

        try {

            inConn.newConnection();
            Statement stmt = null;
            pieDataset = new DefaultPieDataset();
            chartQuantityPerReferenceQuery
                    = "SELECT sum(amount) as amount ,buildings.desc_\n"
                    + "FROM outlays_records \n"
                    + "left join buildings on buildings.id_=outlays_records.buildno\n"
                    + "group by buildings.desc_  ";

            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString("desc_") + "(" + res.getInt("amount") + ")", new Double(res.getDouble("amount")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(totalProjectOutlaysReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("المصروفات حسب المحاضر", pieDataset, this.getWidth() / 3, 280);
    }

    private JPanel showCategoriesOutlays() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        String chartQuantityPerReferenceQuery = "";

        try {

            inConn.newConnection();
            Statement stmt = null;
            pieDataset = new DefaultPieDataset();
            chartQuantityPerReferenceQuery
                    = "SELECT sum(amount) as amount ,category as desc_ \n"
                    + "FROM categories_outlays_records \n"
                          + "group by category  ";

            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString("desc_") + "(" + res.getInt("amount") + ")", new Double(res.getDouble("amount")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(totalProjectOutlaysReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("المصروفات حسب قسمي المشروع", pieDataset, this.getWidth() / 3, 280);
    }

    
    private JPanel showBarChartDetailedRefrenciesOutlays() {

        inConn.newConnection();
        Statement stmt = null;
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        String chartQuantityPerReferenceQuery = "SELECT sum(amount) as amount ,buildings.desc_\n"
                + "FROM outlays_records \n"
                + "left join buildings on buildings.id_=outlays_records.buildno\n"
                + "group by buildings.desc_  ";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                barDataset.setValue(new Integer(res.getInt("amount")), res.getString("desc_") + "(" + res.getInt("amount") + ")", res.getString("desc_"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(____quantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createBarVerticalChartPanel("المصروفات حسب المحاضر", "المحضر", "القيمة", barDataset, this.getWidth(), 380);
    }
}
