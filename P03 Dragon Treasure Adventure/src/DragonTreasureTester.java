//////////////// Tester Class //////////////////////////
//
// Title:    Tester class for the Dragon Treasure Game
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

public class DragonTreasureTester {

  /*
   * Main method which runs all the testers
   * 
   * @param String[] args
   */
  public static void main(String[] args) {
    System.out.println(testRoomInstanceMethods());
    System.out.println(testRoomStaticMethods());
    System.out.println(testPlayerCanMoveTo());
    System.out.println(testPlayerShouldTeleport());
    System.out.println(testPlayerDetectNearbyRooms());
    System.out.println(testDragonChangeRooms());


  }
  
  /*
   * checks the correctness of ALL instance (non-static) methods including
   * the constructor for the Room class
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testRoomInstanceMethods() {
    Room r = new Room(1,"Fire Room");
    try {

      //Testing getID and constructor
      if(r.getID()!=1) {
        System.out.println("The Room constructor did not correctly assign the unique ID to the room"
            + " or the getID method did not correctly return the unique ID");
        return false;
      }
      
      //Testing getRoomDescription and constructor
      if(!r.getRoomDescription().equals("Fire Room")) {
        System.out.println("The room contructor did not correctly assign the RoomDescription to"
            + " the room or the getRoomDescription did not correctly return the RoomDescription");
        return false;
      }
      
      //Testing getType and constructor
      if(r.getType()!=RoomType.NORMAL) {
        System.out.println("The room constructor did not correctly assign the room type to normal"
            + " in the constructor or the getType method did not correctly return the room type");
        return false;
      }
       
      //Testing addToAdjacentRooms and getAdjacentRooms
      ArrayList<Room> test = new ArrayList<Room>();
      test.add(new Room(2,"Water Room"));
      r.addToAdjacentRooms(new Room(2,"Water Room"));
      
      if(!test.equals(r.getAdjacentRooms())) {
        System.out.println("The addToAdjacentRooms did not correctly add the new adjecent room"
            + " to the adjRooms list or the getAdjacentRooms did"
            + " not correctly return the adjRooms list");
        return false;
      }
      
      //Testing isAdjacent
      if(!r.isAdjacent(new Room(2,"Water Room"))) {
        System.out.println("The isAdjacent method did not correctly check if the input"
            + " room is adjecent to the original room");
        return false;
      }
      
      //Test setRoomType
      r.setRoomType(RoomType.PORTAL);
      if(r.getType()!=RoomType.PORTAL) {
        System.out.println("The setRoomType method did not correctly set the"
            + " input room type to the room");
        return false;
      }
    
    }
    //Checking to see if adjRooms is initialized
    catch (Exception e){
      System.out.println("adjRooms must be initialized");
      return false;
    }
    
    //All tests have not return false so no bugs detected
    return true;
    
  }
  
  /*
   * checks the correctness of ALL static methods for the Room class
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testRoomStaticMethods() {
    Room r = new Room(1,"Fire Room");
    
    //Test getPortalWarning
    if(!r.getPortalWarning().equals("You feel a distortion in space nearby.\n")) {
      System.out.println("The getPortalWarning method did not return the right warning");
      return false;
    }
    
    //Test getTreasureWarning
    if(!r.getTreasureWarning().equals("You sense that there is treasure nearby.\n")) {
      System.out.println("The getTreasureWarning method did not return the right warning");
      return false;
    }
    
    //Test assignTeleportLocation and getTeleportationRoom
    r.assignTeleportLocation(1);
    if(r.getTeleportationRoom()!=1) {
      System.out.println("The assignTeleportLocation did not correctly assign the input value "
          + "to the room or the getTeleportationRoom method did not return the right"
          + " teleportLocationID");
      return false;
    }
    
    //No bugs were detected
    return true;
  }

  /*
   * This method checks for the correctness of the canMoveTo() method.
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testPlayerCanMoveTo() {
    Room r = new Room(0,"Fire Room");
    r.addToAdjacentRooms(new Room(1,"Water Room"));
    Player p = new Player(r);
    
    if(!p.canMoveTo(new Room(1,"Water Room"))) {
      System.out.println("The canMoveTo method said the player cant move when it was allowed to");
      return false;
    }
    
    return true;
  }
  
  /*
   * This method checks for the correctness of the shouldTeleport() method.
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testPlayerShouldTeleport() {
    Room r = new Room(0,"Portal Room");
    r.setRoomType(RoomType.PORTAL);
    Player p = new Player(r);
    
    if(!p.shouldTeleport()==true) {
      System.out.println("The shouldTeleport Method said the player shouldnt move when it"
          + " was in a room of type Portal");
      return false;
    }
    
    return true;
  }
  
  /*
   * This method checks for the correctness of both the isPortalNearby()
   * and isTreasureNearby() methods.
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testPlayerDetectNearbyRooms() {
    //Creating an adequate scenario
    Room r = new Room(0,"Lava Room");   
    Room portal = new Room(1,"Water Room");
    portal.setRoomType(RoomType.PORTAL);
    Room treasure = new Room(1,"Ice Room"); 
    treasure.setRoomType(RoomType.TREASURE);
    r.addToAdjacentRooms(portal);
    r.addToAdjacentRooms(treasure);
    
    Player p = new Player(r);
    
    //Testing isPortalNearby
    if(!p.isPortalNearby()) {
      System.out.println("The isPortalNearby said there wasnt a portal nearby when there was");
      return false;
    }
    
    //Testing isTreasureNearby
    if(!p.isTreasureNearby()) {
      System.out.println("The isTreasureNearby said there wasnt a treasure nearby when there was");
      return false;
    }

    //No bugs detected
    return true;
  }
  
  /*
   * checks the correctness of the changeRooms() method.
   * 
   * @return true if no bugs were detected else returns false
   */
  public static boolean testDragonChangeRooms() {
    //Creating an adequate scenario
    Room r = new Room(0, "Water room");
    r.addToAdjacentRooms(new Room(1,"Fire Room"));
    Room r2 = new Room(2, "Lava Room");
    r2.setRoomType(RoomType.PORTAL);
    r.addToAdjacentRooms(r2);
    Dragon d = new Dragon(r);
    
    d.changeRooms();

    //Testing changeRooms
    if(!d.getCurrentRoom().equals(new Room(1,"Fire Room"))) {
      System.out.println("The changeRooms method did not correctly move the dragon");
      return false;
    }
    
    //No bugs detected
    return true;
  }

}
