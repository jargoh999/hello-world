public class MyArrayMethods { 
 
  public static void main (String [] args ){
  
  MyArrayMethods arr = new MyArrayMethods ();
   int [] a = { 7,6,3,4,8,4,9,9,1};
  int [] newO = arr.sortIt(a);
  boolean b = arr.sortElem(newO,6);
      System.out.println(b);
  }
 
 
 
   public int []  sortIt( int [] jinx ){
   
   
         int [] vinx = new int [jinx.length];
         
         for ( int i = 0; i < jinx.length ; i++){ 
                 for (int j = i + 1 ; j < jinx.length ; j++){
                if ( jinx[i] > jinx[j]  ) {
                  int temp = jinx[i];
                 jinx[i] = jinx[j];
                  jinx[j] = temp;
                       }   
                 }} 
        for (int m = 0; m < jinx.length ; m++){ 
             vinx[m] = jinx[m];
             }

             return vinx;
             

  }

    public boolean sortElem ( int [] jinx, int elem ){

      for (int i = 0; i < jinx.length ; i++){
           if ( jinx [i] == elem ){
               System.out.printf("element was found at index %d%n ",i);
               return true; } }
           return false; }





             }     

