public class Ex319 {
   public static void main(String[] args) {
      printReverse("hello there!");
   }
   
   public static void printReverse (String s) {
      String r = "";
      for (int i = s.length() - 1; i >= 0; i--) {
         r = r + s.charAt(i);
      }
      System.out.print(r);
   }
}