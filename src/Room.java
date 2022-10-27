//////////////// Room Parent Class //////////////////////////
//
// Title:    Room
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
import processing.core.PApplet;
import processing.core.PImage;

public class Room {
  private String description; //verbal description of the room
  private ArrayList<Room> adjRooms; //list of all rooms directly connect
  private final int ID; // a "unique" identifier for each room
  protected static PApplet processing; //PApplet object which the rooms will use to
  //draw stuff to the GUI
  private PImage image; //stores the image that corresponds to the background of a room
  /**
   * Constructor for the room object. Assigns values to the non-static fields. 
   * The default type should be RoomType.NORMAL.
   * @param id the unique id number for this room
   * @param roomDescription a brief description of this room
   */
  public Room(int ID, String description, processing.core.PImage image) {
    this.ID = ID;
    this.description = description;
    this.image=image;
    this.adjRooms =  new ArrayList<Room>();
  //TODOthis.image;

  }
  
  /**
   * Getter for the id instance field
   * @return this object's id
   */
  public int getID() {
    return this.ID;
  }
  
  /**
   * Getter for the description instance field
   * @return this object's description
   */
  public String getDescription() {
    return this.description;
  }
  
  /**
   * Getter for the adjRooms instance field
   * @return this object's list of rooms adjacent to it
   */
  public ArrayList<Room> getAdjacentRooms() {
    return this.adjRooms;
  }
  
  /**
   * Sets the processing for the class.
   * @param processing  , the PApplet that this room will use to draw to the window
   */
  public static void setProcessing(processing.core.PApplet processing) {
    Room.processing = processing;
   }
  
  /**
   * Takes the given room and adds it to this object's list of adjacent rooms
   * @param toAdd room to be added to the adjacent rooms list
   */
  public void addToAdjacentRooms(Room toAdd) {
 
    this.adjRooms.add(toAdd);
  }
  
  /**
   * Checks whether this given room is adjacent to this one or not.
   * @param r The room that you are seeing if it is adjacent to this.
   * @return true if they are adjacent, false otherwise
   */
  public boolean isAdjacent(Room r)
  {
    return adjRooms.contains(r);
  }

  /*
   * Checks whether or not this Room is equal to the other.
   */
  @Override
  public boolean equals(Object other)
  {
    if(other instanceof Room) {
      Room otherRoom = (Room)other;
      return this.ID == otherRoom.ID;
    }
    
    return false;
  }
  
  /**
   * Returns a String representation of this Room.
   */
  @Override
  public String toString() {
    
    String s = this.ID +": " + this.description+"\n Adjacent Rooms: ";
    for(int i = 0; i<adjRooms.size(); i++)
    {
      s+= adjRooms.get(i).ID +" ";
    }
    
    return s;
  } 
  
  /**
   * Draws this Room to the window by drawing the background image, 
   * a rectangle, and some text.
   */
  public void draw() {
    processing.image(image, 0, 0);
    processing.fill(-7028);
    processing.rect(0,500,800,600);
    processing.fill(0);
    processing.text(this.toString(), 300, 525);
    
  }
  
  
}
