/*
	Program Name: Lab4b.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: To accept user input with one of four predetermined names
   and then to return the popularity of that specific name from the
   year 1900 to 2000
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lab4b {
   public static void main(String[] args) {
      Scanner file = null;
      System.out.print("Enter a name: ");
      Scanner input = new Scanner(System.in);
      String name = input.nextLine();
      
      try {
         file = new Scanner(new FileInputStream("population.txt"));
      } 
      catch (FileNotFoundException e) {
         System.out.println("File could not be found or opened.");
         System.exit(0);
      }
      
      displayStats(file, name);
   }
   
   public static void displayStats(Scanner f, String name) {
      boolean found = false;
      String word = "";
      while (f.hasNext()) {
         word = f.next();
         if (word.equals(name)) {
            found = true;
            break;
         }
      }
      if (found) {
         System.out.println("Statistics on the name \"" + name + "\"");
         for (int i = 0; i <= 10; i++) {
            System.out.println((1900 + i * 10) + ": " + f.nextInt());
         }
      } else {
         System.out.println("Name not found in the file.");
      }
   }
}