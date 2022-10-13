////////////////  Item class for P04 //////////////////////////
//
// Title:    Exceptional Item Object for Exceptional Mending Machine 
// Course:   CS 300 Fall 2022
//
// Author:   Yash Athma
// Email:    athma@wisc.edu
// Lecturer: Mouna Kacem
//
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

public class Item {
  private String description; //represents a human readable description of the item.
  private int expirationDate; //the expiration date of the item
  
  /*
   * Creates a new Item Object with a specific expiration date and description
   * 
   * @param
   * description - a human readable description of this item
   * expirationDate - a positive integer starting at day 0, which represents Jan 1, 2023
   * 
   * @throws IllegalArgumentException if expirationDate is negative (less than zero)
   * or description is null or blank

   */
  public Item(String description, int expirationDate) throws IllegalArgumentException{
    if(expirationDate<0) {
      throw new IllegalArgumentException("The constructor input expirationDate was less than 0");
    }else if(description == null) {
      throw new IllegalArgumentException("The constructor input description was null");
    }else if(description.isBlank()){
      throw new IllegalArgumentException("The constructor input description was blank");
    }else {
      this.description = description;
      this.expirationDate = expirationDate;
    }
  }
  
  /*
   * Gets the description of this item
   * 
   * @returns the description of this item
   */
  public String getDescription() {
    return this.description;
  }
  
  /*
   * Changes the description of this item
   * 
   * @param description - new description of the item
   * @throws IllegalArgumentException - if description is null or blank
   */
  public void setDescription(String description) throws IllegalArgumentException {
    try {
      if(description == null) {
        throw new IllegalArgumentException("The setDescription input description was null");
      }else if(description.equals("")){
        throw new IllegalArgumentException("The setDescription input description was blank");
      }else {
        this.description = description;
      }
    } catch(Exception e) {
      System.out.println(e);
      return;
    }
  }
  
  /*
   * Gets the expiration date of this item
   * 
   * @returns the expiration date of this item
   */
  public int getExpirationDate() {
    return this.expirationDate;
  }
  
  /*
   * Checks whether this item equals another object passed as input.
   * 
   * @Overrides equals in class Object
   * @returns true if other is instance of Item and has the same description as this item, false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Item) {
      Item otherItem = (Item) other;
      if(otherItem.getDescription().equals(this.description)) {
          return true;
      }
    }
    
    return false;
  }
  
  /*
   * Returns a String representation of this item formatted as "description: expirationDate"
   * 
   * @Overrides toString in class Object
   * @returns a String representation of this item
   */
  @Override
  public String toString() {
    return this.description+": "+Integer.toString(this.expirationDate);
  }
  
}
