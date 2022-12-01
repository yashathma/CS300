//////////////// Song class //////////////////////////
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
import java.io.IOException;

/*
 * A representation of a single Song. Interfaces with the provided AudioUtility class, which uses
 * the javax.sound.sampled package to play audio to your computer's audio output device
 */
public class Song extends Object {
  private String artist; // The artist of this song
  private AudioUtility audioClip; // This song's AudioUtility interface to javax.sound.sampled
  private int duration; // The duration of this song in number of seconds
  private String title; // The title of this song

  /*
   * Initializes all instance data fields according to the provided values
   * 
   * @param title - the title of the song, set to empty string if null
   * 
   * @param artist - the artist of this song, set to empty string if null
   * 
   * @param filepath - the full relative path to the song file, begins with the "audio" directory
   * for P08
   * 
   * @throws IllegalArgumentException - if the song file cannot be read (null)
   */
  public Song(String title, String artist, String filepath) throws IllegalArgumentException {
    if (filepath == null) {
      throw new IllegalArgumentException(
          "The input filepath was null when calling the Song constructor");
    }
    try {
      audioClip = new AudioUtility(filepath);
      duration = audioClip.getClipLength();
    } catch (IOException e) {
      throw new IllegalArgumentException(
          "The input filepath was not found when calling the Song constructor");
    }
    this.title = title;
    this.artist = artist;
  }

  /*
   * Tests whether this song is currently playing using the AudioUtility
   * 
   * @return true if the song is playing, false otherwise
   */
  public boolean isPlaying() {
    return audioClip.isRunning();
  }

  /*
   * Accessor method for the song's title
   * 
   * @return the title of this song
   */
  public String getTitle() {
    return title;
  }

  /*
   * Accessor method for the song's artist
   * 
   * @return the artist of this song
   */
  public String getArtist() {
    return artist;
  }

  /*
   * Uses the AudioUtility to start playback of this song, reopening the clip for playback if
   * necessary
   */
  public void play() {
    try {
      audioClip.startClip();
      System.out.println("Playing " + this.toString());
    } catch (Exception e) {
      audioClip.reopenClip();
      audioClip.startClip();
    }
  }

  /*
   * Uses the AudioUtility to stop playback of this song
   */
  public void stop() {
    audioClip.stopClip();
  }

  /*
   * Creates and returns a string representation of this Song, for example:
   * 
   * @Overrides toString in class Object
   * 
   * @return a formatted string representation of this Song
   */
  @Override
  public String toString() {
    int min = (duration / 60);
    int sec = duration % 60;
    return "\"" + this.title + "\" (" + Integer.toString(min) + ":" + Integer.toString(sec)
        + ") by " + this.artist;
  }


}
