/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package building_management;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
//import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class connect {

    Connection conn = null;
    //        Connection con = null;
    private PreparedStatement preparedStatement;
    int NumberOfRows, NumberOfColumns;
    Statement stmt = null;
    ResultSet srs = null;
    String[] AttributeNames;
    String state;
    Object[][] MyArray = null;

    // static int proctressID;
    PreparedStatement pst = null;
    FileInputStream fis = null;

//    static String userName = "postgres";
//    static String password = "qwe123!@#";
//
//    static String dbname = "mizan";
//
//     static String serverip = "localhost";
    static String port = "5432";
    static String userName, password, dbname, serverip,projectname;

    static String role_ = "";
    
    static String dollar_factor_value="";
    String allfiledswithtype;
    GUI window = null;
    signin loginwindow = null;
    int connectionTryCounter = 0;

    public void newConnection() {

        try {
            String path = new File(".").getCanonicalPath();

            readXMLConnection(path + "\\xml\\paradb.xml");
            //  IMPORTANT***********************هام جدا
            //  we must add   a new entry to pg_hba.conf
            //  host  all all 192.168.1.0/24 trust
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://" + serverip + ":" + port + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8", userName,
                    password);
        } catch (Exception e) {
            connectionTryCounter++;
            if (connectionTryCounter < 10) {
                newConnection();
            } else {
                JOptionPane.showMessageDialog(null, "فشل بالاتصال بعد عدة محاولات");
System.err.println(e + "  Cannot connect to database server");               
// new connection_settings(null).setVisible(true);
            }
            //loginwindow.msg.setText("غير متصل بقاعدة البيانات");
            
        }

    }
public static void exportDb2() throws IOException, InterruptedException {
    Runtime rt = Runtime.getRuntime();
    Process p;
    ProcessBuilder pb;
    rt = Runtime.getRuntime();
    java.util.Date now= new java.util.Date();
    java.util.Date currentDate = new java.util.Date();
            String backupDate;
            Format formatter;
                  formatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
           
            try {
                backupDate = formatter.format(currentDate.getTime());
            } catch (NullPointerException te) {
                backupDate = null;

            }
    String home=System.getProperty("user.home");
    pb = new ProcessBuilder(
            "C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe",
            "--host", serverip,
            "--port", port,
            "--username", userName,
            "--no-password",
            "--format", "custom",
            "--blobs",
            "--verbose", "--file", home+"\\Dropbox\\"+projectname+"\\backup\\sawan_backup_"+backupDate+".backup", dbname);
    try {
        final Map<String, String> env = pb.environment();
        env.put("PGPASSWORD", password);
        p = pb.start();
        final BufferedReader r = new BufferedReader(
                new InputStreamReader(p.getErrorStream()));
        String line = r.readLine();
        while (line != null) {
            System.err.println(line);
            line = r.readLine();
        }
        r.close();
        p.waitFor();
        System.out.println(p.exitValue());

    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
    }
}
    public int searchId(String tableName, String sourceId, String target, String ID) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        int id;
        stmt = conn.createStatement();

        String query = "select " + sourceId + " from " + tableName + " where " + target + "='" + ID + "'";
        ResultSet res = stmt.executeQuery(query);

        if (res.next()) {

            id = res.getInt(sourceId);

        } else {
            id = 0;
        }

        return id;

    }

    public void getCurrencyFactorValue() throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
       
        stmt = conn.createStatement();

        String query = "select value_ from curreny_factor";
        ResultSet res = stmt.executeQuery(query);

        if (res.next()) {
            dollar_factor_value =""+ res.getDouble(1);
        } 

    }

      public Boolean isCategorInDollar(String cat_id) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
       
        stmt = conn.createStatement();

        String query = "select dollar_factor from references_categories where reference_id='"+cat_id+"'";
        ResultSet res = stmt.executeQuery(query);

        if (res.next()) {
            if( res.getString(1).equals("نعم"))
            return true;
        } 
