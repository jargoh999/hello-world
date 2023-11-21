
import java.util.Scanner; 

public class MeAlone {
public static void main ( String [] args) { 

Scanner input = new Scanner(System.in ) ;

int total = 0 ;

int counter = 0;

int aCounter = 0;

int bCounter = 0;

int cCounter = 0;

int dCounter = 0;

int eCounter = 0;

int fCounter = 0;


while ( input.hasNext() ){

System.out.print( "enter student grade");

int grade = input.nextInt() ;

switch ( grade / 10 ) { 

       case 9 :
       case 8 :
        aCounter++;
         counter++;

	total+= grade ;
       break;

	case 7:
	bCounter++;
        counter++;
       total+= grade;
        break;

      case 6 :
	cCounter++;
      counter++;
	total+=grade;
	break;
   
       case 5 :
     dCounter++;
     counter++;
     total+=grade;
     break;


   default:
   fCounter++;
   counter++;
   total+= grade ;
   break;

}
}

if ( counter > 0 ) { 

int average = total / counter ;}

else { System.out.print( "enter more than one student grade");
}

System.out.printf (" %d students with an  Average mark of  %d%n %d students had an A%n %d student had a B%n  %d student had a C %n %d student had D%n  %d student failed with F%n ", total, counter , aCounter , bCounter , cCounter , dCounter , fCounter );


}

}






