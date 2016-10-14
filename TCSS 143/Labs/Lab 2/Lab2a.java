/*
	Program Name: Lab2a.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/5/2016
	Purpose: To implement a simple for loop
*/


public class Lab2a
{
   public static void main(String[] args) {  
   // A simple for loop with one statement     			
   for(int index = 0; index < 5 ; index++)
   System.out.println("Index is : " + index);
			
// A Loop body may contain more than one statement. In // that case they should be enclosed in curly braces.
      for(int index = 0; index < 5 ; index++) {
         System.out.println("Index is : " + index);
         index++;
		}
	}
}
