package AlarmSystem.Sensor;

import java.util.Random;

public class FireButton implements ISensor {

    private final int ID;
    private final String location;

    public boolean isPressed() {
        return isPressed;
    }

    private boolean isPressed;

    private final Random rnd;

    public FireButton(int id, String location) {
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
            this.isPressed = true;

            return 1.0;
        } else {
            this.isPressed = false;

            return 0.0;
        }
    }
}
