public class Snack6{

public static void main (String [] args){

   int [] array = {1,2,3,4,5};

   int[] NewArray = TotalOnRun(array);
   
    System.out.println("the original array was ");
       
   for(int check = 0; check < array.length ; check++){
               System.out.printf("%d   ", array[check]);}

  System.out.println();




        System.out.println("the new array is ");
    
  System.out.println(java.util.Arrays.toString(NewArray));
 




}

 public static int[] TotalOnRun(int[]array){
       int[] Newarray = new int[array.length];
        int sum = 0;
     
 for(int check = 0; check < array.length ; check++){
       sum += array[check];

    Newarray [check] = sum;
                              }

        return Newarray;
                                     }  }