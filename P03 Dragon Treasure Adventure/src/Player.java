//////////////// Player Class //////////////////////////
//
// Title:    Player class for the Dragon Treasure Game
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

public class Player {
  private Room currentRoom; //current location of the player
  
  /*
   * Constructor for a player object.
   * @param currentRoom - the current location of the player
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
  }
  
  /*
   * Determines whether or not the player can move to the given destination room.
   * A valid player move is ONLY to adjacent rooms.
   * 
   * @param destination - room player wants to move to
   * @return true if it is a valid movement, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if(currentRoom.isAdjacent(destination)) {
      return true;
    }
    
    return false;
  }

  /*
   * Setter for this player's current room.
   * 
   * @param newRoom - the location that the player is moving to
   */
  public void changeRoom(Room newRoom) {
    currentRoom = newRoom;
  }
  
  /*
   * Gets the list of rooms adjacent to where the player is currently at.
   * 
   * @return list of rooms adjacent to the current room
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer(){
    return currentRoom.getAdjacentRooms();
  }
  
  /*
   * Getter for this player's current room.
   * 
   * @return The current location of the player
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }
  
  /*
   * Determines whether or not the given dragon is in a nearby room.
   * 
   * @param d - the dragon to check if nearby
   * @return true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    ArrayList<Room> rooms = currentRoom.getAdjacentRooms();
    for(int i = 0; i<rooms.size();i++) {
      if(d.getCurrentRoom().equals(rooms.get(i))) {
        return true;
      }
    }
    
    return false;
  }
  
  /*
   * Determines whether or not a portal room is in a nearby room.
   * 
   * @return true if a portal room is nearby, false otherwise
   */
  public boolean isPortalNearby() {
    ArrayList<Room> rooms = currentRoom.getAdjacentRooms();   
    for(int i = 0; i<rooms.size();i++) {
      if(rooms.get(i).getType() == RoomType.PORTAL) {
        return true;
      }
    }
    
    return false;
  }
  
  /*
   * Determines whether or not the treasure room is in a nearby room.
   * 
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    ArrayList<Room> rooms = currentRoom.getAdjacentRooms();   
    for(int i = 0; i<rooms.size();i++) {
      if(rooms.get(i).getType() == RoomType.TREASURE) {
        return true;
      }
    }
    
    return false;
  }

  /*
   * Determines whether or not the player needs to teleport.
   * 
   * @return true if they should teleport, false otherwise
   */
  public boolean shouldTeleport() {
    if(currentRoom.getType()==RoomType.PORTAL) {
      return true;
    }
    
    return false;
  }
  
}
