package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicle;
import util.CloseWindow;

import java.io.IOException;
import java.net.URL;

public class AddVehicleController implements CloseWindow {
    public AnchorPane AddVehiclePopUp;
    public TextField txtVehicleNo;
    public TextField txtMaxWeight;
    public ComboBox cmbAddVehicleType;
    public TextField txtNoPassenger;
    boolean vehicleNo;
    boolean weight;
    boolean passenger;


    public void initialize(){
        loadType();
    }

    /**
     * load Combo data
     **/
    private void loadType() {

        cmbAddVehicleType.getItems().add("Bus");
        cmbAddVehicleType.getItems().add("Van");
        cmbAddVehicleType.getItems().add("Cargo Lorry");
    }

    /**
     * Check pattern and Match UI and data added to database
     **/
    public void AddVehicleOnAction(ActionEvent actionEvent) throws IOException {

        isValid();
        validConfirm(vehicleNo, txtVehicleNo);
        validConfirm(weight, txtMaxWeight);
        validConfirm(passenger, txtNoPassenger);

        if (vehicleNo && weight && passenger) {
        try {
            Database.vehicleTable.add
                    (new Vehicle(String.valueOf(txtVehicleNo.getText()), (String) cmbAddVehicleType.getValue(), Double.parseDouble(txtMaxWeight.getText()),
                            Integer.parseInt(txtNoPassenger.getText())));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added In To Database");
            alert.show();
            clearFields();

        } catch (Throwable e) {
            Alert warning = new Alert(Alert.AlertType.WARNING, "Maximum Weight should be Double Type");
            warning.showAndWait();
            txtMaxWeight.clear();

        }
    }
    }

    /**
     * Create Valid Date Pattern And check to fields
     **/
    public void isValid(){
        vehicleNo =txtVehicleNo.getText().matches("[A-Z]{2,3}[-][0-9]{4}");
        weight=txtMaxWeight.getText().matches("[0-9]{4,6}[.][0]{2}");
        passenger=txtNoPassenger.getText().matches("\\d[0-9]{1,3}");
    }


    /**
     * CREATE Boarder Colour pattern and use Validating
     **/
    public void validConfirm(Boolean data,TextField txt){
        if (data){
            txt.setStyle("-fx-border-color: #c0c0c0 ; -fx-border-width: 1px;");

        }else {
            txt.setStyle("-fx-border-color: red ; -fx-border-width: 1px; ");
            txt.requestFocus();
        }
    }


    /**
     * clear vehicle UI clear fieldS
     **/
    private void clearFields() {
        txtVehicleNo.clear();
        txtMaxWeight.clear();
        txtNoPassenger.clear();
        cmbAddVehicleType.getSelectionModel().clearSelection();

    }


    /**
     * Override implement Methods For Stage Load
     **/
    public void CancelAddVehicle(ActionEvent actionEvent) throws IOException {

        CloseWindowUi(AddVehiclePopUp);   //CLOSE WINDOW IN CloseWindowUi

        URL resource = getClass().getResource("../view/ManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage1= new Stage();
        stage1.setScene(scene);
        stage1.centerOnScreen();
        stage1.show();
    }


    /**
     * Override implement Methods for Close Anchorepane
     **/
    @Override
    public void CloseWindowUi(AnchorPane x) throws IOException {
        Stage stage= (Stage) x.getScene().getWindow();
        stage.close();


    }
}
