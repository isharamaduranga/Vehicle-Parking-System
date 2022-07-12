package model;

public class Park {

    private String VehicleNumber;
    private String VehicleType;
    private String Slot;
    private String ParkedTime;

    public Park() {
    }

    public Park(String vehicleNumber, String vehicleType, String slot, String parkedTime) {
        VehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
        Slot = slot;
        ParkedTime = parkedTime;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
    }

    public String getParkedTime() {
        return ParkedTime;
    }

    public void setParkedTime(String parkedTime) {
        ParkedTime = parkedTime;
    }

    @Override
    public String toString() {
        return "Park{" +
                "VehicleNumber='" + VehicleNumber + '\'' +
                ", VehicleType='" + VehicleType + '\'' +
                ", Slot='" + Slot + '\'' +
                ", ParkedTime='" + ParkedTime + '\'' +
                '}';
    }
}
