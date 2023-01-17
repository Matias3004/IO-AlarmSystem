package JMockit.AlarmSystem.Sensor;

import AlarmSystem.Sensor.FireButton;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Test;

public class FireButtonMockTest {

    @Test
    public void getLocationTest(@Mocked FireButton fireButton) {
        new Expectations() {{
//           fireButton = new FireButton(1, "Corridor");
            fireButton.getLocation();
            result = "Corridor";
        }};

        fireButton.getLocation();
    }

    @Test
    void readSignalTest(@Mocked FireButton fireButton) {
        new Expectations() {{
            fireButton.readSignal();
            result = 1.0;
        }};

        fireButton.readSignal();
    }
}
