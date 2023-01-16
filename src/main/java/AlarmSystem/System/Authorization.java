package AlarmSystem.System;

import java.util.ArrayList;
import java.util.Scanner;

public class Authorization {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<User> loggedUsers = new ArrayList<>();
    private int sessionDuration;



    Scanner in = new Scanner(System.in);

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean isLoggedIn(User u){
        for (User user : loggedUsers){
            return user.equals(u);
        }
        return false;
    }
    public void addUser(User user) {
        users.add(user);
    }

    public boolean authorize(String username, String password) {
        for (User user : users) {
            if (user.getUserData().getPassword().compareTo(password) == 0 && user.getUserData().getUsername().compareTo(username) == 0) {
                loggedUsers.add(user);
                return true;
            }
        }
        return false;
    }

    public boolean logout(User user) {
        return loggedUsers.remove(user);
    }
}
