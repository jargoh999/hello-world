public class Hypotenuse{

public static void main ( String [] args){

  int max = 25;
  System.out.printf("%S%15s%S%15s%S%n","Side1" ,"", "side2","", "hypotenuse");
  
for(int side1 = 1 ; side1 <= max ; side1++){ 
      for( int side2 = 1; side2 <= max ; side2++){ 
            for ( int hyp = 1; hyp <= max ; hyp++){
 
                   if (( side1 * side1 + side2 * side2) == hyp * hyp ) { 
                             int se = side1*side1; int ve = side2*side2; int hy = hyp*hyp ;   
                                System.out.printf("%d%20s%d%20s%d%n",se,"" ,ve,"",hy);}
									    }
										}
                 								   } } } 
															
            

