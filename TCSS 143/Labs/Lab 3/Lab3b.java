import java.util.Scanner;
import java.text.DecimalFormat;

/*
	Program Name: Lab3b.java
	Programmer: Skylar Cowan & Khoa Doan
	Date: 10/12/2016
	Purpose: To take user's input of package weight and determine shipping cost
*/

public class Lab3b {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("#.00");
      double weight;
      double price;
      
      System.out.println("Enter the weight of the package as a decimal number:");
      weight = getWeight(input);
      price = calcPrice(weight, input);
      System.out.println("Package weights " + weight + " pounds and costs $" + df.format(price) + " to ship");
   }
   
   public static double getWeight(Scanner input) {
      double w;
      do {
         w = input.nextDouble();
      } while(w <= 0);
      
      return w;
   }
   
   public static double calcPrice(double w, Scanner input) {
      double p;
      if (w < 5) {
         return 3;
      } else if (w >= 5 && w < 10) {
         return 3 + (w-5)*.25;
      } else if (w >= 10 && w < 15) {
         return 5.50 + (w-10)*.20;
      } else {
         return 8.50 + (w-15)*.10;
      }
   }
}


