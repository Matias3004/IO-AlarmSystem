package FitNesseTests.FitNesseTestsFixture;

import AlarmSystem.Sensor.FireButton;
import AlarmSystem.Sensor.FireDetector;
import AlarmSystem.Sensor.SmokeDetector;
import AlarmSystem.Sensor.TemperatureDetector;

import fit.Fixture;
import java.util.ArrayList;

public class SetUp extends Fixture {

    static FireDetector fireDetector;

    static TemperatureDetector temperatureDetector;
    static SmokeDetector smokeDetector;
    static FireButton fireButton;

    static ArrayList<TemperatureDetector> temperatureDetectors = new ArrayList<>();
    static ArrayList<SmokeDetector> smokeDetectors = new ArrayList<>();
    static ArrayList<FireButton> fireButtons = new ArrayList<>();

    public SetUp() {
        temperatureDetector = new TemperatureDetector(1, "Biuro", 80.0);
        smokeDetector = new SmokeDetector(1, "Magazyn", 40.0);
        fireButton = new FireButton(1, "Korytarz");

        temperatureDetectors.add(temperatureDetector);
        smokeDetectors.add(smokeDetector);
        fireButtons.add(fireButton);

        fireDetector = new FireDetector(temperatureDetectors, smokeDetectors, fireButtons);
    }

    public FireDetector getFireDetector() {
        return fireDetector;
    }

    public TemperatureDetector getTemperatureDetector() {
        return temperatureDetector;
    }

    public SmokeDetector getSmokeDetector() {
        return smokeDetector;
    }

    public FireButton getFireButton() {
        return fireButton;
    }

    public ArrayList<TemperatureDetector> getTemperatureDetectors() {
        return temperatureDetectors;
    }

    public ArrayList<SmokeDetector> getSmokeDetectors() {
        return smokeDetectors;
    }

    public ArrayList<FireButton> getFireButtons() {
        return fireButtons;
    }
}
