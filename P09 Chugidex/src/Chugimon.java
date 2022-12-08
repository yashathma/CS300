//////////////// Chugimon) //////////////////////////
//
// Title:    Chugimon Project
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
//   __x_ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understand the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
/**
 * Chugimon class
 * @author tanviwadhawan
 *
 */
public class Chugimon implements Comparable<Chugimon>{
  private final String NAME;//the name of the chugimon
  private final ChugiType PRIMARY_TYPE;//the primary type of the Chugimon; cannot be null;cannot 
  //be the same as the primary type
  private final double HEIGHT;//The height of the Chugimon in meters
  private final double WEIGHT;//The weight of the Chugimon in kilograms
  private final int FIRST_ID;//the first ID of the Chugimon
  static final int MAX_ID=ChugidexUtility.MAX_CHUGI_ID;//The maximum ID number
  static final int MIN_ID=ChugidexUtility.MIN_CHUGI_ID;//The minimum ID number
  private final int SECOND_ID;//The second ID of the Chugimon
  private final ChugiType SECONDARY_TYPE;//The secondary type of the Chugimon; may be null;
  //cannot be the same as the primary type
  
  /**
   * Creates a new Chugimon with specific first and second IDs and 
   * initializes all its data fields accordingly.
   * @param firstID-the first ID of the Chugimon, between 1-151
   * @param secondID-The second ID of the Chugimon, between 1-151
   */
  public Chugimon(int firstID, int secondID) throws IllegalArgumentException{
    if(firstID<1 || firstID > 151) {
      throw new IllegalArgumentException("The firstID is out of bounds");
    }
    if(secondID<1 || secondID > 151) {
      throw new IllegalArgumentException("The secondID is out of bounds");
    }
    if(firstID==secondID) {
      throw new IllegalArgumentException("The secondID is out of bounds");
    }
    this.NAME = ChugidexUtility.getChugimonName(firstID, secondID);
    this.FIRST_ID=firstID;
    this.SECOND_ID=secondID;
    this.PRIMARY_TYPE=ChugidexUtility.getChugimonTypes(firstID, secondID)[0];
    this.SECONDARY_TYPE=ChugidexUtility.getChugimonTypes(firstID, secondID)[1];
    this.HEIGHT=ChugidexUtility.getChugimonHeight(firstID, secondID);
    this.WEIGHT=ChugidexUtility.getChugimonWeight(firstID, secondID);

  }
  /**
   * Gets the name of this Chugimon
   * @return the name of the Chugimon
   */
  public String getName() {
    return this.NAME;
    
  }
  /**
   * Gets the first ID of this Chugimon
   * @return the first ID of the Chugimon
   */
  public int getFirstID() {
    return this.FIRST_ID;
    
  }
  /**
   * Gets the second ID of this Chugimon
   * @return the second ID of the Chugimon
   */
  public int getSecondID() {
    return this.SECOND_ID; 
  }
  /**
   * Gets the primary type of this Chugimon
   * @return the primary type of the Chugimon
   */
  public ChugiType getPrimaryType() {
    return this.PRIMARY_TYPE;
    
  }
  /**
   * Gets the secondary type of this Chugimon
   * @return the secondary type of the Chugimon
   */
  public ChugiType getSecondaryType() {
    return this.SECONDARY_TYPE;
    
  }
  /**
   * Gets the height of this Chugimon
   * @return the height of the Chugimon
   */
  public double getHeight() {
    return this.HEIGHT;    
  }
  /**
   * Gets the the weight of the Chugimon.
   * @return the weight of the Chugimon.
   */
  public double getWeight() {
    return this.WEIGHT;
    
  }
  /**
   * Determines the ordering of Chugimon. Chugimon are ordered by: 1) name (alphabetical) 
   * 2) the first ID (if name is equal). The one with the smaller first ID is less than the other. 
   * 3) the second ID (if name and first ID are equal). The one with the smaller second ID is less
   *  than the other. A Chugimon with identical #1-3 are considered equal.
   * @param otherChugi - the other Chugimon to compare this Chugimon to.
   * @return a negative int if this Chugimon is less than other, a positive int if this Chugimon
   *  is greater than other, or 0 if this and the other Chugimon are equal.
   */
  public int compareTo(Chugimon otherChugi) {
    //if 
    if(otherChugi.getName().compareTo(this.NAME)<0) {//if other Chugi is less than this
      return 1;
    } else if(otherChugi.getName().compareTo(this.NAME)>0){
      return -1;
    }
    
    if(otherChugi.getFirstID()<this.getFirstID()) {//if other Chugi is less than this
      return 1;
    } else if(otherChugi.getFirstID()>this.getFirstID()) {
      return -1;
    }
    
    if(otherChugi.getSecondID()<this.getSecondID()) {//if other Chugi is less than this
      return 1;
    } else if(otherChugi.getSecondID()>this.getSecondID()) {
      return -1;
    }

    return 0;
  }
  /**
   * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" -- 
   * Example: "Zapchu#145.25"
   * @return a String representation of this Chugimon
   */
  @Override
  public String toString() {
    return this.NAME + "#" + this.FIRST_ID + "." + this.SECOND_ID;
    
  }
  /**
   * Equals method for Chugimon. This Chugimon equals another object if other is a Chugimon 
   * with the exact same name, and their both first and second IDs match.
   * @param Object to determine equality against this Chugimon
   * @return true if this Chugimon and other Object are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Chugimon) {//if it's a chugimon
      Chugimon abc= (Chugimon) other;
      if(this.compareTo(abc)==0) {//check if equal
        return true;
      }

    }
    return false;

  }

}
