package FitNesseTests.FitNesseTestsFixture;

import fit.ColumnFixture;

import java.util.Objects;

public class TestFireButton extends ColumnFixture {
    String location;
    double signal;

    SetUp setUp = new SetUp();

    public boolean getLocationTest() {
        setUp.getFireButton().setLocation("Korytarz");

        if (Objects.equals(location, "null"))
            location = null;

        return setUp.getFireButton().getLocation().equals(location);
    }

    public double readSignalTest() {
        return setUp.getFireButton().updateReadings();
    }

    public void setLocation(String loc){
        setUp.getFireButton().setLocation(loc);
    }
}
