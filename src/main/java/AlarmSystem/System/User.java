package AlarmSystem.System;

public class User {

    private String authTime;
    private UserData userData;

    public User(String username) {
        this.userData.setUsername(username);
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
