package AlarmSystem.Event;

public class Event {

    private String time;
    private String location;
    private EventType type;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", type=" + type +
                '}';
    }
}
