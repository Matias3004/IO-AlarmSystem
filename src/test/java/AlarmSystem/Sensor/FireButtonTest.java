package AlarmSystem.Sensor;

import jdk.jfr.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireButtonTest {

    FireButton fireButton;

    @BeforeEach
    void setUp() {
        fireButton = new FireButton(0, "Warehouse");
    }

    @Test
    void getLocation() {
        String location = fireButton.getLocation();
        assertNotNull(location);
        assertEquals("Warehouse", location);
    }

    @Test
    void readSignal() {
        double result = fireButton.readSignal();
        assertNotNull(result);
        assertTrue((result == 1.0?true:false) == fireButton.isPressed());
    }
}