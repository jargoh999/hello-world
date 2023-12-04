import java.util.Scanner;

public class  NokiaPhones {

public static void main ( String [] args){

Scanner input = new Scanner(System.in);
do{
 
System.out.printf ("%15s%n%s%n","LIST OF MENU FUNCTION, enter ctrl +  Z to quit ");

System.out.print("1-> Phone Book \n" + "2-> Message \n" + "3-> chat \n" + "4-> Call register \n" + "5-> Tone \n" + "6-> Setting \n"+ "7-> Call Divert \n" + "8-> Games \n" + "9-> Calculator \n"+ "10-> Reminders \n" + "11-> Clock \n" + "12-> Profile \n" + "13 -> Sim Services \n" + "Select options : ");


int phoneMenu = input.nextInt();
System.out.print("\n\n");

 switch (phoneMenu){ 
    case 1: System.out.print("PHONE BOOK \n" + "1-> search \n" + "2 -> Service Nos \n" + "3 -> Add Name \n"+ "4 -> Erase\n" + "5 -> Edit \n" + "6 -> Assign tone \n"+ "7 -> Send b'card \n" + "8 -> options \n 1. Type of view \n 2. Memory status \n" + "9 -> Speed dials \n" + "10 -> Voice tags \n" + "select options ");

int phoneBook = input.nextInt();
            
             
     		switch(phoneBook){
                   case 1: System.out.println("welcome to search"); break;         
	     	   case 2: System.out.println("Welcome to service Nos"); break;
                   case 3: System.out.println("welcome to add name "); break;
            	   case 4: System.out.println("Add Name");  break;
                   case 5: System.out.println("Erase"); break; 
                   case 6: System.out.println("Edit"); break;
                   case 7: System.out.println("Assign Tone"); break;
 	           case 8: System.out.printf("%s%n%n %s%n %s%n", "OPTIONS", "1 -> Type of view","2 -> Memory status");
				int options = input.nextInt();

				switch(options){
				  case 1: System.out.println("Welcome to Type of view"); break;
				  case 2: System.out.println("Welcome to Memory satus"); break;
				  default: System.out.println("Wrong command entered "); break;
				  }
                 
                 break;
		 case 9: System.out.print("Welcome to Speed dials"); break;
		 case 10: System.out.print("Welcome to Voice tags"); break;
		 default:  System.out.print("wrong command entered"); break; }

                
             case 2: System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %S%n%n %S%n %s%n %s%n %s%n %S%n%n %s%n %s%n %s%n %s%n %s%n b %s%n %s%n %s%n%n", "messages","->write messages","->inbox","->outbox","->picture messages","->Templates","->Smileys","->Messages settings"," 1.set ","1.messages centre number","    2.messages sent as","    3.messages validity"," 2.Common","    1.delivery reports","    2.reply via same centre","    3.character support","->info services","->voice mailbox number","-> service command editor"," select an action! " );
                           int action = input.nextInt();              
                         switch (action){ 
                             case 1:  System.out.println("write messages"); break;
                             case 2:  System.out.println("inbox"); break;
                             case 3:   System.out.println("outbox"); break;
                             case 4:    System.out.println("picture messages"); break;
                             case 5:   System.out.println("Templates"); break;
                             case 6:   System.out.println("Smileys"); break;
                             case 7:   System.out.printf("%S%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "messages settings"," ->set1 "," 1.message centre number","2.messages sent as ","3.messages validity"," ->common"," 1.delivery reports"," 3.character support"  );
                                            int Msettings = input.nextInt();                                           
                                              
                                            switch (Msettings){
                                             case 1:  System.out.println("set 1"); break;
                                             case 2:   System.out.println("Common"); break;
                                             default: System.out.println("Wrong command entered "); break;}
					     System.out.println("choose an option from above");
 					         int SetOpp = input.nextInt();
						
                                                switch (SetOpp/1){
						 case 1: System.out.println("messages centre number");
						        System.out.println("messages sent as");
					                System.out.println("message validity"); break;
						 case 2: System.out.println("delivery reports"); 
						         System.out.println("reply via same centre");
						         System.out.println("character support");break;
					         default: System.out.println("Wrong command entered ");break; }
                                                              break; 
                                                                               
                             case 8:       System.out.println("info services"); break;
                             case 9:       System.out.println("voice mail number"); break;
                             case 10:      System.out.println("service command editor"); break;    
                                                                                               }break;     

                              case 3:      System.out.println("welcome to chat"); break;   
                                                                 
                              case 4:  System.out.printf("%s%n %s%n %s%n %s%n %s%n %s%n  %s%n %s%n %s%n %s%n %s%n %s%n %s%n %s%n  ","call Register","1.Missed call"," 2.Recieved call","3.Dailed numbers","4.Erase recent call lists","5.clear timers","6.show call costs","1.last call cost","  2.All calls' cost","3.clear counter","7.call cost settings","1.call cost limit","2.Show costs in","8.prepaid credit");                                      
                                    System.out.println("select an option");      
                                    int fourPtion = input.nextInt();
                                    switch(fourPtion){
                                    case 1:  System.out.println("Missed calls"); break;
			            case 2:  System.out.println("Recieved calls"); break;
                                    case 3:  System.out.println("Dailed calls"); break;
                                    case 4:  System.out.println("Erase recent call lists"); break;		     
                                    case 5:  System.out.printf("%s%n %s%n %s%n %s%n %s%n %s%n","show call duration"," 1.last call duration","2. All calls' cost","3. Recieved calls's duration ","Dialed calls' duration ","clear timers" );
                                                            System.out.println("select an option here");
                                                             int hereOptions = input.nextInt(); 
                                                             switch(hereOptions){ 
                                                             case 1:  System.out.println("last call durations ");break;
                                                             case 2:  System.out.println("All calls' costs");break;     
						             case 3:  System.out.println("Recieved calls' duration");break; 
							     case 4:  System.out.println("Dailed calls' duration");break; 
						             case 5:  System.out.println("Clear timers ");break;  
                                                             default: System.out.println("Wrong command entered ");break; }    

                                                                                   break;                 
                                    case 6:  System.out.printf("%s%n %s%n %s%n %s%n ", "show call costs","1. last call cost ","2. all calls' cost ","clear counters");
							   System.out.println("select an option here");
                                                             int hereCptions = input.nextInt(); 
                                                             switch(hereCptions){ 
							     case 1:  System.out.println("check your last call cost");break; 
                                                             case 2:  System.out.println("check all call cost");break;
							     case 3:  System.out.println("clear all counters"); break;
                                                             default: System.out.println("Wrong command entered ");break;   
                                                                                                   } break;
                                                         
                                   case 7:        System.out.printf("%S%n %s%n %s%n","call cost settings", "1.calls' costs limit", "2.show costs in" );
							   System.out.println("select an option here");
                                                                int sevenOpt = input.nextInt();
                                                                switch (sevenOpt){
								case 1 : System.out.println("your call cost limit");break; 
								case 2 : System.out.println("show your costs in");break; 
				                                 default: System.out.println("Wrong command entered ");break;  }
									             break; 
                                  
                                   case 8:          System.out.println("PREPAID CREDIT"); break; 
                                                                                               
                                                           } break;





                                  case 5:          System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %s%n %s%n %s%n %s%n","-->tones", "1.ringing tone","2.ringing volume","3.incoming call alert","4.composer","5.Message alert tone","6.keypad tones","7.warning and games tones","8.vibrating alert","9.screen saver");
						             
											 System.out.println("select an option here");
											   int fifthOpt = input.nextInt();
											   switch (fifthOpt){ 
											   case 1 : System.out.println("Customize your ringing tone");break;
										           case 2 : System.out.println("Adjust your ringing volume");break;  
									                   case 3 : System.out.println("Incoming call alert");break;  
											   case 4 : System.out.println("composer");break; 
										           case 5 : System.out.println("message alert tone");break;
										           case 6 : System.out.println("customize your keypad tones");break;
											   case 7 : System.out.println("warning and game tones");break;
											   case 8 : System.out.println("vibrating alert");break;   
										           case 9 : System.out.println("Screen saver");break;  
											   default: System.out.println("Wrong command entered ");break; 
                                             								    }  break;

                                    case 6:           System.out.printf("%S%n%n %s%n %s%n %s%n %s%n","-->Settings", "1.call settings","2.phone settings","3.Security settings","4.restore  ");
						               
										 	 System.out.println("select an option here");
											   int sixthOpt = input.nextInt();
											   switch(sixthOpt/1){ 
										           case 1 :  System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %s%n","-->call Settings", "1.Automatic redial","2.speed dialing","3.call waiting options","4.own number sending","5.phone line in use ","6.Automatic answer ");
						                                                      System.out.println("select an option here");
											   int Case1Of4 = input.nextInt();
											   switch ( Case1Of4){ 
											   case 1 : System.out.println("Automatic redial");break;
										           case 2 : System.out.println("speed dialing");break;  
									                   case 3 : System.out.println("call waiting options");break;  
											   case 4 : System.out.println("own number sending");break; 
										           case 5 : System.out.println("phone line in use ");break;
										           case 6 : System.out.println("Automatic answer ");break;        
											   default: System.out.println("Wrong command entered ");break;}
													 break;					
                                                                                    						
											   case 2:   System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %s%n","-->phone Settings", "1.language","2.cell info display","3.welcome note","4.network selection","5.Lights ","6.Confirm SIM service actions");
											               System.out.println("select an option here");
											   int Case2Of4 = input.nextInt();
											   switch ( Case2Of4){ 
											   case 1 : System.out.println("language");break;
										           case 2 : System.out.println("cell info display");break;  
									                   case 3 : System.out.println("welcome note");break;  
											   case 4 : System.out.println("network selection");break; 
										           case 5 : System.out.println("Lights");break;
										           case 6 : System.out.println("Confirm SIM service actions ");break;        
											   default: System.out.println("Wrong command entered ");break;}
													 break;					
                                                                                    		
                                                                                           case 3:   System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %s%n","-->security Settings", "1.PIN code request","2.Call barring service","3.Fixed dialling","4.closed user group","5.phone security ","6.change access codes");;
											               System.out.println("select an option here");
											   int Case3Of4 = input.nextInt();
											   switch ( Case3Of4){ 
											   case 1 : System.out.println(".PIN code request");break;
										           case 2 : System.out.println("Call barring service");break;  
									                   case 3 : System.out.println("Fixed dialling");break;  
											   case 4 : System.out.println("closed user group");break; 
										           case 5 : System.out.println("phone security ");break;
										           case 6 : System.out.println("change access codes");break;        
											   default: System.out.println("Wrong command entered ");break;}
													 break;					
                                                                                    		
											   

											    case 4:   System.out.println("Restore factory settings !!! ");break;
																	 } break;





					case 7 :           System.out.println(" call divert "); break; 
					
					case 8 :           System.out.println(" GAME "); break;
                                     
					case 9 :           System.out.println("CALCULATOR"); break;  

                                        case 10:           System.out.println(" REMINDERS "); break; 
                   
                                             						 
                                        case 11 :          System.out.printf("%S%n%n %s%n %s%n %s%n %s%n %s%n %s%n","-->CLOCK ", "1.Alarm clock","2.Clock settings","3.Date Settings","4.Stopwatch","5.Countdown timer ","6.Auto update date and time");
											               System.out.println("select an option here");
                                                                                                int C11 = input.nextInt();
										 switch (C11){
											   case 1 : System.out.println("Alarm clock");break;										
											   case 2 : System.out.println("Clock settings");break;  
									                   case 3 : System.out.println("Date Settings");break;  
											   case 4 : System.out.println("Stopwatch");break; 
										           case 5 : System.out.println("Countdown timer ");break;
										           case 6 : System.out.println("Auto update date and time");break;        
											   default: System.out.println("Wrong command entered ");break;}
													 break;					
                                                                                    		


				       case 12 :             System.out.println(" Profiles "); break;

                                       case 13:               System.out.println("SIM services"); break;

                                      default: System.out.println("Wrong command entered ");break;}
							        					   }
                                  
                                       while ( input. hasNext());
                                   
                                                          


































} 

}
 


 



