package AlarmSystem.Sensor;

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
        // TODO - implement TemperatureDetector.readSignal
        throw new UnsupportedOperationException();
    }
}
