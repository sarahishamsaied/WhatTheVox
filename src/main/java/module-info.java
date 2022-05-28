module com.example.moviebookingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javafx.graphics;
    requires jasperreports;
//    requires jasperreports.javaflow;
//    requires jasperreports.javaflow;
//    requires firebase.client.android;
    opens com.example.moviebookingsystem to javafx.fxml;
    exports com.example.moviebookingsystem;
    exports Classes;
}