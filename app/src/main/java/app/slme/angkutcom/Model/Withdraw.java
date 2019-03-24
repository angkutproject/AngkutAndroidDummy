package app.slme.angkutcom.Model;

public class Withdraw {
    private int withdrawID;
    private int AccountID;
    private int Amount;

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
