package AlarmSystem.Sensor;

import java.util.concurrent.ThreadLocalRandom;

public class MovementDetector implements ISensor {

    private final int ID;
    private final String location;
    private final double threshold;

    public MovementDetector(int id, String location, double threshold) {
        this.ID = id;
        this.location = location;
        this.threshold = threshold;
    }

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return location;
    }

    public double getThreshold() {
        return threshold;
    }

    @Override
    public double readSignal() {
        if (ThreadLocalRandom.current().nextBoolean())
            return 1;
        else
            return 0;
    }
}
