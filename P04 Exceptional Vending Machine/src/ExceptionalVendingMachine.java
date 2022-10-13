//////////////// ExceptionalVendingMachine class for P04 //////////////////////////
//
// Title:   ExceptionalVendingMachine Object
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class models a vending machine. When requested, the item with the soonest expiration date
 * will be dispensed first.
 */
public class ExceptionalVendingMachine {
  private Item[] items; // array storing the items available within this vending machine
  private int size; // number of items available in this vending machine

  /**
   * Creates a new vending machine with a given capacity
   * 
   * @param capacity maximum number of items that can be held by this vending machine
   * @throws IllegalArgumentException with a descriptive error message if capacity is zero or
   * negative
   */
  public ExceptionalVendingMachine(int capacity) throws IllegalArgumentException {
    if(capacity<=0) {
      throw new IllegalArgumentException("The input capcity for the ExceptionalVendingMachine "
          + "constructor was less than or equal to zero");
    }else {
      items = new Item[capacity];
      size = 0;
    }

  }

  /**
   * Checks whether this vending machine is empty
   * 
   * @return true if this vending machine is empty, false otherwise
   */
  public boolean isEmpty() {
    if(this.size==0) {
      return true;
    }

    return false;
  }

  /**
   * Checks whether this vending machine is full
   * 
   * @return true if this vending machine is full, false otherwise
   */
  public boolean isFull() {
    if(this.items.length==this.size) {
      return true;
    }
    return false;
  }

  /**
   * Returns the total number of items available in this vending machine
   * 
   * @return the size of this vending machine
   */
  public int size() {
    return size;
  }

