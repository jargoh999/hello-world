import java.util.Scanner;
public class ArrayedGradeTest { 


   public static void main (String [] args ){ 

     

       Scanner scan = new Scanner(System.in);
       System.out.println ("no of student ");
       int  gradeLength = scan.nextInt();


        int [] grades = new int [gradeLength]; 
      
       for (int grade = 0; grade < gradeLength ; grade++){ 

                  System.out.println ("enter your grades for student");
                 grades[grade] = scan.nextInt();

      }  

       




       ArrayedGrade myG = new ArrayedGrade("php Semi",grades);


      System.out.printf ( "the course name is %S %n", myG.getCourseName());
      
      myG.gradeReport(); 

                                     } } 


      