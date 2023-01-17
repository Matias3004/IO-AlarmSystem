package JMockit.AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Sensor.FireButton;

import AlarmSystem.Sensor.FireDetector;
import JMockit.AlarmSystem.TestDataMock;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FireDetectorMockTest {

    @Injectable
    FireDetector fireDetector;
    @Injectable
    ArrayList<Event> reportedEvents;

    TestDataMock testDataMock;

    @BeforeEach
    void setUp() {
        testDataMock = new TestDataMock();
        fireDetector = new FireDetector(
                testDataMock.temperatureDetectors,
                testDataMock.smokeDetectors,
                testDataMock.fireButtons);

        testDataMock.temperatureDetectors.get(0).setValue(420);
        testDataMock.temperatureDetectors.get(1).setValue(420);
        testDataMock.temperatureDetectors.get(3).setValue(420);
    }

    @Test
    void monitorFireTest(@Mocked FireButton fireButton, @Injectable ArrayList<Event> reportedEvents) throws Exception {
        new Expectations() {{
            fireButton.readSignal();
            result = "1.0";
        }};

        new Expectations() {{
            reportedEvents.size();
            result = 4;
        }};

        testDataMock.fireButtons.add(fireButton);
        fireDetector = new FireDetector(testDataMock.temperatureDetectors,
                testDataMock.smokeDetectors,
                testDataMock.fireButtons);

        fireDetector.monitorFire();
        assertTrue(reportedEvents.size() == 4);
    }
}
