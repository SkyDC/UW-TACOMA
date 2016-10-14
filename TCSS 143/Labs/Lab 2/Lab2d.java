/*
	Program Name: Lab2d.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/5/2016
	Purpose: To calculate yearly interest on an initial investment
   of 1000 and display the results
*/

public class Lab2d {
   final static double INTEREST = .065;
   final static double DEPOSIT = 100;
   
   public static void main(String[] args) {
      double currentBalance = 1000;
      double interestAmnt = 0;
      double newBalance = 0;
      
      System.out.println("Year  Current Balance  Interest    Deposit        New Balance");
      for (int year = 1; year <= 25; year++) {
         interestAmnt = calcInterest(currentBalance);
         newBalance = calcBalance(year, currentBalance, interestAmnt);
         display(year, currentBalance, interestAmnt, newBalance);
         currentBalance = newBalance;
      }
   }
   
   public static double calcBalance(int year, double currentBalance, double interestAmnt) {
      if (year == 1) {
         return currentBalance + interestAmnt;
      } else {
         return currentBalance + interestAmnt + DEPOSIT;
      }
   }
   
   public static double calcInterest(double currentBalance) {
      return (currentBalance * INTEREST);
   }
   
   public static void display(int year, double currentBalance, double interestAmnt, double newBalance) {
      
      System.out.println(year + "\t\t\t$" + Math.round(currentBalance*100)/100.0 + "\t\t\t$" + Math.round(interestAmnt*100)/100.0 + "\t\t$" 
      + DEPOSIT + "\t\t\t$" + Math.round(newBalance*100)/100.0);
   }
}