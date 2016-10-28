/*
	Program Name: Lab4a.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: Take accept user's input with a name of a file to open and read
   then print out the number of words/lines in the file. In addition, a
   file named Results.txt will be produced with the same information
   from the console output.
*/

import java.util.Scanner;
import java.io.*;

public class Lab4a {
   public static void main(String[] args) {
      Scanner read = null;
      System.out.print("Enter the name of the file: ");
      Scanner input = new Scanner(System.in);
   
      String name = input.nextLine();
      
      try {
         read = new Scanner(new FileInputStream(name));
      } 
      catch (FileNotFoundException e) {
         System.out.println("File could not be found or opened.");
         System.exit(0);
      }
      
      readWriteFile(read);
   }
   
   public static void readWriteFile(Scanner f) {
      int words = 0;
      int lines = 0;
      while (f.hasNextLine()) {
         String line = f.nextLine();
         lines++;
         for (String token : line.split("\\s+")) {
            if (!token.isEmpty()) {
               words++;
            }
         }
      }
      System.out.println("Total number of words: " + words);
      System.out.println("Total number of lines: " + lines);
    
      PrintWriter toFile = null;
      File results;
    
      try {
         results = new File("Results.txt");
         toFile = new PrintWriter(results);
      } 
      catch (IOException e) {
         System.out.println("Could not write to file.");
         System.exit(0);
      }
    
      toFile.println("Total number of words: " + words);
      toFile.println("Total number of lines: " + lines);
      toFile.close();
   }
}