  /**
   * Appends an item defined by its description and expirationDate to this vending machine. The item
   * will be added to the end of the vending machine.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a positive integer which represents the expiration date of the item.
   * @throws IllegalStateException    with a descriptive error message if the vending machine is
   *                                  full
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank or if expirationDate is negative ( &lt; 0)
   */
  public void addItem(String description, int expirationDate)
      throws IllegalStateException, IllegalArgumentException{
      if(items.length==size) {
        throw new IllegalStateException("The vending machine is full when calling the addItem"
            + " method");
      }else if(description == null) {
        throw new IllegalArgumentException("The input description was null when calling the"
            + " addItem Method");
      } else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was empty when calling the"
            + " addItem Method");
      } else if(expirationDate<0) {
        throw new IllegalArgumentException("The input expirationDate was negative when calling"
            + " the addItem Method");
      } else {
        // create a new item and add it to the end of this vending machine
        items[size] = new Item(description, expirationDate);
        size++;
      }
  }

  /**
   * Returns without removing the string representation of the item at the given index within the
   * vending machine
   * 
   * @param index index of an item within the vending machine
   * @return the string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description: expirationDate".
   * @throws IndexOutOfBoundsException with a descriptive error message if index &lt; 0 or index
   *                                   &gt;= size of the vending machine
   */
  public String getItemAtIndex(int index) throws IndexOutOfBoundsException{

      if(index<0) {
        throw new IndexOutOfBoundsException("The input index was negative when calling the"
            + " getItemAtIndex method");
      }else if(index>=size) {
        throw new IndexOutOfBoundsException("The input index was greater than or equal to"
            + " the size of the veinding machine when calling the getItemAtIndex method");
      } else {
        return items[index].toString();
      }

    
  }

  /**
   * Returns the number of occurrences of items with a given description within this vending machine
   * 
   * @param description description (name) of an item
   * @return the number of occurrences of items with a given description within the vending machine
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   */
  public int getItemOccurrences(String description) throws IllegalArgumentException{

      if(description == null) {
        throw new IllegalArgumentException("The input description was null when calling the"
            + " getItemOccurrences Method");
      } else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was blank when calling the"
            + " getItemOccurrences Method");
      } else {
        int nbOccurrences = 0;
        for (int i = 0; i < size; i++) {
          if (description.equals(items[i].getDescription())) {
            nbOccurrences++;
          }
        }
        return nbOccurrences;
      }

  }

  /**
   * Checks whether the vending machine contains at least one item with the provided description
   * 
   * @param description description (name) of an item to search
   * @return true if there is a match with description in the vending machine, false otherwise
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   */
  public boolean containsItem(String description) throws IllegalArgumentException{

      if(description==null) {
        throw new IllegalArgumentException("The input description was null when calling the containsItem method");
      } else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was empty when calling the containsItem method");
      }else {
        return getItemOccurrences(description) != 0;
      }

  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   * @throws IllegalArgumentException with a descriptive error message if expirationDate is negative
   *                                  (less than zero) or description is null or blank
   */
  public int getItemOccurrencesByExpirationDate(String description, int expirationDate)
      throws IllegalArgumentException {

      if(description==null) {
        throw new IllegalArgumentException("The input description was null when calling"
            + " the getItemOccurrencesByExpirationDate method");
      }else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was empty when calling"
            + " the getItemOccurrencesByExpirationDate method");
      }else if(expirationDate<0) {
        throw new IllegalArgumentException("The input expirationDate was negative when"
            + " calling the getItemOccurrencesByExpirationDate method");
      }else {
        int nbOccurrences = 0; // number of occurrences of the matching items
        // traverse the vending machine looking for matching items
        for (int i = 0; i < size; i++) {
          if (description.equals(items[i].getDescription())
              && items[i].getExpirationDate() >= expirationDate) {// match found
            nbOccurrences++;
          }
        }
        // return the number of occurrences of the matching items
        return nbOccurrences;
      }

  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine.
   * 
   * @param description description of an item
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date.
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   * @throws NoSuchElementException   with a descriptive error message if no match found
   */
  public int getIndexNextItem(String description)
      throws IllegalArgumentException, NoSuchElementException {
      if(description==null) {
        throw new IllegalArgumentException("The input description was null when calling the"
            + " getIndexNextItem method");
      }else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was empty when calling the"
            + " getIndexNextItem method");
      } else {
        
        int index = -1; // index of the search item
        int minExpirationDate = -1; // smallest expiration date of matching items

        // traverse the vending machine looking for the matching item with the smallest
        // expiration date
        for (int i = 0; i < size; i++) {
          if (description.equals(items[i].getDescription())) {
            int itemExpirationDate = items[i].getExpirationDate();
            if (index == -1) { // first match found
              minExpirationDate = items[i].getExpirationDate();
              index = i;
            } else { // another match found
              if (itemExpirationDate < minExpirationDate) {
                // match with smaller (sooner) expiration date found
                minExpirationDate = itemExpirationDate; // update minimum expiration date
                index = i; // update the index of the next item
              }
            }
          }
        }
        
        if(index==-1) {
          throw new NoSuchElementException("The input description was not in the vending machine"
              + " when calling the getIndexNextItem method");
        }
        
        return index; // return the index of the item with the given description and the smallest
             
      }
  }

  /**
   * Removes and returns the item having the provided description with the smallest expiration date
   * within the vending machine. This method should maintain the order of precedence of items in the
   * vending machine. This means that the remove operation involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @return The removed or dispensed item if it is available
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   * @throws NoSuchElementException   with a descriptive error message if no match found
   * 
   */
  public Item removeNextItem(String description)
      throws IllegalArgumentException, NoSuchElementException{

      if(description==null) {
        throw new IllegalArgumentException("The input description was null when calling the"
            + " removeNextItem method");
      }else if(description.equals("")) {
        throw new IllegalArgumentException("The input description was empty when calling the"
            + " removeNextItem method");
      } else {
        
        // get the index of the next item to dispense by this vending machine
        int index = getIndexNextItem(description); // exceptions throws by this method call should
                                                   // propagate
        
        if(index == -1) {
          throw new NoSuchElementException("The input description was not in the vending machine"
              + " when calling the removeNextItem method");
        }

        // save a copy of the item to dispense
        Item itemToDispense = items[index];

        // remove the item at index using a shift operation
        for (int i = index + 1; i < size; i++) {
          items[i - 1] = items[i];
        }
        items[size - 1] = null;
        size--;
        return itemToDispense; // return the removed item
      }
      
  }

 
  /**
   * Returns a summary of the contents of this vending machine in the following format: Each line
   * contains the description or item name followed by one the number of occurrences of the item
   * name in the vending machine between parentheses. For instance, if the vending machine contains
   * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
   * follows. water (5)\n chocolate (10)\n snack (7) If the vending machine is empty, this method
   * returns an empty string ""
   * 
   * @return a descriptive summary of the contents of the vending machine
   */
  public String getItemsSummary() {
    
    String summary = ""; // empty string

    // traverse the vending machine and build its items summary description
    for (int i = 0; i < size; i++) {
      // add the item's description and count if not yet processed
      if (!summary.contains(items[i].getDescription())) {
        summary = summary + items[i].getDescription() + " ("
            + getItemOccurrences(items[i].getDescription()) + ")\n";
      }
    }
    return summary.trim(); // return the items' summary
  }

  /**
   * Parse an item's string representation and add the corresponding item to this vending machine
   * 
   * @param itemRepresentation a String representation of an item formatted as "description:
   *                           expirationDate". Extra spaces at the beginning and end of the item
   *                           description and expirationDate can be disregarded.
   * @throws IllegalArgumentException with a descriptive error message if itemRepresentation is null
   *                                  or blank
   * @throws DataFormatException      with a descriptive error message if the provided string is not
   *                                  correctly formatted. A correct format of the
   *                                  itemRepresentation is "description: expirationDate". The
   *                                  description must be a NOT blank string. The expirationDate
   *                                  must be a non-empty string parsable to a positive integer.The
   *                                  item's description and its expiration date must be separated
   *                                  by one colon ":". Extra whitespace at the beginning and end of
   *                                  description or expirationDate should be disregarded.
   * @throws IllegalStateException    with a descriptive error message if the vending machine is
   *                                  full
   */
  public void loadOneItem(String itemRepresentation)
      throws IllegalArgumentException,DataFormatException,IllegalStateException{
    // TODO Complete the implementation of this method with respect to the details provided above
    // TODO Add throws declarations to the method signature as required

    // [HINT] Use String.split() and String.trim() methods to help parsing the itemRepresentation
    // This method MUST call addItem(String, int) to try adding the parsed item to the vending
    // machine

    // This is a complex method. Try to decompose it into steps. We highly recommend breaking its
    // functionality down the way that you see fits using private helper methods.

      if(itemRepresentation==null) {
        throw new IllegalArgumentException("The input itemRepresentation was null when calling the"
            + " loadOneItem method");
      } else if(itemRepresentation.isBlank()) {
        throw new IllegalArgumentException("The input itemRepresentation was empty when"
            + " calling theloadOneItem method");
        
      }else if(isFull()) {
        throw new IllegalStateException("The veinding machine was full when "
            + "calling the loadOneItem method");
      }
      try {
        
        itemRepresentation = itemRepresentation.trim();
        String[] values = itemRepresentation.split(":", 2);
        
        
        String desc = values[0].trim();
        
        if(desc.isBlank() || desc == null) {
          throw new IllegalArgumentException("The Description was blank or null when "
              + "calling the loadOneItem method");
        }
        
        String exps = values[1].trim();
        int exp = Integer.parseInt(exps);
        if(exp<0) {
          throw new DataFormatException("The experation date passed when calling the "
              + "loadOneItem method was negative");
        }
        addItem(desc,exp);
        
      } catch(IllegalArgumentException e) {
        throw new DataFormatException("The experation date was negative "
            + "when calling the loadOneItem method");
      }

  }

  /**
   * Reads and parses the file passed as input line by line and loads the corresponding items to the
   * vending machine. Each line in the file represents an item description formatted as
   * "description: expirationDate". Blank and badly formatted lines must be skipped.
   * 
   * Displays "Vending machine FULL. No more items can be loaded." when trying to load a new item to
   * the vending machine if it is or becomes full.
   * 
   * @param file file to load items from
   * @return the total number of new items loaded to this vending machine
   * @throws FileNotFoundException if the file object does not correspond to an actual file within
   *                               the file system.
   * @throws DataFormatException 
   * @throws IllegalStateException 
   */
  public int loadItems(File file) throws FileNotFoundException{
    Scanner scanner = new Scanner(file);
    
    int counter = 0;
    
    while(scanner.hasNextLine()) {
      String next = scanner.nextLine();
      if(isFull()) {
        System.out.println("The vendingmachine was full when calling the loadItems method.");
        break;
      }
      try {
        loadOneItem(next);
        counter++;
      } 
      catch(DataFormatException data){
        data.printStackTrace();
      }
      catch(IllegalArgumentException arg) {
        arg.printStackTrace();
      }
      
    }
    

    return counter; // default return statement. Feel free to change it.
  }

  /**
   * Saves the summary of this vending machine to the file object passed as input
   * 
   * @param file file object where the vending machine summary will be saved
   */
  public void saveVendingMachineSummary(File file) {

    try {
      FileWriter writer = new FileWriter(file);
      
      writer.write(getItemsSummary());
      
      writer.close();
    } catch(Exception e) {
      e.getStackTrace(); 
    }
  }

}
