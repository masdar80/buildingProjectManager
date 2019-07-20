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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
public class other_types extends javax.swing.JFrame {

    Object[][] MyArray = null;
    String[] AttributeNames;
    connect conn;
    Statement stmt;
    JFrame invoke ;
    boolean state ;
    int selectedRow;
    int NumberOfRows, NumberOfColumns;
    private final Image img;
    String[] fields = {"desc_","unit"};
    String tableName = "others_";
    String tableKey = "other_id";
    String query="SELECT "
            + "  unit as " +'"'+ "الواحدة" +'"'
             + " ,desc_ as " +'"'+ "العمل" +'"'
            +" FROM others_  ";

    public other_types(javax.swing.JFrame mainFram)throws SQLException {
         invoke =mainFram;
        invoke.setEnabled(false);
        initComponents();
        img = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader.getSystemResource("icons/1.png"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp_width = (int) screenSize.getWidth();
        int temp_height = (int) screenSize.getHeight();
       // this.setMaximumSize(new Dimension(680, 530));
        this.setSize(440, 440);
        this.setLocation((temp_width - 440) / 2, (temp_height - 440) / 2);
        this.setIconImage(img);
        reference.grabFocus();
        DataBaseTable.setVisible(false);
        conn = new connect();
        conn.newConnection();
        conn.fillComboBox("units", "desc_", unitsComboBox1);
        try {
            // Class.forName("org.postgresql.Driver");

            java.sql.Statement s = conn.conn.createStatement();
            stmt = conn.conn.createStatement();
        } catch (Exception e) {
        }
        conn.QueryTable(query, DataBaseTable);

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DoQuery = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataBaseTable = new javax.swing.JTable();
        msg = new javax.swing.JLabel();
        deleteselected = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        unitsComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("أنواع الاعمال المتفرقة");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        DoQuery.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DoQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Files-New-File-icon 24.png"))); // NOI18N
        DoQuery.setText("اضافة");
        DoQuery.setMargin(new java.awt.Insets(2, 2, 2, 2));
        DoQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoQueryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("اسم العمل :");

        reference.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceActionPerformed(evt);
            }
        });

        DataBaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] { ""}
        ) {
            Class[] types = new Class [] { java.lang.Object.class};
            boolean[]canEdit=new boolean[]{true};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataBaseTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DataBaseTableFocusLost(evt);
            }
        });
        DataBaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataBaseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataBaseTable);

        msg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        msg.setForeground(new java.awt.Color(0, 102, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setToolTipText("");

        deleteselected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteselected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-delete-icon24.png"))); // NOI18N
        deleteselected.setText("حذف");
        deleteselected.setToolTipText("حذف");
        deleteselected.setEnabled(false);
        deleteselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteselectedActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("الواحدة");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteselected))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(DoQuery)))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(unitsComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(unitsComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DoQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteselected))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, reference});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoQueryActionPerformed
      // if (Functions.editPrevilege) {

        reference.setBackground(Color.white);
        
        
        if (!Functions.validation(reference.getText(), 3, true)) {
            reference.setBackground(Color.red);
            reference.grabFocus();
            reference.selectAll();
            showMessage("يجب ادخال اسم العمل",false);
            state = false;
            return;
        }
         

                 
        try {
            if(conn.checkUniqField("desc_",reference.getText() , tableName))
            {
               
                showMessage("يوجد عمل بنفس الإسم",false);
                return;
            }
           
            String[] values = {"'" + reference.getText()+"'",
                "'" + unitsComboBox1.getSelectedItem().toString()+"'"};
            
            
           conn.insertIntoTable(tableName, fields, values);
             
           conn.QueryTable(query, DataBaseTable);

       
        } catch (SQLException ex) {
            Logger.getLogger(other_types.class.getName()).log(Level.SEVERE, null, ex);
        }
                emptyFields();
                showMessage("تمت عملية الادخال بنجاح  ",true);
              
                // JOptionPane.showMessageDialog ( null, "تمت عملية الادخال بنجاح  " );
                //showMessage("تمت عملية الحفظ بنجاح", true);
         //   }
         
    }//GEN-LAST:event_DoQueryActionPerformed
    
    private void DataBaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataBaseTableMouseClicked
 // TODO add your handling code here:
        deleteselected.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_DataBaseTableMouseClicked

    private void referenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_referenceActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
       invoke.setEnabled(true);
           invoke.toFront();
       
    }//GEN-LAST:event_formWindowClosed

    private void DataBaseTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DataBaseTableFocusLost
    // TODO add your handling code here:
    }//GEN-LAST:event_DataBaseTableFocusLost

    private void deleteselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteselectedActionPerformed
         selectedRow = DataBaseTable.getSelectedRow();
          if(selectedRow<0)
        {
            showMessage("يجب تحديد سطر لحذفه",false);
                return;
        }
        String valueIndex = DataBaseTable.getValueAt(selectedRow, 1).toString();
//if(Functions.deletePrevilege){
        String id = "";

        try {

            id = conn.searchIdwithcondition(tableName, tableKey, "desc_", valueIndex);
        } catch (SQLException ex) {
            Logger.getLogger(other_types.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!id.equals("")) {

       

            try {
                conn.deleteFromTable(tableName, tableKey, id);
               // conn.updateTable(tableName, fieldsToUpdate, valuefields, tableKey, id);

            } catch (SQLException ex) {
            showMessage("يوجد معلومات مرتبطة بهذا العمل ولايمكن حذفه", false);
                return;}
        }
        conn.QueryTable(query, DataBaseTable);

        emptyFields();

        showMessage("تمت عملية الحذف  بنجاح  ", true);
        deleteselected.setEnabled(false);
    }//GEN-LAST:event_deleteselectedActionPerformed

    private void emptyFields() {
        reference.setText("");
        
       }

  private void showMessage(String message, boolean state) {
        if (state) {
            msg.setForeground(Color.GREEN);

        } else {
            msg.setForeground(Color.red);
        }
        msg.setText(message);
    }

   /* private void showMessage(String msg, boolean state) {
        if (state) {
            messages.setForeground(Color.GREEN);

        } else {
            messages.setForeground(Color.red);
        }
        messages.setText(msg);
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataBaseTable;
    private javax.swing.JButton DoQuery;
    private javax.swing.JButton deleteselected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField reference;
    private javax.swing.JComboBox unitsComboBox1;
    // End of variables declaration//GEN-END:variables

}
