//////////////// Dragon Game Runner //////////////////////////
//
// Title:    Dragon Treasure Game
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

public class DragonTreasureGame extends PApplet{
  private boolean isDragonTurn;//checks if it's dragons turn or not
  private int gameState;//checks what the state of the game is 
  private ArrayList<Character>characters;//list of characters
  private ArrayList<Room>roomList;//list of rooms
  private File roomInfo;//given files
  private File mapInfo;//given files
  public static void main(String args[]) {
    PApplet.main("DragonTreasureGame");
    
//    StartRoom xyz;
//    roomList.add(xyz); startRoom 4.1 last 2 bullet points


  }
  @Override
  public void settings() {
    size(800,600);
  }
  
  public void setup() {
    this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
    this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate
    //as the top-left corner
    this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args
    //as top-left corner and bottom-right corner respectively
    this.focused = true; // window will be active upon running program
    this.textAlign(CENTER); // sets the text alignment to center
    this.textSize(20); //sets the font size for the text
    roomList=new ArrayList<>();
    characters = new ArrayList<>();
    
    isDragonTurn = false;//player's turn
    gameState = 0;
    
    Room.setProcessing(this);
    
    roomInfo = new File("roominfo.txt");
    mapInfo = new File("map.txt");
    
    loadRoomInfo();
    loadMap();
    loadCharacters();
    
//    set bg images
    PImage treasureBackground = loadImage("images/treasure.jpg");
    PImage portalImage = loadImage("images/portal.png");
    PortalRoom.setPortalImage(portalImage);
    TreasureRoom.setTreasureBackground(treasureBackground);

//    Room x = new PortalRoom(1, "test portal room", one);
//    roomList.add(x);
  }
  
  
  /*
   * draws onto the screen
   */
  public void draw(){
    int playerIndex = -1;//starts off at -1
    int dragonIndex = -1;
    int key=-1;
    
    for(int i =0; i<characters.size();i++) { 
      if(characters.get(i) instanceof Player) {
        playerIndex = i;
      }else if(characters.get(i) instanceof Dragon) {
        dragonIndex = i;
      }else if(characters.get(i).getLabel().equals("KEYHOLDER")) {
        key = i;
      }
    }  

    
    Player player= (Player)characters.get(playerIndex);
    Dragon dr= (Dragon)characters.get(dragonIndex);
    
    //System.out.println(dr.getCurrentRoom());
    
    player.getCurrentRoom().draw();//draw currentRoom
    //check for warning
    
    
    //check warnings
    if(player.getCurrentRoom() instanceof PortalRoom) {
      if(player.isPortalNearby()) {
        System.out.println(PortalRoom.getPortalWarning());//portal warning
      }
      
    }else if(player.getCurrentRoom() instanceof TreasureRoom) {
      if(player.isTreasureNearby()) {
        System.out.println(TreasureRoom.getTreasureWarning());//treasure warning
      } 
    }else if(player.isDragonNearby(dr)){
      System.out.println(Dragon.getDragonWarning());//dragon warning
    }
//player.getCurrentRoom().equals(characters.get(playerIndex).getCurrentRoom())
//    if(player.hasKey()) {
//      System.out.println("KEY OBTAINED");
//    }
    
    //Check to see if player is in the room with key
    if(player.getCurrentRoom().equals(characters.get(key).getCurrentRoom())){
      player.obtainKey();
      System.out.println("KEY OBTAINED");
    }
    
    //dragon is false, only goes after player
    if(player.getCurrentRoom() instanceof PortalRoom) {
      player.teleport();
      System.out.println("teleported successfully");
      isDragonTurn=true;
      
    }
    
    if(isDragonTurn && gameState==0) {
      System.out.println("sdfsdfasfasdfasefsdf");
      dr.changeRoom(dr.pickRoom());//change to which room
      isDragonTurn=false;
    }
    //win or loss
    if(player.getCurrentRoom() instanceof TreasureRoom && player.hasKey()) {
      gameState=1;
      System.out.println("you won");
    }
    if(player.getCurrentRoom().equals(dr.getCurrentRoom())) {//
      gameState=2;
      System.out.println("you lost");

    }
    
    
    
    
    
    //characters.get(1).getCurrentRoom().draw();
    
//    while(gameState==0) {
//      
//    }
    
    //characters.get(2).getCurrentRoom().draw();
  }
  /**
   * letting the user move the player
   */
  @Override
  
