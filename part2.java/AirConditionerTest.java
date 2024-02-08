import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class AirConditionerTest {
    private AirConditioner airConditioner;

    @BeforeEach
    public void setUp(){

        airConditioner = new AirConditioner();

    }




    @Test
   public void testThatAcCanBeSwitchedOn(){
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        assertTrue(airConditioner.isOn());
    }

    @Test
    public void testThatAcCanBeSwitchedOff(){
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        assertTrue(airConditioner.isOn());
        airConditioner.powerOff();
        assertFalse(airConditioner.isOn());

    }
@Test
   public void testThatTemperatureCanIncrease(){
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        airConditioner.increaseTemperature();
        assertEquals(17,airConditioner.getTemperature());

   }
@Test
    public void testThatTemperatureCanDecrease(){
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        airConditioner.increaseTemperature();
        assertEquals(17,airConditioner.getTemperature());
        airConditioner.decreaseTemperature();
        assertEquals(16,airConditioner.getTemperature());
    }
@Test
    public void testIfTemperatureis30_tempeartureisUnchanged() {
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        for (int count = 1; count < 20; count++) {
            airConditioner.increaseTemperature();
        }
        assertEquals(30, airConditioner.getTemperature());
    }
@Test
    public void testIfTemperatureis16_tempeartureisUnchanged() {
        assertFalse(airConditioner.isOn());
        airConditioner.powerOn();
        for (int count = 1; count < 20; count++) {
            airConditioner.decreaseTemperature();
        }
        assertEquals(16, airConditioner.getTemperature());
    }


    }
