package JUnit.AlarmSystem.Sensor;

import AlarmSystem.Sensor.FireButton;
import jdk.jfr.Category;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Category("FireButton Test")
public class FireButtonTest {

    FireButton fireButton;

    @BeforeEach
    void setUp() {
        fireButton = new FireButton(0, "Warehouse");
    }

    @Test
    @DisplayName("Getting location of Fire Buttons")
    @Order(0)
    void getLocation() {
        String location = fireButton.getLocation();
        assertNotNull(location);
        assertEquals("Warehouse", location);
    }

    @Test
    @DisplayName("FireButton reports if it was pressed or not")
    @Order(1)
    void readSignal() {
        double result = fireButton.readSignal();
        assertNotNull(result);
        assertTrue((result == 1.0?true:false) == fireButton.isPressed());
    }
}