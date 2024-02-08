public class ThursdayTask {

    public static int[] doubleLengthAndElement(int[] element) {
        int[] newElements = new int[element.length + element.length];
        for (int i = 0; i < newElements.length; i++) {
            if (i < element.length )newElements[i] = element[i];
            if (newElements[i] == 0)newElements [i] = element[i - element.length ] * 2;
        }


        return newElements;

    }


    public static void main(String[] args) {
        int [] test = {4,5,8};
       int [] result =  doubleLengthAndElement(test);
       System.out.println(java.util.Arrays.toString(result));

    }
}