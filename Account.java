public class Account{

private String name;
private Double balance;



public Account(String name, double balance){

                this.name = name;
              if (balance > 0 )
               this .balance = balance;
                 				}



 public void setName ( String name ) { 

                 this.name = name;
					}

public String getName(){

		return name;

				}

public void deposit( double DepositAmount){


         if (DepositAmount > 0) {
		balance = balance + DepositAmount;}

						}


public void withdraw ( double WithdrawalAmount) {

          if ( WithdrawalAmount > 0 && WithdrawalAmount < balance ) { 

balance = balance - WithdrawalAmount ;
						}
}

public double getBalance () {


	 return balance ; 
          	          }


 }

             











