import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayToSun {

    public static int [] largestMinusLowest(int [] numbers ){
        int [] value = new int[1];
        int lowest = numbers[0];
        int highest = numbers[0];
        for(var number : numbers){
            if (number < lowest)lowest=number;
            if (number > highest)highest=number;
        }
           value[0] = highest-lowest;
          return value;

    }
    public static void main(String[] args) {
        int [] toCompare = {1,3,4,5,6,7};
       int [] result = largestMinusLowest(toCompare);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testTheFunction(){
        int [] toCompare = {1,3,4,5,6,7};
        int []actual = {6};
        assertArrayEquals(largestMinusLowest(toCompare),actual);


    }
}
