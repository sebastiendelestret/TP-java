module com.example.tpjavafx{
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tpjavafx to javafx.fxml;
    exports com.example.tpjavafx;
    exports com.example.tpjavafx.controller;
    opens com.example.tpjavafx.controller to javafx.fxml;

}