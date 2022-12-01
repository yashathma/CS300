//////////////// MusicPlayer Tester class //////////////////////////
//
// Title:    MusicPlayer Program
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
import java.util.Scanner;
/**
 * Tester class for the music player
 * @author tanviwadhawan
 *
 */
public class MusicPlayerTester {

  public static void main(String[] args) {
//    System.out.println("Start");
//    // System.out.println(testDequeue());
//
//    System.out.println("testSongConstructor: " + testSongConstructor());
//    System.out.println("testSongPlayback: " + testSongPlayback());
//    System.out.println("testSongNode: " + testSongNode());
//    System.out.println("testEnqueue: " + testEnqueue());
//    System.out.println("testDequeue: " + testDequeue());
    MusicPlayer300 testRunner = new MusicPlayer300();
    testRunner.runMusicPlayer300(new Scanner(System.in));



  }


  /*
   * Tester for the Song Construtor
   * 
   * @return true is no bugs detected otherwise false
   */
  public static boolean testSongConstructor() {
    try {
      Song one = new Song("1.mid", "artist", "wrong");
      return false;//needs filepath
    } catch (IllegalArgumentException e) {
    }catch (Exception e) {
      return false;
    }
    try {
      Song one = new Song("first", "artist", "audio/1.mid");
      String onestr = one.toString();
//      System.out.println(one.toString());
////      System.out.println(onestr.equals("\"first\" (0:6) by artist\n"));
      if(!onestr.equals("\"first\" (0:6) by artist")) {
        System.out.println("wrong");
        return false;
      }

      if (!one.getArtist().equals("artist")) {
        return false;
      }
      if (!one.getTitle().equals("first")) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /*
   * Tester for the playback methods in Song class
   * 
   * @return true is no bugs detected otherwise false
   */
  public static boolean testSongPlayback() {
    Song one = new Song("first", "artist", "audio/1.mid");
    if (one.isPlaying()) {
      return false;
    }

    one.play();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (!one.isPlaying()) {
      return false;
    }
    one.stop();

    if (one.isPlaying()) {
      return false;
    }

    return true;

  }

  /*
   * Tester for the SongNode class constructor and methods
   * 
   * @return true is no bugs detected otherwise false
   */
  public static boolean testSongNode() {
    try {
      SongNode sn = new SongNode(null);
    } catch (IllegalArgumentException e) {
    } catch (Exception e) {

    }
    try {
      Song s1 = new Song("first", "artist", "audio/1.mid");
      Song s2 = new Song("second", "artist2", "audio/2.mid");
      SongNode sn2 = new SongNode(s2);
      SongNode sn1 = new SongNode(s1, sn2);
      if (!sn1.getNext().equals(sn2)) {//testing getNext
        System.out.println("ss");
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    try {
      Song s3 = new Song("first", "artist", "audio/3.mid");
      Song s4 = new Song("second", "artist2", "audio/4.mid");
      SongNode sn4 = new SongNode(s4);
      SongNode sn3 = new SongNode(s3);
      if (!sn3.getSong().equals(s3)) {//testing get
        return false;
      }
      sn3.setNext(sn4);
      if (!sn3.getNext().equals(sn4)) {//testing getNext
        return false;
      }
      return true;
    } catch (Exception d) {
      d.printStackTrace();
      return false;
    }
  }



  /*
   * Tester for the Enqueue method in the Playlist class and also Tests the constructor and accessor
   * methods in the Playlist class
   * 
   * @return true is no bugs detected otherwise false
   */
  public static boolean testEnqueue() {
    Playlist p = new Playlist();
    if (!p.isEmpty()) {
      return false;
    }

    Song n2 = new Song("second", "artist2", "audio/2.mid");
    Song n = new Song("first", "artist", "audio/1.mid");
    p.enqueue(n);

    if (p.size() != 1) {
      return false;
    }
    // System.out.println(p.toString());
    if (!p.peek().equals(n)) {//check if the first is equal to what we enqueue
      return false;
    }

    p.enqueue(n2);

    if (p.size() != 2) {//check if it adds properly
      return false;
    }

    if (!p.peek().equals(n)) {//check if enqueue adds to the back 
      return false;
    }

    return true;
  }

  /*
   * Tester for the Dequeue method in the Playlist class
   * 
   * @return true is no bugs detected otherwise false
   */
  public static boolean testDequeue() {
    Playlist p = new Playlist();
    Song n2 = new Song("second", "artist2", "audio/2.mid");
    Song n = new Song("first", "artist", "audio/1.mid");

    p.enqueue(n);
    p.enqueue(n2);

    p.dequeue();//remove

    // System.out.println(p.peek().toString());
    if (!p.peek().equals(n2)) {
      System.out.println("asg");
      return false;//check if it removes to the right place
    }

    p.dequeue();

    if (!p.isEmpty()) {
      return false;
    }

    return true;
  }


}
