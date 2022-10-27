//////////////// Player of type Character //////////////////////////
//
// Title:    Player
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

public class Player extends Character implements Moveable{
  private boolean hasKey;
  
  /*
   * Constructor for player object. The label should be "PLAYER" and not have a key by default.
   * 
   * @param currentRoom - , the room that the player should start in
   *
   * @throws IllegalArgumentException - if the currentRoom is not a StartRoom
   */
  public Player(Room currentRoom) throws IllegalArgumentException{
    super(currentRoom, "PLAYER");
    if(!(currentRoom instanceof StartRoom)) {
      throw new IllegalArgumentException("The input currentRoom is not a StartRoom when "
          + "calling the Player constructor");
    }
    hasKey = false;
  }

  /*
   * Determines if the player has the key.
   * 
   * @return true if the player has the key, false otherwise
   */
  public boolean hasKey() {
    return hasKey;
  }
  
  /*
   * Gives player the key.
   */
  public void obtainKey() {
    hasKey=true;
  }
  
  /*
   * Moves the Player to the destination room.
   * 
   * @specified by changeRoom in interface Moveable
   * 
   * @param destination - , the Room to change it to
   * 
   * @returns true if the change was successful, false otherwise
   */
  public boolean changeRoom(Room destination) {
    if(!this.canMoveTo(destination)) {
      return false;
    }
    
    this.setCurrentRoom(destination);

    return true;
  }
  
  /*
   * Checks if the player can move to the given destination. A valid move is the destination 
   * is a room adjacent to the player.
   * 
   * @Specified by canMoveTo in interface Moveable
   * 
   * @param destination - , the room to check if the player can move towards
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
   * Determines whether or not the given dragon is nearby. A dragon is considered nearby if it is in one of the adjacent rooms.
   * 
   * @param d - the dragon to check if nearby
   * 
   * @return true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    
    for(int i = 0; i<adjRooms.size();i++) {
      if(adjRooms.get(i).equals(d.getCurrentRoom())) {
        return true;
      }
    }
    return false;
  }
  
  /*
   * Checks if the player needs to teleport and move them if needed.
   * 
   * @return true if a teleport occurred, false otherwise
   */
  public boolean teleport() {
    if(this.getCurrentRoom() instanceof PortalRoom) {
      PortalRoom x =(PortalRoom)this.getCurrentRoom();
      this.setCurrentRoom(x.getTeleportLocation());
      return true;
    }
    
    return false;
  }
  
  /*
   * Determines whether or not a portal room is nearby. A portal room is considered nearby if it is one of the adjacent rooms.
   * 
   * @return true if a portal room is nearby, false otherwise
   */
  public boolean isPortalNearby() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    
    for (int i = 0; i<adjRooms.size();i++) {
      if(adjRooms.get(i) instanceof PortalRoom) {
        return true;
      }
    }
    
    return false;
  }
  
  /*
   * Determines whether or not the treasure room is nearby. The treasure room is considered nearby if it is one of the adjacent rooms.
   * 
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
        
      for (int i = 0; i<adjRooms.size();i++) {
        if(adjRooms.get(i) instanceof TreasureRoom) {
          return true;
        }
      }
        
    return false;
  }
}
