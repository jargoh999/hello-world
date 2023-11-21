public class Clock{

private int hour;

private int minute;

private int second;

public Clock( int hour , int minute, int second ){
		if ( hour <= 24){
                  this.hour = hour;}

		if ( minute <= 60){ 
		  this.minute = minute;}


		if ( second <= 60){
		  this.second = second;}

					} 

public void sethour ( int hour ) { 

			if ( hour <= 24){
                  this.hour = hour;} 
					}

public void setminutes (int minute ) { 

			if ( minute <= 60){ 
		  this.minute = minute;}

						}

public void setsecond ( int second){

			if ( second <= 60){
		  this.second = second;}

						}

public int gethour(){ 
			return hour; }


public int getminutes(){ 
			return minute; }

public int getsecond(){ 
			return second; }




public void DisplayTime(){

  System.out.printf("Time is : %d : %d : %d ", gethour() , getminutes(), getsecond());

}




}