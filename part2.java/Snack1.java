public class Snack1{

public static void main (String [] args){

int [] array = {1,2,3};

int largest = ReturnLargestElement(array );

 System.out.printf("the largest element is %d%n ",largest );



}



private static int  ReturnLargestElement(int [] array){

     int largestElem = array[0];


for  ( int check = 0; check < array.length; check++){

    

     if (array[0] < array[check] ){ 

         largestElem = array[check];

                  }

    
   
   
       
} 
    return largestElem;
                                  
}}















