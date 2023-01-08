package AlarmSystem.System;

import java.util.ArrayList;
import java.util.Scanner;

public class Authorization {

    private ArrayList<User> users;
    private int sessionDuration;

    Scanner in = new Scanner(System.in);

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean authorize(User user) {
        System.out.print("Podaj hasło: ");
        String password = in.nextLine();

        return user.getUserData().getPassword().equals(password);
    }

    public boolean logout(User user) {
        // TODO - implement Authorization.logout
        throw new UnsupportedOperationException();
    }
}
