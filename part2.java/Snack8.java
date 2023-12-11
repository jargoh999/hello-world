public class Snack7{

public static void main (String [] args){

 int[] array = {1,2,3};
 int[] array1 = {7,8,9};
 int[] array2 = alternateCombo(array,array1);

 System.out.println( java.util.Arrays.toString(array2));
 	}

private static int[] alternateCombo(int[] array, int[] array1){
             int [] Concatinator = new int [array.length + array1.length];      
                    int token = 0;
                    int count = 0;

    while (count < array.length || count < array1.length ){


                if(count < array.length){
                                         
                 Concatinator [token++] = array[count]; }
                
                if( count < array1.length){
                 
		 Concatinator[token++] = array1[count]; }
                  count++;
                           
 }


        return Concatinator;

}

}