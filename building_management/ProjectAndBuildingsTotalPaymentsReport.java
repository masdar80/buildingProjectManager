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

public class ProjectAndBuildingsTotalPaymentsReport extends javax.swing.JFrame {

    String quantityPerReferenceQuery = "";

    DecimalFormat df;

    connect inConn;
    Double TOTAL;
    private final Image img;

    public ProjectAndBuildingsTotalPaymentsReport() throws SQLException {

        inConn = new connect();
        inConn.newConnection();
        df = new DecimalFormat("#.#");

        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(489, 242);
        this.setLocation((temp_width - 489) / 2, (temp_height - 242) / 2);
        this.setIconImage(img);

        this.setTitle("اجمالي مدفوعات المحاضر مضافا اليها مصاريف المشروع");

        /*inputs*/
        TOTAL = calcProjectOUtlays() + calcBuidlingsPayments();
        totalcosLable.setText(df.format(new BigDecimal(TOTAL)));

        // conn.QueryTable(recordsquery, cardRecordsjTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        totalcosLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        totalcosLable.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        totalcosLable.setForeground(new java.awt.Color(102, 0, 51));
        totalcosLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalcosLable, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(totalcosLable, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel totalcosLable;
    // End of variables declaration//GEN-END:variables

    private Double calcProjectOUtlays() {
        Double total1 = 0.0;
        inConn.newConnection();
        Statement stmt = null;

        String total_outlays_recordsQuery = "SELECT sum(amount) as amount FROM total_outlays_records  ";

        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(total_outlays_recordsQuery);
            while (res.next()) {
                total1 = res.getDouble("amount");
            }

        } catch (SQLException ex) {
            Logger.getLogger(____quantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total1;
    }

    private Double calcBuidlingsPayments() {
        Double total1 = 0.0;
        inConn.newConnection();
        Statement stmt = null;
        String chartQuantityPerReferenceQuery = "SELECT amount FROM totalpayments  ";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
                total1 = res.getDouble("amount");
            }

        } catch (SQLException ex) {
            Logger.getLogger(____quantityReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total1;
    }
}
