public class RealTask {

public static void main ( String [] args){

int len = 10 ;

for ( int i = 1 ; i <= len; i++){ 
   for ( int j = 1 ; j <= i ; j++){ 
    System.out.print("*");}
System.out.println("");}

       
for ( int i = 1 ; i <= len; i++){ 
   for ( int j = len ; j >= i ; j--){ 
    System.out.print("*");}
System.out.println("");}

 
for ( int i = 1 ; i <= len; i++){ 
   for ( int j = len ; j >= i ; j--){ 
    System.out.print(" ");}
for ( int k = 1; k <= i ; k++){
     System.out.print("*");}
System.out.println("");}

for ( int i = 1 ; i <= len; i++){ 
   for ( int j = 1 ; j <= i ; j++){ 
    System.out.print(" ");}
for ( int k = len; k >= i ; k--){
     System.out.print("*");}
System.out.println("");}

















  } } 



    