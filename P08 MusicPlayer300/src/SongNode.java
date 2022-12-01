//////////////// SongNode class //////////////////////////
//
// Title:    MusicPlayer 
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
/*
 * A singly-linked node for our linked queue, which contains a Song object
 */
public class SongNode extends Object {
  private SongNode next; // The next SongNode in this queue
  private Song song; // The Song object in this node

  /*
   * Constructs a single SongNode containing the given data, not linked to any other SongNodes
   * 
   * @param data - the Song for this node
   * 
   * @throws IllegalArgumentException - if data is null
   */
  public SongNode(Song data) throws IllegalArgumentException {
    if (data == null) {
      throw new IllegalArgumentException("Input song was null when calling SongNode");
    }

    this.song = data;
  }

  /*
   * Constructs a single SongNode containing the given data, linked to the specified SongNode
   * 
   * @param data - the Song for this node
   * 
   * @param next - the next node in the queue
   * 
   * @throws IllegalArgumentException - if data is null
   */
  public SongNode(Song data, SongNode next) throws IllegalArgumentException {
    if (data == null) {
      throw new IllegalArgumentException("Input song was null when calling SongNode");
    }
    this.song = data;
    this.next = next;
  }

  /*
   * Accessor method for this node's data
   * 
   * @return the Song in this node
   */
  public Song getSong() {
    return song;
  }

  /*
   * Accessor method for the next node in the queue
   * 
   * @return the SongNode following this one, if any
   */
  public SongNode getNext() {
    return next;
  }

  /*
   * Changes the value of this SongNode's next data field to the given value
   * 
   * @param next - the SongNode to follow this one; may be null
   */
  public void setNext(SongNode next) {
    this.next = next;
  }


}
