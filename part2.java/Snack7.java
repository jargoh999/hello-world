public class Snack7{

public static void main (String [] args){

 int[] array = {1,2,3};
 int[] array1 = {7,8,9};

 int[] Darray = ConcArrs(array,array1);

System.out.println(java.util.Arrays.toString(Darray));




}

private static int[] ConcArrs(int[] array, int[] array1){

              int[] Newone = new int[array.length + array1.length]; 

             for ( int j = 0; j < array.length ; j++){
                    
                     Newone[j] = array[j];
                                              }
                      
            for ( int i = 0; i < array1.length ; i++){
                    
                       Newone[array.length + i ] = array1[i];}


                  return Newone; } }
                             