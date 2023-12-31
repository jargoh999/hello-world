public class ArrayedGrade{ 

   private String CourseName;
   private int [] grades;


public ArrayedGrade(String CourseName, int [] grades ){ 

      this.CourseName = CourseName ;
      this.grades = grades;


} 


public String getCourseName(){ 

    return CourseName; 

                                 } 


   
public void gradeReport(){ 

      outputGrades();

   System.out.printf("the class average is  : %.2f%n%n",getAverage());

   System.out.printf("the highest Grade is : %d%n%n",getHighest());
   
   System.out.printf("the lowest Grade is : %d%n%n",getLowest());

   System.out.printf("here is the grade distribution bar chart %n%n  ");

                   displayBarChart(); 



                                 } 

public double getAverage (){ 

      int total = 0; 
      

    for(int grade : grades ) { 

         total += grade; }


   double average = (double) total /  grades.length ;
     

    return average ; 

} 

public int getHighest(){

 int largest = grades[0] ;

for ( int i= 0; i < grades.length ; i++ ){

      if (grades [i] > grades[0]){
       largest = grades[i] ; }
  } 

       return largest ;    
} 




public int getLowest(){


int lowest = grades[0];

for ( int i= 0; i < grades.length ; i++ ){

      if (grades [i] < grades[0]){ 
        lowest = grades[i] ;  }

} 


      return lowest ;    

} 
 


public void  displayBarChart(){
  

int [] frequency = new int [11];

 for (int grade : grades ){ 

  ++ frequency[ grade/10 ];
} 


for (int i = 0 ;  i < frequency.length ; i++){ 
     if ( i == 10 ){ 

      System.out.printf ("%d  ", 100  ); } 


   else { 

          System.out.printf ("%n%d - %d",i * 10 , i * 10 + 9 );

}



for ( int asterisk = 0; asterisk < frequency[i] ; asterisk ++ ){

     
      System.out.print (" *");

} 

    System.out.println();


} 

}




public void outputGrades(){


  for (int  students = 0;  students < grades.length; students++ ){ 


   System.out.printf( "student%d  - %d%n", students + 1 , grades[students] );

     
} 

}  



} 

                  


    



  


  


 

    

   