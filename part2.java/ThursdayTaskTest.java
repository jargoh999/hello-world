

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThursdayTaskTest {

    @Test
    public void testThatElementCanBeAddedAtTheEndOfTheList(){
        ThursdayTask task = new ThursdayTask();
        int [] sample = {1,2,3};
        int [] expected = {1,2,3,2,4,6};
        int [] result = task.doubleLengthAndElement(sample);
        assertArrayEquals(expected,result);
    }



}