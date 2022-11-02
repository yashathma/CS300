//////////////// Path Class //////////////////////////
//
// Title:    Intersection
// Course:   CS 300 Fall 2022
//
// Author:   Tanvi Wadhawan
// Email:    twadhawan@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Yash Athma
// Partner Email:   athma@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understand the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Path {
  private ArrayList<Intersection> intersections;// List of Intersections followed in this Path

  /**
   * Initializes this Path to start as empty
   */
  public Path() {
    intersections = new ArrayList<>();
  }

  /**
   * Returns the number of Intersections in this Path
   * 
   * @return the number of intersections in this Path
   */
  public int length() {
    return intersections.size();
  }

  /**
   * Returns the first Intersection in this Path, if it is not empty. Otherwise, throws a
   * NoSuchElementException.
   * 
   * @return the first Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getHead() throws NoSuchElementException {
    if (intersections.isEmpty()) {//base case
      throw new NoSuchElementException("No head");
    }
    return intersections.get(0);
  }

  /**
   * Returns the last Intersection in this Path, if it is not empty. Otherwise, throws a
   * NoSuchElementException.
   * 
   * @return the last Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getTail() throws NoSuchElementException {
    if (intersections.isEmpty()) {//base case
      throw new NoSuchElementException("No tail");
    }
    return intersections.get(intersections.size() - 1);
  }

  /**
   * Adds the given Intersection to the end of this Path if it is a valid addition. A Intersection
   * is a valid addition if the current Path is empty, or the Intersection to add is one step
   * directly east, or one step directly north of the current tail Intersection in this Path. Should
   * throw an IllegalArgumentException if the given Intersection is not a valid addition.
   * 
   * @param toAdd Intersection to add to the end of this Path
   * @throws IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addTail(Intersection toAdd) throws IllegalArgumentException {
    if (intersections.isEmpty()) {//base case
      intersections.add(toAdd);
    }
    //add tail if valid
    else if (toAdd.goWest().equals(intersections.get(intersections.size() - 1))) {
      intersections.add(toAdd);
    }
    //add tail if valid
    else if (toAdd.goSouth().equals(intersections.get(intersections.size() - 1))) {
      intersections.add(toAdd);
    } else {
      throw new IllegalArgumentException(
          "the Intersection to add is not valid " + "when calling the addTail method");
    }
  }

  /*
   * Adds the given Intersection to the front of this Path if it is a valid addition. A Intersection
   * is a valid addition if the current Path is empty, or the Intersection to add is one step
   * directly west, or one step directly south of the current head Intersection in this Path. Should
   * throw an * IllegalArgumentException if the given Intersection is not a valid addition.
   * 
   * @param toAdd - Intersection to add to the beginning of this Path
   * 
   * @throws IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addHead(Intersection toAdd) throws IllegalArgumentException {
    if (intersections.isEmpty()) {//base case
      intersections.add(0, toAdd);
    } 
    //add head if valid
    else if (toAdd.goEast().equals(getHead())) {
      intersections.add(0, toAdd);
    }
    //add head if valid
    else if (toAdd.goNorth().equals(getHead())) {
      intersections.add(0, toAdd);
    }
    else {
      throw new IllegalArgumentException("the Intersection to add is not valid " + 
    "when calling the addHead method");
    }


  }

  /*
   * Returns a String representing the coordinates taken in this Path. An empty Path should return
   * the String "Empty", while a non-empty Path should return the coordinates of the Intersections
   * it visits separated by a "->". For example: (0,0)->(1,0)->(1,1)->(1,2)
   * 
   * @return a String representing the coordinates followed by this Path
   */
  @Override
  public String toString() {
    if (intersections.isEmpty()) {
      return "Empty";
    }
    String finalStr = "";
    for (int i = 0; i < intersections.size(); i++) {
      if (i < intersections.size() - 1) {
        finalStr += intersections.get(i).toString() + "->";
      } else {
        finalStr += intersections.get(i).toString();
      }
    }
    return finalStr;
  }

}
