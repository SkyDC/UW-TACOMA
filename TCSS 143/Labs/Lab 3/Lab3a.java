import java.util.Scanner;
import java.text.DecimalFormat;

/*
	Program Name: Lab3a.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/12/2016
	Purpose: To take a user's input on the price of an item and the amount paid. Then
   calculate the amount of change due.
*/

public class Lab3a {
   public static void main(String[] args) {
      double price = 0;
      double amountPaid = 0;
      int change = 0;
      int dollars = 0;
      int quarters = 0;
      int dimes = 0;
      int nickles = 0;
      Scanner input = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("#.00");
      
      price = getPrice(input);
      amountPaid = getAmountPaid(input);
      System.out.println("The change due is: $" + df.format(amountPaid - price));
      change = (int)((amountPaid - price)*100);
      dollars = getDollars(change);
      change = change%100;
      quarters = getQuarters(change);
      change = change%25;
      dimes = getDimes(change);
      change = change%10;
      nickles = getNickles(change);
      change = change%5;
      System.out.println("This is..: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " 
      + nickles + " nickles, " + change + " pennies");
   }
   
   public static double getPrice(Scanner input) {
      double p;
      do {
         System.out.println("Please enter the price of the item bought:");
         p = input.nextDouble();
         } while(p <= 0);
         return p;
   }
   
   public static double getAmountPaid(Scanner input) {
      double p;
      do {
         System.out.println("Please enter the amount of cash tendered:");
         p = input.nextDouble();
         } while(p <= 0);
         return p;
   }
   
   public static int getDollars(int change) {
      return change/100;
   }
   public static int getQuarters(int change) {
      return change/25;
   }
   public static int getDimes(int change) {
      return change/10;
   }
   public static int getNickles(int change) {
      return change/5;
   }
}