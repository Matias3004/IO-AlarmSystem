package AlarmSystem.System;

import AlarmSystem.Event.Event;

public class Controller {

    private boolean isActive;
    private Alarm[] alarms;
    private Event[] events;

    public boolean isActive() {
        return this.isActive;
    }

    public static void main(String[] args) {
        // TODO - implement Controller.main
        System.out.println("Seima");
        throw new UnsupportedOperationException();
    }

    public boolean activateSystem(Authorization authorization) {
        // TODO - implement Controller.activateSystem
        throw new UnsupportedOperationException();
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
