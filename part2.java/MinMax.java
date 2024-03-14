import java.util.Arrays;

public class MinMax {
    public static int[] minAndMax(int [] values){
            int [] minAndMaxOnly = new int[2];
            int [] totalAfterIsolatingValues = new int[values.length];
            for(int valueToIsolate = 0; valueToIsolate< values.length; valueToIsolate++)totalAfterIsolatingValues[valueToIsolate] = Arrays.stream(values).sum() - values[valueToIsolate];
            minAndMaxOnly[0] = Arrays.stream(totalAfterIsolatingValues).min().getAsInt();
            minAndMaxOnly[1] = Arrays.stream(totalAfterIsolatingValues).max().getAsInt();
            return minAndMaxOnly;
    }
    public static void main(String[] args) {
        int [] values = {1,2,3,4};
        System.out.println(Arrays.toString(minAndMax(values)));
    }

}
