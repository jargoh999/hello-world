public class Snack2{

public static void main (String [] args){

int [] LetsGo = {1,2,3,4,5};
  System.out.println ("element reversed is : ");
     
    ReversePrinter(LetsGo);
      

}


private static void ReversePrinter(int [] array ){


   int begin = 0; 

   int ending = array.length - 1;


   while (begin < ending ){

   int temporary = array[begin];
   array[begin] = array[ending];
   array[ending] = temporary ;
    begin ++;
    ending --;
    
         }

    for ( int j = 0; j < array.length; j++){
    System.out.printf("%d  ", array[j]);}

} }



