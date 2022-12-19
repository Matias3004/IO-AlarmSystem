package AlarmSystem.Sensor;

import java.util.Random;

public class OpeningDetector implements ISensor {

    private final int ID;
    private final String location;
    private boolean isOpen;

    private final Random rnd;

    public OpeningDetector(int id, String location) {
        rnd = new Random();
        this.ID = id;
        this.location = location;
    }

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return location;
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
