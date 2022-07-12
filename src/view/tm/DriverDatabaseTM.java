package view.tm;

public class DriverDatabaseTM {
     private String name;
     private String NIC;
     private String licenseNo;
     private String address;
     private String contact;

    public DriverDatabaseTM() {
    }

    public DriverDatabaseTM(String name) {
        this.name = name;
    }

    public DriverDatabaseTM(String name, String NIC, String licenseNo, String address, String contact) {
        this.name = name;
        this.NIC = NIC;
        this.licenseNo = licenseNo;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name;
    }
}
