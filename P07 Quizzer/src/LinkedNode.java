//////////////// LinkedNode Class //////////////////////////
//
// Title: LinkedNode
// Course: CS 300 Fall 2022
//
// Author: Yash Athma
// Email: athma@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Tanvi Wadhawan
// Partner Email: twadhawan@wisc.edu
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
/**
 * LinkedNode class serves as a node in the slightly linked list
 * 
 * @author tanviwadhawan
 * @param <T>
 *
 */
public class LinkedNode<T> {
  private T data; // data carried by this linked node
  private LinkedNode<T> next; // reference to the next linked node

  /**
   * Constructs a new node with the provided information.
   * 
   * @param data  -to be stored within this node
   * @param next- node, which comes after this node in a singly linked list
   * @throws NullPointerException - with a descriptive error message if data is null
   */
  public LinkedNode(T data, LinkedNode<T> next) throws NullPointerException {
    if (data == null) {
      throw new NullPointerException("Data is null");
    }
    this.data = data;
    this.next = next;

  }

  /**
   * Constructs a new node with the provided information.
   * 
   * @param data - to be stored within this node
   * @throws NullPointerException - with a descriptive error message if data is null
   */
  public LinkedNode(T data) throws NullPointerException {
    if (data == null) {
      throw new NullPointerException("Data is null");
    }
    this.data = data;
    this.next = null;
  }

  /**
   * Accessor method for this node's next node reference.
   * 
   * @return the next reference to the node that comes after this one in the list, or null when 
   * this is the last node in that list
   */
  public LinkedNode<T> getNext() {
    return this.next;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next -which comes after this node in a doubly linked list
   */
  public void setNext(LinkedNode<T> next) {

    this.next = next;
  }

  /**
   * Acessor method for this node's data.
   * 
   * @return the data stored within this node.
   */
  public T getData() {
    return data;
  }

  /**
   * Returns a string representation of this linked node formatted as follows: data.toString() if
   * this node does NOT have a next node in the list data.toString() + "->" if this node has a next
   * node in the list
   * 
   * @return a String representation of this node in the list
   */
  @Override
  public String toString() {
    if (next == null) {
      return data.toString();
    }

    return data.toString() + "->";


  }
}
