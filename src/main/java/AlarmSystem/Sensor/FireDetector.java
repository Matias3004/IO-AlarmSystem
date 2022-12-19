package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FireDetector {

    private ArrayList<TemperatureDetector> tempDetectors;
    private ArrayList<SmokeDetector> smokeDetectors;
    private ArrayList<FireButton> fireButtons;

    public FireDetector(ArrayList<TemperatureDetector> tempDetectors, ArrayList<SmokeDetector> smokeDetectors, ArrayList<FireButton> fireButtons) {
        this.tempDetectors = tempDetectors;
        this.smokeDetectors = smokeDetectors;
        this.fireButtons = fireButtons;
    }

    public Event monitorFire() {
        while (true) {
            for (SmokeDetector detector : smokeDetectors) {
                if (detector.readSignal() < detector.getThreshold()) continue;

                return new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.FIRE);
            }
            for (TemperatureDetector detector : tempDetectors) {
                if (detector.readSignal() < detector.getThreshold()) continue;

                return new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.FIRE);
            }
            for (FireButton button : fireButtons) {
                if (button.readSignal() != 1.0) continue;

                return new Event(LocalDateTime.now().toString(), button.getLocation(), EventType.FIRE);
            }
        }
    }
}
