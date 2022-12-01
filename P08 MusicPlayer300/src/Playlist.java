//////////////// Playlist class //////////////////////////
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
 * A FIFO linked queue of SongNodes, conforming to our QueueADT interface.
 */
public class Playlist extends Object implements QueueADT<Song> {
  private SongNode first; // The current first song in the queue; the next one up to play (front of
                          // the queue)
  private SongNode last; // The current last song in the queue; the most-recently added one (back of
                         // the queue)
  private int numSongs; // The number of songs currently in the queue

  /*
   * Constructs a new, empty playlist queue
   */
  public Playlist() {
    numSongs = 0;
    first = null;
    last = null;
  }

  /*
   * Adds a new song to the end of the queue
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @param element - the song to add to the Playlist
   */
  @Override
  public void enqueue(Song element) {
    SongNode n = new SongNode(element);
    if (numSongs == 0) {
      first = n;//add to empty
      last = n;
    } else {
      last.setNext(n);//add
      last = n;
    }
    numSongs++;
  }

  /*
   * Removes the song from the beginning of the queue
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @return the song that was removed from the queue, or null if the queue is empty
   */
  @Override
  public Song dequeue() {
    if (numSongs == 1) {
      Song returnVal = first.getSong();//remove everything
      first = null;
      last = null;
      numSongs--;
      return returnVal;
    } else {
      Song returnVal = first.getSong();
      first = first.getNext();//remove the first
      numSongs--;
      return returnVal;
    }
  }

  /*
   * Returns the song at the front of the queue without removing it
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @return the song that is at the front of the queue, or null if the queue is empty
   */
  @Override
  public Song peek() {
    if (isEmpty()) {
      return null;
    }
    return first.getSong();
  }

  /*
   * Returns true if and only if there are no songs in this queue
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @return true if this queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return (numSongs == 0);
  }

  /*
   * Returns the number of songs in this queue
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @return the number of songs in this queue
   */
  @Override
  public int size() {
    return numSongs;
  }

  /*
   * Creates and returns a formatted string representation of this playlist, with the string version
   * of each song in the list on a separate line.
   * 
   * Specified by enqueue in interface QueueADT<Song>
   * 
   * @Override toString in class Object
   * 
   * @return the string representation of this playlist
   */
  @Override
  public String toString() {
    String finalstr = new String();
    SongNode cur = first;
    int inx = 0;
    while (inx < numSongs) {
      finalstr += cur.getSong().toString() + "\n";
      inx++;
      cur = cur.getNext();

    }
    return finalstr;
  }

}
