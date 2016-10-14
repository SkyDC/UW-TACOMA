/*
	Program Name: Lab3e.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/12/2016
	Purpose: To randomly generate an array with 15 numbers and count the numbers of evens and odds
*/

import java.util.Random;

public class Lab3e {
   public static void main(String[] args) {
      int[] numbers = new int[15];
      fillArray(numbers);
      printArray(numbers);
      oddsAndEvens(numbers);  
   }
   
   public static void fillArray(int[] array) {
      int n = array.length;
      Random r = new Random();
      for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(20) + 1;
      }
   }
   
   public static void printArray(int[] array) {
      System.out.print("Array: ");
      for (int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println();
   }
   
   public static void oddsAndEvens(int[] array) {
      int o = 0;
      int e = 0;
      for (int i = 0; i < array.length; i++) {
         if (array[i]%2 == 0) {
            e++;
         } else {
            o++;
         }
      }
      System.out.println("Even Count: " + e);
      System.out.println("Odd Count: " + o);
   }
}