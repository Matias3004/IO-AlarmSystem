package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BurglaryDetector implements Runnable {

    private boolean isActive = false;

    private final ArrayList<MovementDetector> movementDetectors;
    private final ArrayList<OpeningDetector> openingDetectors;

    private final ArrayList<Event> reportedEvents;

    public BurglaryDetector(ArrayList<MovementDetector> movementDetectors, ArrayList<OpeningDetector> openingDetectors) {
        this.movementDetectors = movementDetectors;
        this.openingDetectors = openingDetectors;

        this.reportedEvents = new ArrayList<>();
    }

    @Override
    public void run() {
        isActive = true;
        monitorBurglary();
    }

    public void stop() {
        isActive = false;
    }

    public void monitorBurglary() {
        while (isActive) {
            for (MovementDetector detector : movementDetectors) {
//                System.out.println("Czujnik ruchu " + detector.getID()
//                        + ", " + detector.getLocation());
                if (detector.readSignal() == 1.0) {
                    reportedEvents.add(new Event(LocalDateTime.now().toString(),
                            detector.getLocation(),
                            EventType.BURGLARY));
                }
            }
            for (OpeningDetector detector : openingDetectors) {
//                System.out.println("Czujnik otwarcia " + detector.getID()
//                        + ", " + detector.getLocation());
                if (detector.readSignal() == 1.0) {
                    reportedEvents.add(new Event(LocalDateTime.now().toString(),
                            detector.getLocation(),
                            EventType.BURGLARY));
                }
            }
        }
    }

    public ArrayList<Event> getReportedEvents() {
        return reportedEvents;
    }
}
