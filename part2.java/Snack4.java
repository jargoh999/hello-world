public class Snack4{

public static void main (String [] args){

int [] array1 = {1,2,3,4,5,6,7};

    EvenElemprinter(array1);





}

private static void EvenElemprinter( int [] array ){ 

       for (int count = 0 ; count < array.length ; count++ ){

               if ( count % 2 == 0 ) 
                    System.out.printf("%d    ", array[count]);
                                                  }



  } 

}