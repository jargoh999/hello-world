public class Car{ 

private String Model;

private double Price;

private int Year ;


public  Car( String Model, double Price, int Year ){

this.Model = Model;
if ( Price > 0 ) {
this.Price = Price;
}
this. Year = Year;
}

public void setModel(String Model ) {

this.Model = Model;
}

public String getModel(){

return Model;
                  }


public void SetPrice(double Price){
	if ( Price > 0 ) {
this.Price = Price;
}
			}


public double getPrice(){

return Price;  } 



public void setYear( int Year){

       this. Year = Year;
			}

public int getYear(){

return Year; }

}








