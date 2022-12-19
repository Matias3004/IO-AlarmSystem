package AlarmSystem.Sensor;

import java.util.Random;

public class FireButton implements ISensor {

    private int ID;
    private double signal;
    private double threshold;

    private final Random rnd = new Random();

    @Override
    public double getThreshold() {
        return 0;
    }

    @Override
    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public double readSignal() {
        if (rnd.nextBoolean()) {
            this.signal = 1.0;

            return 1;
        } else {
            this.signal = 0.0;

            return 0;
        }
    }
}
