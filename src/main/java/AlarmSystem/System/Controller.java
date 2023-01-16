package AlarmSystem.System;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private static final Scanner in = new Scanner(System.in);

    private static boolean isActive;
    private ArrayList<Alarm> alarms;
    private ArrayList<Event> events;
    private static final Monitor monitor = new Monitor();
    private static Authorization authorization = null;

    public static boolean isActive() {
        return isActive;
    }

    public Controller(){
        authorization = new Authorization();
    }
    public static void main(String[] args) throws InterruptedException {
        /*1. Aktywować system
          2. Dezaktywacja alarmu
          3. Ustawienia
          4. Wyjdź
        * */

        User user = new User("admin");
        UserData ud = new UserData();
        ud.setUsername("admin");
        ud.setPassword("123");
        ud.setId(0);
        user.setUserData(ud);

        authorization.addUser(user);
        while(true) {
            if (isActive())
                System.out.println("2. Deactivate the system");
            else
                System.out.println("1. Activate the system");

            System.out.println("2. Settings");
            System.out.println("3. Quit");
            System.out.println("4. Login as admin");
            System.out.print("Choice: ");

            String answer = in.nextLine();

            switch (answer) {
                case "1" -> {
                    if (!isActive()) {
                        activateSystem(user);
                        isActive = true;

                        System.out.println("The system was activated!");
                    } else {
                        deactivateSystem(user);
                        isActive = false;

                        System.out.println("The system was deactivated!");
                    }
                }
                case "2" ->
                        System.out.println("TODO ustawienia może progów na czujnikach czy tam numerów telefonów służb");
                case "3" -> System.exit(0);
                case "4" -> authorization.authorize(user.getUserData().getUsername(), user.getUserData().getPassword());
                default -> {
                    return;
                }
            }
        }
    }



    public static boolean activateSystem(User user) throws InterruptedException {
        if(authorization.isLoggedIn(user)) {
            isActive = true;
            monitor.setActive(true);
            //monitor.monitor();
            return true;
        }
        return false;
    }

    public static boolean deactivateSystem(User user) {
        if(authorization.isLoggedIn(user)) {
            monitor.setActive(false);
            return true;
        }
        return false;
    }

    public String callAuthorities(String alarmData, EventType type) {
        System.out.println("The message is: ");
        System.out.println(alarmData);
        System.out.println("The following authorities will be notified:");
        if(type != null) {
            if (type.equals(EventType.FIRE)) {
                System.out.println("Firefighters");
                return "Firefighters";
            } else if (type.equals(EventType.BURGLARY)) {
                System.out.println("Cops");
                return "Cops";
            }
        }
        System.out.println("Error");
        return "Error";
    }

    public boolean authorize(String login, String password) {
        if(login.length() == 0){
            System.out.println("The login field is empty");
            if (password.length() == 0){
                System.out.println("The password field is empty");
            }
            return false;
        }
        return authorization.authorize(login, password);
    }

    public void addUser(User user){
        authorization.addUser(user);
    }
}
