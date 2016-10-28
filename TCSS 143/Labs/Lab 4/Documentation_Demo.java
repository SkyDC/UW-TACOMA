/* 
* TCSS 143 - Winter 2016
* Instructor: David Schuessler 
* Documentation of code demo 
*/ 

import java.util.Scanner; 

/** 
* Generates a class average on a series of student test grades. 
* 
* @author Skylar Cowan sdcowan@uw.edu 
* @version 21 October 2016 
*/ 
public class Documentation_Demo { 
// constants (static final fields) 
/** A default value for the number of students. */ 
   public static final int TOTAL_STUDENTS = 10; 

/** 
* Driver method of the class average processing. 
* 
* @param theArgs is used for command line input. 
*/ 
   public static void main(String[] theArgs) { 
      Scanner console = new Scanner(System.in); // Scanner-keyboard input. 
   // The following is an array - to be discussed formally in week 2. 
      int[] testScores = new int[TOTAL_STUDENTS]; // Self-documenting name. 
      double classAverage = 0.0; // Same as above which means 
                           // no need for these comments. 
      int totalPassed = 0; 
      getTestScores(testScores, console); 
      classAverage = getTestAverage(testScores); 
      totalPassed = getTotalPassed(testScores); 
      displayResults(testScores, classAverage, totalPassed);
   } 
/** 
* Reads all the test scores from the console. 
* 
* @param theTestScores is the array to hold all the scores. 
* @param theConsole is a Scanner to read from the keyboard. 
*/ 
   public static void getTestScores(int[] theTestScores, Scanner theConsole) {
      for (int testNumber = 1; testNumber <= TOTAL_STUDENTS; testNumber++) { 
         System.out.printf("Enter test Score #%2d: ", testNumber); 
         theTestScores[testNumber - 1] = theConsole.nextInt(); 
      } 
      System.out.println(); 
   }
// Continued next page ---->
/** 
* Generates and returns the average of the test scores. 
* 
* @param theTestScores is the array of test scores.
* @return the average of all the test scores. 
*/ 
   public static double getTestAverage(int[] theTestScores) { 
      double sum = 0.0;
      for (int testIndex = 0; testIndex < TOTAL_STUDENTS; testIndex++) { 
         sum += theTestScores[testIndex]; 
      } 
      return sum / TOTAL_STUDENTS; } 

/** 
* Counts and returns the total of passing scores. Instead of using the preferred
* for loop to process an array, this method does the same using a while loop. 
* 
* @param theTestScores is the array of test scores. 
* @return a count of how many scores were above 75% 
*/ 
   public static int getTotalPassed(int[] theTestScores) { 
      int totalPassingSum = 0; // 3 sections of for loop header:
      int testIndex = 0; // 1. Initialize 
      while (testIndex < TOTAL_STUDENTS) { // 2. Test condition 
         if (theTestScores[testIndex] >= 75) { 
            totalPassingSum++; 
         } 
         testIndex++; // 3. Increment 
      } 
      return totalPassingSum; 
   } 

/** 
* Displays the results (class average and number or passing scores). 
* 
* @param theTestScores is the array of test scores. 
* @param theClassAverage contains the average of all scores. 
* @param theTotalPassed contains how many scores were >= 75. 
*/ 
   public static void displayResults(int[] theTestScores, 
                                    double theClassAverage, 
                                    int theTotalPassed) { 
      String output = "The class average = " + theClassAverage + "%\n" + 
                      "The total Passing = " + theTotalPassed + "\n" + 
                      "All the test scores are:\n"; 
   
   // Concatenate all test scores to output, one per line. 
      for (int testIndex = 0; testIndex < TOTAL_STUDENTS; testIndex++) { 
         output += String.format("\t Test #%2d:%4d\n", 
                                   testIndex + 1, 
                                   theTestScores[testIndex]); 
      } 
   
   // Display the results to the console. 
      System.out.println(output); 
   } 
}