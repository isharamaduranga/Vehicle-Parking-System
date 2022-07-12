package model;

public class Slot {
    private String VehicleType;
    private String Slot;
    private String status;

    public Slot() {
    }

    public Slot(String vehicleType, String slot, String status) {
        VehicleType = vehicleType;
        Slot = slot;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "VehicleType='" + VehicleType + '\'' +
                ", Slot='" + Slot + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
