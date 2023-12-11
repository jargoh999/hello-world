public class Snack9{ 

public static void main (String [] args){
   int [] array = {1,2,3,4,5};
   
int sum = SumArray(array);

System.out.printf("sum of the element is %d%n",sum);

   }

   private static int SumArray(int [] array){
                 int sum = 0;
                   
           for ( int breaker = 0 ; breaker < array.length; breaker++){
                       
                      sum += array[breaker];

                  
								}

           
                  return sum; }

                                          }
         
