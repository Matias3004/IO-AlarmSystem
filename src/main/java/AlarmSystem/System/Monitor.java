package AlarmSystem.System;

import AlarmSystem.Event.Event;
import AlarmSystem.Sensor.*;

import java.util.ArrayList;

public class Monitor {

    private final FireDetector fireDetector;
    private final BurglaryDetector burglaryDetector;

    private final ArrayList<TemperatureDetector> temperatureDetectors;
    private final ArrayList<SmokeDetector> smokeDetectors;
    private final ArrayList<FireButton> fireButtons;

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive = true;

    private final ArrayList<OpeningDetector> openingDetectors;
    private final ArrayList<MovementDetector> movementDetectors;

    public Monitor() {
        temperatureDetectors = new ArrayList<>();
        smokeDetectors = new ArrayList<>();
        fireButtons = new ArrayList<>();

        openingDetectors = new ArrayList<>();
        movementDetectors = new ArrayList<>();

        initializeFireSensors();
        initializeBurglarySensors();

        fireDetector = new FireDetector(temperatureDetectors, smokeDetectors, fireButtons);
        burglaryDetector = new BurglaryDetector(movementDetectors, openingDetectors);
    }
    public void monitor() {
        ArrayList<Event> fireEvents;

        Thread fireDetectorThread = new Thread(fireDetector);
        fireDetectorThread.start();


        fireEvents = fireDetector.getReportedEvents(); //TODO new thread for monitor
        for (Event ev : fireEvents) {
            System.out.println(ev.toString());
        }

    }

    public void initializeFireSensors() {
        temperatureDetectors.add(new TemperatureDetector(1, "Korytarz", 100.0));
        temperatureDetectors.add(new TemperatureDetector(2, "Biuro", 100.0));
        temperatureDetectors.add(new TemperatureDetector(3, "Magazyn", 100.0));

        smokeDetectors.add(new SmokeDetector(1, "Korytarz", 50.0));
        smokeDetectors.add(new SmokeDetector(1, "Biuro", 30.0));
        smokeDetectors.add(new SmokeDetector(1, "Magazyn", 10.0));

        fireButtons.add(new FireButton(1, "Korytarz"));
        fireButtons.add(new FireButton(2, "Magazyn"));
    }

    public void initializeBurglarySensors() {
        openingDetectors.add(new OpeningDetector(1, "Drzwi wejsciowe"));
        openingDetectors.add(new OpeningDetector(2, "Okna biuro"));
        openingDetectors.add(new OpeningDetector(3, "Okna magazyn"));
        openingDetectors.add(new OpeningDetector(4, "Rampa magazyn"));

        movementDetectors.add(new MovementDetector(1, "Korytarz", 0.5));
        movementDetectors.add(new MovementDetector(1, "Biuro", 0.5));
        movementDetectors.add(new MovementDetector(1, "Magazyn", 0.5));
    }
}
