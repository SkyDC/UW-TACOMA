/*
	Program Name: Author.java
	Programmer: Skylar Cowan
	Date: 10/19/2016
	Purpose: To be able to use the Author object in TestAuthor.java
   storing the name, email and gender of the Author
*/

public class Author {
   private String name;
   private String email;
   private char gender;
   
   public Author (String name, String email, char gender) {
      this.name = name;
      this.email = email;
      this.gender = gender;
   }
   
   public String getName() {
      return this.name;
   }
   
   public String getEmail() {
      return this.email;
   }
   
   public char getGender() {
      return this.gender;
   }
   
   public void setEmail(String email) {
      this.email = email;
   }
   
   public String toString() {
      return this.getName() + " (" + this.getGender() + ") at " + this.getEmail();
   }
}