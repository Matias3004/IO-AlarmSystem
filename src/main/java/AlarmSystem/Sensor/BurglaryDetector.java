package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BurglaryDetector {

    private ArrayList<MovementDetector> movementDetectors;
    private ArrayList<OpeningDetector> openingDetectors;

    public Event monitorBurglary(MovementDetector[] movementDetectors, OpeningDetector[] openingDetectors) {
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
