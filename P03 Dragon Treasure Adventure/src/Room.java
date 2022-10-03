//////////////// Room Class //////////////////////////
//
// Title:    Room class for the Dragon Treasure Game
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

public class Room {
    private RoomType type; //one of the four types a room could be
    private String roomDescription; //a brief description of the room
    private ArrayList<Room> adjRooms; //arraylist that holds the rooms adjacent
    private final int ID; //unique ID for each room to identify it
    private static int teleportLocationID; //place where all portal rooms will go to
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    
    
    /*
     * Constructor for the room object.
     * 
     * @param id - the unique id number for this room
     * @param roomDescription - a brief description of this room
     */
    public Room(int id, String roomDescription) {
      adjRooms = new ArrayList<>();
      ID = id;
      this.roomDescription = roomDescription;
      type = RoomType.NORMAL;
    }
    
    /** Determines if the given object is equal to this room.
    * They are equal if other is a Room and their IDs are the same.
    * @param other, another object to check if it is equal to this
    * @return true if the two rooms are equal, false otherwise
    * @author Michelle */
    @Override
    public boolean equals(Object other){
    if(other instanceof Room) {
    Room otherRoom = (Room)other;
    return this.ID == otherRoom.ID;
    }
    return false;
    }
    
    /** Returns a String representation of this room.
    * @return the string representation of this room and
    * it’s object data field values
    * @author Michelle*/
    @Override
    public String toString(){
    String s = this.ID +": " + this.roomDescription+ " (" + type +")\n Adjacent Rooms: ";
    for(int i = 0; i<adjRooms.size(); i++){
    s+= adjRooms.get(i).ID +" ";
    }
    return s;
    }
    
    /*
     * Takes the given room and adds it to this object's list of adjacent rooms
     * 
     * @param toAdd - room to be added to the adjacent rooms list
     */
    public void addToAdjacentRooms(Room toAdd) {
      adjRooms.add(toAdd);
    }
  
    /*
     * Sets the class field teleportLocation to the int given.
     * 
     * @param teleportID - the id of the room where all portals should teleport to
     */
    public static void assignTeleportLocation(int teleportID) {
      teleportLocationID = teleportID;
    }
    
    /*
     * Getter for the adjRooms instance field
     * 
     * @return this object's list of rooms adjacent to it
     */
    public ArrayList<Room> getAdjacentRooms(){
      return adjRooms;
    }
    
    /*
     * Getter for the id instance field
     * @return this object's list of rooms adjacent to it
     */
    public int getID() {
      return ID;
    }
    
    /*
     * Returns the string that is the room class's portal warning, indicating that there is one nearby.
     * 
     * @return The portal warning message string
     */
    public static String getPortalWarning() {
      return PORTAL_WARNING;
    }
    
    /*
     * Getter for the description instance field
     * 
     * @return this object's description
     */
    public String getRoomDescription() {
      return roomDescription;
    }
    
    /*
     * Returns the id of the room where all portals will teleport to.
     * 
     * @return the id of the teleportLocation room
     */
    public static int getTeleportationRoom() {
      return teleportLocationID;
    }

    /*
     * Returns the string that is the room class's treasure warning, indicating that the treasure room nearby.
     * 
     * @return The treasure warning message string
     */
    public static String getTreasureWarning() {
      return TREASURE_WARNING;
    }

    /*
     * Getter for the type instance field
     * 
     * @return this object's roomtype
     */
    public RoomType getType() {
      return type;
    }
  
    /*
     * Checks whether this given room is adjacent to this one or not.
     * 
     * @param r - The room that you are seeing if it is adjacent to this.
     * @return true if they are adjacent, false otherwise
     */
    public boolean isAdjacent(Room r) {
      for(int i = 0; i<adjRooms.size(); i++) {
        if(adjRooms.get(i).equals(r)) {
          return true;
        }
      }
      return false;
    }
    
    /*
     * Changes this objects type to the roomtype given
     * 
     * @param newType - The new roomtype of this Room object.
     */
    public void setRoomType(RoomType newType) {
      type = newType;
    }

  
}
