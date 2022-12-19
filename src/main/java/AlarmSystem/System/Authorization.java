package AlarmSystem.System;

import java.util.ArrayList;

public class Authorization {

    private ArrayList<User> users;
    private int sessionDuration;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean authorize(User user) {
        // TODO - implement Authorization.authorize
        throw new UnsupportedOperationException();
    }

    public boolean logout(User user) {
        // TODO - implement Authorization.logout
        throw new UnsupportedOperationException();
    }
}
