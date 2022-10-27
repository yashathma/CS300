//////////////// TreasureRoom of type Room  //////////////////////////
//
// Title:    Treasure Room
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
import processing.core.PImage;

public class TreasureRoom extends Room{
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
  private static PImage treasureBackground = Room.processing.loadImage("images/treasure.jpg"); //the image ALWAYS used for treasure rooms

  /**
   * Constructor for a TresureRoom object and have a description of "In the back of
   * this room, you spot a treasure chest.
   * @param ID the ID to give to this object
   */
  public TreasureRoom(int ID) {
    super(ID, "In the back of this room, you spot a treasure chest. It is locked...",treasureBackground);
  }
  
  /*Getter for TREASURE_WARNING.
   * 
   * @return the string for warning about treasure being nearby.
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }
  
  /*
   * Determines whether or not the player can open the treasure chest in the room.
   * 
   * @param p the Player to check if they can open the chest
   * @return true if the player has the key and is in this TreasureRoom, false otherwise
   */
  public boolean playerCanGrabTreasure(Player p) {
    return p.hasKey();
  }
 
  /*
   * Sets the background image for the TreasureRoom class.
   * @param treasureBackground the image to be the background
   */
  public static void setTreasureBackground(processing.core.PImage treasureBackground) {
    TreasureRoom.treasureBackground = treasureBackground;
  }

}
