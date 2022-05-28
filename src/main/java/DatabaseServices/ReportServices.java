package DatabaseServices;

import Classes.DatabaseConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class ReportServices extends DatabaseConnection {
    public static void ConnectReport(String reportName) throws JRException, SQLException {
        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Sarah\\IdeaProjects\\demo6\\movie-booking-system\\"+reportName);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,dbConnection);
        JasperViewer.viewReport(jp,true);
        dbConnection.close();
    }
}
