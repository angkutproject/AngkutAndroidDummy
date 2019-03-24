package app.slme.angkutcom.Model;

import java.util.Date;

public class Order {
    private int OrderID;
    private int CustID;
    private int PartnerID;
    private Date OrderTime;
    private String Location;
    private int statusID;

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
