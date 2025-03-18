module com.lechugasdelcaos.lechugasdelcaos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.lechugasdelcaos.lechugasdelcaos to javafx.fxml;
    exports com.lechugasdelcaos.lechugasdelcaos;
    exports com.lechugasdelcaos.lechugasdelcaos.controller;
    opens com.lechugasdelcaos.lechugasdelcaos.controller to javafx.fxml;
}