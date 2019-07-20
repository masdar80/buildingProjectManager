
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package building_management;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 *
 * @author user
 */
public class Functions {

    static int role_ = 0;
    static String portname="";
    static Element doc;
    
static HashMap portMap = new HashMap();
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isValidText(String str) {

        if (str.equals("")) {
            return true;
        }
        if (str.toLowerCase().contains("or")
                || str.toLowerCase().contains("drop")
                || str.contains("--") || str.contains("'")
                || str.toLowerCase().contains("truncate")
                || str.toLowerCase().contains("select")
                || str.toLowerCase().contains("insert")
                || str.toLowerCase().contains("update")) {
            return false;
        }
        return true;
    }

 

    public static String ConvertStringToUTF(String source) {
        char[] Arabic = {'ئ', 'ء', 'ى', 'ة', 'آ', 'إ', 'أ', 'ا', 'ب', 'ت', 'ث', 'ج', 'ح', 'خ', 'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق', 'ك', 'ل', 'م', 'ن', 'ه', 'و', 'ي', 'ؤ'};
        char[] shapeChar = {'Æ', 'Á', 'ì', 'É', 'Â', 'Å', 'Ã', 'Ç', 'È', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó', 'Ô', 'Õ', 'Ö', 'Ø', 'Ù', 'Ú', 'Û', 'Ý', 'Þ', 'ß', 'á', 'ã', 'ä', 'å', 'æ', 'í', 'Ä'};

        String result = "";
        char[] charArray = source.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < shapeChar.length; j++) {
                if (charArray[i] == shapeChar[j]) {
                    charArray[i] = Arabic[j];
                }
            }

        }
        result = new String(charArray);
        return result;
    }

  public static JPanel createPieChartPanel(String title, DefaultPieDataset pieDataset,int width,int height){
   
    //JFreeChart chart = ChartFactory.createPieChart3D(title, pieDataset, true, true, true);
    JFreeChart chart = ChartFactory.createRingChart(title, pieDataset, true, true, true);
    ChartPanel chartPanel=new ChartPanel(chart);
    chartPanel.setMaximumDrawWidth(4000);  
     chartPanel.setFillZoomRectangle(true);
     chartPanel.setMouseZoomable(true);
     
// The second step is to set the width of a chart panel.
    
chartPanel.setPreferredSize(new Dimension(width,height));
    
    return chartPanel;
}
  
   public static JPanel createBarChartPanel(String title,String x_lable,String y_Lable, DefaultCategoryDataset  barDataset,int width,int height){
   
    JFreeChart chart = ChartFactory.createBarChart(title,x_lable,y_Lable, barDataset,PlotOrientation.HORIZONTAL,true,true,true);
   
           
           
           
    ChartPanel chartPanel=new ChartPanel(chart);
    chartPanel.setMaximumDrawWidth(4000);  
   // chartPanel.set
    chartPanel.setFillZoomRectangle(true);
     chartPanel.setMouseZoomable(true);
      
// The second step is to set the width of a chart panel.
    
chartPanel.setPreferredSize(new Dimension(width,height));
    
    return chartPanel;
}
    
   
    public static JPanel createBarVerticalChartPanel(String title,String x_lable,String y_Lable, DefaultCategoryDataset  barDataset,int width,int height){
   
    JFreeChart chart = ChartFactory.createBarChart(title,x_lable,y_Lable, barDataset,PlotOrientation.VERTICAL,true,true,true);
   
    ChartPanel chartPanel=new ChartPanel(chart);
    chartPanel.setMaximumDrawWidth(4000);  
   // chartPanel.set
    chartPanel.setFillZoomRectangle(true);
     chartPanel.setMouseZoomable(true);
      
// The second step is to set the width of a chart panel.
    
chartPanel.setPreferredSize(new Dimension(width,height));
    
    return chartPanel;
}
    
    public static boolean validation(String textFieldContent, int type, boolean emptyCheck) {
        boolean result = true;

        // JTextField fieldToCheck = (JTextField) field;
        // String textFieldContent = fieldToCheck.getText();
        if (textFieldContent.equals("")) {
                  result = !emptyCheck;
            
        } else {
            switch (type) {
                case 1:// text
                    if (!isValidText(textFieldContent)) {

                        result = false;
                    }
                    break;
                case 2: // number
                    if (!isNumeric(textFieldContent)) {

                        result = false;
                    }
                    break;
                case 3: // mixed
                    if (!isValidText(textFieldContent)) {

                        result = false;
                    }
                    break;
                default:
                    result = true;
                    break;
            }
        }

        return result;
    }

    public static void showImage(final Image img) {
        JFrame frame = new JFrame("Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new JPanel() {
            public void paint(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        });
        frame.show();
    }

    public static void creatDIR(String name) throws IOException {
        String path = new File(".").getCanonicalPath();
        File theDir = new File(path + "\\" + name);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + path + "\\" + name);
            boolean result = theDir.mkdir();

            if (result) {
                System.out.println(name + " DIR created");
            }
        }
    }

    public static void emtyfolder(String folderName) throws IOException {
        String path = new File(".").getCanonicalPath();
        // final Image img = ImageIO.read(new File(path + "\\tempimg\\" + img_id + ".jpg"));
        File file = new File(path + "\\" + folderName);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public static void copyFile(File sourceFile, File destFile)
            throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            // previous code: destination.transferFrom(source, 0, source.size());
            // to avoid infinite loops, should be:
            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, count, size
                    - count)) < size)
                ;
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

   

