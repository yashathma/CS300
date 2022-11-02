//////////////// Intersection Class //////////////////////////
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
public class Intersection {
  private final int x;// X-axis coordinate of this intersection
  private final int y;// y-axis coordinate of this intersection

  /**
   * Initializes this intersection with the given coordinates
   * 
   * @param x Horizontal position of this Intersection
   * @param y Vertical position of this Intersection
   */
  public Intersection(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the horizontal position of this Intersection
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the vertical position of this Intersection
   */
  public int getY() {
    return y;
  }

  /**
   * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
   * 
   * @return a coordinate-pair representation of this Intersection
   */
  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }

  /**
   * Returns true if the given Object is identical to this Intersection
   * 
   * @param o object to compare for equality
   */
  @Override
  public boolean equals(Object o) {
    if(o instanceof Intersection) {
      if (this.x == ((Intersection) o).getX() && this.y == ((Intersection) o).getY()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Creates a new Intersection instance which is one step directly above this Intersection. Should
   * not modify the original Intersection object.
   * 
   * @return a new Intersection instance which is one step directly above this Intersection
   */
  public Intersection goNorth() {
    Intersection new1 = new Intersection(x, y + 1);
    return new1;
  }

  /**
   * Creates a new Intersection instance which is one step directly below this Intersection. Should
   * not modify the original Intersection object.
   * 
   * @return a new Intersection instance which is one step directly below this Intersection
   */
  public Intersection goSouth() {
    Intersection new1 = new Intersection(x, y - 1);
    return new1;
  }

  /**
   * Creates a new Intersection instance which is one step directly to the right of this
   * Intersection. Should not modify the original Intersection object.
   * 
   * @return a new Intersection instance which is one step directly to the right of this
   *         Intersection
   */
  public Intersection goEast() {
    Intersection new1 = new Intersection(x + 1, y);
    return new1;
  }

  /**
   * Creates a new Intersection instance which is one step directly to the left of this
   * Intersection. Should not modify the original Intersection object.
   * 
   * @return a new Intersection instance which is one step directly to the left of this Intersection
   */
  public Intersection goWest() {
    Intersection new1 = new Intersection(x - 1, y);
    return new1;
  }


}
