public class Snack9b{ 

public static void main (String [] args){
   int [] array = {1,2,3,4,5};
   
int sum = SumArray(array);

System.out.printf("sum of the element is %d%n",sum);

   }

   private static int SumArray(int [] array){
           int sum = 0;
                   
           int breaker = 0 ; 



		do{ 
            


                sum += array[breaker];


               ++breaker; 
                       
 

                  
          } while(breaker < array.length);

           
                  return sum; }

}