//    public static String[] removeElements(String[][] input, int deleteMe,int length) {
//    List result = new LinkedList();
//
//   for(int i=0;i<length;i++)
//   {
//       if(deleteMe!=deleteMe)
//            result.add(item);
//   }
//        
//
//    return result.toArray(input);
//}
    public static Calendar getCalendarFromString(String stringDate) {
        Calendar cal;
        try {
            DateFormat formatter;
            java.util.Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (java.util.Date) formatter.parse(stringDate);
            cal = Calendar.getInstance();
            cal.setTime(date);

        } catch (ParseException ex) {
            cal = null;
        }
        return cal;
    }

   
    public static Date StringToDate(String str) {

        String str_date = str;
        DateFormat formatter;
        Date date = null;
        try {

            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(str_date);
            //  inspection_datejDateChooser.setDate(date);

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        return date;
    }

   

    
    
   
    public static String selecDirectoryFolder() throws IOException
    {
        JFileChooser chooser;
        String choosertitle = "Select directory to save in";
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(new File(".").getCanonicalPath() + "\\templyr\\"));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();

        }
        return "";
    }
    public static Object[][] copyLargArrayToSmallArray(Object[][] small,Object[][] larg,int rowCount)
    {

        for (int i = 0; i < rowCount ; i++) {
            small[i] = larg[i].clone();
        }

        return small;
    }
    


   
      public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewport = (JViewport)table.getParent();

        // This rectangle is relative to the table where the
        // northwest corner of cell (0,0) is always (0,0).
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);

        // The location of the viewport relative to the table
        Point pt = viewport.getViewPosition();

        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x-pt.x, rect.y);

        table.scrollRectToVisible(rect);

        // Scroll the area into view
        //viewport.scrollRectToVisible(rect);
    }
  
      
      
 
  
    public static String readXMLConnection(String xml) {
      
        try {
            Document dom;
            // Make an  instance of the DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

             doc = dom.getDocumentElement();

          

            return getTextValue(portname, doc, "portname");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
  private static String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
        
      
   public static void printJasperReport(Map parameters,String reportName,boolean view) {
        connect jasperConn;
        jasperConn = new connect();
        jasperConn.newConnection();
        String path;

        try {
            path = new File(".").getCanonicalPath();
            File reportFile = new File(path + "/reports/"+reportName+".jrxml");//your report_name.jasper file

            String jrxmlFile = reportFile.getPath();

            

            InputStream input = new FileInputStream(new File(jrxmlFile));

            //Generating the report
            JasperReport jasperReport = JasperCompileManager.compileReport(input);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jasperConn.getConn());
            
            if(view)
                JasperViewer.viewReport(jasperPrint, false);
            else
              JasperPrintManager.printReport(jasperPrint, false);
//JasperViewer.viewReport(jasperPrint, false);
            //Exporting the report as a PDF
            //JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream(pdf));

        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    

    } 
     
       public static void saveToXML(String xml,String portname) throws IOException {
    Document dom;
   
    Element e = null;
       
    // instance of a DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {
        // use factory to get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        // create instance of DOM
        dom = db.newDocument();

        // create the root element
        Element rootEle = dom.createElement("conn");

        // create data elements and place them under root
        e = dom.createElement("portname");
        e.appendChild(dom.createTextNode(portname));
        rootEle.appendChild(e);

      
        dom.appendChild(rootEle);

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "conn.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(dom), 
           new StreamResult(new FileOutputStream(xml)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    } catch (ParserConfigurationException pce) {
        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
    }
} 
       public static void backupDB(String filePath)
       {
        try {
            if(filePath.equals(""))
            {
                filePath="d:\\backup_building\\";
            }
            Date currentDate = new Date();
            String backupDate;
            Format formatter;
            
              formatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
           
            try {
                backupDate = formatter.format(currentDate.getTime());
            } catch (NullPointerException te) {
                backupDate = null;

            }
            
            String command = "pg\\pg_dump  -i -h "+connect.serverip+" -p "+connect.port+" -U postgres -F c -b -v -f \"" + filePath+ "\\db_backup_"+backupDate+".backup\" mizan ";
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
      
     public static void setEnabledStatusJpanleComonents(JPanel panel,boolean status)
     {
         for(int i=0;i<panel.getComponentCount();i++)
         {
             panel.getComponent(i).setEnabled(status);
         }
     }
}
