/*
	Program Name: Lab2b.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/5/2016
	Purpose: To draw a pyramid using nested for loop
*/


public class Lab2b
{
   public static void main(String[] args) { 
   
      // outer loop
      for(int i=1; i<= 5 ;i++) {
         // inner nested loop 
         for(int j=0; j < i; j++) {
            System.out.print("*");
         }
      
      // Generate a new line
         System.out.println("");
      }
   }
}
