//////////////// Chugimon Tester //////////////////////////
//
// Title: Chugimon Project
// Course: CS 300 Fall 2022
//
// Author: Tanvi Wadhawan
// Email: twadhawan@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Yash Athma
// Partner Email: athma@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __x_ Write-up states that pair programming is allowed for this assignment.
// __x_ We have both read and understand the course Pair Programming Policy.
// __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 * 
 * @author tanviwadhawan, yash athma
 *
 */

public class ChugidexTester {
  public static boolean testChugimonCompareToEquals() {

    // first name is less
    {
      Chugimon chugi1 = new Chugimon(1, 8);// Bulbusaur
      Chugimon chugi2 = new Chugimon(1, 2);// Bulbysaur
      if (!(chugi1.compareTo(chugi2) < 0)) {
        // System.out.println("absb");
        return false;
      }
    }
    // second name is less
    {
      Chugimon chugi1 = new Chugimon(1, 2);
      Chugimon chugi2 = new Chugimon(1, 8);

      if (!(chugi1.compareTo(chugi2) > 0)) {
        // System.out.println("absb");
        return false;
      }
    }
    // names are equal, but first firstID is less than the second
    {
      Chugimon chugi1 = new Chugimon(4, 7);
      Chugimon chugi2 = new Chugimon(6, 7);
      if (!(chugi1.compareTo(chugi2) < 0)) {
        // System.out.println("absb");
        return false;
      }
    }
    // fourth case: names are equal, but first firstID is greater than the second
    {
      Chugimon chugi1 = new Chugimon(6, 7); // chartle
      Chugimon chugi2 = new Chugimon(4, 7); // chartle
      if (!(chugi1.compareTo(chugi2) > 0)) {
        // System.out.println("absb");

        return false;
      }
    }
    // fifth case: names and firstIDs are equal, but first secondID is less than the second
    {
      Chugimon chugi1 = new Chugimon(4, 25); //
      Chugimon chugi2 = new Chugimon(4, 26); //
      if (!(chugi1.compareTo(chugi2) < 0)) {
        return false;
      }
    }
    // sixth case: names and firstIDs are equal, but first secondID is greater than the second
    {
      Chugimon chugi1 = new Chugimon(4, 26); //
      Chugimon chugi2 = new Chugimon(4, 25); //
      if (!(chugi1.compareTo(chugi2) > 0)) {
        // System.out.println("absb");

        return false;
      }
    }
    // seventh case: tests compareTo and equals methods when objects are equal
    {
      Chugimon chugi1 = new Chugimon(4, 25); // name Venoeon
      Chugimon chugi2 = new Chugimon(4, 25); // name Venoeon
      if (!(chugi1.compareTo(chugi2) == 0) || !(chugi1.equals(chugi2))) {
        // System.out.println("abs1b");

        return false;
      }
    }
    // eighth case: tests equals method when objects aren't equal
    {
      Chugimon chugi1 = new Chugimon(4, 25); // name Venoeon
      Chugimon chugi2 = new Chugimon(4, 26); // name Venoeon
      if (chugi1.equals(chugi2)) {
        // System.out.println("absb");

        return false;
      }
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonToString() {
    Chugimon one = new Chugimon(4, 25);
    // System.out.println(one.toString());
    if (one.toString().equalsIgnoreCase("Charchu#4.25")) {
      return true;
    }
    return false; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
   * search order property is violated at at least one internal node.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsValidBSTHelper() {
    // 1 < 4 < 2 < 5 < 3
    // b < c < i < s < v
    Chugimon c1 = new Chugimon(1, 2); // Bulbysaur
    Chugimon c2 = new Chugimon(2, 3); // Ivyusaur
    Chugimon c3 = new Chugimon(3, 2); // Venuysaur
    Chugimon c4 = new Chugimon(4, 2); // Charysaur
    Chugimon c5 = new Chugimon(7, 2); // Squirtysaur


    BSTNode<Chugimon> n1 = new BSTNode<Chugimon>(c1);
    BSTNode<Chugimon> n2 = new BSTNode<Chugimon>(c2);
    BSTNode<Chugimon> n3 = new BSTNode<Chugimon>(c3);
    BSTNode<Chugimon> n4 = new BSTNode<Chugimon>(c4);
    BSTNode<Chugimon> n5 = new BSTNode<Chugimon>(c5);
    
    n5.setLeft(n4);
    n5.setRight(n3);
    n4.setLeft(n1);
    n4.setRight(n2);
    

    // case 1
    if (ChugiTree.isValidBSTHelper(null) == false) {
       System.out.println("fail1");

      return false;
    }

    // case 2
    if (ChugiTree.isValidBSTHelper(n5) == false) {
      System.out.println("fail2");
      return false;
    }

    // case 3
    // 4 < 2 < 5 < 3
    Chugimon d2 = new Chugimon(2, 3); // Ivyusaur
    Chugimon d3 = new Chugimon(3, 2); // Venuysaur
    Chugimon d4 = new Chugimon(4, 2); // Charysaur
    Chugimon d5 = new Chugimon(7, 2); // Squirtysaur


    BSTNode<Chugimon> nn2 = new BSTNode<Chugimon>(d2);
    BSTNode<Chugimon> nn3 = new BSTNode<Chugimon>(d3);
    BSTNode<Chugimon> nn4 = new BSTNode<Chugimon>(d4);
    BSTNode<Chugimon> nn5 = new BSTNode<Chugimon>(d5);
    nn2.setLeft(nn5);
    nn3.setRight(nn4);

    
    if (ChugiTree.isValidBSTHelper(nn2)) {
       System.out.println("fail3");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of both add() and toString() methods implemented
   * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
   * string representation of the contents of the binary search tree in an increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
   * sure that the add() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddToStringSize() {
    // test 1
    {
      ChugiTree tree = new ChugiTree();
      if (tree.size() != 0 || !tree.isEmpty() || !tree.toString().equals("")) {
        System.out.println("test 1 L");
        return false;
      }
    }

    // test 2
    {
      ChugiTree tree = new ChugiTree();
      Chugimon c = new Chugimon(1, 2);
      if (tree.add(c) == false) {
        System.out.println("test 2 add L");
        return false;
      }
      if (tree.size() != 1 || tree.isEmpty() || !tree.toString().equals("Bulbysaur#1.2")
          || !tree.isValidBST()) {
        System.out.println("test 2.2 failed.");
        return false;
      }
    }

    // test 3
    {
      ChugiTree tree = new ChugiTree();
      Chugimon c = new Chugimon(1, 3); // Bulbusaur
      Chugimon c2 = new Chugimon(1, 2); // Bulbysaur
      if (tree.add(c) == false) {
        System.out.println("test 3 add L");
        return false;
      }
      if (tree.add(c2) == false) {
        System.out.println("test 3.2 add L");
        return false;
      }
      if (tree.size() != 2 || tree.isEmpty()
          || !tree.toString().equals("Bulbusaur#1.3,Bulbysaur#1.2")) {
        System.out.println("test 3.3 L");
        return false;
      }

      // test 4
      Chugimon c3 = new Chugimon(4, 35); // Charfairy
      if (tree.add(c3) == false) {
        System.out.println("test 4 L");
        return false;
      }
      if (tree.size() != 3 || tree.isEmpty()
          || !tree.toString().equals("Bulbusaur#1.3,Bulbysaur#1.2,Charfairy#4.35")) {
        System.out.println("test 4.2 L");
        return false;
      }

      // test 5
      Chugimon c4 = new Chugimon(11, 72); // Metacool
      Chugimon c5 = new Chugimon(16, 61); // Pidwhirl
      if (tree.add(c4) == false || tree.add(c5) == false) {
        System.out.println("test 5 add L");
        return false;
      }
      if (tree.size() != 5 || tree.isEmpty()
          || !tree.toString()
              .equals("Bulbusaur#1.3,Bulbysaur#1.2,Charfairy#4.35,Metacool#11.72,Pidwhirl#16.61")) {
        System.out.println("test 5.2 L");
        return false;
      }

      // test 6
      Chugimon c52 = new Chugimon(16, 61); // Pidwhirl
      if (tree.add(c52) != false || tree.size() != 5) {
        System.out.println("test 6 L");
        return false;
      }
    }

    return true;
  }

  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful search
   * operations. Make sure that the lookup() method returns the expected output for every method
   * call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // 1 < 4 < 2 < 5 < 3
    try {
      Chugimon c1 = new Chugimon(1, 2); // Bulbysaur
      Chugimon c2 = new Chugimon(2, 3); // Ivyusaur
      Chugimon c3 = new Chugimon(3, 2); // Venuysaur
      Chugimon c4 = new Chugimon(4, 2); // Charysaur
      Chugimon c5 = new Chugimon(7, 2); // Squirtysaur
      Chugimon notFound = new Chugimon(1, 120);// doesn't matter


      ChugiTree tree = new ChugiTree();
      // case 1
      if (tree.lookup(1, 2) != null) {// look for one
        return false;
      }

      tree.add(c1);
      tree.add(c2);
      tree.add(c3);
      tree.add(c4);
      tree.add(c5);


      // case 2
      if (!tree.lookup(2, 3).equals(c2)) {// found
        return false;
      }

      // case 3
      try {
        if (tree.lookup(1, 120).equals(notFound)) { // case 1: not found in the tree
          return false;
        }
      } catch (NullPointerException e) {
      }

      if (!tree.lookup(3, 2).equals(c3)) { // case 2: l right branch
        return false;
      }
      if (!tree.lookup(2, 3).equals(c2)) { // case 3: left branch
        // System.out.println("adf");
        return false;
      }
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }

  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCountType() {
    Chugimon c1 = new Chugimon(1, 2); // Bulbysaur
    Chugimon c2 = new Chugimon(2, 3); // Ivyusaur


    ChugiTree tree = new ChugiTree();
    tree.add(c1);
    tree.add(c2);

    // System.out.println(c1.getPrimaryType());
    // System.out.println(c1.getSecondaryType());
    // System.out.println(c2.getPrimaryType());
    // System.out.println(c2.getSecondaryType());
    if (tree.countType(ChugiType.GRASS) != 2 || tree.countType(ChugiType.POISON) != 2) {
      System.out.println("Method countType failed.");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ChugiTree with four levels for instance, is 4.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    Chugimon bulbysaur = new Chugimon(1, 2);
    Chugimon ivyusaur = new Chugimon(2, 3);
    Chugimon venuysaur = new Chugimon(3, 2);
    Chugimon charysaur = new Chugimon(4, 2);


    ChugiTree tree = new ChugiTree();

    // (1) ensures that the height of an empty Chugimon tree is zero.
    // test case 1

    if (tree.height() != 0) {
      System.out.println("the height of an empty tree was no zero");
      return false;
    }

    tree.add(bulbysaur);

    // (2) ensures that the height of a tree which consists of only one node is 1.
    // test case 2

    if (tree.height() != 1) {
      System.out.println("when adding one chugi to tree the height wasnt 1");
      return false;
    }

    tree.add(ivyusaur);
    tree.add(venuysaur);
    tree.add(charysaur);

    // (3) ensures that the height of a ChugiTree with four levels for instance, is 4.
    // test case 3

    if (tree.height() != 3) {
      System.out.println("once adding three more chugis the trees height wasnt 3");
      return false;
    }

    // no bugs detected
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetFirst() {
    try {
      Chugimon Bulbysaur = new Chugimon(1, 2);
      Chugimon Ivyusaur = new Chugimon(2, 3);
      Chugimon Venuysaur = new Chugimon(3, 2);
      Chugimon Charysaur = new Chugimon(4, 2);
      Chugimon Squirtysaur = new Chugimon(7, 2);



      // Chugimon 1 < 4 < 2 < 5 < 3

      ChugiTree chugiTree = new ChugiTree();
      chugiTree.add(Bulbysaur);
      chugiTree.add(Ivyusaur);
      chugiTree.add(Venuysaur);
      chugiTree.add(Charysaur);
      chugiTree.add(Squirtysaur);


      if (!chugiTree.getFirst().equals(Bulbysaur)) {
        // first chugi has to be bulbicate
        //System.out.println("testGetFirst method did not pull the correct chugi");
        return false;
      }
      return true;
    } catch (Exception e) {
//      System.out.println(e);
      return false;
    }

  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLast() {
    // creating tree

    Chugimon Bulbysaur = new Chugimon(1, 2);
    Chugimon Ivyusaur = new Chugimon(2, 3);
    Chugimon Venuysaur = new Chugimon(3, 2);
    Chugimon Charysaur = new Chugimon(4, 2);
    Chugimon Squirtysaur = new Chugimon(7, 2);



    ChugiTree chugiTree = new ChugiTree();
    chugiTree.add(Bulbysaur);
    chugiTree.add(Ivyusaur);
    chugiTree.add(Venuysaur);
    chugiTree.add(Charysaur);
    chugiTree.add(Squirtysaur);

    if (!chugiTree.getLast().equals(Venuysaur)) {
      // venuicate should be the last chugi
      System.out.println("getlast method did not return the right chugi");
      return false;
    }

    // no bugs detected
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDelete() {

    Chugimon Bulbysaur = new Chugimon(1, 2);
    Chugimon Ivyusaur = new Chugimon(2, 3);
    Chugimon Venuysaur = new Chugimon(3, 2);
    Chugimon Charysaur = new Chugimon(4, 2);
    Chugimon Squirtysaur = new Chugimon(7, 2);

    Chugimon c6 = new Chugimon(11, 20);


    ChugiTree chugTree = new ChugiTree();
    chugTree.add(Bulbysaur);
    chugTree.add(Ivyusaur);
    chugTree.add(Venuysaur);
    chugTree.add(Charysaur);
    chugTree.add(Squirtysaur);

    // test case 1
    boolean firstDeleted = chugTree.delete(Ivyusaur);
    if (!firstDeleted) {
      System.out.println("did not delete the first chugi, test case 1");
      return false;
    }
    if (chugTree.height() != 3 || !(chugTree.isValidBST())) {
      System.out.println("did not delete the first chugi or returned invalid bst.");
      return false;
    }

    // test case 2
    boolean secondDeleted = chugTree.delete(Charysaur);
    if (!secondDeleted) {
      // first case
      System.out.println("Method delete test case 2 returned wrong value");
      return false;
    }
    if (chugTree.height() != 2 || chugTree.isValidBST() == false) {
      System.out.println("Method delete test case 2 either didn't work or returned invalid bst.");
      return false;
    }

    // test case 3
    try {
      boolean thirdDeleted = chugTree.delete(c6);
      if (thirdDeleted) {
        System.out.println("chugi 6 was not in the tree");
        return false;
      }
      if (chugTree.delete(null)) {
        System.out.println("the input was null and a IllegalArgumentException wasnt thrown");
        return false;
      }
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNext() {
    Chugimon Bulbysaur = new Chugimon(1, 2);
    Chugimon Ivyusaur = new Chugimon(2, 3);
    Chugimon Venuysaur = new Chugimon(3, 2);
    Chugimon Charysaur = new Chugimon(4, 2);
    Chugimon Squirtysaur = new Chugimon(7, 2);


    ChugiTree tree = new ChugiTree();
    tree.add(Bulbysaur);
    tree.add(Ivyusaur);
    tree.add(Venuysaur);
    tree.add(Charysaur);

    try {
      tree.next(null);
      System.out.println(
          "The .next() method did not throw an IllegalArgumentException when null was the input");
      return false;
    } catch (IllegalArgumentException e) {
      // Do nothing
    }
    try {
      tree.next(Squirtysaur);
      System.out.println("Squirty is not in the tree but a NoSuchElementException wasnt thrown");
      return false;
    } catch (NoSuchElementException e) {
      // DO nothing
    }

    if (!tree.next(Bulbysaur).equals(Charysaur)) {
      // a should pull d
      System.out.println("The .next() method did pull the right chugi");
      return false;
    }

    // Everything worked
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPrevious() {
    Chugimon c1 = new Chugimon(1, 2); // Bulbysaur
    Chugimon c2 = new Chugimon(2, 3); // Ivyusaur
    Chugimon c3 = new Chugimon(3, 2); // Venuysaur
    Chugimon c4 = new Chugimon(4, 2); // Charysaur
    Chugimon c5 = new Chugimon(7, 2); // Squirtysaur

    // Chugimon 1 < 4 < 2 < 5 < 3

    ChugiTree tree = new ChugiTree();
    tree.add(c1);
    tree.add(c2);
    tree.add(c3);
    tree.add(c4);
    tree.add(c5);

    // exception cases
    try {
      tree.previous(null);
      System.out.println("Can't take null parameter");
      return false;
    } catch (IllegalArgumentException e) {

    }
    try {
      tree.previous(c1);
      System.out.println("Element not found");
      return false;
    } catch (NoSuchElementException e) {
    }

    if (!tree.previous(c2).equals(c4)) {
      System.out.println("Failed");
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }

}
