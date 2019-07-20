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
public class ProjectdigingQuantityReport extends javax.swing.JFrame {

 
   
     String tableName = "rec_diging";
    String tableKey = "re_id";


    String quantityPerReferenceQuery = "";
    
  
  
     connect inConn;
 
    private final Image img; 
    public ProjectdigingQuantityReport()throws SQLException {
       
        inConn = new connect();
        inConn.newConnection();
        
 
   quantityPerReferenceQuery = "SELECT "
            
           + " diging_.unit  as"+ '"' + "الواحدة" + '"'+", "
            + "sum (rec_diging.quantity )  as"+ '"' + "مجموع الكميات" + '"'+","
            
            + " diging_.desc_  as"+ '"' + "بيان عمل الحفر" + '"'+" "
            + "FROM rec_diging "
            + "left join  diging_ on rec_diging.diging_id = diging_.diging_id "
        
            + "   group by diging_.desc_,diging_.unit";
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(953, 680);
        this.setLocation((temp_width - 953) / 2, (temp_height - 680) / 2);
        this.setIconImage(img);   
    
      
         
         this.setTitle("مجموع كميات أعمال الحفر للمشروع");
        jLabel2.setText("مجموع كميات أعمال الحفر للمشروع");
        /*inputs*/
        
        showAllResults();
       
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
        jPanel2 = showChartQuantity();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = showBarChartQuantity();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("مجموع كميات أعمال الحفر");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        inputsRecordsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "التاريخ", "الصافي", "السائق", "الزبون", "السيارة", "الجهة", "البطاقة"
            }
        ));
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
        jLabel2.setText("مجموع كميات أعمال الحفر");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public static void showResults(String recordsquery,JTable RecordsjTable,connect conn) {
       System.out.println(recordsquery);
        conn.QueryTable(recordsquery, RecordsjTable);

    }

    
    private void showAllResults() {
        showResults(quantityPerReferenceQuery,inputsRecordsjTable,inConn);
  
    }



    private JPanel showChartQuantity() {
         
        inConn.newConnection();
        Statement stmt = null;
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        String chartQuantityPerReferenceQuery = "SELECT "
                + " diging_.unit , "
                + "sum (rec_diging.quantity )  as quantity,"
                
                + " diging_.desc_ "
                + "FROM rec_diging "
                + "left join  diging_ on rec_diging.diging_id = diging_.diging_id "
              
                + "   group by diging_.desc_,diging_.unit";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                pieDataset.setValue(res.getString("desc_") +"("+res.getInt("quantity")+ ") " + res.getString("unit"), new Integer(res.getInt("quantity")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjectdigingQuantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createPieChartPanel("كميات أعمال الحفريات للمشروع", pieDataset,this.getWidth()/2,370);
    }
    
    
       private JPanel showBarChartQuantity() {
         
        inConn.newConnection();
        Statement stmt = null;
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
                String chartQuantityPerReferenceQuery = "SELECT "
              
                + "sum (rec_diging.quantity )  as quantity,"
                + " diging_.unit , "
                + " diging_.desc_ "
                + "FROM rec_diging "
                + "left join  diging_ on rec_diging.diging_id = diging_.diging_id "
         
                + "   group by diging_.desc_,diging_.unit";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {

                barDataset.setValue(new Integer(res.getInt("quantity")),res.getString("desc_") +"("+res.getInt("quantity")+ ") " +res.getString("unit"), res.getString("desc_"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjectdigingQuantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Functions.createBarChartPanel("كميات أعمال الحفريات للمشروع","اعمال حفر","كميات", barDataset,this.getWidth()/2,370);
    }
}
