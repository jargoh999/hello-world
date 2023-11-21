public class HeartRates { 

private String firstName ;

private String LastName;

 private int YearOfBirth ;

public void HeartRates ( String firstName,String LastName, int YearOfBirth){ 

                      this.firstName = firstName;
                       this . LastName =  LastName;
			this. YearOfBirth = YearOfBirth;  }


public void setfirstName ( String firstName ) { 

 				this.firstName = firstName; }

public String getfirstName(){ 
			return firstName; 

						}

public void setLastName (  String LastName ) { 

 			this . LastName =  LastName;	}

public String getLastName (){ 

			return LastName; }

public void setYearOfBirth( int YearOfBirth){ 

           this.YearOfBirth =  YearOfBirth;}
public int getYearOfBirth (){ 
      		 return YearOfBirth;}



public int getAge(){ 
                int  Age =   2023 - YearOfBirth ; 

			return Age; }


public double getMaxheartRate(){ 

          double MaxheartRate= 220 - getAge();

 		return MaxheartRate;
 }  


public double getminTargetRate(){
double  MIN =   50 * getMaxheartRate()/100 ;

		return MIN;     } 

public double getmaxTargetRate (){ 
double MAX = 85 * getMaxheartRate()/100 ; 
	return MAX;}
								 
}

