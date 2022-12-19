package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BurglaryDetector {

    private ArrayList<MovementDetector> movementDetectors;
    private ArrayList<OpeningDetector> openingDetectors;

    public BurglaryDetector(ArrayList<MovementDetector> movementDetectors, ArrayList<OpeningDetector> openingDetectors) {
        this.movementDetectors = movementDetectors;
        this.openingDetectors = openingDetectors;
    }

    public Event monitorBurglary() {
        while (true) {
            for (MovementDetector detector : movementDetectors) {
                if (detector.readSignal() != 1.0) continue;

                return new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.BURGLARY);
            }
            for (OpeningDetector detector : openingDetectors) {
                if (detector.readSignal() != 1.0) continue;

                return new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.BURGLARY);
            }
        }
    }
}