  public void keyPressed() {
    super.keyPressed();
    
    Player player=null;//need to load characters into it
    String press= "" +key;
    for(int i=0;i<characters.size();i++) {
      if(characters.get(i) instanceof Player) {
        player = (Player) characters.get(i);
      }
    }
    Room abc=null; //room to move to
    for(int i=0;i<player.getAdjacentRooms().size();i++) {
      String id= "" + player.getAdjacentRooms().get(i).getID();
      if(id.equals(press)) {
        abc=player.getAdjacentRooms().get(i);//change rooms
      }
    }
    
    if(gameState==0) {//makes sure we can play the game
      player.setCurrentRoom(abc);
      isDragonTurn=true;
    }else {
      System.out.println("Pick a valid room");
    }
  }
  /** Loads in room info using the file stored in roomInfo
   *  @author Michelle 
   */  private void loadRoomInfo() {
    System.out.println("Loading rooms...");
    Scanner fileReader = null;
    try {
      
      //scanner to read from file
      fileReader= new Scanner(roomInfo);
      
      //read line by line until none left
      while(fileReader.hasNext()) {
        String nextLine = fileReader.nextLine();
        
        //parse info and create new room 
        String[] parts = nextLine.split(" \\| ");
        int ID = Integer.parseInt(parts[1].trim()); //get the room id
        String imageName = null;
        String description = null;
        PImage image = null;
        Room newRoom = null;
        
        if(parts.length >= 3) {
          imageName = parts[2].trim();
          image = this.loadImage("images" + File.separator + imageName);
         
        }
        
        if(parts.length == 4) {
          description = parts[3].trim(); //get the room description
        }
   
        switch(parts[0].trim()) {
          case "S":
            newRoom = new StartRoom(ID, image);
            break;
          case "R":
            newRoom = new Room(ID, description, image);
            break;
          case "P":
            newRoom = new PortalRoom(ID, description, image);
            break;
          case "T":
            newRoom = new TreasureRoom(ID);
            break;
          default:
            break;
        }  
        
        if(newRoom != null) {
          roomList.add(newRoom);
        }
      }
    }catch(IOException e) { //handle checked exception
      e.printStackTrace();
    }finally {
      if(fileReader != null)
        fileReader.close(); //close scanner regardless of what happened for security reasons :)
    }
  }
  
  /** Loads in room connections using the file stored in mapInfo
   *  @author Michelle 
   */
  private void loadMap() {
    System.out.println("Loading map...");
    Scanner fileReader = null;
    try {
          //scanner to read from file
          fileReader= new Scanner(mapInfo);
          
        //read line by line until none left
          while(fileReader.hasNext()) {
            
            //parse info
            String nextLine = fileReader.nextLine();
            String parts[] = nextLine.split(" ");
            int id = Integer.parseInt(parts[0]);
            
            Room toEdit = getRoomByID(id); //get the room we need to update info for adjacent rooms
            
            //add all the rooms to the adj room list of toEdit
            for(int i=1; i<parts.length; i++) {
              Room toAdjAdd = getRoomByID(Integer.parseInt(parts[i]));
              toEdit.addToAdjacentRooms(toAdjAdd);
            }
          }
        }catch(IOException e) { //handle checked exception
          e.printStackTrace();
        }finally {    //close scanner regardless of what happened for security reasons :)
          if(fileReader != null)
            fileReader.close();
        }
  }
  
  /**
   * Get the room objected associated with the given ID.
   * @param id the ID of the room to retrieve
   * @return the Room that corresponds to that id
   * @author Michelle
   */
  private Room getRoomByID(int id){
    int indexToEdit = roomList.indexOf(new Room(id,"dummy", null));
    Room toEdit = roomList.get(indexToEdit); 
    return toEdit;
  }
/**
 * loads characters
 */
  private void loadCharacters() {
    System.out.println("Adding characters...");
    characters.add(new Character(getRoomByID(5),"KEYHOLDER"));
    characters.add(new Player(getRoomByID(1)));
    characters.add(new Dragon(getRoomByID(9)));
    }


}
