//////////////// Character Parent Class //////////////////////////
//
// Title:    Character
// Course:   CS 300 Fall 2022
//
// Author:   Tanvi Wadhawan
// Email:    twadhawan@wisc.edu email address
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Yash Athma
// Partner Email:   athma@wisc.edu
// Partner Lecturer's Name: Mouna Kacen
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   _x__ We have both read and understand the course Pair Programming Policy.
//   _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

public class Character extends Object{
  private Room currentRoom; //current room the character is in
  private String label; //a label giving a basic description of the character
  
  /*
   * Constructor for a Character object. Initializes all instance fields.
   * 
   * @param currentRoom - , the room that the Character is located in
   * @param label - , a descriptive label of this Character
   * 
   * @throws IllegalArgumentException - with a descriptive message if currentRoom is null.
   */
  public Character(Room currentRoom, String label) throws IllegalArgumentException  {
    if(currentRoom==null) {
      throw new IllegalArgumentException("The input value for currentRoom was null when"
          + " making a new Character");
    }
    this.currentRoom=currentRoom;
    this.label=label;
  }
  
  /*
   * Getter for the current room of this Character.
   * 
   * @return the room where the character is
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  
  /*
   * Getter for the label of this Character.
   * 
   * @return this Character's descriptive label
   */
  public String getLabel() {
    return label;
  }
  
  /*
   * Sets the current room to the one given.
   * 
   * @param newRoom - , the room that should become the current room
   */
  public void setCurrentRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }
  
  /*
   * Gets the list of rooms adjacent to this Character.
   * 
   * @return an ArrayList of rooms adjacent to this character
   */
  public ArrayList<Room> getAdjacentRooms(){
    return currentRoom.getAdjacentRooms();
  }
  
}
