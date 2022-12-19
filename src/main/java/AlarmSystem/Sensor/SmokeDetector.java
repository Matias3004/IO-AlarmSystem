package AlarmSystem.Sensor;

import java.util.Random;

public class SmokeDetector implements ISensor {

    private final int ID;
    private final String location;
    private final double threshold;

    private final Random rnd = new Random();

    public SmokeDetector(int id, String location, double threshold) {
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
        return this.threshold;
    }

    @Override
    public double readSignal() {
        return 100 * rnd.nextDouble();
    }
}
