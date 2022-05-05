module com.example.moviebookingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.moviebookingsystem to javafx.fxml;
    exports com.example.moviebookingsystem;
}