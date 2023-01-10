package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FireDetector implements Runnable {

    private boolean isActive = false;

    private final ArrayList<TemperatureDetector> tempDetectors;
    private final ArrayList<SmokeDetector> smokeDetectors;
    private final ArrayList<FireButton> fireButtons;

    private final ArrayList<Event> reportedEvents;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public FireDetector(ArrayList<TemperatureDetector> tempDetectors, ArrayList<SmokeDetector> smokeDetectors, ArrayList<FireButton> fireButtons) {
        this.tempDetectors = tempDetectors;
        this.smokeDetectors = smokeDetectors;
        this.fireButtons = fireButtons;

        this.reportedEvents = new ArrayList<>();
    }

    @Override
    public void run() {
        isActive = true;
        monitorFire();
    }

    public void stop() {
        isActive = false;
    }

    public void monitorFire() {
        while (isActive) {
            for (SmokeDetector detector : smokeDetectors) {
//                System.out.println("Czujnik dymu " + detector.getID()
//                        + ", " + detector.getLocation());
                if (detector.readSignal() >= detector.getThreshold()) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.FIRE));
                }
            }

            for (TemperatureDetector detector : tempDetectors) {
//                System.out.println("Czujnik temperatury " + detector.getID()
//                        + ", " + detector.getLocation());
                if (detector.readSignal() >= detector.getThreshold()) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.FIRE));
                }
            }

            for (FireButton button : fireButtons) {
//                System.out.println("Przycisk " + button.getID()
//                        + ", " + button.getLocation());
                if (button.readSignal() == 1.0) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            button.getLocation(),
                            EventType.FIRE));
                }
            }
        }
    }

    public ArrayList<Event> getReportedEvents() {
        return reportedEvents;
    }
}
