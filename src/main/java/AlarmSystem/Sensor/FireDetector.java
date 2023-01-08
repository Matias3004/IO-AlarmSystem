package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FireDetector {

    private final ArrayList<TemperatureDetector> tempDetectors;
    private final ArrayList<SmokeDetector> smokeDetectors;
    private final ArrayList<FireButton> fireButtons;

    private ArrayList<Event> foundEvents;

    public FireDetector(ArrayList<TemperatureDetector> tempDetectors, ArrayList<SmokeDetector> smokeDetectors, ArrayList<FireButton> fireButtons) {
        this.tempDetectors = tempDetectors;
        this.smokeDetectors = smokeDetectors;
        this.fireButtons = fireButtons;
    }

    public void monitorFire() throws InterruptedException {
        foundEvents = new ArrayList<>();
        while (true) {
            for (SmokeDetector detector : smokeDetectors) {
                System.out.println("Sprawdzanie czujnika dymu nr " + detector.getID() +
                        " w miejscu " + detector.getLocation());

                Thread.sleep(500);

                if (detector.readSignal() < detector.getThreshold())
                    System.out.println("Jest czysto");
                else
                    foundEvents.add(new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.FIRE));
            }
            for (TemperatureDetector detector : tempDetectors) {
                System.out.println("Sprawdzanie czujnika temperatury nr " + detector.getID() +
                        " w miejscu " + detector.getLocation());

                Thread.sleep(500);

                if (detector.readSignal() < detector.getThreshold()) {
                    System.out.println("Jest czysto");
                }
                else
                    foundEvents.add(new Event(LocalDateTime.now().toString(), detector.getLocation(), EventType.FIRE));
            }
            for (FireButton button : fireButtons) {
                System.out.println("Sprawdzanie przycisku nr " + button.getID() +
                        " w miejscu " + button.getLocation());

                Thread.sleep(500);

                if (button.readSignal() != 1.0)
                    System.out.println("Jest czysto");
                else
                    foundEvents.add(new Event(LocalDateTime.now().toString(), button.getLocation(), EventType.FIRE));
            }

            if (!foundEvents.isEmpty()) return;
        }
    }

    public ArrayList<Event> getFoundEvents() {
        return foundEvents;
    }
}
