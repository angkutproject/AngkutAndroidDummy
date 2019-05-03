package app.slme.angkutcom.Instance;

public class ActiveID {
    private static ActiveID instance;
    private int ActiveID;
    private String ActiveUsername;
    private String ActiveEmail;

    public int getActiveID() {
        return ActiveID;
    }

    public void setActiveID(int activeID) {
        ActiveID = activeID;
    }

    public String getActiveUsername() {
        return ActiveUsername;
    }

    public void setActiveUsername(String activeUsername) {
        ActiveUsername = activeUsername;
    }

    public String getActiveEmail() {
        return ActiveEmail;
    }

    public void setActiveEmail(String activeEmail) {
        ActiveEmail = activeEmail;
    }

    public static ActiveID getInstance(){
        if(instance == null){
            instance = new ActiveID();
        }
        return instance;
    }
}
