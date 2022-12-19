package AlarmSystem.Sensor;

public class FireButton implements ISensor {

    private int ID;
    private double signal;
    private double threshold;

    @Override
    public double getThreshold() {
        return 0;
    }

    @Override
    public void setThreshold(double threshold) {

    }

    @Override
    public double readSignal() {
        return 0;
    }
}
