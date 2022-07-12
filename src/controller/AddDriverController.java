package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import util.CloseWindow;

import java.io.IOException;
import java.net.URL;

public class AddDriverController implements CloseWindow {
    public AnchorPane AddVehiclePopUp;
    public TextField txtDriverName;
    public TextField txtLicene;
    public TextField txtDriverNic;
    public TextField txtAddress;
    public TextField txtContact;
    boolean name;
    boolean nic;
    boolean licene;
    boolean address;
    boolean contact;

    /**
     * Close Current Window load Before Window
     **/
    public void CancelAddDriver(ActionEvent actionEvent) throws IOException {

        CloseWindowUi(AddVehiclePopUp);

        URL resource = getClass().getResource("../view/ManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage1= new Stage();
        stage1.setScene(scene);
        stage1.centerOnScreen();
        stage1.show();
    }


    /**
     * clear vehicle UI clear fieldS
     **/
    private void ClearFields() {
        txtDriverName.clear();
        txtDriverNic.clear();
        txtLicene.clear();
        txtAddress.clear();
        txtContact.clear();
    }


    /**
     * Check pattern and Match UI and data added to database
     **/
    public void AddDriverOnAction(ActionEvent actionEvent) {

        isValid();
        validConfirm(name, txtDriverName);
        validConfirm(nic, txtDriverNic);
        validConfirm(licene, txtLicene);
        validConfirm(address, txtAddress);
        validConfirm(contact, txtContact);

        if (name && nic && licene && address && contact) {

        Database.driverTable.add(new Driver(txtDriverName.getText(), txtDriverNic.getText(),
                txtLicene.getText(), txtAddress.getText(), txtContact.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully Added Driver In To Database");
        alert.show();
        ClearFields();
        }
    }


    /**
     * Create Valid Date Pattern And check to fields
     **/
    public void isValid(){
        name = txtDriverName.getText().matches("[A-Z][a-z]*[ ][A-Z][a-z]*");
        nic = txtDriverNic.getText().matches("[0-9]{10}[V]");
        licene = txtLicene.getText().matches("[B]{1}[0-9]{7}");
        address = txtAddress.getText().matches("[A-Z][a-z]*");
        contact = txtContact.getText().matches("\\d{3}[-]\\d{7}");
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
     * Override implement Methods for Close Anchorepane
     **/
    @Override
    public void CloseWindowUi(AnchorPane x) throws IOException {
        Stage stage= (Stage) x.getScene().getWindow();
        stage.close();
    }
}
