
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireDrill3Test {
    private FireDrill3 fire;

    @BeforeEach
    public void setUp() {

        fire = new FireDrill3();
    }







    @Test
    public void testThatAnArrayOfScoreIsReturned() {


        int[] actual = fire.task1(45, 56, 53, 19, 34, 56, 78, 90, 65, 90);
        int[] expected = {45, 56, 53, 19, 34, 56, 78, 90, 65, 90};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testThatArrayIsDisplayedVertically() {


        FireDrill3 fire = new FireDrill3();

        String actual = fire.task2(45, 56, 53, 19, 34, 56, 78, 90, 65, 90);
        String expected = "45 56 53 19 34 56 78 90 65 90";
        assertEquals(expected, actual);


    }

    @Test
    public void testThatArrayIsDisplayedHorizontally() {




        String actual = fire.task3(45, 56, 53, 19, 34, 56, 78, 90, 65, 90);
        String expected = "45\n56\n53\n19\n34\n56\n78\n90\n65\n90";
        assertEquals(expected, actual);


    }

    @Test
    public void testThatArrayOfEvenIsDisplayed() {
        int[] given = {45, 56, 53, 35};
        int[] expected = fire.task4(given);
        int[] actual = {45, 53};
        assertArrayEquals(expected, actual);


    }

    @Test
    public void testThatArrayOfOddIsDisplayed() {

        int[] given = {45, 56, 53, 35};
        int[] expected = fire.task5(given);
        int[] actual = {56, 35};
        assertArrayEquals(expected, actual);


    }

    @Test

    public void testThatEvenSumIsDisplayed() {




        int[] given = {1, 2, 3, 4};
        int sumOfEven = fire.task6(given);
        assertEquals(4, sumOfEven);


    }

@Test
    public void testThatOddSumIsDisplayed() {




        int[] given = {1, 2, 3, 4};
        int sumOfOdd = fire.task7(given);
        assertEquals(6, sumOfOdd);


    }


    @Test
    public void testThatEvenMinIsDisplayed() {




        int[] given = {1, 2, 3, 4};
        int minEven = fire.task8(given);
        assertEquals(1, minEven);


    }

    @Test
    public void testThatOddMinIsDisplayed() {




        int[] given = {1, 2, 3, 4};
        int minEven = fire.task9(given);
        assertEquals(2, minEven);


    }

    @Test
    public void testThatEvenMaxIsDisplayed() {



        int[] given = {1, 2, 3, 4};
        int minEven = fire.task10(given);
        assertEquals(3, minEven);


    }



    @Test
    public void testThatOddMaxIsDisplayed() {




        int[] given = {1, 2, 3, 4};
        int minEven = fire.task11(given);
        assertEquals(4, minEven);


    }


    @Test
    public void testThatIndicesAreShuffled() {




        int[] given = {1, 2, 3, 4};
        int [] expected = fire.task12(given);
        int [] actual = {2,1,4,3};
        assertArrayEquals(actual, expected);


    }

    @Test
    public void testThatIndicesAreShuffledIfEitherOfTheIndicesIsEven() {




        int[] given = {1, 7, 3, 4};
        int [] expected = fire.task13(given);
        int [] actual = {7,1,3,4};
        assertArrayEquals(actual, expected);


    }

    @Test
    public void testThatIndicesAreShuffledIfEitherOfTheIndicesIsOdd() {




        int[] given = {1, 7, 2, 4};
        int [] expected = fire.task14(given);
        int [] actual = {1,7,4,2};
        assertArrayEquals(actual, expected);


    }

    @Test
    public void testThatIndicesAreShuffledIfBothOfTheIndicesIsNotOdd() {




        int[] given = {1, 4, 2, 3};
        int [] expected = fire.task15(given);
        int [] actual = {4,1,3,2};
        assertArrayEquals(actual, expected);


    }

}
