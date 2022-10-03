//////////////// Dragon Class //////////////////////////
//
// Title:    Dragon class for the Dragon Treasure Game
// Course:   CS 300 Fall 2022
//
// Author:   Yash Athma
// Email:    athma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Random;

public class Dragon {
  private Room currentRoom; //current location of the dragon
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  
  /*
   * Constructor for a dragon object. Assigns values to all non-static fields.
   * 
   * @param currentRoom - the current location of the dragon
   */
  public Dragon(Room currentRoom) {
    randGen = new Random();
    this.currentRoom = currentRoom;
  }
  
  /*
   * Getter for this Dragon's currentRoom
   * 
   * @return this Dragon's current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  
  /*
   * Returns the string that is the dragon class's warning, indicating that there is one nearby.
   * 
   * @return The dragon warning message string
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }

  /*
   * Dragon picks one of the rooms at random and moves there if possible. 
   * If it is not a valid move, then it will pick again. 
   */
  public void changeRooms() {
    boolean breaker = true;
    ArrayList<Room> rooms = currentRoom.getAdjacentRooms();
    
    while(breaker) {
      int rand = randGen.nextInt(rooms.size());
      Room room = rooms.get(rand);
      if(room.getType()!=RoomType.PORTAL) {
        currentRoom = room;
        breaker=false;
      }
    }
  }
  
}
