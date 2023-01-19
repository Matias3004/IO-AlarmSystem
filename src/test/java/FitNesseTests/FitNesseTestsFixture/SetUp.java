package FitNesseTests.FitNesseTestsFixture;

import AlarmSystem.Sensor.FireButton;
import AlarmSystem.System.Controller;
import fit.Fixture;

public class SetUp extends Fixture {

    static Controller controller;
    static FireButton fireButton;

    public SetUp() {
        controller = new Controller();
        fireButton = new FireButton(1, "Korytarz");
    }

    public FireButton getFireButton() {
        return fireButton;
    }
}
