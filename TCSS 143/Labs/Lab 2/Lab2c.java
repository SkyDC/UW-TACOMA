/*
	Program Name: Lab2c.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/5/2016
	Purpose: To calculate and display the total cost of a meal
   after a tip was brought into the equation
*/

public class Lab2c {

   public static void main(String[] args) {
   double mealCost = 20.00;
   double tipPct = 0.15;
   double tipAmnt = calculateTipAmount(mealCost, tipPct);
   double totalCost = calculateTotalCost(mealCost, tipAmnt);
   display(totalCost, tipAmnt);
   }
   
   public static double calculateTipAmount(double cost, double tipP) {
      return cost*tipP;
   }
   
   public static double calculateTotalCost(double cost, double tipA) {
      return cost + tipA;
   }
   
   public static void display (double total, double tip) {
      System.out.println("Total cost: $" + total);
      System.out.println("Tip: $" + tip);
   }
}