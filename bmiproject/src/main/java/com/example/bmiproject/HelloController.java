package com.example.bmiproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label statusText;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private double result;
    @FXML
    private String type = "";
    @FXML
    private RadioButton rButton1, rButton2;

    @FXML
    public void getType(ActionEvent event) {
        ToggleGroup type1 = new ToggleGroup();
        rButton1.setToggleGroup(type1);
        rButton2.setToggleGroup(type1);
        if (rButton1.isSelected()) {
            type = "English Unit";
        } else if (rButton2.isSelected()) {
            type = "Metric Unit";
        }
    }

    @FXML
    protected void CalculateBMI() {
        String val = weight.getText();
        String val1 = height.getText();
        double w = Double.parseDouble(val);
        double h = Double.parseDouble(val1);
        if (type.equals("English Unit")) {
            result = 703 * w / (h * h);
        } else if (type.equals("Metric Unit")) {
            result = w / (h * h);
        }
        if (result < 18.5) {
            statusText.setText("Underweight");
        } else if (result >= 18.5 && result <= 24.9) {
            statusText.setText("Normal");
        } else if (result >= 25 && result <= 29.9) {
            statusText.setText("Overweight");
        } else if (result >= 30) {
            statusText.setText("Obese");
        }
    }
    @FXML
    private void onclickAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("BMI Calculator");
        alert.setContentText("This is a simple BMI calculator application.\n\n" +
                "Enter your weight and height, and choose the unit type (English or Metric) to calculate your BMI.");
        alert.showAndWait();
    }
    @FXML
    private void onClickClear(){
        weight.setText("");
        height.setText("");
        statusText.setText("");
        rButton1.setSelected(false);
        rButton2.setSelected(false);
    }
    @FXML
    private void onClickExit(){
        javafx.application.Platform.exit();
    }
}