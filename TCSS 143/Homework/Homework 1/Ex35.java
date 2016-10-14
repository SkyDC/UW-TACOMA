public class Ex35 {
   public static void main(String[] args) {
      printGrid(3, 6);
      //printGrid(5, 3);
      //printGrid(4, 1);
      //printGrid(1, 3);
   }
   
   public static void printGrid(int r, int c) {
      int p = 1;
      for (int i = 1; i <= r; i++) {
         for (int j = 1; j <= c; j++) {
            if (j == c) {
            System.out.print(p + " ");
            } else {
            System.out.print(p + ", ");
            }
            p+=r;
         }
         p = i + 1;
         System.out.println();
      }     
   }
}