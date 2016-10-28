/*
	Program Name: Lab4d.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: To accept user input for a 3x3 integer array which will
   then be tested to see if the numbers entered create a magic
   square or not.
*/

import java.util.*;

public class Lab4d {
   public static void main(String[] args) {
      // Test magic square {{2,7,6}, {9,5,1}, {4,3,8}};
      int[][] square = new int[3][3];
      int num;
      
      Scanner input = new Scanner(System.in);
      System.out.println("Enter 9 numbers with a value of 1 to 9:");
      for (int r = 0; r < square.length; r++) {
         for (int c = 0; c < square[r].length; c++) {
            System.out.print("(r" + (r+1) + ",c" + (c+1) + "): ");
            num = validate(input, input.nextInt());
            square[r][c] = num;
         }
      }
      
      System.out.println("Is it a magic square? " + magicSquare(square));
   }
   
   public static boolean magicSquare(int[][] matrix) {
      int sum = 0;
      
      // Compute potential sum
      for (int i = 0; i < matrix[0].length; i++) {
         sum = sum + matrix[0][i];
      }
      
      // Check that all rows are equal to sum
      for (int i = 1; i < matrix.length; i++) {
         if (!checkRow(matrix, i, sum)) {
            return false;
         }
      }
      
      // Check that all columns are equal to sum
      for (int i = 0; i < matrix.length; i++) {
         if (!checkCol(matrix, i, sum)) {
            return false;
         }
      }
      
      // Check diagonals equal to sum
      if (!checkDiagonals(matrix, sum)) {
         return false;
      }
      
      return true;
   }
   
   private static boolean checkRow(int[][] matrix, int r, int sum) {
      int s = 0;
      for (int i = 0; i < matrix[r].length; i++) {
         s = s + matrix[r][i];
      }
      
      return s == sum;
   }
   
   private static boolean checkCol(int[][] matrix, int c, int sum) {
      int s = 0;
      for (int i = 0; i < matrix.length; i++) {
         s = s + matrix[i][c];
      }
   
      return s == sum;
   }
   
   private static boolean checkDiagonals(int[][] matrix, int sum) {
      int s1 = 0;
      int s2 = 0;
      for (int i = 0; i < matrix.length; i++) {
         s1 = s1 + matrix[i][i];
         s2 = s2 + matrix[i][matrix.length-i-1];
      }
   
      return (s1 == sum) && (s2 == sum);
   }
   
   private static int validate(Scanner input, int n) {
      int num = n;
      do {
         if (!(num <= 9 && num >= 1)) {
            System.out.println("Number is not valid! Enter another number 1-9:");
            num = input.nextInt();
         } else {
            return num;
         }
      } while (num < 1 || num > 9);
      
      return num;
   }
}