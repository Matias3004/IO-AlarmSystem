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
        System.out.print("Aktywować system? [T/N]: ");
        String answer = in.nextLine();
        if (answer.equalsIgnoreCase("N")) return;

        isActive = activateSystem();
    }

    public boolean activateSystem() throws InterruptedException {
        monitor.monitor();

        return true;
    }

    public boolean deactivateSystem(Authorization authorization) {
        // TODO - implement Controller.deactivateSystem
        throw new UnsupportedOperationException();
    }

    public void callAuthorities(String alarmData) {
        // TODO - implement Controller.callAuthorities
        throw new UnsupportedOperationException();
    }
}
