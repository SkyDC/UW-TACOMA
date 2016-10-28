/*
 * TCSS 143 - Winter 2016
 * Instructor: Raghavi Sakpal
 * Assignment #2 - LostPuppy Game
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Contains methods for use in PuppyPlay driver
 * 
 * @author Skylar Cowan sdcowan@uw.edu
 * @version 25 October 2016
 */

public class LostPuppy {
   private char[][] myHidingPlaces; // Rows = #floors, Columns = #rooms on floor
   private int myFloorLocation;
   private int myRoomLocation;
   private char myWinner;
   private boolean myFound;
   
   /**
    * Constructor for lost puppy, creates LostPuppy object and generates
    * a random floor/room location for the puppy based on array dimensions.
    * All values are initialized within the object for the game.
    * 
    * @param numFloors number of floors (must be above 0)
    * @param numRooms number of rooms per floor (must be above 0)
    */
   public LostPuppy(int numFloors, int numRooms) {
      int row = validateFloors(numFloors);
      int col = validateRooms(numRooms);
      this.myHidingPlaces = new char[row][col];
      for (int floor = 0; floor < myHidingPlaces.length; floor++) {
         for (int room = 0; room < myHidingPlaces[floor].length; room++) {
            myHidingPlaces[floor][room] = ' ';
         }
      }
      
      Random rn = new Random();
      myFloorLocation = rn.nextInt(row); // Generate random floor location for puppy
      myRoomLocation = rn.nextInt(col); // Generate random room location for puppy
      myHidingPlaces[myFloorLocation][myRoomLocation] = 'P'; // Set puppy location
      myWinner = ' '; // Set myWinner to empty
      myFound = false; // Set myFound false
   }
   
   /**
    * Checks if the given floor and room have already been searched.
    * 
    * @param floor the floor to search
    * @param room the room to search
    * @return true if room has been searched, false otherwise
    */
   public boolean roomSearchedAlready(int floor, int room) {
      if (myHidingPlaces[floor][room] == '1' || myHidingPlaces[floor][room] == '2') {
         // Notify if room has already been searched
         System.out.println("Sorry! That room has been searched already!");
         return true;
      } else {
         return false;
      }
   }
   
   /**
    * Determines if the puppy is in the room on the given floor.
    *  
    * @param floor the floor to check
    * @param room the room to check
    * @return true if puppy is here, false otherwise
    */
   public boolean puppyLocation(int floor, int room) {
      if (myHidingPlaces[floor][room] == 'P') {
         return true;
      } 
      else {
         return false;
      }
   }
   
   /**
    * Determines if the given floor and room is within possible locations.
    * 
    * @param floor number to check if in range
    * @para room number to check if in range
    * @return true if location is within the array, false otherwise
    */
   public boolean indicesOK(int floor, int room) {
      // Print correct range for guessing if either number was out of bounds
      if ((floor < 0 || room < 0) || (floor > numberOfFloors() - 1 || room > numberOfRooms() - 1)) {
         System.out.println("Numbers must be between [0-" + (numberOfFloors() - 1) + "] and [0-" +
                           (numberOfRooms() - 1) + "]!");
      }
      return ((floor < myHidingPlaces.length && room < myHidingPlaces[0].length) &&
              (floor >= 0 && room >= 0));
   }
   
   /**
    * Gets and returns the number of floors.
    * 
    * @return number of floors in array
    */ 
   public int numberOfFloors() {
      return myHidingPlaces.length;
   }
   
  /**
   * Gets and returns the number of rooms.
   * 
   * @return number of rooms in array
   */ 
   public int numberOfRooms() {
      return myHidingPlaces[0].length;
   }
   
  /**
   * Checks room to see if the room contains the puppy, if not, insert player number.
   * 
   * @param floor the floor to check
   * @param room the room to check
   * @param player the player searching the room (1 or 2)
   * @return true if puppy is in the room and player wins, false otherwise and player
   * number is placed in room
   */ 
   public boolean searchRoom(int floor, int room, char player) {
      if (puppyLocation(floor, room)) {
         myFound = true;
         myWinner = player;
         return true;
      } 
      else {
         myHidingPlaces[floor][room] = player;
         return false;
      }
   }
   
   /**
    * Validates that the number of floors is greater than zero.
    *
    * @param numFloors the number of floors
    * @return validated number of floors
    */
   public int validateFloors(int numFloors) {
      Scanner input = new Scanner(System.in);
      int floors = numFloors;
      while (floors < 1) {
         System.out.println("Oops! The number of floors you entered is not valid" +
                           "\n" + "Please enter another number above 0:");
         floors = input.nextInt();
      }
      return floors;
   }
   
   /**
    * Validates that the number of rooms is greater than zero.
    *
    * @param numRooms the number of rooms
    * @return validated number of rooms
    */
   public int validateRooms(int numRooms) {
      Scanner input = new Scanner(System.in);
      int rooms = numRooms;
      while (rooms < 1) {
         System.out.println("Oops! The number of rooms you entered is not valid" +
                           "\n" + "Please enter another number above 0:");
         rooms = input.nextInt();
      }
      return rooms;
   }
   
   /**
    * Converts LostPuppy two-dimensional array into a string and 
    * prints it out in a nicely formatted display.
    *
    * @return printed out LostPuppy game object
    */
   public String toString() {
      int floors = myHidingPlaces.length;
      int rooms = myHidingPlaces[0].length;
      
      System.out.print(" ");
      // Print top of the grid
      for (int i = 0; i < rooms; i++) {
         System.out.print("___");
      }
      for (int j = 0; j < rooms - 1; j++) {
         System.out.print("_");
      }
      System.out.print("\n");
      
      // Print out floors and rooms with their contents
      for (int floor = floors - 1; floor >= 0; floor--) {
         System.out.print("| ");
         for (int room = 0; room <= rooms - 1; room++) {
            if (myHidingPlaces[floor][room] == 'P' && myFound) {
               System.out.print("" + myWinner + "" + myHidingPlaces[floor][room] + "| ");
            } 
            else if (myHidingPlaces[floor][room] == 'P' && !myFound) {
               System.out.print("  | ");
            } 
            else {
               System.out.print(myHidingPlaces[floor][room] + " | ");
            }
         }
         System.out.print("\n");
         for (int i = 0; i < rooms; i++) {
            System.out.print("|___");
         }
         System.out.print("|\n");
      }
      return "";
   }
}