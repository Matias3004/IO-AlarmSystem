package AlarmSystem.System;

public class Authorization {

    private User[] users;
    private int sessionDuration;

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
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
