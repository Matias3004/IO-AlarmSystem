package AlarmSystem.Sensor;

public class OpeningDetector implements ISensor {

    private int ID;
    private boolean isOpen;

    @Override
    public double getThreshold() {
        return 0;
    }

    @Override
    public void setThreshold(double threshold) {

    }

    @Override
    public double readSignal() {
        // TODO - implement OpeningDetector.readSignal
        throw new UnsupportedOperationException();
    }
}
