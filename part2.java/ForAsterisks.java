import java.util.Scanner;


public class ForAsterisks{

public static void main ( String [] args){

Scanner input = new Scanner( System.in); 


int main  = 10 ;

for ( int i = 1 ; i < main; i++){ 

     for (int j = i ;j <= main; j++){
      System.out.print("  ");
                             }
      
       for (int k = 1; k < i; k++){ 
          System.out.print("* ");}


        for( int l = 1; l <= i; l++){
            System.out.print("* ");
                                    }

       System.out.println();
                               }
         
           
          for ( int i = 1; i <= main ; i++){   
             
           for( int m = 1; m <= i; m++){
               System.out.print("  ");}

            for ( int n = i ; n < main  ; n++){
                  System.out.print("* ");}
              for ( int o = main; o >= i; o--){ 
		
	           System.out.print("* ");}
                    System.out.println();  
                                         }
                           



                                    }}
						
  










              
 