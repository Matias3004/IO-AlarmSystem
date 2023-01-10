package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BurglaryDetector implements Runnable {

    private boolean isActive = false;

    private final ArrayList<MovementDetector> movementDetectors;
    private final ArrayList<OpeningDetector> openingDetectors;

    private final ArrayList<Event> reportedEvents;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


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
                if (detector.readSignal() == 1.0 && !containsEventByLocationType(detector.getLocation(), EventType.BURGLARY)) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.BURGLARY));
                }
            }
            for (OpeningDetector detector : openingDetectors) {
//                System.out.println("Czujnik otwarcia " + detector.getID()
//                        + ", " + detector.getLocation());
                if (detector.readSignal() == 1.0 && !containsEventByLocationType(detector.getLocation(), EventType.BURGLARY)) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.BURGLARY));
                }
            }
        }
    }

    public ArrayList<Event> getReportedEvents() {
        return reportedEvents;
    }

    public boolean containsEventByLocationType(String location, EventType type) {
        for (Event ev : reportedEvents){
            if (ev.getLocation().equals(location) && ev.getType().equals(type)){
                return true;
            }
        }
        return false;
    }
}
