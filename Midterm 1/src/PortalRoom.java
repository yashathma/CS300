//////////////// Portal Type Room //////////////////////////
//
// Title:    Portal Room
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
import java.util.Random;
import processing.core.PImage;
import java.util.ArrayList;

public class PortalRoom extends Room{
  private Random randGen; //random number generator for location picking
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TELEPORT_MESSAGE = "The space distortion teleported you"
      +"to another room!\n";
  private static PImage portalImage; //image of a portal to be shown in all portal rooms
  
  /**
   * Constructor for a PortalRoom object. Initializes all instance data fields.

   * @param ID the ID that this PortalRoom should have
   * @param description the verbal description this PortalRoom should have
   * @param image the image that should be used as a background when drawing this PortalRoom.
   */

  public PortalRoom(int ID, String description, PImage image) {
    super(ID, description, image);
    portalImage = image;
    randGen = new Random();
    
  }
  
  /**
   * overrides draw method
   * Draws this PortalRoom to the window by drawing the background image, a rectangle, 
   * some text, and the portal image.
   */
  @Override
  public void draw() {
    processing.image(Room.processing.loadImage("images/1.jpg"), 0, 0);
    processing.fill(-7028);
    processing.rect(0,500,800,600);
    processing.fill(0);
    processing.text(this.toString(), 300, 525);
    processing.image(portalImage,325, 225);
    
  }
  /**
   * Getter for PORTAL_WARNING.
   * @return the string for warning about a portal being nearby.

   */
  public static String getPortalWarning(){
    return PORTAL_WARNING;
  }
  /**
   * Getter for TELEPORT_MESSAGE.
   * @return the string for letting the player know they were teleported.

   */
  public static String getTeleportMessage(){
    return TELEPORT_MESSAGE;
  }
  /**
   * Picks an adjacent room at random for the player to teleport into.
   * @return The room that player should immediately be moved to
   */
  public Room getTeleportLocation() {
    ArrayList<Room> adjRooms = this.getAdjacentRooms();
    
    int randInt = randGen.nextInt(adjRooms.size());
    return adjRooms.get(randInt);
  }
  /**
   * Sets the portal image for the PortalRoom class.
   * @param portalImage the image to represent the portal
   */
  public static void setPortalImage(processing.core.PImage portalImage) {
    PortalRoom.portalImage=portalImage;
    
  }
}
