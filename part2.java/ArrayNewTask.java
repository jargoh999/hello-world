import java.util.stream.IntStream;


public class ArrayNewTask {
    public static int [] modifyArray(int [] elements){
        return IntStream.of(elements).map(x -> x % 2).toArray();
    }
    public static void main(String[] args) {
        int [] values = {1,2,3,4,5,6,7};
        System.out.println(java.util.Arrays.toString(modifyArray(values)));
    }
}
