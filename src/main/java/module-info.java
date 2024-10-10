module org.example.b {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.b to javafx.fxml;
    exports org.example.b;
}