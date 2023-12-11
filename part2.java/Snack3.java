public class Snack3{

public static void main (String [] args){

int [] array1 = {1,2,3,4,5,6,7};

    OddElemprinter(array1);



}


private static void OddElemprinter(int [] array){
              
     for (int check = 1; check < array.length; check++){
              if ( check % 2 != 0){ 
                 System.out.printf("%d   ", array[check]);
                   }
                                                  } }}


