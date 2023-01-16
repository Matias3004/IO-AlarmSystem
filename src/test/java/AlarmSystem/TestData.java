package AlarmSystem;

import AlarmSystem.Sensor.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestData {

    public ArrayList<TemperatureDetector> temperatureDetectors = new ArrayList<>(
            Arrays.asList(
                    new TemperatureDetector(1, "Corridor", 80.0),
                    new TemperatureDetector(2, "Office", 80.0),
                    new TemperatureDetector(3, "Toilet", 80.0),
                    new TemperatureDetector(4, "Warehouse", 80.0),
                    new TemperatureDetector(5, "Warehouse", 80.0)
            )
    );

    public ArrayList<SmokeDetector> smokeDetectors = new ArrayList<>(
            Arrays.asList(
                    new SmokeDetector(1, "Corridor", 50.0),
                    new SmokeDetector(2, "Office", 30.0),
                    new SmokeDetector(3, "Toilet", 60.0),
                    new SmokeDetector(4, "Warehouse", 10.0),
                    new SmokeDetector(5, "Warehouse", 10.0)
            )
    );

    public ArrayList<FireButton> fireButtons = new ArrayList<>(
            Arrays.asList(
                    new FireButton(1, "Corridor"),
                    new FireButton(2, "Office"),
                    new FireButton(3, "Warehouse"),
                    new FireButton(4, "Warehouse")
            )
    );

    public ArrayList<OpeningDetector> openingDetectors = new ArrayList<>(
            Arrays.asList(
                    new OpeningDetector(1, "Entrance doors"),
                    new OpeningDetector(2, "Office windows"),
                    new OpeningDetector(3, "Warehouse windows"),
                    new OpeningDetector(4, "Warehouse windows"),
                    new OpeningDetector(5, "Warehouse ramp")
            )
    );

    public ArrayList<MovementDetector> movementDetectors = new ArrayList<>(
            Arrays.asList(
                    new MovementDetector(1, "Corridor", 0.5),
                    new MovementDetector(2, "Office", 0.5),
                    new MovementDetector(3, "Warehouse", 0.5),
                    new MovementDetector(4, "Warehouse", 0.5)
            )
    );
}
