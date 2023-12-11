public class Snack5{

public static void main (String [] args){

int [] array1 = {1,2,3,4,5,6,7};

int ElementToCheck = 5;

if(isInarray(array1,ElementToCheck)){

 System.out.println( "this element is present in array");}


else{

    System.out.println("this element is not present in array");}


}

private static boolean  isInarray( int [] array , int ElementToCheck ) {
                

   for( int check = 0; check < array.length ; check++){
           if ( array[check] == ElementToCheck ){ 
                    return true;
                                      }

      }


               return false;    }
 
 

            

}


   

