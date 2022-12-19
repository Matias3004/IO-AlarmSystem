package AlarmSystem.Sensor;

import java.util.Random;

public class OpeningDetector implements ISensor {

    private int ID;
    private String location;
    private double threshold;
    private boolean isOpen;

    private final Random rnd = new Random();

    public String getLocation() {
        return this.location;
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
