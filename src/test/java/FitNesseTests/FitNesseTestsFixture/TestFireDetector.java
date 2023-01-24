package FitNesseTests.FitNesseTestsFixture;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;
import AlarmSystem.Sensor.FireDetector;
import AlarmSystem.Sensor.TemperatureDetector;
import fit.ColumnFixture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestFireDetector extends ColumnFixture {

        int eventCount;
        double tempDetectorSignal;
        double smokeDetectorSignal;
        double fireButtonSignal;

        String eventLocation;
        String testLocation;

        SetUp setUp = new SetUp();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public boolean monitorFireTest() throws Exception {
                FireDetector fireDetector = setUp.getFireDetector();

                fireDetector.activate();

                setUp.getTemperatureDetector().setValue(tempDetectorSignal);
                setUp.getSmokeDetector().setValue(smokeDetectorSignal);
                setUp.getFireButton().setValue(fireButtonSignal);

                fireDetector.monitorFire();

                return fireDetector.getReportedEvents().size() == eventCount;
        }

        public boolean containsEventByLocationTypeTest() throws Exception {
                FireDetector fireDetector = setUp.getFireDetector();
                setUp.getFireDetector().getReportedEvents()
                        .add(new Event(LocalDateTime.now().format(formatter), eventLocation, EventType.FIRE));

                return fireDetector.containsEventByLocationType(
                        testLocation, EventType.FIRE);
        }
}
