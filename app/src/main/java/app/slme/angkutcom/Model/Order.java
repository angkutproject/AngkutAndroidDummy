package app.slme.angkutcom.Model;

import java.util.Date;

public class Order {
    private int OrderID;
    private int CustID;
    private int PartnerID;
    private Date OrderTime;
    private String Location;
    private int statusID;
    private static String OrderTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/Order";

    public static String getOrderTableURL() {
        return OrderTableURL;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int custID) {
        CustID = custID;
    }

    public int getPartnerID() {
        return PartnerID;
    }

    public void setPartnerID(int partnerID) {
        PartnerID = partnerID;
    }

    public Date getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(Date orderTime) {
        OrderTime = orderTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
}
