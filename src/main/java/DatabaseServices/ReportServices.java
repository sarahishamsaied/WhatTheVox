package DatabaseServices;

import Classes.DatabaseConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import java.sql.SQLException;

public class ReportServices extends DatabaseConnection {
    public static void ConnectReport(String reportName) throws JRException, SQLException {
        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Sarah\\IdeaProjects\\demo6\\movie-booking-system\\"+reportName);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,dbConnection);

        JasperViewer.viewReport(jp,true);
//        dbConnection.close();
    }
    public static void printInvoice(String invoicePath,String ID) throws JRException{
        JasperDesign jd = JRXmlLoader.load(invoicePath);
        JRDesignQuery newQuery = new JRDesignQuery();
        String statement = "select * from purchaseHistory where purchaseId = '"+ID+"'";
        newQuery.setText(statement);
        jd.setQuery(newQuery);
        JasperReport jr =  JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,dbConnection);
        JasperViewer.viewReport(jp,false);
    }
}
