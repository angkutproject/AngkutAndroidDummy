package app.slme.angkutcom.Model;

public class Partner {
    private int AccountID;
    private String plateNumber;
    private String Location;
    private char Availability;
    private static String PartnerTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/Partner";

    public static String getPartnerTableURL() {
        return PartnerTableURL;
    }

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
