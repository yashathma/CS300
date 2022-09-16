// Title:    P01 Vending Machine Assignment
// Course:   CS 300 Fall 2022
//
// Author:   Yash Athma
// Email:    athma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE

// Below is a javadoc class header to complete
/**
 * This class has all the methods for the Vending Machine assignment P01
 * 
 * @author TODO Yash Athma
 *
 */
public class VendingMachine {
  
  /*
   * Adds items to the vending machine if it is not already full
   */
  public static int addItem(String description, String expirationDate, String[][] items,
      int itemsCount) {
    //Check to see if vending machine is full
    if (itemsCount >= items.length) {
      return itemsCount;
    }
    //adding new item to vending machine
    items[itemsCount] = new String [] {description,expirationDate};

    // amount of items in vending machine must increase
    itemsCount+=1;
    
    //Finished adding item
    return itemsCount;
  }
  
  /*
   * Returns the description of an item along with its expiration date given an input index
   */
  public static String getItemAtIndex(int index, String[][] items, int itemsCount) {
    //Check to see if the given index is valid
    if(index>=itemsCount || index<0) {
      return "ERROR INVALID INDEX";
    }
    
    //returning the item at the given index in the correct syntax
    return items[index][0]+" ("+items[index][1]+")";
  }
  
  /*
   *Returns the item with the smallest expiration date given the name of the item (Description)
   */
  public static int getIndexNextItem(String description, String[][] items, int itemsCount) {
    //Check to see if vending machine is empty
    if(itemsCount<=0) {
      return -1;
    }
    
    //Creating values used to keep track of what is the best item to return
    int index = -1;
    int minExpirationDate = Integer.MAX_VALUE;
    
    for(int i=0; i<itemsCount;i++) {
      //Check to see if the description of the two items are the same and it is 
      //the smallest expiration date
      if(items[i][0].equals(description) && minExpirationDate > Integer.parseInt(items[i][1])) {
        index = i;
        minExpirationDate = Integer.parseInt(items[i][1]);
      }
    }
    
    //Pulled the correct index of the matching description with the smallest expiration date
    return index;
  }
  
  /*
   *Removes the item having the provided description with the smallest expiration date within the
   *vending machine defined
   */
  public static int removeNextItem(String description, String[][] items, int itemsCount) {
    //Getting the index of the description with smallest expiration date
    int index = getIndexNextItem(description, items, itemsCount);
    
    //starting from the index shift all values left
    if(index >= 0) {
      for(int i = index; i<itemsCount-1;i++) {
        items[i][0] = items[i+1][0];
        items[i][1] = items[i+1][1];
      }
      //Adding null values after itemsCount
      for(int i = itemsCount-1; i<items.length;i++) {
        items[i] = null;
      }
      
      //Removing one from the counter
      itemsCount-=1;
    }
    
    //Returning count once done
    return itemsCount;
    
  }
  
  /*
   *Returns the number of occurrences of an item with a given description within the vending
   *machine
   */
  public static int getItemOccurrences(String description, String[][] items, int itemsCount) {
    //Counter to count how many times an item occurs
    int counter = 0;
    
    //going through each item in array and checking to see if it matches the description
    //and adding 1 every time it matches
    for(int i = 0; i<itemsCount; i++) {
      if (description.equals(items[i][0])) {
        counter++;
      }
    }
    
    //returning the total amount of times it occured
    return counter;
  }
  
  /*
   *Checks whether a vending machine contains at least an item with the provided description
   */
  public static boolean containsItem(String description, String[][] items, int itemsCount) {
    //looping through each item in vending machine and seeing if it matches the input description
    for(int i = 0; i<itemsCount; i++) {
      if(items[i][0].equals(description)) {
        return true;
      }
    }
    //if it has not returned true after looping through every item that means 
    //that the vending machine doesnt have the item
    return false;
  }
  
  /*
   *  Returns the number of items in the vending machine with a specific description and whose
   *  expiration dates are greater or equal to a specific expiration date
   */
  public static int getItemsOccurrencesByExpirationDate(String description, String expirationDate,
      String[][] items, int itemsCount) {
    //Creating counter to count how many items match the description and
    //have a larger expiration date
    int counter = 0;
    
    //Looping through each item to see which items work and dont
    for(int i = 0; i<itemsCount; i++) {
      if(items[i][0].equals(description) && 
          Integer.parseInt(expirationDate)<=Integer.parseInt(items[i][1])) {
        counter++;
      }
    }
    
    //returning the amount of times the vending machine had the item
    return counter;
  }
  
  /*
   *Displays the contents of the vending machine
   */
  public static String getItemsSummary(String[][] items, int itemsCount) {
    //Creating final string to add values to
    String returnFinal = "";
    
    //Check to see if its empty
    if (itemsCount<1) {
      return "Vending Machine is Empty";
    }
    
    //iterate through items in vending machine and adds their name and count to final string
    for(int i = 0; i<itemsCount; i++) {
      if(!returnFinal.contains(items[i][0])) {
        returnFinal += (items[i][0] + " (" + getItemOccurrences(items[i][0], items, itemsCount) + ") ");
      }
      
    }

    //returns all the values of the items in vending machine
    return returnFinal;
  }

}
