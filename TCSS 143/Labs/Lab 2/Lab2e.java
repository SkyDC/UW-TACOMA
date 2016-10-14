/*
	Program Name: Lab2e.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/5/2016
	Purpose: 
*/
import java.util.Scanner;

public class Lab2e {
   public static void main(String[] args) {
      String NE = "NorthEast", NW = "NorthWest", SE = "SouthEast", SW = "SouthWest";
      double nwSales = 0, neSales = 0, seSales = 0, swSales = 0;
      nwSales = getSales(NW);
      neSales = getSales(NE);
      swSales = getSales(SW);
      seSales = getSales(SE);
      findHighest(nwSales, neSales, swSales, seSales);
   }
   
   public static double getSales(String division) {
      Scanner kb = new Scanner(System.in);
      double input = 0;
      boolean valid = false;
      System.out.println("Enter the sales figure for the " + division + " division:");
      while (!valid) {
         input = kb.nextDouble();
         if (input >= 0.00 ) {
            valid = true;
         } else {
            System.out.println("Please enter a number greater than 0.00");
         }
      }
      return input;
   }
   
   // I couldn't figure out an effective way to link the sales variable to each division
   // hopefully this is sufficient
   public static void findHighest(double a, double b, double c, double d) {
      double highest = a;
      String division = "NorthWest";
      if (b > highest) {
         highest = b;
         division = "NorthEast";
      } 
      if (c > highest) {
         highest = c;
         division = "SouthWest";
      } 
      if (d > highest) {
         highest = d;
         division = "SouthEast";
      }
      System.out.println("The highest division is the " + division + " with a sales record of: $" + Math.round(highest*100)/100.0);
   }
}