package view.tm;

import model.Deliver;

public class DeliverTM extends Deliver {
    private String vehicleNo;
    private String vehicleType;
    private String driverName;
    private String leftTime;

    public DeliverTM() {
    }

    public DeliverTM(String vehicleNo, String vehicleType, String driverName, String leftTime) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.leftTime = leftTime;
    }

    public DeliverTM(String value, String text, DriverDatabaseTM value1, String text1) {
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "DeliverTM{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
