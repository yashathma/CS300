//////////////// P02 Walking Simulator //////////////////////////
//
// Title:    Entire P02 Walking Simulator Assignment (Includes Main)
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

import java.util.Random;
import java.io.File;
import processing.core.PImage;


public class WalkingSim {
  
//static variables used in class
  private static Random randGen;
  private static int bgColor;
  private static PImage[] frames;
  private static Walker[] walkers;

  /*
   * main method which calls the utility run application to start the walking simulator
   */
  public static void main(String[] args) {
    Utility.runApplication();
  }

  /*
   * Sets up all the values in the walking simulator
   * Only runs once
   */
  public static void setup() {
     randGen = new Random();
     bgColor = randGen.nextInt();
     walkers = new Walker[8];
     int numWalkers = randGen.nextInt(1,walkers.length+1);
     frames = new PImage[Walker.NUM_FRAMES];
     
     //Assigning walkers in the walkers array with random values and loads in frames images
     for(int i = 0; i<numWalkers; i++) {
       walkers[i] = new Walker(randGen.nextInt(0,Utility.width()),
           randGen.nextInt(0,Utility.height()));
     }
     
     //Assigning frame values in the Frames array
     for(int i = 0; i<frames.length;i++) {
       frames[i] = Utility.loadImage("images"+File.separator+"walk-"+i+".png");    
     }
  }

  /*
   * Draws the walkers onto the frame and animates them
   */
  public static void draw() {
    //Assigns new background color
    Utility.background(bgColor);
    
    //Loops through all non-null walkers and draws them 3 pixels forward is they are walking
    //or in the same place if not walking
    for(int i =0; i<frames.length;i++) {
      if(walkers[i]!=null) {
        if(walkers[i].isWalking()) {
          Utility.image(frames[walkers[i].getCurrentFrame()],walkers[i].getPositionX(),
              walkers[i].getPositionY());
          walkers[i].setPositionX((walkers[i].getPositionX() + Utility.width() + 3)
              % Utility.width());
          walkers[i].update();
        }else {
          Utility.image(frames[walkers[i].getCurrentFrame()],walkers[i].getPositionX(),
              walkers[i].getPositionY());
        }   
      }
    }
  }

  /*
   * Checks to see if the mouse is over the walker input
   * 
   * @param walker a Walker
   * @return true if mouse is over the walker otherwise returns false
   */
  public static boolean isMouseOver(Walker walker) {
    //Checks if mouses x and y values are in the rectangle image of walker
    if (Utility.mouseX()>(walker.getPositionX()-(frames[0].width/2)) &&
        Utility.mouseX()<(walker.getPositionX()+(frames[0].width/2))) {
      if (Utility.mouseY()>(walker.getPositionY()-(frames[0].height/2)) &&
          Utility.mouseY()<(walker.getPositionY()+(frames[0].height/2))) {
        return true;        
      }
    }
    return false;
  }
  
  /*
   * When the mouse is over a walker which is not walking and is clicked the method makes the
   * walker starts walking
   */
  public static void mousePressed() {
    //Loops over every walker which is non-null and if the mouse is over the walker it sets
    //walking as true

    for(int i = 0;i<Walker.NUM_FRAMES;i++) {
      if(walkers[i]!=null) {
        if(isMouseOver(walkers[i])) {
          walkers[i].setWalking(true);
          
          //Break statement for when walkers are on top of each other
          //Since both would start walking we want the lowest index to start walking
          break;
        }
      }
    }
  }

  /*
   * when the 'a' key is pressed and there are null walkers it adds another walker at a 
   * random spot when the 's' key is pressed, any walker which was walking spots
   * 
   * @param key a char
   */
  public static void keyPressed(char key) {
    //Change to lower case so key works as both upper case and lower case
    
    //if the walker is null we assign it to a new walker which now has a value
    if (Character.toLowerCase(key)=='a') {
      for(int i =0; i<frames.length;i++) {
        if(walkers[i]==null) {
          walkers[i] = new Walker(randGen.nextInt(0,Utility.width()),
              randGen.nextInt(0,Utility.height()));

          break;
        }
      }
    }
    
    //if a walker is walking it stops when the 's' key is pressed
    if (Character.toLowerCase(key)=='s') {
      for(int i = 0; i<frames.length;i++) {
        if(walkers[i]!=null) {
          walkers[i].setWalking(false);
        }
      }
    }
  }
}
