package AlarmSystem.Sensor;

public interface ISensor {
    int ID = 0;
    double threshold = 512;
    double signal = 0.0;

    double getThreshold();
    void setThreshold(double threshold);
    double readSignal();
}
