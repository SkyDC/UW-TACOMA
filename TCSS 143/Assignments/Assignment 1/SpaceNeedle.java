/*
   Program Name: SpaceNeedle.java
   Programmer: Skylar Cowan
   Date: 10/3/2016
   Purpose: To print out a space needle, which
   can be modified by changing the variable SIZE.
*/

public class SpaceNeedle {

   final static int SIZE = 4; //When SIZE is changed, the height/width of the needle will also change.

   public static void main(String[] args) {
      needle();
      upHalfDome();
      spacer();
      botHalfDome();
      needle();
      body();
      upHalfDome();
      spacer();
   }
   
   // Pre: none
   // Post: Prints out the needle portion
   public static void needle() {
      for (int i = 1; i <= SIZE; i++) {
         for (int space = 1; space <= SIZE*3; space++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   // Pre: none
   // Post: Prints out the upper half of needle's dome
   public static void upHalfDome(){
      for (int line = 1; line <= SIZE; line++) {
         for (int space = 1; space <= SIZE-line; space++) {
            System.out.print("   ");
         }  
         System.out.print("__/");
         for (int j = 1; j <= line-1; j++) {
            System.out.print(":::");
         }
         System.out.print("||");
         for (int j = 1; j <= line-1; j++) {
            System.out.print(":::");
         }
         System.out.println("\\__");
         }
   }
   
   // Pre: none
   // Post: Prints horizontal line to space out portions
   public static void spacer() {
      System.out.print("|");
      for (int i = 1; i <= SIZE; i++) {
         System.out.print("\"\"\"\"\"\"");
      }
      System.out.println("|");
   }
   
   // Pre: none
   // Post: Prints out the bottom half of needle's dome
   public static void botHalfDome(){
      for (int line = 1; line <= SIZE; line++) {
         for (int space = 1; space <= (line*2)-2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int j = 1; j <= (((SIZE*3)+1) - (line*2)); j++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   
   // Pre: none
   // Post: Prints out the body of the space needle
   public static void body() {
      for (int line = 1; line <= SIZE * SIZE; line++) {
         for (int space = 1; space <= (SIZE*3)-3; space++) {
            System.out.print(" ");
         }
         System.out.println("|%%||%%|");
      }
   }
}