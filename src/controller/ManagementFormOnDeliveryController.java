package controller;

import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Deliver;
import util.AddToLoadUi;
import util.CloseWindow;
import view.tm.DeliverTM;

import java.io.IOException;
import java.net.URL;

public class ManagementFormOnDeliveryController implements AddToLoadUi, CloseWindow {

    public AnchorPane deliveryAnchorpane;

    public ComboBox ManagemntCmbType;

    public TableView <DeliverTM>tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public TableColumn colVehicleNumber1;


    /**
     * Display all load data to Deliver table from  delivery
     **/
    public void initialize() {

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory("leftTime"));


        ManagemntCmbType.getItems().add("In Parking");
        ManagemntCmbType.getItems().add("On Delivery");

        ManagemntCmbType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String text=String.valueOf(newValue);
            if(text.equals("In Parking")){

                Stage stage1= (Stage) deliveryAnchorpane.getScene().getWindow();
                try{
                    stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementForm.fxml"))));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        loadAllData();

    }


    /**
     * load to Above fields data to Database
     **/
    private void loadAllData() {
        ObservableList obList = FXCollections.observableArrayList();
        for (Deliver d: Database.deliverTable) {


            DeliverTM tm= new DeliverTM(d.getVehicleNo(),d.getVehicleType(),d.getDriverName(),d.getLeftTime());
            obList.add(tm);

        }
        tblOnDelivery.setItems(obList);


    }


    /**
     * load to Add Vehicle UI
     **/
    public void AddVehicleToDeliveryOnAction(ActionEvent actionEvent) throws IOException {

        CloseWindowUi(deliveryAnchorpane);
        loadUi("AddVehicle");

    }


    /**
     * load to Add Driver UI
     **/
    public void AddDriverToDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        CloseWindowUi(deliveryAnchorpane);
        loadUi("AddDriver");
    }


    /**
     * Log Out to Current ui and Load before home ui
     **/
   public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {

        deliveryAnchorpane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ParkingHomeForm.fxml"));
        deliveryAnchorpane.getChildren().add(parent);
    }


    /**
     * Override implement Methods For Stage Load
     **/
    @Override
    public void loadUi(String location) throws IOException {
        URL resource = getClass().getResource("../view/"+location+".fxml");
        Parent  load =FXMLLoader.load(resource);
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
        Stage stage= (Stage)x.getScene().getWindow();
        stage.close();
    }
}
