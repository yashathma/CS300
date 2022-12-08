//////////////// ChugiTree //////////////////////////
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
// Persons:         Hobbes' lectures for the delete methods and helper methods
// Online Sources:  geeksforgeeks.org helped with binary search and how to think about 
//                  implementing the isValidBST and helper method
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class implements a ChugidexStorage as a Binary Search Tree.
 * 
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc) in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {

  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    root = null;
    size = 0;

  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   * 
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    return root.getData();
  }

  /**
   * A method for determining whether this ChugiTree is a valid BST. In order to be a valid BST, the
   * following must be true: For every internal (non-leaf) node X of a binary tree, all the values
   * in the node's left subtree are less than the value in X, and all the values in the node's right
   * subtree are greater than the value in X.
   * 
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    if (root == null) {
      return true;
    }
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In order to be a valid
   * BST, the following must be true: For every internal (non-leaf) node X of a binary tree, all the
   * values in the node's left subtree are less than the value in X, and all the values in the
   * node's right subtree are greater than the value in X.
   * 
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    // base case
    if (node == null) {
      return true;
    }

    /* false if the max of the left is > than us */
    if(node.getLeft() !=null && getLastHelper(node.getLeft()).compareTo(node.getData())>0) {
      return false;
    }
    /* false if the max of the right is > than us */
    if(node.getRight() !=null && getFirstHelper(node.getRight()).compareTo(node.getData())<0) {
      return false;
    }
    //recursively
    if(!isValidBSTHelper(node.getLeft())) {
      return false;
    }
    if(!isValidBSTHelper(node.getRight())) {
      return false;
    }
    
    return true;

  }

  /**
   * Checks whether this ChugiTree is empty or not
   * 
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }

    return false; // default return statement
  }

  /**
   * Gets the size of this ChugiTree
   * 
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    return size; // default return statement
  }

  /**
   * Returns a String representation of all the Chugimons stored within this ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method. The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces are expected to be
   * in the resulting string. No comma should be at the end of the resulting string. For instance,
   * 
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   * 
   * @return a string containing all of the Chugimon, in the increasing order. Returns an empty
   *         string "" if this BST is empty.
   * 
   */
  @Override
  public String toString() {
    String result = toStringHelper(root);
    int length = result.length();
    // checks validity of String
    if (result.isEmpty()) {
      return result;
    }
    // no comma at the end
    if (result.charAt(length - 1) == ',') {
      result = result.substring(0, length - 1);
    }
    return result;
  }

  /**
   * Recursive helper method which returns a String representation of the ChugiTree rooted at node.
   * An example of the String representation of the contents of a ChugiTree storing three Chugimons
   * is provided in the description of the above toString() method.
   * 
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    String result = "";
    // base case
    if (node == null) {
      return result;
    }
    // add left then root then right
    result = result.concat(toStringHelper(node.getLeft()));
    result = result.concat(node.getData().toString()) + ",";
    result = result.concat(toStringHelper(node.getRight()));

    return result; // Default return statement added to resolve compiler errors
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   * 
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree, false if a match
   *         with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) {
    // if is empty
    if(newChugimon==null) {
      throw new IllegalArgumentException(" can't be null");
    }
    if (this.isEmpty() || root==null) {
      root = new BSTNode<Chugimon>(newChugimon);
      size++;
      return true;
    }
    // add node
    if (addHelper(newChugimon, root)) {
      size++;
      return true;
    } else {
      return false; // default return statement
    }
  }

  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   * 
   * @param node        The "root" of the subtree we are inserting the new Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We assume that newChugimon
   *                    is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree, false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) {
      if (node.getData().equals(newChugimon))//equal
          return false;

      else if (newChugimon.compareTo(node.getData()) < 0) {
          if (node.getLeft() == null) {
              node.setLeft(new BSTNode<Chugimon>(newChugimon));
              return true;
          }
          // check left child then recursively move to left child and add
          // the chugimon there
          else {
              return addHelper(newChugimon, node.getLeft());
          }
      }

      // if not null and greater than put to right child
      else {
          if (node.getRight() == null) {
              node.setRight(new BSTNode<Chugimon>(newChugimon));
              return true;
          }
          //worst case
          else
              return addHelper(newChugimon, node.getRight());
      }
  }
//    // false is match with newChugimon
//    if(node==null) {
//      node = new BSTNode<Chugimon>(newChugimon);
//    }
//    if (newChugimon.equals(node.getData())) {//if match return false
//      return false;
//    }
//    if(node.getData().compareTo(newChugimon)<0&&node.getLeft()!=null) {//if less put on left side
//        node.setLeft(new BSTNode<Chugimon>(newChugimon));
//        return addHelper(newChugimon,node.getLeft());
//    }//if more put on right side
//    else if(node.getData().compareTo(newChugimon)>0 && node.getRight()!=null) {
//        node.setRight(new BSTNode<Chugimon>(newChugimon));
//        return addHelper(newChugimon,node.getRight());
//    }
//    return false;
//    // false is match with newChugimon
//    if (newChugimon.equals(node.getData())) {
//      return false;
//    }
//    // base case
//    if (node.getLeft() == null && node.getRight() != null) {
//      if (newChugimon.compareTo(node.getData()) < 0) {// put it into left side
//        node.setLeft(new BSTNode<Chugimon>(newChugimon));
//        return true;
//      }else {
//        return addHelper(newChugimon, node.getRight());
//      }
//    }
//    // opposite, if right is null and left is not null so put into right child
//    else if (node.getRight() == null && node.getLeft() != null) {
//      if (newChugimon.compareTo(node.getData()) > 0) {// put it into right side
//        node.setRight(new BSTNode<Chugimon>(newChugimon));
//        return true;
//      } else {
//        return addHelper(newChugimon, node.getLeft());
//      }
//    }
//    // if both children are null
//    else if (node.getRight() == null && node.getLeft() == null) {
//      if (newChugimon.compareTo(node.getData()) > 0) {// put it into left side
//        node.setRight(new BSTNode<Chugimon>(newChugimon));
//        return true;
//      } else if (newChugimon.compareTo(node.getData()) < 0) {// put it into right side
//        node.setLeft(new BSTNode<Chugimon>(newChugimon));
//        return true;
//      } else {
//        return false;
//      }
//    }
//
//    boolean bool = true;
//
//    if (newChugimon.compareTo(node.getData()) > 0) {
//      bool = addHelper(newChugimon, node.getRight());
//    } else if (newChugimon.compareTo(node.getData()) < 0) {
//      bool = addHelper(newChugimon, node.getLeft());
//    }
//
//    return bool;
//  
//  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   * 
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    Chugimon toFind = new Chugimon(firstId, secondId);
    return lookupHelper(toFind, root);
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in the subtree
   * rooted at node, if present.
   * 
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume that toFind is NOT
   *               null.
   * @param node   "root" of the subtree we are checking whether it contains a match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    Chugimon result = null;
    // base case
    if (node == null) {
      return result;
    }
    // if found
    if (node.getData().equals(toFind)) {
      result = node.getData();
    }
    // traverse through the tree
    else {
      result = lookupHelper(toFind, node.getLeft());
      if (result == null) {
        result = lookupHelper(toFind, node.getRight());
      }
    }
    return result;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root); // Default return statement
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at node counting the
   * number of nodes and NOT the number of edges from node to the deepest leaf
   * 
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    // base case
    if (node == null) {
      return 0;// height is 0
    }
    // find height of left side and return the higher one
    if (heightHelper(node.getLeft()) > heightHelper(node.getRight())) {
      return heightHelper(node.getLeft()) + 1;
    }
    // if they are equal then return whichever one
    else {
      return heightHelper(node.getRight()) + 1;
    }
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing order, within this
   * ChugiTree (meaning the smallest element stored in the tree).
   * 
   * @return the first element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    // check if first is null
    if (root == null) {
      return null;
    }
    // HINT: The smallest element in a non-empty BST is the left most element

    return getFirstHelper(root); // default return statement
  }

  /**
   * Recursive helper method for getFirst().
   * 
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    // base case
    if (root.getLeft() == null) {
      return root.getData();
    }
    return getFirstHelper(root.getLeft());// left most
    // HINT: The smallest element in a non-empty BST is the left most element
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing order, within this
   * ChugiTree (meaning the greatest element stored in the tree).
   * 
   * @return the last element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getLast() {
    if (root == null) {
      return null;
    }
    return getLastHelper(root.getRight());// right most
    // HINT: The greatest element in a non-empty BST is the right most element

  }

  /**
   * Recursive helper method for getLast().
   * 
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    // base case
    if (root.getRight() == null) {
      return root.getData();
    }
    // HINT: The smallest element in a non-empty BST is the right most element
    return getLastHelper(root.getRight());// right most

  }

  /**
   * Recursive method to get the number of Chugimon with a primary or secondary type of the
   * specified type, stored in this ChugiTree.
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    return countTypeHelper(chugiType, root);
  }

  /**
   * Helper method for CountType so we can go down the tree with the node
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is NOT null.
   * @param node      root of a subtree
   * @return the number of all the Chugimon objects with a primary or secondary type of the
   *         specified type stored in this ChugiTree.
   */
  private static int countTypeHelper(ChugiType chugiType, BSTNode<Chugimon> node) {
    int num=0;

    if (node == null) {
      return num;
    }
    // add up all who have same type
    
    num+=countTypeHelper(chugiType, node.getLeft());
    num+=countTypeHelper(chugiType, node.getRight());
    
    if (node.getData().getPrimaryType().equals(chugiType) ||
        node.getData().getSecondaryType()!=null &&
        node.getData().getSecondaryType().equals(chugiType)) {

        return num+= 1;// add 1 for the extra match
    } 
    return num;
  }

  /**
   * Finds and returns the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptive error message if the Chugimon provided as
   *                                  input has no in-order successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    if(chugi==null) {
      throw new IllegalArgumentException("can't be null");
    }
    if(chugi.equals(getLast())) {
      throw new NoSuchElementException("not in order");
    }
    return nextHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order successor. We assume that <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *                                input has no in-order successor in the subtree rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> next) throws NoSuchElementException {
    // TODO: Implement this method.
    // Hint: you will need to use getFirstHelper in this method. Below are
    // additional hints.
    

    // base case 
    if (node == null) {
      throw new NoSuchElementException("null is there");
    }

    // recursive cases:
    // (1) if chugi is found and if the right child is not null, use getFirstHelper
    // to find and
    // return the next chugimon. It should be the left most child of the right
    // subtree
    if (chugi.equals(node.getData())) {
      if (node.getRight() != null) {
        next = new BSTNode<Chugimon>(getFirstHelper(node.getRight()));
        return getFirstHelper(node.getRight());
      } else if(node.getRight()==null) {
        if(next==null) {
          return getFirstHelper(node.getRight()); 
        }
        return next.getData();
      }
      // (2) if chugi is less than the Chugimon at node, set next as the root node and
      // search
      // recursively into the left subtree
    } else if (chugi.compareTo(node.getData()) > 0) {
      
      return nextHelper(chugi, node.getRight(), next);
    }
    return nextHelper(chugi, node.getLeft(), node);

  }
  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this ChugiTree
   * 
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * 
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) {
    if(chugi==null) {
      throw new IllegalArgumentException("can't be null");
    }
    if(chugi.equals(getFirst())) {
      throw new NoSuchElementException("not in order");
    }
    return previousHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order predecessor. We assume that <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *                                input has no in-order predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> prev) {
    // TODO Implement this method.
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.
    if(chugi==null) {
      throw new NoSuchElementException("cannot be null");
    }

    // base case: node is null
    if (node == null) {
      return prev.getData();
    }
    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree
    if(node.getData().equals(chugi)) {
      if(node.getLeft()!=null) {
        return getLastHelper(node.getLeft());
      }
    }
    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree
    else if(chugi.compareTo(node.getData())>0) {
      return previousHelper(chugi, node.getRight(), node);
    }
    return prev.getData();
  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   * 
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) throws IllegalArgumentException {
    if (chugi == null) {
      throw new IllegalArgumentException("The input chugimon for delete method was null");
    }

    if (lookupHelper(chugi, root) == null) {
      return false;
    }

    if (chugi.equals(root.getData())) {
      // no child
      if (root.getLeft() == null && root.getRight() == null) {
        root = null;
      }
      // right child
      if (root.getLeft() == null && root.getRight() != null) {
        root = root.getRight();
      }
      // left child
      else if (root.getLeft() != null && root.getRight() == null) {
        root = root.getLeft();
      }

      // two kids
      if (root.getLeft() != null && root.getRight() != null) {

        BSTNode<Chugimon> original = root.getRight();
        while (original.getLeft() != null) {
          original = original.getLeft();
        }

        // System.out.println(successor.getData());

        BSTNode<Chugimon> child = new BSTNode<Chugimon>(
            new Chugimon(original.getData().getFirstID(), original.getData().getSecondID()));

        deleteChugimonHelper(original.getData(), root);

        child.setLeft(root.getLeft());
        child.setRight(root.getRight());

        root = child;
      }
    } else {
      deleteChugimonHelper(chugi, root);
    }
    size -= 1;
    return true;
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST rooted at node
   * 
   * @param target a reference to a Chugimon to delete from the BST rooted at node. We assume that
   *               target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a match with the target
   *               Chugimon.
   * 
   * 
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws NoSuchElementException with a descriptive error message if there is no Chugimon
   *                                matching target in the BST rooted at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) {
    // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below

    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception

    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly

    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.

    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.

    // no match
    if (node == null) {
      throw new NoSuchElementException("can't be null");
    }

    // Compares target to input node
    int comp = target.compareTo(node.getData());

    // right
    if (comp > 0) {
      if (node.getRight().getData().equals(target)) {
        // no children
        if (node.getRight().getLeft() == null && node.getRight().getRight() == null) {
          node.setRight(null);
          return null;
        }

        // has one right child
        if (node.getRight().getLeft() == null && node.getRight().getRight() != null) {
          node.setRight(node.getRight().getRight());
          return node.getRight();
        }
        // has one left child
        else if (node.getRight().getLeft() != null && node.getRight().getRight() == null) {
          node.setRight(node.getRight().getLeft());
          return node.getRight();
        }

        // has two children
        if (node.getRight().getLeft() != null && node.getRight().getRight() != null) {
          return nodeTwoChildren(node, node.getRight(), "right");
        }
      }
      return deleteChugimonHelper(target, node.getRight());
    }

    // left
    else if (comp < 0) {
      if (node.getLeft().getData().equals(target)) {
        // no children
        if (node.getLeft().getLeft() == null && node.getLeft().getRight() == null) {
          node.setLeft(null);
          return null;
        }

        // has one right child
        if (node.getLeft().getLeft() == null && node.getLeft().getRight() != null) {
          node.setLeft(node.getLeft().getRight());
          return node.getLeft();
        }
        // has one left child
        else if (node.getLeft().getLeft() != null && node.getLeft().getRight() == null) {
          node.setLeft(node.getLeft().getLeft());
          return node.getLeft();
        }

        // has two children
        if (node.getLeft().getRight() != null && node.getLeft().getLeft() != null) {
          return nodeTwoChildren(node, node.getLeft(), "left");
        }
      }
      return deleteChugimonHelper(target, node.getLeft());
    }
    return null;
  }

  /**
   * helepr for delete method to delete the node with two children to move along the tree
   * 
   * @param root          parent node
   * @param toDelete      which ones we want to delete
   * @param originalChild tells us what side the child is on
   * @return the Chugimon that needs to be deleted
   */
  public static BSTNode<Chugimon> nodeTwoChildren(BSTNode<Chugimon> root,
      BSTNode<Chugimon> toDelete, String originalChild) {
    // finding original toDelete
    BSTNode<Chugimon> original = toDelete.getRight();
    while (original.getLeft() != null) {
      original = original.getLeft();
    }

    if (originalChild.equals("left")) {
      BSTNode<Chugimon> child = new BSTNode<Chugimon>(
          new Chugimon(original.getData().getFirstID(), original.getData().getSecondID()));

      deleteChugimonHelper(original.getData(), toDelete);
      child.setLeft(toDelete.getLeft());
      child.setRight(toDelete.getRight());

      root.setLeft(child);
      return child;
    } else if (originalChild.equals("right")) {
      BSTNode<Chugimon> child = new BSTNode<Chugimon>(
          new Chugimon(original.getData().getFirstID(), original.getData().getSecondID()));

      deleteChugimonHelper(original.getData(), toDelete);
      child.setLeft(toDelete.getLeft());
      child.setRight(toDelete.getRight());

      root.setRight(child);
      return child;
    } else {
      return null;
    }
  }

}
