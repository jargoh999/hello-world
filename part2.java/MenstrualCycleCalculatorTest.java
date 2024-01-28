import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualCycleCalculatorTest {

    @Test
    public void testThatMenstrualCalculatorAppExist() {
        MenstrualCycleCalculator menstrualCalculator = new MenstrualCycleCalculator();

        assertNotNull(menstrualCalculator);

    }

    @Test

    public void testThatPeriodDateIsPrecise() {
        MenstrualCycleCalculator menstrualCalculator = new MenstrualCycleCalculator();
        String[] verifier = menstrualCalculator.getLastPeriodDate("2002-02-14");
        String[] Expected = {"2002", "02", "14"};
        assertArrayEquals(Expected, verifier);

    }

    @Test
    public void testThatNextCycleIsValid() {

        MenstrualCycleCalculator menstrualCalculator = new MenstrualCycleCalculator();
        boolean isValid = menstrualCalculator.isValidCycle(2002, 11, 23);

        assertTrue(isValid);
    }

    @Test
    public void testThatOvulationMinimumRangeIsAccurate() {

        MenstrualCycleCalculator menstrualCalculator = new MenstrualCycleCalculator();
        String[] date = {"2002", "02", "14"};
        String verifier = menstrualCalculator.ovulationMinimumRange(date);
        String Expected = "2002 - FEBRUARY - 23";
        assertEquals(Expected, verifier);
    }

    @Test
    public void testThatOvulationMaximumRangeIsAccurate() {

        MenstrualCycleCalculator menstrualCalculator = new MenstrualCycleCalculator();
        String[] date = {"2002", "02", "14"};
        String verifier = menstrualCalculator.ovulationMaximumRange(date);
        String Expected = "2002 - FEBRUARY - 28";
        assertEquals(Expected, verifier);
    }


    }

