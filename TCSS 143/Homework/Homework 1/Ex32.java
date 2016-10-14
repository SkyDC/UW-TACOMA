public class Ex32 {

   public static void main(String[] args) {
   
      printPowersOf2(3);
      System.out.println();
      printPowersOf2(10);
   
   }
   
   public static void printPowersOf2 (int x) {
   
      for (int i = 0; i <= x; i++) {
      int r = (int) Math.pow(2, i);
         System.out.print(r + " ");
      
      }
   }
}