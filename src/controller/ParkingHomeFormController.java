package controller;

import db.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.tm.DriverDatabaseTM;
import view.tm.VehicleDatabaseTM;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class ParkingHomeFormController  {

    public AnchorPane loginContextAnchor;
    public Button managemntClose;
    public Label setTimeDateToLabel;

    public ComboBox cmbVehicleNo;
    public ComboBox cmbDriverName;
    public TextField txtVehicleType;
    public Label slotNoToLabel;
    public Button btnPark;
    public Button btnDelivery;
    public Label lblDay;

    /**
     * Create Boolean reference default
     **/

    boolean b=false;
    boolean deliver=false;

    /**
     * Initialized All data
     **/
    public void initialize(){

        try {
            loadHomeDate();
            curDateTime();

            cmbVehicleNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                VehicleType(newValue);
            });

        }catch (Exception e){

        }

    }


    /**
     * Set Vehicle Type According to Vehicle No
     **/
    private void VehicleType(Object newValue) {

        String a= String.valueOf(newValue);
        for (int i=0;i<Database.vehicleTable.size();i++){
            String number=Database.vehicleTable.get(i).getVehicleNo();
            if (a.equals(number)){

                txtVehicleType.setText(Database.vehicleTable.get(i).getVehicleType());
               // String type=txtVehicleType.getText();

            }
        }
        parkingSlot();
    }


    /**
     * Define current Vehicle of selected
     **/
   public void parkingSlot() {

        switch (txtVehicleType.getText()){
            case "Van" : {
                setslot("Van");
            }break;
            case "Cargo Lorry" : {
                setslot("Cargo Lorry");
            }break;
            case "Bus" : {
                setslot("Bus");
            }break;
        }
    }


    /**
     * Assign Slot number to Label
     **/
    private void setslot(String vehicletype) {
        for (int i=0; i<Database.slotTable.size(); i++){
            for (int j=0; j<Database.slotTable.size(); j++){
                if (vehicletype.equals(Database.slotTable.get(i).getVehicleType()) && Database.slotTable.get(i).getStatus().equals("notUse")) {
                    slotNoToLabel.setText(Database.slotTable.get(i).getSlot());
                    return;
                }
            }
        }
        clearslotlbl();
    }


    /**
     * clear Slot Label
     **/
    private void clearslotlbl() {
        for (int i=0; i<Database.parkInTable.size(); i++){
            if (Database.parkInTable.get(i).getVehicleNumber().equals(cmbVehicleNo.getValue())){
                slotNoToLabel .setText(" ");
            }
        }
    }


    /**
     * Display status of use or NotUse
     **/
    private void setnotuse(String slotnmbr) {
        for (int i=0; i<Database.slotTable.size(); i++){
            if (Database.slotTable.get(i).getSlot().equals(slotnmbr)){
                Database.slotTable.get(i).setStatus("notUse");
            }
        }
    }


    /**
     * load Time & Date to Labels
     **/
    public void curDateTime(){

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            setTimeDateToLabel.setText(currentDate.getYear()+"-"+currentDate.getMonthValue()+"-"+currentDate.getDayOfMonth()+
                    "    "+ currentTime.getHour() + ":" + currentTime.getMinute() + ":"+ currentTime.getSecond());
            lblDay.setText(String.valueOf(currentDate.getDayOfWeek()));
          }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    /**
     * Home page combo Box DataLoaded..
     **/
    private void loadHomeDate() {
     ObservableList<VehicleDatabaseTM>observableList=FXCollections.observableArrayList();
        for (Vehicle v:Database.vehicleTable){
            VehicleDatabaseTM tm =new VehicleDatabaseTM(v.getVehicleNo());
            observableList.add(tm);
        }

        ObservableList<DriverDatabaseTM>observableList1=FXCollections.observableArrayList();
        for (Driver d: Database.driverTable){
            DriverDatabaseTM dr=new DriverDatabaseTM(d.getName());
            observableList1.add(dr);
        }

        cmbVehicleNo.setItems(observableList);
        cmbDriverName.setItems(observableList1);
    }


    /**
     * load management window
     **/
    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {

        Database.belowUp=loginContextAnchor;
            URL resource = getClass().getResource("../view/LoginForm.fxml");
            Parent  load =FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage1= new Stage();
            stage1.setScene(scene);
            stage1.setTitle("L O G I N   P A G E");
            stage1.centerOnScreen();
            stage1.show();

        }


    /**
     * clear fields
     **/
    public void clearFields() {
        txtVehicleType.clear();
        cmbVehicleNo.getSelectionModel().clearSelection();
        cmbDriverName.getSelectionModel().clearSelection();
    }


    /**
     * Vehicle Park And Add Data to Table
     **/
    public void parkVehicleOnAction(ActionEvent actionEvent){
        for(int k=0;k<Database.slotTable.size();k++){
            if( slotNoToLabel.getText().equals(Database.slotTable.get(k).getSlot())){
                Database.slotTable.get(k).setStatus("Use");
            }
        }
        parkTest();
    }


    /**
     * Vehicle Deliver And Add Data to Table
     **/
    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {

        try{
            deliveryTest();
            for(int k=0;k<Database.parkInTable.size();k++){
                if(cmbVehicleNo.getValue().equals(Database.parkInTable.get(k).getVehicleNumber())){
                    setnotuse(Database.parkInTable.get(k).getSlot());
                }
            }

        }catch(Throwable e){
            System.out.println(e);
        }
    }


    /**
     * Calling ParkTest(park & deliver btn check conditions)
     **/
    public void parkTest(){
        cmbVehicleNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            btnPark.setDisable(false);
            String temp=String.valueOf(newValue);
            for (int i=0;i<Database.parkInTable.size();i++){
                b= Database.parkInTable.get(i).getVehicleNumber().contains(temp);
                if(b==true){
                    btnPark.setDisable(true);

                }
            }
        });
        if(b==false){
            if(cmbVehicleNo.getValue()!=null){
                String data= (String.valueOf(cmbVehicleNo.getValue())) ;
                Park p=new Park(String.valueOf(cmbVehicleNo.getValue()),txtVehicleType.getText(),slotNoToLabel.getText(),setTimeDateToLabel.getText());
                Database.parkInTable.add(p);

                for(int i=0;i<Database.deliverTable.size();i++){
                    if(Database.deliverTable.get(i).getVehicleNo().contains(data)){
                        Database.deliverTable.remove(i);
                    }
                }
            }
        }
        clearFields();
    }


    /**
     * Calling deliveryTest(park & deliver btn check conditions)
     **/
    public void deliveryTest(){
        cmbVehicleNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String temp2=String.valueOf(newValue);
            btnDelivery.setDisable(false);

            for (int i=0;i<Database.deliverTable.size();i++){
                deliver= Database.deliverTable.get(i).getVehicleNo().contains(temp2);

                if(deliver==true){
                    btnDelivery.setDisable(false);

                }
            }
        });

        if(deliver==false){

            if(cmbVehicleNo.getValue()!=null && cmbDriverName.getValue()!=null){
                String data= (String.valueOf(cmbVehicleNo.getValue())) ;
                for(int i=0;i<Database.parkInTable.size();i++){
                    if(Database.parkInTable.get(i).getVehicleNumber().contains(data)){
                        Database.parkInTable.remove(i);
                    }
                }
                Deliver d=new Deliver(String.valueOf(cmbVehicleNo.getValue()),txtVehicleType.getText(),String.valueOf(cmbDriverName.getValue()),setTimeDateToLabel.getText());
                Database.deliverTable.add(d);
            }
        }
        clearFields();
    }
}


