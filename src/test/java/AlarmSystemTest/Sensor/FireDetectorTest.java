package AlarmSystemTest.Sensor;

import AlarmSystemTest.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FireDetectorTest {

    TestData testData;

    @BeforeEach
    void setUp() {
        testData = new TestData();
    }

    @Test
    @DisplayName("Testing if events are reported by detectors")
    void testMonitorFire() {

    }
}
