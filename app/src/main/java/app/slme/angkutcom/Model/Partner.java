package app.slme.angkutcom.Model;

public class Partner {
    private int AccountID;
    private String plateNumber;
    private String Location;
    private char Availability;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public char getAvailability() {
        return Availability;
    }

    public void setAvailability(char availability) {
        Availability = availability;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }
}