return false;
    }
    public void creatView(String Viewname, String query) {
        try {
//             String dropview="drop view  if exists "+Viewname;
//              stmt = conn.createStatement();
//           
//            preparedStatement = conn.prepareStatement(dropview);
//            preparedStatement.executeUpdate();
            String viewQuery = " CREATE OR REPLACE VIEW " + Viewname + " AS (" + query + ")";
            //  String viewQuery = " CREATE VIEW " +"'"+Viewname+"'"+ " AS (" + query +")" ;
            stmt = conn.createStatement();
            System.out.println(viewQuery);
            preparedStatement = conn.prepareStatement(viewQuery);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getArrayofPointfromPointsString(String points) {
        String[] pointsArray = null;
        if (points.contains("(")) {
            points = points.substring(points.lastIndexOf("(") + 1, points.lastIndexOf(")") - 1);
        }
        pointsArray = points.split(",");
        return pointsArray;
    }

    public void excuteQuery(String query) throws SQLException {

        java.sql.Statement s = conn.createStatement();
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.executeUpdate();

    }
    //creatTable(String tableName,String[] fields,String []fieldtype,int fieldcount)

    public void creatTable(String tableName, String[] fields, String[] fieldtype, int fieldcount) {
        try {
            String filedType[] = null;
            allfiledswithtype = "";
            stmt = conn.createStatement();
            String sql;
            for (int i = 1; i < fieldcount; i++) {
                allfiledswithtype += fields[i];
                allfiledswithtype += "  ";
                allfiledswithtype += fieldtype[i];
                if (i + 1 < fieldcount) {
                    allfiledswithtype += ",";

                }
            }

            sql = "CREATE TABLE IF NOT EXISTS " + tableName + "( FID SERIAL NOT NULL PRIMARY KEY ," + allfiledswithtype + " )";
            System.out.println(sql);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();

//             preparedStatement = conn.prepareStatement(sql);
//            stmt.executeUpdate(sql);
//            System.out.println("Table creation table successfully!");
//            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int insertIntoTable(String tableName, String[] fields, String[] values) throws SQLException {
        String allFields = "";
        String allValues = "";
        int returnedid = 0;
        //  stmt = conn.createStatement();
        //java.sql.Statement s = conn.createStatement();
        for (int i = 0; i < fields.length; i++) {

            allFields += fields[i];

            allValues += values[i];

            if (i + 1 < fields.length) {
                allFields += ",";
                allValues += ",";
            }
        }

        String query = "insert into  " + tableName + " (" + allFields + ") "
                + "VALUES (" + allValues + ")";

        System.out.println(query + ";");
//        preparedStatement = conn.prepareStatement(query);
//        preparedStatement.executeUpdate();
        if (stmt == null) {
            stmt = conn.createStatement();
        }
        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            // Retrieve the auto generated key(s).
            returnedid = rs.getInt(1);
        }
        return returnedid;

    }

    public void updateTable(String tableName, String[] fields, String[] values, String key, String keyIndex) throws SQLException {
        String statment = "";

        for (int i = 0; i < fields.length; i++) {

            statment += fields[i] + "=" + values[i];

            if (i + 1 < fields.length) {
                statment += ",";
            }
        }
        String query = "Update  " + tableName + " SET " + statment + " where " + key + "=" + keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void updateTableWithInCondition(String tableName, String[] fields, String[] values, String key, String keyIndex) throws SQLException {
        String statment = "";

        for (int i = 0; i < fields.length; i++) {

            statment += fields[i] + "='" + values[i] + "'";

            if (i + 1 < fields.length) {
                statment += ",";
            }
        }
        String query = "Update  " + tableName + " SET " + statment + " where " + key + " in " + keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void setdeletedFromTable(String tableName, String key, String keyIndex) throws SQLException {
        //String query = "delete  from " + tableName + " where "+key+"="+keyIndex;
        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        String query = "update  " + tableName + " set `deleted`= '1' WHERE " + key + "=" + keyIndex;
        // System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    // search for exist id
    public int searchId(String tableName, String sourceId, String ID) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        int id;
        stmt = conn.createStatement();

        String query = "select " + sourceId + " from " + tableName + " where " + sourceId + "='" + ID + "'";
        ResultSet res = stmt.executeQuery(query);

        if (res.next()) {

            id = res.getInt(sourceId);

        } else {
            id = 0;
        }

        return id;

    }

    public void deleteFromTable(String tableName, String key, String keyIndex) throws SQLException {
        String query = "delete  from " + tableName + " where " + key + "=" + keyIndex;

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        //     System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void deleteFromTable2options(String tableName, String key1, String keyIndex1, String key2, String keyIndex2) throws SQLException {
        String query = "delete  from " + tableName + " where " + key1 + "=" + keyIndex1 + " and " + key2 + "=" + keyIndex2;

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        // System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void deleteFromTable3options(String tableName, String PK, String key1, String keyIndex1, String key2, String keyIndex2, String key3, String keyIndex3) throws SQLException {

        String query = " DELETE FROM " + tableName + " a   where a." + PK + "=";

        query += "(select  min(b." + PK + ") from " + tableName + " b where "
                + " b." + key1 + "=" + keyIndex1
                + " and b." + key2 + "=" + keyIndex2
                + " and b." + key3 + "=" + keyIndex3 + ") ";

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void deleteFromTable4options(String tableName, String PK, String key1, String keyIndex1, String key2, String keyIndex2, String key3, String keyIndex3, String key4, String keyIndex4) throws SQLException {

        String query = " DELETE FROM " + tableName + " a   where a." + PK + "=";

        query += "(select  min(b." + PK + ") from " + tableName + " b where "
                + " b." + key1 + "=" + keyIndex1
                + " and b." + key2 + "=" + keyIndex2
                + " and b." + key3 + "=" + keyIndex3
                + " and b." + key4 + "=" + keyIndex4
                + ") ";

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void deleteFromTable5options(String tableName, String PK, String key1, String keyIndex1, String key2, String keyIndex2, String key3, String keyIndex3, String key4, String keyIndex4, String key5, String keyIndex5) throws SQLException {

        String query = " DELETE FROM " + tableName + " a   where a." + PK + "=";

        query += "(select  min(b." + PK + ") from " + tableName + " b where "
                + " b." + key1 + "=" + keyIndex1
                + " and b." + key2 + "=" + keyIndex2
                + " and b." + key3 + "=" + keyIndex3
                + " and b." + key4 + "=" + keyIndex4
                + " and b." + key5 + "=" + keyIndex5
                + ") ";

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void deleteFromTable6options(String tableName, String PK, String key1, String keyIndex1, String key2, String keyIndex2, String key3, String keyIndex3, String key4, String keyIndex4, String key5, String keyIndex5, String key6, String keyIndex6) throws SQLException {

        String query = " DELETE FROM " + tableName + " a   where a." + PK + "=";

        query += "(select  min(b." + PK + ") from " + tableName + " b where "
                + " b." + key1 + "=" + keyIndex1
                + " and b." + key2 + "=" + keyIndex2
                + " and b." + key3 + "=" + keyIndex3
                + " and b." + key4 + "=" + keyIndex4
                + " and b." + key5 + "=" + keyIndex5
                + " and b." + key6 + "=" + keyIndex6
                + ") ";

        // UPDATE tablename SET `deleted` = '1' WHERE `field` =selectedindex;
        //String query = "update  " + tableName + " set `deleted`= '1' WHERE "+key+"="+keyIndex;
        System.out.println(query);
        preparedStatement = conn.prepareStatement(query);
        System.out.println(query);
        preparedStatement.executeUpdate();
    }

    public void fillComboBox(String tableName, String fieldName, JComboBox myCombo) throws SQLException {

        myCombo.removeAllItems();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();
        String query = "select " + fieldName + " from " + tableName + "  order by " + fieldName;
        ResultSet res = stmt.executeQuery(query);
//myCombo.addItem("");
        int i = 0;
        while (res.next()) {

            myCombo.addItem(res.getString(fieldName));

            i++;
        }

    }

    public void fillComboBoxWithCondition(String tableName, String fieldName, String conditionFieldName, JComboBox myCombo, int fieldConditionValue) throws SQLException {
        // stmt = null;
        //  stmt = conn.createStatement();
        myCombo.removeAllItems();
        String Queryadmin = "select " + fieldName + " from " + tableName + " where " + conditionFieldName + " = " + fieldConditionValue + "";
        //String keyadmin = " select administrative_unit_name from adninistrative_unit where provinces_id = "+ ID+"" ;

        stmt = conn.createStatement();
        srs = stmt.executeQuery(Queryadmin);
        int i = 0;
        while (srs.next()) {

            myCombo.addItem(srs.getString(fieldName));
            i++;
        }

    }

    public void fillListwithcondition(String tableName, String fieldName, String PKfield, String PKvalue, JList myList) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        /*to get count*/
        String querycountr = "select count(*) as counter from " + tableName + " where " + PKfield + " = '" + PKvalue + "'";
        ResultSet rescounter = stmt.executeQuery(querycountr);
        rescounter.next();
        int counter = rescounter.getInt("counter");
        /**
         * ****************
         */

        String query = "select " + fieldName + " from " + tableName + " where " + PKfield + " = '" + PKvalue + "'";
        ResultSet res = stmt.executeQuery(query);
        Object[] dataArray = null;
        dataArray = new Object[counter];
        int i = 0;
        while (res.next()) {

            dataArray[i] = res.getString(fieldName);

            i++;
        }
        myList.setListData(dataArray);

    }

    public void fillList(String tableName, String fieldName, JList myList) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        /*to get count*/
        String querycountr = "select count(*) as counter from " + tableName;
        ResultSet rescounter = stmt.executeQuery(querycountr);
        rescounter.next();
        int counter = rescounter.getInt("counter");
        /**
         * ****************
         */

        String query = "select " + fieldName + " from " + tableName;
        ResultSet res = stmt.executeQuery(query);
        Object[] dataArray = null;
        dataArray = new Object[counter];
        int i = 0;
        while (res.next()) {

            dataArray[i] = res.getString(fieldName);

            i++;
        }
        myList.setListData(dataArray);

    }

    public void fillListwithCheckboxes(String tableName, String fieldName, JList myList) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        myList.setCellRenderer(new CheckListRendererItm());

        myList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        stmt = conn.createStatement();

        /*to get count*/
        String querycountr = "select count(*) as counter from " + tableName;
        ResultSet rescounter = stmt.executeQuery(querycountr);
        rescounter.next();
        int counter = rescounter.getInt("counter");
        /**
         * ****************
         */

        String query = "select " + fieldName + " from " + tableName;
        ResultSet res = stmt.executeQuery(query);

        final CheckBoxItem[] CheckBoxes = new CheckBoxItem[counter];
        int i = 0;
        while (res.next()) {

            CheckBoxes[i] = new CheckBoxItem(res.getString(fieldName));
            i++;
        }

        myList.setModel(new javax.swing.AbstractListModel() {
            CheckBoxItem[] CheckBoxes1 = CheckBoxes;

            public int getSize() {
                return CheckBoxes1.length;
            }

            public Object getElementAt(int i) {
                return CheckBoxes1[i];
            }
        });

    }

    public String getDescByID(String tableName, int id, String id_field, String description_field) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "select " + description_field + " from " + tableName + " where " + id_field + "='" + id + "'";
        ResultSet res = stmt.executeQuery(query);
        String desc = "";
        if (res.next()) {
            desc = res.getString(description_field);
        }
        return desc;
    }

    public int getIDByDesc(String tableName, String desc, String sourceField, String destinationField) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "select " + destinationField + " from " + tableName + " where " + sourceField + "='" + desc + "' ";
        ResultSet res = stmt.executeQuery(query);
        int id = 0;
        if (res.next()) {
            id = res.getInt(destinationField);

        }
        return id;
    }

    public int getIDByCondiotonArray(String tableName, String[] fields, String[] values, String destinationField) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")

        String statment = "";

        for (int i = 0; i < fields.length; i++) {

            statment += fields[i] + "=" + values[i] + "";

            if (i + 1 < fields.length) {
                statment += " and ";
            }
        }

        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "select " + destinationField + " from " + tableName + " where " + statment;
        ResultSet res = stmt.executeQuery(query);
        int id = 0;
        if (res.next()) {
            id = res.getInt(destinationField);

        }
        return id;
    }

    public void startTransaction() throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "START TRANSACTION";
        stmt.executeQuery(query);

    }

    public void rollBack() throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "ROLLBACK";
        stmt.executeQuery(query);

    }

    public void commit() throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        stmt = conn.createStatement();

        String query = "COMMIT";
        stmt.executeQuery(query);

    }

    public String validate(String text, int type, String TextLable, boolean emptyCheck) {
        String msg = "";
        /*
         * type =1 number type =2 Text type =3 Mixed type =4 date type =5 mail
         */

        if (emptyCheck) {
            if (text.equals("")) {
                msg = " อแ " + TextLable + " วั ";
                return msg;
            }
        }

        switch (type) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        return msg;
    }

    public String searchIdwithcondition(String tableName, String outId, String sourceId, String ID) throws SQLException {

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Statement stmt = null;
        String id;
        stmt = conn.createStatement();

        String query = "select " + outId + " from " + tableName + " where " + sourceId + "='" + ID + "'";
        ResultSet res = stmt.executeQuery(query);

        if (res.next()) {

            id = res.getString(outId);

        } else {
            id = "";
        }

        return id;

    }

    public void QueryTable(String query, JTable Table) {
        try {
            // java.sql.Statement s = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            ResultSetMetaData RSMD = res.getMetaData();
            NumberOfColumns = RSMD.getColumnCount();
            AttributeNames = new String[NumberOfColumns];
            for (int i = 0; i < NumberOfColumns; i++) {
                AttributeNames[i] = RSMD.getColumnLabel(i + 1);
            }
            MyArray = new Object[10000][NumberOfColumns];

            int R = 0;
            while (res.next()) {
                for (int C = 1; C <= NumberOfColumns; C++) {
                    MyArray[R][C - 1] = res.getObject(C);
                }
                R++;
            }
            res.close();
            NumberOfRows = R;
            Object[][] TempArray = MyArray;
            MyArray = new Object[NumberOfRows][NumberOfColumns];
            for (R = 0; R < NumberOfRows; R++) {
                System.arraycopy(TempArray[R], 0, MyArray[R], 0, NumberOfColumns);
            }
            Table.setModel(new MyTableModel());
            Table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
            Table.getTableHeader().setBackground(Color.darkGray);
            Table.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            Table.setDefaultRenderer(String.class, centerRenderer);
            Table.setDefaultRenderer(Integer.class, centerRenderer);
            Table.setDefaultRenderer(Date.class, centerRenderer);
            Table.setDefaultRenderer(Double.class, centerRenderer);
            Table.setDefaultRenderer(Number.class, centerRenderer);

            Table.setVisible(true);
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            if (defaults.get("Table.alternateRowColor") == null) {
                defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
            }

        } catch (Exception e) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void QueryGroupedTable(String query, JTable Table) {
        try {
            // java.sql.Statement s = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            ResultSetMetaData RSMD = res.getMetaData();
            NumberOfColumns = RSMD.getColumnCount();
            AttributeNames = new String[NumberOfColumns];
            for (int i = 0; i < NumberOfColumns; i++) {
                AttributeNames[i] = RSMD.getColumnLabel(i + 1);
            }
            MyArray = new Object[10000][NumberOfColumns];

            int R = 0;
            while (res.next()) {
                for (int C = 1; C <= NumberOfColumns; C++) {
                    MyArray[R][C - 1] = res.getObject(C);
                }
                R++;
            }
            res.close();
            NumberOfRows = R;
            Object[][] TempArray = MyArray;
            MyArray = new Object[NumberOfRows][NumberOfColumns];
            for (R = 0; R < NumberOfRows; R++) {
                System.arraycopy(TempArray[R], 0, MyArray[R], 0, NumberOfColumns);
            }
            Table.setModel(new MyGruopedTableModel());
            Table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
            Table.getTableHeader().setBackground(Color.darkGray);
            Table.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            Table.setDefaultRenderer(String.class, centerRenderer);
            Table.setDefaultRenderer(Integer.class, centerRenderer);
            Table.setDefaultRenderer(Date.class, centerRenderer);
            Table.setDefaultRenderer(Double.class, centerRenderer);

            Table.setVisible(true);
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            if (defaults.get("Table.alternateRowColor") == null) {
                defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
            }

        } catch (Exception e) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    public boolean readXMLConnection(String xml) {

        try {
            Document dom;
            // Make an  instance of the DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();
            projectname=getTextValue(projectname, doc, "projectname");
            
            userName = getTextValue(userName, doc, "username");

            //password = getTextValue(password, doc, "password");  to protect it
            password="qwe123!@#";

            dbname = getTextValue(dbname, doc, "dbname");

            serverip = getTextValue(serverip, doc, "serverip");

            port = getTextValue(port, doc, "port");

            return true;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkUser(String username, String password) {
        boolean result = false;
        try {
            stmt = conn.createStatement();
            String query = "SELECT  *  FROM  users where username='" + username + "' and password_='" + password + "'";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {

                // role= 1  admin full
                // role= 2  user limited
                // role= 3  view only
                role_ = res.getString("role_");
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Connection getConn() {
        return conn;
    }

    public boolean checkUniqField(String field, String value, String Table) {
        boolean result = false;
        try {
            stmt = conn.createStatement();
            String query = "SELECT  *  FROM  " + Table + " where " + field + "='" + value + "'";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean checkForeignID(String field, String value, String Table) {
        boolean result = false;
        try {
            stmt = conn.createStatement();
            String query = "SELECT  *  FROM  " + Table + " where " + field + "='" + value + "'";
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    class MyTableModel extends AbstractTableModel {
        //You can choose any long value for serialVersionUID.
        //I chose 317 because this is CSCI 317.

        private static final long serialVersionUID = 317L;

        public int getColumnCount() {
            return (NumberOfColumns);
        }

        public int getRowCount() {
            return (NumberOfRows);
        }

        @Override
        public String getColumnName(int i) {
            return (AttributeNames[i]);
        }

        public java.lang.Object getValueAt(int row, int column) {

            return (MyArray[row][column]);
        }

        @Override
        public Class getColumnClass(int c) {
            try {
                if (getValueAt(0, c).getClass() == null) {
                    return String.class.getClass();
                }
                return getValueAt(0, c).getClass();
            } catch (NullPointerException e) {
                return String.class.getClass();
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
           /* if (col < 1) {
             return false;
             } else {
             return true;
             }*/
            return false;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            MyArray[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }

    class MyGruopedTableModel extends AbstractTableModel {
        //You can choose any long value for serialVersionUID.
        //I chose 317 because this is CSCI 317.

        boolean flag = true;
        int counter = 0;
        private static final long serialVersionUID = 317L;

        public int getColumnCount() {
            return (NumberOfColumns);
        }

        public int getRowCount() {
            return (NumberOfRows);
        }

        @Override
        public String getColumnName(int i) {
            return (AttributeNames[i]);
        }

        public java.lang.Object getValueAt(int row, int column) {

            if (row > 0) {
                if (column == 0) {

                    if (MyArray[row][column].toString().equals(MyArray[row - 1][column].toString())) {
                        flag = true;

                        return "";

                    } else {

                        flag = false;
                    }
                }
                if (flag && (column == 1 || column == 2 || column == 3)) {
                    if (MyArray[row][column].toString().equals(MyArray[row - 1][column].toString())) {
                        return "";
                    }
                }

            }

            return (MyArray[row][column]);
        }

        @Override
        public Class getColumnClass(int c) {
            try {
                if (getValueAt(0, c).getClass() == null) {
                    return String.class.getClass();
                }
                return getValueAt(0, c).getClass();
            } catch (NullPointerException e) {
                return String.class.getClass();
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
           /* if (col < 1) {
             return false;
             } else {
             return true;
             }*/
            return false;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            MyArray[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }

}

class CheckBoxItem {

    private String label;

    private boolean isSelected = false;

    public CheckBoxItem(String label) {

        this.label = label;

    }

    public boolean isSelected() {

        return isSelected;

    }

    public void setSelected(boolean isSelected) {

        this.isSelected = isSelected;

    }

    public String toString() {

        return label;

    }

}

// Handles rendering cells in the list using a check box
class CheckListRendererItm extends JCheckBox
        implements ListCellRenderer {

    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean hasFocus) {

        setEnabled(list.isEnabled());

        setSelected(((CheckBoxItem) value).isSelected());

        setFont(list.getFont());

        setBackground(list.getBackground());

        setForeground(list.getForeground());

        setText(value.toString());

        return this;

    }

}
