module com.example.bmiproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bmiproject to javafx.fxml;
    exports com.example.bmiproject;
}