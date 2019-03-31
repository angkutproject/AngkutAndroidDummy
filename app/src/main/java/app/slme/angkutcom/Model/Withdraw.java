package app.slme.angkutcom.Model;

public class Withdraw {
    private int withdrawID;
    private int AccountID;
    private int Amount;
    private static String WithdrawTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/Withdraw";

    public static String getWithdrawTableURL() {
        return WithdrawTableURL;
    }

    public int getWithdrawID() {
        return withdrawID;
    }

    public void setWithdrawID(int withdrawID) {
        this.withdrawID = withdrawID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
