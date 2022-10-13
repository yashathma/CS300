//////////////// ExceptionalVendingMachineTester class for P04 //////////////////////////
//
// Title:    Tester ExceptionalVendingMachine
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


import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
  
  /**
   * Checks the correctness of the constructor of the class Item when passed invalid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorNotValidInput() {
    try {
      Item item = new Item("",1);
      
      System.out.println("No error was thrown when passing invalid inputs into the constructor"
          + " of Item");
      return false;
    }
    catch (IllegalArgumentException ignore){
      return true;
    } catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Checks the correctness of the constructor of the class Item, Item.getDescription(),
   * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorGettersSetters() {
    
    Item item = new Item("Apple",12);
    //Test getDescription and constructor
    if(!item.getDescription().equals("Apple")) {
      System.out.println("The item constructor assigned the description incorrectly to item "
          + "or the getDescription method did not return the right value");
      return false;
    }
    
    //Test getExpirationDate and constructor
    if(item.getExpirationDate()!=12) {
      System.out.println("The item constructor assigned the expiration date incorrectly to item"
          + " or the getExpirationDate method did not return the right value");
      return false;
    }
    
    //Test setDescription
    item.setDescription("Green Apple");
    if(!item.getDescription().equals("Green Apple")) {
      System.out.println("The setDescription method did not"
          + " correctly change the value of description");
      return false;
    }
    
    //Test toString
    if(!item.toString().equals("Green Apple: 12")) {
      System.out.println("The toString method did not correctly return"
          + " the compiled description and expiration date");
      return false;
    }

    //did not detect any bugs
    return true;
  }

  /**
   * Checks the correctness of the Item.equals() method.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemEquals() {
    
// (1) Create an item with valid description and expiration date, comparing it to
// itself should return true. 
    {
      Item item = new Item("Apple", 16);
      if(!item.equals(item)) {
        System.out.println("The equals method returned false when comparing the same "
            + "item to itself");
        return false;
      }
    }
    
// (2) Two items having the same description but different expiration
// dates should be equal. 
    
    {
      Item item = new Item("Apple", 16);
      Item itemTwo = new Item("Apple", 18);
      if(!item.equals(itemTwo)) {
        System.out.println("The equals method returned false when two items having the same"
            + " description but different expiration dates was the input");
        return false;
      }
    }
    
// (3) Passing a null reference to the Item.equals() method should return
// false. 
    
    {
      Item item = new Item("Apple", 16);
      Item itemTwo = null;
      if(item.equals(itemTwo)) {
        System.out.println("The equals method returned true when a null reference was an input"
            + " to be compared");
        return false;
      }
    }
    
// (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
// a string object.
    
    {
      Item item = new Item("Apple", 16);
      String test = "sadfasdf";
      
      if(item.equals(test)) {
        System.out.println("The equals method returned true when an Item object was compared"
            + " to a String object");
        return false;
      }
      
      
    }
    
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
   * input
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineConstructor() {
    try {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(-1);
      System.out.println("An error was not thrown when passing invalid inputs to the"
          + " ExceptionalVendingMachine constructor");
      return false;
    } catch(IllegalArgumentException ignore) {
      return true;
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  /**
   * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
   * when an exception is expected to be thrown:
   * 
   * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
   * getItemOccurrencesByExpirationDate(), removeNextItem().
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
    //Test addItem
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      
      try {
        vm.addItem(null, 0);
        System.out.println("The addItem method did not throw an"
            + " exception when the input description was null");
        return false;
      } catch(IllegalArgumentException ignore) {
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    
    //Test containsItem
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      try {
        vm.containsItem("");
        System.out.println("The containsItem method did not throw an "
            + "exception when an empty string was the input");
        return false;
      } catch(IllegalArgumentException ignore) {
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    
    //Test getIndexNextItem
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      try {
        vm.getIndexNextItem("");
        System.out.println("The getIndexNextItem method did not throw"
            + " an excpetion when the input description was empty");
        return false;
      } catch (IllegalArgumentException ignore){
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
      
    }
    
    //Test getItemAtIndex
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      try {
        vm.getItemAtIndex(7);
        System.out.println("The getItemAtIndex method did not throw an"
            + " excpetion when the input index was empty");
        return false;
      } catch (IndexOutOfBoundsException ignore){
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }

    }
    
    //Test getItemOccurrences
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      try {
        vm.getItemOccurrences(null);
        System.out.println("The getItemOccurrences method did not throw an"
            + " excpetion when the input was null");
        return false;
      } catch(IllegalArgumentException ignore) {
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
      
    }
    
    //Test getItemOccurrencesByExpirationDate
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      
      try {
        vm.getItemOccurrencesByExpirationDate("sdfsd",-7);
        System.out.println("The getItemOccurrences method did not throw an"
            + " excpetion when the input was invalid");
        return false;
      } catch(IllegalArgumentException ignore) {
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
      
    }
    
    //Test removeNextItem
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      
      try {
        vm.removeNextItem("sfgsdf");
        System.out.println("The removeNextItem method did not throw an"
            + " excpetion when the input was invalid");
        return false;
      } catch(NoSuchElementException ignore) {
      }
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
      
      
    }
    
    //No bug detected
    return true;
  }

  /**
   * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
   * ExceptionalVendingMachine class
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testEmptySizeFullExceptionalVendingMachine() {
    //Test isEmpty
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      
      if(!vm.isEmpty()) {
        System.out.println("The isEmpty method did not return true when the vending machine"
            + " was empty");
        return false;
      }
    }
    
    //Test size
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(10);
      vm.addItem("Apple", 7);
      if(vm.size()!=1) {
        System.out.println("The size method did not return the correct size of the vending machine");
        return false;
      }
    }
    
    //Test isFull
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(1);
      vm.addItem("Apple", 7);
      if(!vm.isFull()) {
        System.out.println("The isFull method did not return true when the vending machine was full");
        return false;
      }
    }

    //No bugs detected
    return true;
  }

  /**
   * Checks the correctness of loadOneItem method with respect to its specification. Consider at
   * least the four following scenarios. (1) Successful scenario for loading one item with a valid
   * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
   * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
   * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario for passing a
   * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
   * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
   * full vending machine. An IllegalStateException is expected to be thrown.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testLoadOneItem(){
// (1) Successful scenario for loading one item with a valid
// string representation to a non-full vending machine.
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(6);
      
      try {
        vm.loadOneItem("Apple: 7");
        if(!vm.getItemAtIndex(0).equals("Apple: 7")) {
          System.out.println("the loadOneItem method did not correctly add an item which should "
              + "have been added");
          return false;
        }
      } catch(Exception e) {
        System.out.println("The loadOneItem method threw an exception when it wasnt supposed to");
        return false;
      }

      

    }

// (2) Unsuccessful scenario for passing null
// or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
// IllegalArgumentEXception is expected to be thrown.
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(6);
      try {
        vm.loadOneItem(null);
        System.out.println("The loadOneItem method did not throw"
            + " an exception when the input was null");
        return false;
      } catch(IllegalArgumentException ignore) {
        
      }
      catch(Exception e) {
        e.printStackTrace();
        return false;
      }
    }

// (3) Unsuccessful scenario for passing a
// badly formatted string to the loadOneItem method. A DataFormatException is expected to be
// thrown.
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(6);
      try {
        vm.loadOneItem("    Apple  :    -7   ");
        System.out.println("The loadOneItem method was supposed to throw an"
            + " exception because the input string was invalid");
        return false;
      } catch(DataFormatException ignore) {
        
      }
      catch(Exception e) {
        e.printStackTrace();
        return false;
      }
    }

// (4) Unsuccessful scenario for trying to load an item with a valid representation to a
// full vending machine. An IllegalStateException is expected to be thrown.
    {
      ExceptionalVendingMachine vm = new ExceptionalVendingMachine(1);
      vm.addItem("Apple", 18);
      
      try {
        vm.loadOneItem("Apple: 7");
        System.out.println("The loadOneItem method did not throw an"
            + " exception when the vendingmachine was full");
        return false;
      } catch (IllegalStateException e) {

      }
      catch(Exception e) {
        e.printStackTrace();
        return false;
      }
      
    }
    
//No bugs detected
    return true;
  }

  /**
   * Invokes all the public tester methods implemented in this class
   * 
   * @return true if all testers pass with no errors, and false if any of the tester fails.
   */
  public static boolean runAllTests() {
    if(testItemConstructorNotValidInput()&&
        testItemConstructorGettersSetters()&&
        testItemEquals()&&
        testExceptionalVendingMachineConstructor()&&
        testExceptionalVendingMachineAddContainsRemoveGetters()&&
        testEmptySizeFullExceptionalVendingMachine()&&
        testLoadOneItem()) {

      return true;
    }
    return false; // default return statement added to resolve compiler errors
  }

  /**
   * Main method for the tester class
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }

}
