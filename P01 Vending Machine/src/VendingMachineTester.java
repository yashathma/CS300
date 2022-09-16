// Title:    VendingMachinr.java Tester Class
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

import java.util.Arrays;
/*
 * This class tests the methods created in VendingMachine.java returns True if zero bugs 
 * detected, 
 * else returns False
 */
public class VendingMachineTester {
  
  /*
   * Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did"
            + " not return -1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem "
            + "did not return the expected output when the vending machines contains"
            + " multiple matches with the provided item description and the matching "
            + "item with the soonest expiration date is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did"
            + " not return the expected output when the vending machines contains multiple"
            + " matches with the provided item description and the matching item with the "
            + "soonest expiration date is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did"
            + " not return the expected output when the vending machines contains matches"
            + " with the provided item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }
  
  /*
   * Checks the correctness of containsItem defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testContainsItem() {
// 1. Test if the description (name) is not in the vending machine, expect False
// (unsuccessful search returning false)
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.containsItem("Apple", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem did not return "
                + "false when no match found.");
        return false;
      }
      
      // Check that the containsItem method did not make change to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    
// 2. Test if the description (name) is in the vending machine, expect True
// (successful search returning true)
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (!VendingMachine.containsItem("Water", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 2. Problem detected: Your containsItem did not return "
                + "True when a was match found.");
        return false;
      }
      
      // Check that the containsItem method did not make change to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testContainsItem-scenario 2. Problem detected: Your containsItem made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    

// Correctly checked that there was and wasn't a description (name) in the the vending machine
    return true;
  }
  
  /*
   * Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemAtIndex() {
// 1. Test when provided index is out of the range of the provided vending machine array
     {
       // define the vending machine
       String[][] items =
           new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
       int itemsCount = 3;

       // check the correctness of the output
       if (!VendingMachine.getItemAtIndex(3, items, itemsCount).equals("ERROR INVALID INDEX")) {
         System.out.println(
             "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return "
                 + "'ERROR INVALID INDEX' when the input index was out of range"
                 + " of the input array.");
         return false;
       }
       
       // Check that the getItemAtIndex method did not make changes to the contents 
       // of the array items passed as input
       String[][] originalItems =
           new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
       if (!Arrays.deepEquals(items, originalItems)) {
         System.out.println(
             "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex made "
                 + "changes to the content of the array passed as input.");
         return false;
       }
     }
     
// 2. Test when provided index is in the range of the provided vending machine array
     {
       // define the vending machine
       String[][] items =
           new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
       int itemsCount = 3;

       // check the correctness of the output
       if (!VendingMachine.getItemAtIndex(1, items, itemsCount).equals("Water (20)")) {
         System.out.println(
             "testGetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did not return "
                 + "the correct value at the input index in the Vending Machine array"
                 + " or output syntax was incorrect");
         return false;
       }
       
       // Check that the getItemAtIndex method did not make changes to the contents 
       // of the array items passed as input
       String[][] originalItems =
           new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
       if (!Arrays.deepEquals(items, originalItems)) {
         System.out.println(
             "testGetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex made "
                 + "changes to the content of the array passed as input.");
         return false;
       }
     }

//Correctly retrieved the item at the given input index
    return true;
  }
  
  /*
   * Checks the correctness of getItemOccurrences defined in the VendingMachine class. 
   * This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsOccurrences() {
// 1. Test for when there is no match found in the Vending Machine, expect 0
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getItemOccurrences("Soda", items, itemsCount)!=0) {
        System.out.println(
            "testGetItemsOccurrences-scenario 1. Problem detected: Your getItemOccurrences"
            + " did not return 0 when the Vending Machine did not contain the item");
        return false;
      }
      
      // Check that the getItemOccurrences method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetItemsOccurrences-scenario 1. Problem detected: Your getItemOccurrences made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    
// 2. Test for when there is a match found in the Vending Machine, expect 2
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getItemOccurrences("Water", items, itemsCount)!=2) {
        System.out.println(
            "testGetItemsOccurrences-scenario 2. Problem detected: Your getItemOccurrences"
            + " did not return 2 when the Vending Machine contained 2 water items");
        return false;
      }
      
      // Check that the getItemOccurrences method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetItemsOccurrences-scenario 2. Problem detected: Your getItemOccurrences made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    
//getItemOccurrences correctly counts how many times an item occurs in the Vending Machine
    return true;
    
  }

  
  /*
   * Checks the correctness of addItem defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testAddItem() {
// 1. Test when adding a new item to an empty vending machine whose size is zero
    {
      // define the vending machine
      String[][] items = new String[][] {null, null, null, null};
      int itemsCount = 0;

      // check the correctness of the output
      if (VendingMachine.addItem("Water", "10", items, itemsCount)!=1) {
        System.out.println(
            "testAddItem-scenario 1. Problem detected: Your addItem did not return "
                + "1 when one item was added to an empty Vending Machine");
        return false;
      }
      
      // Check that the addItem method correctly added the item and its expiration date
      String[][] newItems =
          new String[][] {{"Water", "10"}, null, null, null};
      if (!Arrays.deepEquals(items, newItems)) {
        System.out.println(
            "testAddItem-scenario 1. Problem detected: Your addItem did not correctly add "
            + "the new item to the vending machine");
        return false;
      }
    }
  
 // 2. Test when adding a new item to a non-empty non-full Vending machine
    {
      // define the vending machine
      String[][] items = new String[][] {{"Coke", "18"}, null, null, null};
      int itemsCount = 1;

      // check the correctness of the output
      if (VendingMachine.addItem("Water", "10", items, itemsCount)!=2) {
        System.out.println(
            "testAddItem-scenario 2. Problem detected: Your addItem did not return "
                + "2 when one item was added to a Vending Machine with an existing item");
        return false;
      }
      
      // Check that the addItem method correctly added the item and its expiration date
      String[][] newItems =
          new String[][] {{"Coke", "18"}, {"Water", "10"}, null, null};
      if (!Arrays.deepEquals(items, newItems)) {
        System.out.println(
            "testAddItem-scenario 2. Problem detected: Your addItem did not correctly add "
            + "the new item to the vending machine with an existing item");
        return false;
      }
    }
    
 // 3. Test when adding a new item to a full vending machine
    {
      // define the vending machine
      String[][] items = 
          new String[][] {{"Coke", "18"}, {"Water", "10"}, {"Juice", "17"}, {"Ale", "14"}};
      int itemsCount = 4;

      // check the correctness of the output
      if (VendingMachine.addItem("Water", "10", items, itemsCount)!=4) {
        System.out.println(
            "testAddItem-scenario 3. Problem detected: Your addItem did not return "
                + "Vending Machine size when an item was added to a full Vending Machine");
        return false;
      }
      
      // Check that the addItem method didn't change the original Vending Machine values
      String[][] newItems =
          new String[][] {{"Coke", "18"}, {"Water", "10"}, {"Juice", "17"}, {"Ale", "14"}};
      if (!Arrays.deepEquals(items, newItems)) {
        System.out.println(
            "testAddItem-scenario 3. Problem detected: Your addItem changed the values"
            + " in the original Vending Machine when it was originally full");
        return false;
      }
    }
    
//the addItem method correctly added the new item to the vending machine or correctly
//performed when it was full
    return true;
  }

  /*
   * Checks the correctness of removeNextItem defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testRemoveNextItem() {

// 1. Test when trying to remove a non-existing item from a vending machine (Not Empty)
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Coke", items, itemsCount)!=3) {
        System.out.println(
            "testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem did not return "
                + "the original size when the original Vending machine didnt contain the value "
                + "you were trying to remove.");
        return false;
      }
      
      // Check that the removeNextItem method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Chocolate", "10"}, {"Water", "20"}, {"Juice", "15"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem made "
                + "changes to the content of the array passed as input when it shouldnt have"
                + " made changes");
        return false;
      }
    }
    
// 2. Test when the next item to be removed matching the provided description 
 //is at index 0 of the array
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Chocolate", "10"}, {"Salad", "20"}, {"Juice", "15"}, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Chocolate", items, itemsCount)!=2) {
        System.out.println(
            "testRemoveNextItem-scenario 2. Problem detected: Your removeNextItem did not return "
                + "the correct size of the Vending Machine when the first item needed to be"
                + " removed");
        return false;
      }
      
      // Check that the removeNextItem method only removed the value at the first index
      String[][] originalItems =
          new String[][] {{"Salad", "20"}, {"Juice", "15"},null,null};
          
      if (Arrays.equals(items, originalItems)) {
        System.out.println(
            "testRemoveNextItem-scenario 2. Problem detected: Your"
            + " removeNextItem incorrectly removed"
            + " the first index of the Vending Machine");
        return false;
      }
    }
    
 // 3. Test when the next item to be removed matching the provided description
 //is at the last index of the vending machine
       {
         // define the vending machine
         String[][] items =
             new String[][] {{"Juice", "15"}, {"Chocolate", "20"}, {"Chocolate", "10"}, null};
         int itemsCount = 3;

         // check the correctness of the output
         if (VendingMachine.removeNextItem("Chocolate", items, itemsCount)!=2) {
           System.out.println(
               "testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem did "
               + "not return the correct size of the Vending Machine when the last item "
               + "needed to be removed");
           return false;
         }
         
         // Check that the removeNextItem method only removed the value at the last index
         String[][] originalItems =
             new String[][] {{"Juice", "15"}, {"Chocolate", "20"}, null};
         if (Arrays.deepEquals(items, originalItems)) {
           System.out.println(
               "testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem incorrectly"
               + " removed the last index of the Vending Machine");
           return false;
         }
       }
       
// 4. Test when the next item to be removed is at a middle index of the provided items array.
      {
        // define the vending machine
        String[][] items =
            new String[][] {{"Chocolate", "20"}, {"Chocolate", "10"}, {"Juice", "15"}, null};
        int itemsCount = 3;

        // check the correctness of the output
        if (VendingMachine.removeNextItem("Chocolate", items, itemsCount)!=2) {
          System.out.println(
              "testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem did not return "
                  + "the correct size of the Vending Machine when the item in the"
                  + " middle needed to "
                  + "be removed");
          return false;
        }
        
        // Check that the removeNextItem method only removed the value at the middle index
        String[][] originalItems =
            new String[][] {{"Chocolate", "20"}, {"Juice", "15"}, null};
        if (Arrays.deepEquals(items, originalItems)) {
          System.out.println(
              "testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem"
              + " incorrectly removed the middle index of the Vending Machine");
          return false;
        }
      }

// the removeNextItem correctly removed the item with the smallest expiration date
    return true;
  }
  
  /*
   * Checks the correctness of getItemsSummary defined in the VendingMachine class. This method
   * returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsSummary() {
// 1. Test output when the vending machine is empty, expect ""
    {
      // define the vending machine
      String[][] items =
          new String[][] {null, null, null, null};
      int itemsCount = 0;

      // check the correctness of the output
      if (!VendingMachine.getItemsSummary(items, itemsCount).equals("Vending Machine is Empty")) {
        System.out.println(
            "testGetItemsSummary-scenario 1. Problem detected: Your getItemsSummary"
            + " did not return an empty string when the vending machine was empty");
        return false;
      }
      
      // Check that the getItemsSummary method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {null, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetItemsSummary-scenario 1. Problem detected: Your getItemsSummary made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    
// 2. Test output when the vending machine when there are non duplicate items
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (!VendingMachine.getItemsSummary(items, itemsCount).equals("Water (1)"
          + " Chocolate (1) Juice (1) ")) {
        System.out.println(
            "testGetItemsSummary-scenario 2. Problem detected: Your getItemsSummary did"
            + " not return the proper summary when there are non duplicate items");
        return false;
      }
      
      // Check that the getItemsSummary method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetItemsSummary-scenario 2. Problem detected: Your getItemsSummary made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
  
// 3. Test output when the vending machine contains multiple items with the same description at 
//various index locations
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, 
        {"Juice", "20"}, {"Chocolate", "10"}, null};
      int itemsCount = 5;

      // check the correctness of the output
      if (!VendingMachine.getItemsSummary(items, itemsCount).equals("Water (1)"
          + " Chocolate (2) Juice (2) ")) {
        System.out.println(
            "testGetItemsSummary-scenario 3. Problem detected: Your getItemsSummary did not return "
                + "the proper summary when there are duplicate items");
        return false;
      }
      
      // Check that the getItemsSummary method did not make changes to the contents 
      // of the array items passed as input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Juice", "20"}, 
        {"Chocolate", "10"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetItemsSummary-scenario 3. Problem detected: Your getItemsSummary made "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    
//The summary of items was read and displayed correctly
    return true;
  }

  
  /*
   * runs every test and checks if everything returns true meaning it didnt catch any bugs
   */
  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    
    //testing to see if each test is false
    if (!testGetIndexNextItem()){
      System.out.println("testGetIndexNextItem(): false");
      return false;
    }
    if (!testContainsItem()){
      System.out.println("testContainsItem(): false");
      return false;
    }
    if (!testGetItemAtIndex()){
      System.out.println("testGetItemAtIndex(): false");
      return false;
    }
    if (!testGetItemsOccurrences()){
      System.out.println("testGetItemsOccurrences(): false");
      return false;
    }
    if (!testAddItem()){
      System.out.println("testAddItem(): false");
      return false;
    }
    if (!testRemoveNextItem()){
      System.out.println("testRemoveNextItem(): false");
      return false;
    }
    if (!testGetItemsSummary()){
      System.out.println("testGetItemsSummary(): false");
      return false;
    }
    //all tests returned true, no bugs detected
    return true; 
  }

  /*
   * main method to call the tester methods defined in this class
   */
  public static void main(String[] args) {
    runAllTests();
  }

}
