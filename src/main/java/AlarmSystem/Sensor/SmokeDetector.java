package AlarmSystem.Sensor;

import java.util.Random;

public class SmokeDetector implements ISensor {

    private int ID;
    private double threshold;

    private final Random rnd = new Random();

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
        return 100 * rnd.nextDouble();
    }
}
