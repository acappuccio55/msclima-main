module com.microservice.agustin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.microservice.agustin to javafx.fxml;
    exports com.microservice.agustin;
}