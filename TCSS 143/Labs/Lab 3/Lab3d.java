/*
	Program Name: Lab3d.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/12/2016
	Purpose: To take a user's First and Last name as well as 3 exam scores to find their grade
*/

import java.util.Scanner;

public class Lab3d {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String lastName;
      String firstName;
      int exam1;
      int exam2;
      int exam3;
      char grade;
      boolean cont = true;
      
      do {
      lastName = getLast(input);
      firstName = getFirst(input);
      exam1 = getScore(input, 1);
      exam2 = getScore(input, 2);
      exam3 = getScore(input, 3);
      grade = calcGrade(exam1, exam2, exam3);
      display(lastName, firstName, grade);
      System.out.println("1 - Add another student | 0 - Quit");
      if (input.nextInt() == 0) {
         cont = false;
      } else {
         input.nextLine();
      }
      } while (cont);
   }
   
   public static String getLast(Scanner input) {
      String n;
      System.out.println("Enter last name:");
      do {
         n = input.nextLine();
         if (n.length() == 0) {
            System.out.println("Oops! Nothing was entered.");
         }
      } while (n.length() < 1);
      
      return n;
   }
   
   public static String getFirst(Scanner input) {
      String n;
      System.out.println("Enter first name:");
      do {
         n = input.nextLine();
         if (n.length() == 0) {
            System.out.println("Oops! Nothing was entered.");
         }
      } while (n.length() < 1);
      
      return n;
   }
   
   public static int getScore(Scanner input, int e) {
      int s;
      do {
         System.out.println("Enter a score for exam " + e + ":");
         s = input.nextInt();
         if (s < 0) {
            System.out.println("Looks like you entered a number below 0, try again");
         }
      }  while (s < 0);
      
      return s;
   }
   
   public static char calcGrade(int e1, int e2, int e3) {
      double g = ((e1*.25) + (e2*.30) + (e3*.45));
      if (g >= 90) {
         return 'A';
      } else if (g >= 80) {
         return 'B';
      } else if (g >= 70) {
         return 'C';
      } else if (g >= 60) {
         return 'D';
      } else {
         return 'F';
      }
   }
   
   public static void display(String l, String f, char grade) {
      System.out.println("LastName\t FirstName\t LetterGrade");
      System.out.println(l + "\t\t\t" + f + "\t\t\t\t" + grade);
      System.out.println();
   }
}