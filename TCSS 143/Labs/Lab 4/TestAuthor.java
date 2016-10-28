/*
	Program Name: TestAuthor.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: To create a new Author object and pass it some values
   then to change the email string and print out the new object
*/

public class TestAuthor {
   public static void main(String[] args) {
      Author anAuthor = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'm');
      System.out.println(anAuthor);
      anAuthor.setEmail("paul@nowhere.com");
      System.out.println(anAuthor);
   }
}