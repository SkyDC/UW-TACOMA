/*
	Program Name: Lab4c.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: To receive 10 different employee ID#s and their sales
   amounts then to return the highest, lowest, average and to give
   the ability to search for any specific ID.
*/

import java.util.Scanner;

public class Lab4c {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int[] ids = new int[10];
      double[] sales = new double[10];
      double avg;
      int c = 1;
      
      do {
         System.out.print("Enter ID for employee " + c + ": ");
         ids[c-1] = input.nextInt();
         System.out.print("Enter sales amount: $");
         sales[c-1] = input.nextDouble();
         c++;
      } while (c < 11);
      System.out.println("ID\t\t\tSales");
      for (int i = 0; i < ids.length; i++) {
         System.out.println(ids[i] + "\t\t" + sales[i]);
      }
      highestSales(ids, sales);
      lowestSales(ids, sales);
      avg = averageSales(sales);
      System.out.println("Employees with below average sales: ");
      for (int i = 0; i < ids.length; i++) {
         if (sales[i] < avg) {
            System.out.print(ids[i] + " ");
         }
      }
      System.out.println();
      System.out.println("Employees with above average sales: ");
      for (int i = 0; i < ids.length; i++) {
         if (sales[i] > avg) {
            System.out.print(ids[i] + " ");
         }
      }
      System.out.println();
      System.out.print("Enter an ID to search for employee records: ");
      int sID = input.nextInt();
      searchID(ids, sales, sID);
   }
   
   public static void highestSales(int[] ids, double[] sales) {
      double highest = sales[0];
      int employee = 0;
      for (int i = 1; i < sales.length; i++) {
         if (sales[i] > highest) {
            highest = sales[i];
            employee = i;
         }
      }
      System.out.println("Highest sales person ID#: " + ids[employee] + " with sales of $" + sales[employee]);
   }
   
   public static void lowestSales(int[] ids, double[] sales) {
      double lowest = sales[0];
      int employee = 0;
      for (int i = 1; i < sales.length; i++) {
         if (sales[i] < lowest) {
            lowest = sales[i];
            employee = i;
         }
      }
      System.out.println("Lowest sales person ID#: " + ids[employee] + " with sales of $" + sales[employee]);
   }
   
   public static double averageSales(double[] sales) {
      double avg = 0;
      double sum = 0;
      for (int i = 0; i < sales.length; i++) {
         sum += sales[i];
      }
      avg = sum / sales.length;
      System.out.println("The average sales amount was: $" + avg);
      return avg;
   }
   
   public static void searchID(int[] ids, double[] sales, int id) {
      int loc = -1;
      for (int i = 0; i < ids.length; i++) {
         if (ids[i] == id) {
            loc = i;
            break;
         }
      }
      if (loc == -1) {
         System.out.println("The targetted ID you were searching for could not be found.");
      } else {
         System.out.println("Employee ID: " + ids[loc]);
         System.out.println("Employee sales: $" + sales[loc]);
      }
   }
}