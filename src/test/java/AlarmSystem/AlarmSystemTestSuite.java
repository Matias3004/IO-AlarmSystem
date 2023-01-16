package AlarmSystem;

import AlarmSystem.Sensor.FireButtonTest;
import AlarmSystem.Sensor.FireDetectorTest;
import AlarmSystem.System.ControllerTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ControllerTest.class, FireButtonTest.class, FireDetectorTest.class})
public class AlarmSystemTestSuite {
}
