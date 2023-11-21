public class HealthProfile { 

private String firstName ;

private String LastName;

 private int YearOfBirth ;

private String gender ; 

private String DOB ;

private int height ;
  
private int weight;





public void HealthProfile ( String firstName,String LastName,String gender , String DOB , int YearOfBirth, int height , int weight ){ 

                      this.firstName = firstName;
                       this . LastName =  LastName;
			this. YearOfBirth = YearOfBirth; 
                          this. gender = gender ;
		         this. DOB  = DOB ;
			this . height = height;
			this. weight = weight; 
						}

public void setgender( String gender ) { 
		 this. gender = gender ;}

public String getgender ( ){
		return gender;}

public void setDOB ( String DOB ) { 
		this. DOB  = DOB ;}

public String getDOB (){
		return DOB;}

public void setheight( int height){
		this. height  = height ;}

public int getheight () {
		return height;}

public void setweight( int weight){
               this. weight  = weight ;}

public int getweight (){
		return weight;}

public double getBMI(){
        double BMI = getweight() / getheight()*getheight() ;
              return BMI ; }


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

