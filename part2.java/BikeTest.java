import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike bike;
    @BeforeEach
    public void setUp(){
        bike = new Bike();
        }


    @Test
    public void testThatTheBikeIsOn (){

        assertFalse(bike.isOn());
        bike.powerOn();
        assertTrue(bike.isOn());
    }
    @Test
public void testThatBikeIsOff(){
    assertFalse(bike.isOn());
    bike.powerOn();
    assertTrue(bike.isOn());
    bike.powerOff();
    assertFalse(bike.isOn());
}
@Test
public void testThatBikeCanAccelerate(){
        bike.powerOn();
        for(int movement = 0; movement < 20; movement++)
            bike.accelerate();


    assertEquals(20,bike.getBikeSpeed());
}

@Test
    public void testThatBikeCanDecelerate(){

        bike.powerOn();
        for(int movement = 1; movement < 44; movement++)
            bike.accelerate();

            bike.accelerate();

        for(int movement = 1; movement < 44; movement++)
            bike.decelerate();

        assertEquals(0,bike.getBikeSpeed());

    }


    @Test
    public void testThatGearCanBeSwitched(){
        bike.powerOn();
        for(int movement = 15; movement >= 1 ; movement--)
            bike.accelerate();


        assertEquals(1,bike.switchGear());

    }


}
