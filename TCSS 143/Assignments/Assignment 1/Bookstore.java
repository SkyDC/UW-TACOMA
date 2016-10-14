import java.util.Scanner;
import java.text.DecimalFormat;

/*
   Program Name: Bookstore.java
   Programmer: Skylar Cowan
   Date: 10/5/2016
   Purpose: To receive user input and calculate the number of books that must be ordered, 
   total cost and expected profit for the bookstore. Also, to practice validating the data 
   that is being entered by the user.
*/

public class Bookstore {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("0.00"); // Used to format monetary values to 2 decimals
      int cont = 1;
      double cost; 
      double totalCost = 0; 
      double expectedProfit;
      double orderTotal;
      int currentBooks;
      int prospEnroll;
      int toOrder;
      String isbn;
      String req;
      String book;
      
      // Loop continues as long as cont is 1 --
      // user can enter 0 to exit loop at the end
      while (cont == 1) {
         isbn = getIsbn(input);
         cost = getCost(input);
         currentBooks = getBooks(input);
         prospEnroll = getProspEnroll(input);
         req = getRequired(input);
         book = getBookStatus(input);
         // End of user input
         display(isbn, cost, currentBooks, prospEnroll, req, book);
         toOrder = calcOrder(currentBooks, prospEnroll, req, book);
         orderTotal = calcTotal(toOrder, cost);
         System.out.println("Books needed to order: " + toOrder);
         System.out.println("Total Cost: $" + df.format(orderTotal));
         totalCost+=orderTotal;
         
         System.out.println("\n" + "Do you want to add any more books? (1 to continue, 0 to end)");
         cont = input.nextInt();
         if (cont == 0) {        // 1 - Continue to add more books
            break;               // 0 - End program
         } 
         else {
            input.nextLine();    // Dump input
         }
      }
      
      expectedProfit = calcProfit(totalCost);
      System.out.println("Total cost for all orders: $" + df.format(totalCost));
      System.out.println("Expected Profit: $" + df.format(expectedProfit));
   }
   
   // Pre: Scanner is passed in
   // Post: After validating user's input, returns valid 10 digit ISBN code
   // ISBN must be exactly 10 digits, no characters
   public static String getIsbn(Scanner input) {
      boolean valid = false;
      String isbn = "";
      String regex = "\\d+";           // Used to test if isbn contains only numbers
      System.out.println("Enter the book ISBN number (10 digits):");
      while (!valid) {                 // Test for valid ISBN number
         isbn = input.nextLine();
         if (isbn.length() == 10 && isbn.matches(regex)) { // Length = 10 && numbers only
            valid = true;
         } 
         else {
            System.out.println("That is not a valid number, try again:");
         }
      }  
   
      return isbn;
   }
   
   // Pre: Scanner is passed in
   // Post: After validating user's input, returns monetary value over 0
   // Cost must be >= 0.00
   public static double getCost(Scanner input) {
      double cost;
      do {
         System.out.println("Price of a single copy of the book:");
         System.out.print("$");
         cost = input.nextDouble();
         if (cost < 0) {
            System.out.println("Cost must be above 0! Try again.");
         }
      } while (cost < 0);
      
      return cost;
   }
   
   // Pre: Scanner is passed in
   // Post: After validating user's input, returns number of books in inventory
   // Number must be >= 0
   public static int getBooks(Scanner input) {
      int books;
      do {
         System.out.println("How many books are on hand?");
         books = input.nextInt();
         if (books < 0) {
         System.out.println("You can't have negative books! Try again.");
         }
      } while (books < 0);
      
      return books;
   }
   
   // Pre: Scanner is passed in
   // Post: After validating user's input, returns number of prospective students
   // Students must be >= 0
   public static int getProspEnroll(Scanner input) {
      int students;
      do {
         System.out.println("Number of prospective students?");
         students = input.nextInt();    
         if (students < 0) {
         System.out.println("You can't have negative students! Try again.");
         }  
      } while (students < 0);
      
      return students;
   }
   
   // Pre: Scanner is passed in
   // Post: After validating that user entered the characters r or o, string is
   // modified and returned in all capitals
   public static String getRequired(Scanner input) {
      String r = "";
      do {
         System.out.println("Is the book required or optional? (r/o)");
         r = input.next();
         r = r.toLowerCase();
      } while (!r.equals("r") && !r.equals("o"));
      
      if (r.equals("r")) {
         r = "REQUIRED";
      } 
      else {
         r = "OPTIONAL";
      }
      
      return r;
   }
   
   // Pre: Scanner is passed in
   // Post: After validating that user entered the characters n or u, string is
   // modified and returned in all capitals
   public static String getBookStatus(Scanner input) {
      String r = "";
      do {
         System.out.println("Is the book new or was it used in class before? (n/u)");
         r = input.next();
         r = r.toLowerCase();
      } while (!r.equals("n") && !r.equals("u"));
      
      if (r.equals("n")) {
         r = "NEW";
      } 
      else {
         r = "USED";
      }
      
      return r;
   }
   
   // Pre: ISBN number, cost, current number of books, prospective students, req/opt, 
   // new/used values are passed in
   // Post: Prints out all values in nicely formatted display
   public static void display(String isbn, double cost, int currentBooks, int prospEnroll, String req, String book) {
      System.out.println("ISBN: " + isbn);
      System.out.println("Price of book: $" + cost);
      System.out.println("Current number of books: " + currentBooks);
      System.out.println("Prospective students: " + prospEnroll);
      System.out.println("Required or optional: " + req);
      System.out.println("New or used before: " + book);
   }
   
   // Pre: Current number of books, prospective students and whether the book is req/opt or new/used
   // values are passed in
   // Post: Returns number of books that need to be ordered, depending on if the book is req/opt, new/used
   // the percentages of potential buyers changes
   public static int calcOrder(int currentBooks, int pStudents, String ro, String nu) {
      double pct;
      int toOrder;
      if (ro.equals("REQUIRED") && nu.equals("NEW")) {
         pct = .90;
      } 
      else if (ro.equals("REQUIRED") && nu.equals("USED")) {
         pct = .65;
      } 
      else if (ro.equals("OPTIONAL") && nu.equals("NEW")) {
         pct = .40;
      } 
      else {
         pct = .20;
      }
      toOrder = (int)(pStudents * pct) - currentBooks;
      
      if (toOrder < 0) {      // Return 0 if books are overstocked
         return 0;
      }
      
      return (int)(pStudents * pct) - currentBooks;
   }
   
   // Pre: Number of books to be ordered and cost of each book are passed in
   // Post: Returns the cost of all the books to be ordered
   public static double calcTotal(int orderNum, double cost) {
      return orderNum * cost;
   }
   
   // Pre: Total cost of all books is passed in
   // Post: Returns the expected profit if all the books are bought at 80% list price
   public static double calcProfit(double totalCost) {
      return totalCost - (totalCost*.80);
   }
}