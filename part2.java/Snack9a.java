public class Snack9a{ 

public static void main (String [] args){
   int [] array = {1,2,3,4,5};
   
int sum = SumArray(array);

System.out.printf("sum of the element is %d%n",sum);

   }

   private static int SumArray(int [] array){
           int sum = 0;
                   
           int breaker = 0 ; 



     while ( breaker <  array.length  ){
              sum += array[breaker];

               ++breaker; 
                       
 

                  
                  	}

           
                  return sum; }

                                          }



         