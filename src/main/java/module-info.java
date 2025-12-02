module com.example.evadefromdarkov {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.evadefromdarkov to javafx.fxml;
    exports com.example.evadefromdarkov;
}