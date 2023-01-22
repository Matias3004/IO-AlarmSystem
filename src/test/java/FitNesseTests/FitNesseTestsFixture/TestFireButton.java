package FitNesseTests.FitNesseTestsFixture;

import FitNesseTests.FitNesseTestsFixture.SetUp;
import fit.ColumnFixture;

import java.util.Set;

public class TestFireButton extends ColumnFixture {
    String location;
    SetUp setUp = new SetUp();
    public boolean getLocationTest() {
        setUp.getFireButton().setLocation("Korytarz");
        return setUp.getFireButton().getLocation().equals(location);
    }

    public void setLocation(String loc){
        setUp.getFireButton().setLocation(loc);
    }
}
