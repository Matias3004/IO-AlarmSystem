package FitNesseTests.FitNesseTestsFixture;

import AlarmSystem.Sensor.FireDetector;
import fit.ColumnFixture;

public class TestFireDetector extends ColumnFixture {

        int eventCount;
        double tempDetectorSignal;
        double smokeDetectorSignal;
        double fireButtonSignal;

        SetUp setUp = new SetUp();

        public boolean monitorFireTest() throws Exception {
                FireDetector fireDetector = setUp.getFireDetector();

                setUp.getTemperatureDetector().setValue();
                fireDetector.monitorFire();

                return fireDetector.getReportedEvents().size() == eventCount;
        }
}
