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
        activate();
        try {
            monitorFire();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void activate(){
        isActive = true;
    }
    public void stop() {
        isActive = false;
    }

    public void monitorFire() throws Exception {
        while (isActive && reportedEvents.size() == 0) {
            for (SmokeDetector detector : smokeDetectors) {
                if (detector.readSignal() >= detector.getThreshold() && !containsEventByLocationType(detector.getLocation(), EventType.FIRE)) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.FIRE));
                }
            }

            for (TemperatureDetector detector : tempDetectors) {
                if (detector.readSignal() >= detector.getThreshold() && !containsEventByLocationType(detector.getLocation(), EventType.FIRE)) {
                    reportedEvents.add(new Event(LocalDateTime.now().format(formatter),
                            detector.getLocation(),
                            EventType.FIRE));
                }
            }

            for (FireButton button : fireButtons) {
                if (button.readSignal() == 1.0 &&!containsEventByLocationType(button.getLocation(), EventType.FIRE)) {
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

    public boolean containsEventByLocationType(String location, EventType type) throws Exception {
        for (Event ev : reportedEvents){
            if (location != null && type != null) {
                if (ev.getLocation().equals(location) && ev.getType().equals(type)) {
                    return true;
                }
            }else{
                Exception NullPointerException = null;
                throw NullPointerException;
            }
        }
        return false;
    }
}
