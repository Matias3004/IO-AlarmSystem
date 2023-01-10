package AlarmSystem.System;

import AlarmSystem.Event.Event;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final Scanner in = new Scanner(System.in);

    private boolean isActive;
    private ArrayList<Alarm> alarms;
    private ArrayList<Event> events;
    private final Monitor monitor = new Monitor();
    private final Authorization authorization = new Authorization();

    public boolean isActive() {
        return this.isActive;
    }

    public Controller() throws InterruptedException {


        /*1. Aktywować system
          2. Dezaktywacja alarmu
          3. Ustawienia
          4. Wyjdź
        * */

        while(true) {
            if (isActive())
                System.out.println("2. Deactivate the system");
            else
                System.out.println("1. Activate the system");

            System.out.println("2. Settings");
            System.out.println("3. Quit");
            System.out.print("Choice: ");

            String answer = in.nextLine();

            switch (answer) {
                case "1" -> {
                    if (!isActive()) {
                        activateSystem(authorization);
                        isActive = true;

                        System.out.println("The system was activated!");
                    } else {
                        deactivateSystem(authorization);
                        isActive = false;

                        System.out.println("The system was deactivated!");
                    }
                }
                case "2" ->
                        System.out.println("TODO ustawienia może progów na czujnikach czy tam numerów telefonów służb");
                case "3" -> System.exit(0);
                default -> {
                    return;
                }
            }
        }
    }


    public boolean activateSystem(Authorization authorization) throws InterruptedException {
        monitor.setActive(true);
        monitor.monitor();

        return true;
    }

    public boolean deactivateSystem(Authorization authorization) {
        monitor.setActive(false);
        return true;
    }

    public void callAuthorities(String alarmData) {
        // TODO - implement Controller.callAuthorities
        throw new UnsupportedOperationException();
    }
}
