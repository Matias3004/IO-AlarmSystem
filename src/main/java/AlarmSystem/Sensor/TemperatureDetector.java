package AlarmSystem.Sensor;

import java.util.concurrent.ThreadLocalRandom;

public class TemperatureDetector implements ISensor {

    private final int ID;
    private final String location;
    private final double threshold;

    public void setValue(double value) {
        this.value = value;
    }

    private double value;

    public TemperatureDetector(int id, String location, double threshold) {
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

    public void updateReadings(){
        value = ThreadLocalRandom.current().nextDouble(18, 800);
    }

    @Override
    public double readSignal() {
        return value;
    }
}
