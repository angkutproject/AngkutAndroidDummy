package app.slme.angkutcom.Model;

public class OrderDetail {
    private int OrderID;
    private int ItemID;
    private String Amount;
    private static String OrderDetailTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/OrderDetail";

    public static String getOrderDetailTableURL() {
        return OrderDetailTableURL;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
