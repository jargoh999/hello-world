public class PetrolPurchase{ 


private String place;

private String petrolType;

private int quantity;

private double pricePerLiter ;

private double discount ;


public void petrolPurchase( String place, String petrolType, int quantity,
                 
		double pricePerLiter, double discount){ 


                      this.place = place;
		     this.petrolType = petrolType ;
		     if( quantity > 0 ) {
		      this.quantity = quantity ; }
		      
		    this.pricePerLiter = pricePerLiter;
		    this. discount = discount;

						}

public void setLocation( String place) { 
       
           this.place = place ; } 

public String getLocation(){ 
         return place;
                         }


public void setPetrolType( String petrolType){
            this. petrolType = petrolType ; }

public String getPetrolType(){ 

             return petrolType ; } 


public void setQuantity( int quantity ) {
              if( quantity > 0 ) {
		      this.quantity = quantity ; }
						}


public int getQuantity (){ 
        return quantity;
         		}

public void setPricePerLiter( double pricePerLiter ) { 
              this.pricePerLiter = pricePerLiter;
							} 


public double getPricePerLiter(){ 
			return pricePerLiter; } 


public void setDiscount ( double discount) { 
			this. discount = discount ;
                                                    }


public double getDiscount () { 
			discount = pricePerLiter - ( discount/ 100) * pricePerLiter ; 
                               
                                   return discount ;}

public double getPurchaseAmount(){ 

               double purchaseAmount =  quantity * getDiscount(); 

				return purchaseAmount; }



}





     
      		
      
                         














