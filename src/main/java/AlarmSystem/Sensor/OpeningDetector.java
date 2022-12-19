package AlarmSystem.Sensor;

import java.util.Random;

public class OpeningDetector implements ISensor {

    private int ID;
    private boolean isOpen;

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
        if (rnd.nextBoolean()) {
            this.isOpen = true;

            return 1.0;
        } else {
            this.isOpen = false;

            return 0.0;
        }
    }
}
