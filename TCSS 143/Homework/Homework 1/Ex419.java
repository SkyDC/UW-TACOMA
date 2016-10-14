public class Ex419 {
   public static void main(String[] args) {
      double gpa = 3.2;
      double credits = gpa * 3;
      double diff = Math.abs(credits - 9.6);
      if (diff < 0.1) {
         System.out.println("You earned enough credits.");
      }
   }
}