//////////////// Dragon of Type Character //////////////////////////
//
// Title:    Dragon
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
import java.util.Random;


public class Dragon extends Character implements Moveable{
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";
  
  /*
   * Constructor for a Dragon object. Initializes all instance fields. The label should be "DRAGON" by default.
   * 
   * @param currentRoom - , the room that the Dragon starts in
   * 
   * @throws IllegalArgumentException - with a descriptive message if currentRoom is not a TreasureRoom
   */
  public Dragon(Room currentRoom) throws IllegalArgumentException{
    super(currentRoom, "DRAGON");
    if(!(currentRoom instanceof TreasureRoom)) {
      throw new IllegalArgumentException("The input currentRoom is not a TreasureRoom"
          + " when calling the Dragon Constructor");
    }
    randGen = new Random();
  }
  
  /*
   * Moves the Dragon to the destination room.
   * 
   * @Specified by changeRoom in interface Moveable
   * 
   * @param destination - , the Room to change it to
   * 
   * @return true if the change was successful, false otherwise
   */
  public boolean changeRoom(Room destination) {
    if(!this.canMoveTo(destination)) {
      return false;
    }
    
    this.setCurrentRoom(destination);

    return true;
  }
  
  /*
   * Checks if the dragon can move to the given destination. A valid move is the destination not a PortalRoom.
   * 
   * @Specified by canMoveTo in interface Moveable
   * 
   * @param destination - , the room to check if the dragon can move towards
   * 
   * @return true if they can, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    
    if(adjRooms.contains(destination)) {
      return true;
    }
    return false;
  }

  /*
   * Picks randomly ONCE an adjacent room to move into.
   * 
   * @return the room that this Dragon should try to move into 
   */
  public Room pickRoom() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    int randInt;
    Room destRoom;
    do {
      int numOfRooms = this.getAdjacentRooms().size();
      randInt = randGen.nextInt(numOfRooms); //[0,3]
      destRoom = adjRooms.get(randInt);
    }while(!canMoveTo(destRoom));//keeps going until it can pick a new room
    
    return destRoom;
  }

  /*
   * Getter for DRAGON_WARNING.
   * 
   * @return the string for warning about a dragon being nearby.
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }

  /*
   * Getter for DRAGON_ENCOUNTER.
   * 
   * @return the string for letting the player know they ran into the dragon.
   */
  public static String getDragonEncounter() {
    return DRAGON_ENCOUNTER;
  }

}
