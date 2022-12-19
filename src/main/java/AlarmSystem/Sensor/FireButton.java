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

    }

    @Override
    public double readSignal() {
        if (rnd.nextBoolean())
            return 1;
        else
            return 0;
    }
}
