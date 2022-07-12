package db;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.util.ArrayList;

public class Database {
    public static AnchorPane belowUp;
    public static ArrayList<Driver> driverTable=new ArrayList<Driver>();

    static {
        driverTable.add(new Driver("Sumith Kumara", "7835348345V", "B6474845","Panadura","0725637456"));
        driverTable.add(new Driver("Amila Pathirana", "8826253734V", "B3354674 ","Galle","0717573583"));
        driverTable.add(new Driver("Jithmal Perera", "9283289272V", "B3674589","Horana","0772452457"));
        driverTable.add(new Driver("Sumith Dissanayaka", "9425245373V", "B8366399","Kaluthara","0782686390"));
        driverTable.add(new Driver("Sumanasiri Herath", "8976544373V", "B3537538","Beruwala","0772534436"));
        driverTable.add(new Driver("Awantha Fernando", " 9173537839V",  "B3554789" ,"Colombo 5", "0714534356"));
        driverTable.add(new Driver("Charith Sudara", "9573536833V", "B6835836", "Baththaramulla", "0771536662"));
        driverTable.add(new Driver("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa", "0715353434"));
        driverTable.add(new Driver("Chethiya Dilan", "9162353436V", "B6836836", "Panadura", "0772436737"));
        driverTable.add(new Driver("Dushantha Perera", "9255556343V", "B3334435", "Matara" ,"0777245343"));
        driverTable.add(new Driver("Sumith Udayanga", "8735354355V", "B3573783", "Galle", "0703635442"));
        driverTable.add(new Driver("Dinesh Udara", "9026344373V" ,"B5343783" ,"Hettimulla", "0713456878"));
        driverTable.add(new Driver("Udana Chathuranga", "9692653338V" ,"B7888632", "Kottawa", "0772442444"));
        driverTable.add(new Driver("Mohommad Riaz", "9124537733V", "B3638537", "Kaluthara", "0777544222"));
        driverTable.add(new Driver("Sandun Kumara", "9563524267V", "B2263333", "Panadura", "0772325544"));
        driverTable.add(new Driver("Priyanga Perera", "9135343537V" ,"B3853753" ,"Matara" ,"0723344562"));

    }

    public static ArrayList<Deliver> deliverTable = new ArrayList<Deliver>();

    static {


    }

    public static ArrayList<Park> parkInTable=new ArrayList<Park>();
    static {


    }

    public static ArrayList<Slot> slotTable=new ArrayList<Slot>();
    static {
        slotTable.add(
                new Slot("Bus","14","notUse")
        );
        slotTable.add(
                new Slot("Van","1","notUse")
        );
        slotTable.add(
                new Slot("Van","2","notUse")
        );
        slotTable.add(
                new Slot("Van","3","notUse")
        );
        slotTable.add(
                new Slot("Van","4","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","5","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","6","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","7","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","8","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","9","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","10","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","11","notUse")
        );
        slotTable.add(
                new Slot("Van","12","notUse")
        );
        slotTable.add(
                new Slot("Van","13","notUse")
        );

    }

    public static ArrayList<Vehicle> vehicleTable=new ArrayList<Vehicle>();

    static {
        vehicleTable.add(
                new Vehicle("NA-3434","Bus",3500.00,60)
        );
        vehicleTable.add(
                new Vehicle("KA-4563","Van",1000.00,7)
        );
        vehicleTable.add(
                new Vehicle("58-3567","Van",1500.00,4)
        );
        vehicleTable.add(
                new Vehicle("GF-4358","Van",800.00,4)
        );
        vehicleTable.add(
                new Vehicle("CCB-3568","Van",1800.00,8)
        );
        vehicleTable.add(
                new Vehicle("LM-6679","Van",1500.00,4)
        );
        vehicleTable.add(
                new Vehicle("QA-3369","Van",1800.00,6)
        );
        vehicleTable.add(
                new Vehicle("KB-3668","Cargo Lorry",2500.00,2)
        );
        vehicleTable.add(
                new Vehicle("JJ-9878","Cargo Lorry",3000.00,2)
        );
        vehicleTable.add(
                new Vehicle("GH-5772","Cargo Lorry",4000.00,3)
        );
        vehicleTable.add(
                new Vehicle("XY-4456","Cargo Lorry",3500.00,2)
        );
        vehicleTable.add(
                new Vehicle("YQ-3536","Cargo Lorry",2000.00,2)
        );
        vehicleTable.add(
                new Vehicle("CBB-3566","Cargo Lorry",2500.00,2)
        );
        vehicleTable.add(
                new Vehicle("QH-3444","Cargo Lorry",5000.00,4)
        );


    }

}
