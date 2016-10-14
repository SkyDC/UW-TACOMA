/*
	Program Name: Lab3c.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/12/2016
	Purpose: To see how many attempts it takes to guess a randomly generated number
*/

import java.util.Scanner;
import java.util.Random;

public class Lab3c {
   public static void main(String[] args) {
      Random r = new Random();
      int number = r.nextInt(100) + 1;
      
      System.out.println("Guess a number 1 to 100");
      guess(number);
   }
      
   public static void guess(int number) {
      Scanner input = new Scanner(System.in);
      int g;
      int t = 0;
      do {
         g = input.nextInt();
         t++;
         if (g < number) {
            System.out.println("Too low!");
         } else if (g > number) {
            System.out.println("Too high!");
         }
      } while (g != number);
      
      System.out.println("Correct! The number was " + number + " it took " + t + " attempts");
      
   }
}
