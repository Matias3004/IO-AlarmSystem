package AlarmSystem.Sensor;

import java.util.concurrent.ThreadLocalRandom;

public class TemperatureDetector implements ISensor {

    private int ID;
    private double threshold;

    @Override
    public double getThreshold() {
        return this.threshold;
    }

    @Override
    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public double readSignal() {
        return ThreadLocalRandom.current().nextDouble(18, 800);
    }
}
