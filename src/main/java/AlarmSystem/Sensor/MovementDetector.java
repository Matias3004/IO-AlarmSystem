package AlarmSystem.Sensor;

import java.util.concurrent.ThreadLocalRandom;

public class MovementDetector implements ISensor {

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
        if (ThreadLocalRandom.current().nextBoolean())
            return 1;
        else
            return 0;
    }
}
