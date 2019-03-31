package app.slme.angkutcom.Model;

public class BankList {
    private int BankID;
    private String BankName;
    private static String BankListTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/BankList";

    public static String getBankListTableURL() {
        return BankListTableURL;
    }

    public int getBankID() {
        return BankID;
    }

    public void setBankID(int bankID) {
        BankID = bankID;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}
