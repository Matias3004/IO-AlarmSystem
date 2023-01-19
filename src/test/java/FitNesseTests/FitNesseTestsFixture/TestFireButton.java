package FitNesseTests.FitNesseTestsFixture;

import fit.ColumnFixture;

public class TestFireButton extends ColumnFixture {

    SetUp setUp = new SetUp();

    public String getLocationTest() {
        return setUp.getFireButton().getLocation();
    }

    public double readSignalTest() {
        return setUp.getFireButton().readSignal();
    }
}
