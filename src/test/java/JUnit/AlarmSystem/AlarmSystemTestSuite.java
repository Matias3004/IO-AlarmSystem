package JUnit.AlarmSystem;

import JUnit.AlarmSystem.Sensor.FireButtonTest;
import JUnit.AlarmSystem.Sensor.FireDetectorTest;
import JUnit.AlarmSystem.System.ControllerTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ControllerTest.class, FireButtonTest.class, FireDetectorTest.class})
public class AlarmSystemTestSuite {
}
