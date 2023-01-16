package AlarmSystem.Sensor;

import AlarmSystem.Event.Event;
import AlarmSystem.Event.EventType;
import AlarmSystem.TestData;
import AlarmSystem.Sensor.FireDetector;
import jdk.jfr.Category;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Category("Zadanie 3")
public class FireDetectorTest {

    TestData testData;
    FireDetector fireDetector;

    ArrayList<Event> reportedEvents;


    @BeforeEach
    void setUp() {
        testData = new TestData();
        fireDetector = new FireDetector(testData.temperatureDetectors, testData.smokeDetectors, testData.fireButtons);
        testData.temperatureDetectors.get(0).setValue(420);
        testData.temperatureDetectors.get(1).setValue(420);
        testData.temperatureDetectors.get(3).setValue(420);
    }

    @Test
    @DisplayName("ContainsEventByLocationType method works as intended")
    @Order(0)
    void ContainsEventByLocationTypeTest() throws Exception {
        fireDetector.activate();
        fireDetector.monitorFire();
        reportedEvents = fireDetector.getReportedEvents();
        assertTrue(fireDetector.containsEventByLocationType(reportedEvents.get(0).getLocation(), reportedEvents.get(0).getType()));
        assertFalse(fireDetector.containsEventByLocationType(testData.temperatureDetectors.get(2).getLocation(), EventType.FIRE));
        assertFalse(fireDetector.containsEventByLocationType(testData.temperatureDetectors.get(0).getLocation(), EventType.BURGLARY));
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            fireDetector.containsEventByLocationType(null, null);
        }, "NullPointerException expected");
    }
    @Test
    @DisplayName("Fire detector reports fires")
    @Order(1)
    void testMonitorFire() throws Exception {
         reportedEvents = fireDetector.getReportedEvents();
        assertEquals(0, reportedEvents.size());

        fireDetector.activate();
        fireDetector.monitorFire();

        reportedEvents = fireDetector.getReportedEvents();
        assertTrue(reportedEvents.size() > 0);
    }

}
