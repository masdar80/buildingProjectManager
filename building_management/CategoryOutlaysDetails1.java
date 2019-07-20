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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.data.general.DefaultPieDataset;
public class CategoryOutlaysDetails1 extends javax.swing.JFrame {

 
    boolean state;
    JFrame invoke ;
    int other_id = 0;
    String[] fields = {"amount", "receipt_name", "receipt_no", "desc_", "notice", "date_","type_","category"};
    String tableName = "categories_outlays_records";
    String tableKey = "total_outlays_re_id";
    String resultquery = "";
    String orderby="";
    String whereclause="";

    connect conn,conn1,inConn,connSearch1,connSearch2;
    Statement stmt;
    String project_desc;
    private final Image img;

    
    
    public CategoryOutlaysDetails1(javax.swing.JFrame mainFram,String project_desc)throws SQLException {
        invoke = mainFram;
        invoke.setEnabled(false);
       this.project_desc=project_desc;
        conn = new connect();
        conn.newConnection();
        
        conn1 = new connect();
        conn1.newConnection();
        
        connSearch1 = new connect();
        connSearch1.newConnection();
        
        connSearch2 = new connect();
        connSearch2.newConnection();
        
        /*
        
    
        
        */
         inConn = new connect();
        inConn.newConnection();
 
        java.sql.Statement s = conn.conn.createStatement();
        conn.conn.createStatement();
       
        resultquery = "SELECT "
            + " categories_outlays_records.notice as " + '"' + "ملاحظات" + '"'
            + ", categories_outlays_records.receipt_no as " + '"' + "رقم الايصال" + '"'
            + ", categories_outlays_records.receipt_name as " + '"' + "المستلم" + '"'
            + ", categories_outlays_records.amount  as " + '"' + "القيمة" + '"'
            + ", categories_outlays_records.date_  as " + '"' + "التاريخ " + '"'
            + ", categories_outlays_records.desc_ as " + '"' + "بيان المصروف" + '"'
            + " FROM categories_outlays_records  where type_= ";
        
        whereclause=" and category='"+project_desc+"' ";
        orderby=" order by categories_outlays_records.date_";
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();

        this.setSize(945, 608);
        this.setLocation((temp_width - 945) / 2, (temp_height - 608) / 2);
        this.setIconImage(img);   
        
         this.setTitle("مصروفات "+this.project_desc);
         jLabel2.setText("قائمة المصروفات الادارية "+this.project_desc);
         jLabel3.setText("قائمةالمصرفات العامة "+this.project_desc);
      
        Date currentDate = new Date();
//        if(connect.role_.equals("مستخدم"))
//        {
//            editSelected.setEnabled(false);
//            deleteselected.setEnabled(false);
//            
//            editSelected1.setEnabled(false);
//            deleteselected1.setEnabled(false);
//        }
        inDate.setDate(currentDate);
         inDate1.setDate(currentDate);
        
       showAdminResults();
       showGeneralResults();
        showAllSumResults();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        inValue1 = new javax.swing.JTextField();
        inDate1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        savein1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        notice1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        reicept_name1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        reicept_no1 = new javax.swing.JTextField();
        descTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        generalRecordsjTable = new javax.swing.JTable();
        deleteselected1 = new javax.swing.JButton();
        editSelected1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generalSumjLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchjTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
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
        descTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        adminRecordsjTable = new javax.swing.JTable();
        deleteselected = new javax.swing.JButton();
        editSelected = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        adminSumJlabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        searchjTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        add1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("قائمة المصروفات");
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

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("القيمة");

        inValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inValue1ActionPerformed(evt);
            }
        });
        inValue1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inValue1KeyReleased(evt);
            }
        });

        inDate1.setDateFormatString("MMM d, yyyy ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("التاريخ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("بيان المصاريف");

        savein1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savein1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Files-New-File-icon 24.png"))); // NOI18N
        savein1.setText("حفظ");
        savein1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        savein1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savein1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ملاحظة");

        notice1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notice1ActionPerformed(evt);
            }
        });
        notice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notice1KeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("الجهة");

        reicept_name1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reicept_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reicept_name1ActionPerformed(evt);
            }
        });
        reicept_name1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reicept_name1KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("رقم الايصال");

        reicept_no1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reicept_no1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reicept_no1ActionPerformed(evt);
            }
        });
        reicept_no1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reicept_no1KeyReleased(evt);
            }
        });

        descTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextField1ActionPerformed(evt);
            }
        });
        descTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(savein1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notice1)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(reicept_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(reicept_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(inDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(inValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descTextField1)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reicept_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reicept_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savein1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notice1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        generalRecordsjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        generalRecordsjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generalRecordsjTableMouseClicked(evt);
            }
        });
        generalRecordsjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalRecordsjTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                generalRecordsjTableKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(generalRecordsjTable);

        deleteselected1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteselected1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-delete-icon24.png"))); // NOI18N
        deleteselected1.setText("حذف");
        deleteselected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteselected1ActionPerformed(evt);
            }
        });

        editSelected1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editSelected1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit 32.png"))); // NOI18N
        editSelected1.setText("تعديل");
        editSelected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelected1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("مجموع :");

        generalSumjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generalSumjLabel.setForeground(new java.awt.Color(0, 51, 204));
        generalSumjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("بحث  :");

        searchjTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prev-icon24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-icon 32.png"))); // NOI18N
        add.setText("طباعة");
        add.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalSumjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(deleteselected1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editSelected1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteselected1, editSelected1});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(generalSumjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editSelected1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteselected1)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(searchjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteselected1, editSelected1});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {generalSumjLabel, jLabel1, jLabel3});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(443, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 138, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("مصروفات عامة", jPanel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("القيمة");

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
        jLabel6.setText("بيان المصاريف");

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
        jLabel8.setText("الجهة");

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
        jLabel9.setText("رقم الايصال");

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

        descTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextFieldActionPerformed(evt);
            }
        });
        descTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTextFieldKeyReleased(evt);
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
                        .addComponent(savein)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notice, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(reicept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inValue, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reicept_name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reicept_no, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adminRecordsjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        adminRecordsjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminRecordsjTableMouseClicked(evt);
            }
        });
        adminRecordsjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminRecordsjTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adminRecordsjTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(adminRecordsjTable);

        deleteselected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteselected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-delete-icon24.png"))); // NOI18N
        deleteselected.setText("حذف");
        deleteselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteselectedActionPerformed(evt);
            }
        });

        editSelected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit 32.png"))); // NOI18N
        editSelected.setText("تعديل");
        editSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectedActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("مجموع :");

        adminSumJlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminSumJlabel.setForeground(new java.awt.Color(0, 51, 204));
        adminSumJlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("بحث  :");

        searchjTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prev-icon24.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        add1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-icon 32.png"))); // NOI18N
        add1.setText("طباعة");
        add1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(adminSumJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(deleteselected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteselected, editSelected});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(adminSumJlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(searchjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteselected)
                        .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteselected, editSelected});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {adminSumJlabel, jLabel2, jLabel4});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(443, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 135, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("مصروفات إدارية", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoke.setEnabled(true); 
        invoke.toFront();
    }//GEN-LAST:event_formWindowClosed

    
    private int getselectedAdmibRecordID()
{
         int  selectedRow = adminRecordsjTable.getSelectedRow();
        if(selectedRow<0)
        {
            //showMessage("يجب تحديد سطر لحذفه",false);
            return 0;
        }
        
        
        String receiptNo ="";
        if(adminRecordsjTable.getValueAt(selectedRow, 1)!=null)
        receiptNo= adminRecordsjTable.getValueAt(selectedRow, 1).toString();
        
        String receiptName ="";
        if(adminRecordsjTable.getValueAt(selectedRow, 2)!=null)
        receiptName= adminRecordsjTable.getValueAt(selectedRow, 2).toString();
        
        
        String value_ ="";
        if(adminRecordsjTable.getValueAt(selectedRow, 3)!=null)
        value_ = adminRecordsjTable.getValueAt(selectedRow, 3).toString();
        
        String date_ = adminRecordsjTable.getValueAt(selectedRow, 4).toString();
        
        String desc_ = adminRecordsjTable.getValueAt(selectedRow, 5).toString();
     

            try {

           
            String[] values = {
            "'" + value_ + "'",
            "'" + receiptName + "'",
            "'" + receiptNo + "'",
            "'" + desc_ + "'",
            "'" + date_ + "'",
            "'A'",
            "'" + this.project_desc + "'"};
            
            
            String[] fields1 = {"amount", "receipt_name", "receipt_no", "desc_",  "date_","type_","category"};
       return conn.getIDByCondiotonArray(tableName, fields1, values,tableKey);
           } catch (SQLException ex) {
               
               return 0;
            }
       
}
    
    
    private int getselectedGenRecordID()
{
         int  selectedRow = generalRecordsjTable.getSelectedRow();
        if(selectedRow<0)
        {
            //showMessage("يجب تحديد سطر لحذفه",false);
            return 0;
        }
        
        
        String receiptNo ="";
        if(generalRecordsjTable.getValueAt(selectedRow, 1)!=null)
        receiptNo= generalRecordsjTable.getValueAt(selectedRow, 1).toString();
        
        String receiptName ="";
        if(generalRecordsjTable.getValueAt(selectedRow, 2)!=null)
        receiptName= generalRecordsjTable.getValueAt(selectedRow, 2).toString();
        
        
        String value_ ="";
        if(generalRecordsjTable.getValueAt(selectedRow, 3)!=null)
        value_ = generalRecordsjTable.getValueAt(selectedRow, 3).toString();
        
        String date_ = generalRecordsjTable.getValueAt(selectedRow, 4).toString();
        
        String desc_ = generalRecordsjTable.getValueAt(selectedRow, 5).toString();
       

            try {

             
           
            String[] values = {
            "'" + value_ + "'",
            "'" + receiptName + "'",
            "'" + receiptNo + "'",
            "'" + desc_ + "'",
            "'" + date_ + "'",
   
            "'G'",
            "'" + this.project_desc + "'"};
            
            
            String[] fields1 = {"amount", "receipt_name", "receipt_no", "desc_",  "date_","type_","category"};
       return conn1.getIDByCondiotonArray(tableName, fields1, values,tableKey);
           } catch (SQLException ex) {
               
               return 0;
            }
       
}
    
    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
        
        
        showAdminResults();
       showGeneralResults();
       showAllSumResults();
    }//GEN-LAST:event_formWindowActivated

    private void editSelected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelected1ActionPerformed
        try {
            new addCategoriesOutlays(this,"G",project_desc,getselectedGenRecordID()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOutlaysDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editSelected1ActionPerformed

    private void deleteselected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteselected1ActionPerformed

        try {
            conn.deleteFromTable(tableName, tableKey, ""+getselectedGenRecordID());
            showGeneralResults();
            showAllSumResults();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOutlaysDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteselected1ActionPerformed

    private void generalRecordsjTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalRecordsjTableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_generalRecordsjTableKeyReleased

    private void generalRecordsjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalRecordsjTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_generalRecordsjTableKeyPressed

    private void generalRecordsjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generalRecordsjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_generalRecordsjTableMouseClicked

    private void descTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descTextField1KeyReleased

    private void descTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descTextField1ActionPerformed

    private void reicept_no1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_no1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_no1KeyReleased

    private void reicept_no1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_no1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_no1ActionPerformed

    private void reicept_name1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_name1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_name1KeyReleased

    private void reicept_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_name1ActionPerformed

    private void notice1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notice1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_notice1KeyReleased

    private void notice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notice1ActionPerformed

    private void savein1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savein1ActionPerformed
        try {

            SaveGenRecord();
            showGeneralResults();
            showAllSumResults();

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            descTextField1.setBackground(Color.red);
        }
    }//GEN-LAST:event_savein1ActionPerformed

    private void inValue1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValue1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inValue1KeyReleased

    private void inValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inValue1ActionPerformed

    private void editSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectedActionPerformed
        try {
            new addCategoriesOutlays(this,"A",project_desc,getselectedAdmibRecordID()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOutlaysDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editSelectedActionPerformed

    private void deleteselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteselectedActionPerformed

        try {
            conn.deleteFromTable(tableName, tableKey, ""+getselectedAdmibRecordID());
            showAdminResults();
            showAllSumResults();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOutlaysDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteselectedActionPerformed

    private void adminRecordsjTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminRecordsjTableKeyReleased

    }//GEN-LAST:event_adminRecordsjTableKeyReleased

    private void adminRecordsjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminRecordsjTableKeyPressed

    }//GEN-LAST:event_adminRecordsjTableKeyPressed

    private void adminRecordsjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRecordsjTableMouseClicked

    }//GEN-LAST:event_adminRecordsjTableMouseClicked

    private void descTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descTextFieldKeyReleased

    private void descTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descTextFieldActionPerformed

    private void reicept_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_noKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_noKeyReleased

    private void reicept_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_noActionPerformed

    private void reicept_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reicept_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_nameKeyReleased

    private void reicept_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reicept_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reicept_nameActionPerformed

    private void noticeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noticeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeKeyReleased

    private void noticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noticeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noticeActionPerformed

    private void saveinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinActionPerformed

        try {

            SaveAdminRecord();
            showAdminResults();
            showAllSumResults();

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            descTextField.setBackground(Color.red);
        }
    }//GEN-LAST:event_saveinActionPerformed

    private void inValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inValueKeyReleased

    }//GEN-LAST:event_inValueKeyReleased

    private void inValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inValueActionPerformed

    }//GEN-LAST:event_inValueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String searchtext = searchjTextField1.getText();
        String whereClause = "and category='" + project_desc + "'  "
                + "and (categories_outlays_records.notice like '%" + searchtext + "%'"
                + " or categories_outlays_records.desc_ like '%" + searchtext + "%'"
                + " or categories_outlays_records.receipt_no like '%" + searchtext + "%'"
                + " or categories_outlays_records.receipt_name like '%" + searchtext + "%') ";

        try {
            System.out.println(resultquery+whereClause);
            connSearch1.QueryTable(resultquery+"'G'"+whereClause+orderby, generalRecordsjTable);

        }catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String searchtext = searchjTextField2.getText();
        String whereClause = "and category='" + project_desc + "'  "
                + "and (categories_outlays_records.notice like '%" + searchtext + "%'"
                + " or categories_outlays_records.desc_ like '%" + searchtext + "%'"
                + " or categories_outlays_records.receipt_no like '%" + searchtext + "%'"
                + " or categories_outlays_records.receipt_name like '%" + searchtext + "%') ";

        try {
            System.out.println(resultquery+whereClause);
            connSearch2.QueryTable(resultquery+"'A'"+whereClause+orderby, adminRecordsjTable);

        }catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        Map parameters = new HashMap();
        try {
            parameters.put("category", project_desc);
            Functions.printJasperReport(parameters, "categoryOutlaysReport", true);
        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_addActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        Map parameters = new HashMap();
        try {
            parameters.put("category", project_desc);
            Functions.printJasperReport(parameters, "admincategoryOutlaysReport", true);
        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_add1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private static javax.swing.JTable adminRecordsjTable;
    private javax.swing.JLabel adminSumJlabel;
    private javax.swing.JButton deleteselected;
    private javax.swing.JButton deleteselected1;
    private javax.swing.JTextField descTextField;
    private javax.swing.JTextField descTextField1;
    private javax.swing.JButton editSelected;
    private javax.swing.JButton editSelected1;
    private static javax.swing.JTable generalRecordsjTable;
    private javax.swing.JLabel generalSumjLabel;
    private com.toedter.calendar.JDateChooser inDate;
    private com.toedter.calendar.JDateChooser inDate1;
    private javax.swing.JTextField inValue;
    private javax.swing.JTextField inValue1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField notice;
    private javax.swing.JTextField notice1;
    private javax.swing.JTextField reicept_name;
    private javax.swing.JTextField reicept_name1;
    private javax.swing.JTextField reicept_no;
    private javax.swing.JTextField reicept_no1;
    private javax.swing.JButton savein;
    private javax.swing.JButton savein1;
    private javax.swing.JTextField searchjTextField1;
    private javax.swing.JTextField searchjTextField2;
    // End of variables declaration//GEN-END:variables

  
    private void SaveAdminRecord() throws SQLException {
        
        descTextField.setBackground(Color.white);
        inValue.setBackground(Color.white);
        reicept_name.setBackground(Color.white);
        reicept_no.setBackground(Color.white);
        
        if (!Functions.validation(descTextField.getText(), 1, true)) {
            descTextField.setBackground(Color.red);
            descTextField.grabFocus();
            descTextField.selectAll();
            
            return;
        }
        if (!Functions.validation(inValue.getText(), 2, true)) {
            inValue.setBackground(Color.red);
            inValue.grabFocus();
            inValue.selectAll();
            
            return;
        }
        if (!Functions.validation(reicept_name.getText(), 1, false)) {
            reicept_name.setBackground(Color.red);
            reicept_name.grabFocus();
            reicept_name.selectAll(); 
            
            return;
        }
        if (!Functions.validation(reicept_no.getText(), 1, false)) {
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

         String desc_valuse = descTextField.getText();
        String payment_value = inValue.getText();
        String reic_name = reicept_name.getText();
        String reic_no = reicept_no.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "desc_", "notice", "date_","type_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + desc_valuse + "'",
            "'" + notice.getText() + "'",
            "'" + recorindDate + "'",
             "'A'",
             "'" + this.project_desc + "'"};
        conn.insertIntoTable(tableName, fields, values);
        emptyAdminFields();
            
    }

  private void SaveGenRecord() throws SQLException {
        
        descTextField1.setBackground(Color.white);
        inValue1.setBackground(Color.white);
        reicept_name1.setBackground(Color.white);
        reicept_no1.setBackground(Color.white);
        
        if (!Functions.validation(descTextField1.getText(), 1, true)) {
            descTextField1.setBackground(Color.red);
            descTextField1.grabFocus();
            descTextField1.selectAll();
            
            return;
        }
        if (!Functions.validation(inValue1.getText(), 2, true)) {
            inValue1.setBackground(Color.red);
            inValue1.grabFocus();
            inValue1.selectAll();
            
            return;
        }
        if (!Functions.validation(reicept_name1.getText(), 1, false)) {
            reicept_name1.setBackground(Color.red);
            reicept_name1.grabFocus();
            reicept_name1.selectAll(); 
            
            return;
        }
        if (!Functions.validation(reicept_no1.getText(), 1, false)) {
            reicept_no1.setBackground(Color.red);
            reicept_no1.grabFocus();
            reicept_no1.selectAll(); 
            
            return;
        }
        
        Format formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd");
        String recorindDate = "";
        try {
            recorindDate = formatter.format(inDate1.getCalendar().getTime());
        } catch (NullPointerException te) {
            recorindDate = null;
            inDate1.grabFocus();
            inDate1.setBackground(Color.red);
            
            return;

        }

         String desc_valuse = descTextField1.getText();
        String payment_value = inValue1.getText();
        String reic_name = reicept_name1.getText();
        String reic_no = reicept_no1.getText();
        
       
       //{"amount", "receipt_name", "receipt_no", "desc_", "notice", "date_","type_"};

        String[] values = {
            "'" + payment_value + "'",
            "'" + reic_name + "'",
            "'" + reic_no + "'",
            "'" + desc_valuse + "'",
            "'" + notice1.getText() + "'",
            "'" + recorindDate + "'",
   
            "'G'",
             "'" + this.project_desc + "'"};
        conn.insertIntoTable(tableName, fields, values);
        emptyGenFields();
    }

    
    private void emptyAdminFields() {
        descTextField.setText("");
        inValue.setText("");
        reicept_name.setText("");
        reicept_no.setText("");
        notice.setText("");
        
        
            
    }
      private void emptyGenFields() {
   
        
        descTextField1.setText("");
        inValue1.setText("");
        reicept_name1.setText("");
        reicept_no1.setText("");
        notice1.setText("");
       
    }
  

    private void showAdminResults() {
        try {
       
            conn.QueryTable(resultquery+"'A'"+whereclause+orderby, adminRecordsjTable);
        }catch (NullPointerException ex) {
            
        }
            
    }
     private void showGeneralResults() {
        try {
       
            conn1.QueryTable(resultquery+"'G'"+whereclause+orderby, generalRecordsjTable);
        }catch (NullPointerException ex) {
            
        }
            
    }
      private void showAllSumResults() {
         inConn.newConnection();
        Statement stmt = null;
      generalSumjLabel.setText("");
      adminSumJlabel.setText("");
        String chartQuantityPerReferenceQuery = "SELECT sum(amount) as amount, type_\n" +
                                            "  FROM categories_outlays_records where category='"+this.project_desc+"' group by type_ ";
        try {
            stmt = inConn.conn.createStatement();
            ResultSet res = stmt.executeQuery(chartQuantityPerReferenceQuery);
            while (res.next()) {
if(res.getString("type_").equals("G"))
               generalSumjLabel.setText(res.getString("amount"));
else
               adminSumJlabel.setText(res.getString("amount"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryOutlaysDetails1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
