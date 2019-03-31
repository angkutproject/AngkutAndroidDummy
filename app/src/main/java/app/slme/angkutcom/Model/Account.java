package app.slme.angkutcom.Model;

public class Account {
    private int accountID;
    private String fullName;
    private String Email;
    private String Phone;
    private String Password;
    private static String AccountTableURL = "https://api.backendless.com/099BF0BC-DEFD-54D5-FF1E-E7554F0AFE00/947D7949-26B6-165D-FF5A-A1612B614A00/data/Account";

    public static String getAccountTableURL() {
        return AccountTableURL;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
