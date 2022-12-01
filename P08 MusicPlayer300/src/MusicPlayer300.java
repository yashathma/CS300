//////////////// MusicPlayer300 class //////////////////////////
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
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/*
 * A linked-queue based music player which plays Actual Music Files based on keyboard input in an
 * interactive console method.This music player can load playlists of music or add individual song
 * files to the queue.
 */
public class MusicPlayer300 {
  private Playlist playlist; // The current playlist of Songs
  private boolean filterPlay; // Whether the current playback mode should be
  // filtered by artist; false by default
  private String filterArtist; // The artist to play if filterPlay is true; should be null otherwise

  /*
   * Creates a new MusicPlayer300 with an empty playlist
   */
  public MusicPlayer300() {
    filterPlay = false;
    filterArtist = null;
    playlist = new Playlist();
  }

  /*
   * Stops any song that is playing and clears out the playlist
   */
  public void clear() {
    playlist.peek().stop();
    while (!playlist.isEmpty()) {
      playlist.dequeue();//keep clearing
    }
  }

  /*
   * Loads a playlist from a provided file, skipping any individual songs which cannot be loaded.
   * 
   * @param file - the File object to load
   * 
   * @throws FileNotFoundException - if the playlist file cannot be loaded
   */
  public void loadPlaylist(File file) throws FileNotFoundException {
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        try {
          int size = playlist.size();//load playlist
          String line = scanner.nextLine();
          String[] input = line.split(",");
          Song song = new Song(input[0], input[1], "audio/" + input[2]);//how to load in file
          System.out.print("Loading " + song);
          playlist.enqueue(song);
          if (playlist.size() <= size) {
            System.out.print("X");//if not working
          }
        } catch (Exception e) {
          System.out.println("X");
        }
        System.out.println("\n");
      }

    } catch (FileNotFoundException e) {
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

  }

  /*
   * Loads a single song to the end of the playlist given the title, artist, and filepath. Filepaths
   * for P08 must refer to files in the audio directory.
   * 
   * @param title - the title of the song
   * 
   * @param artist - the artist of this song
   * 
   * @param filepath - the full relative path to the song file, begins with the "audio" directory
   * for P08
   * 
   * @throws IllegalArgumentException - if the song file cannot be read
   */
  public void loadOneSong(String title, String artist, String filepath) {
    try {
      playlist.enqueue(new Song(title, artist, filepath));//load song
    } catch (IllegalArgumentException e) {
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
  }

  /*
   * Provides a string representation of all songs in the current playlist
   * 
   * @return a string representation of all songs in the current playlist
   */
  public String printPlaylist() {
    Playlist copy = new Playlist();
    Song idx = playlist.peek();
    String finalstr = "";
    while (idx != null) {
      copy.enqueue(idx);
      finalstr += idx + "\n";
      idx = playlist.dequeue();

    }
    playlist = copy;//print songs
    return finalstr;
  }

  /*
   * Creates and returns the menu of options for the interactive console program.
   * 
   * @return the formatted menu String
   */
  public String getMenu() {
    String finl = "";

    finl += "Enter one of the following options:\n";
    finl += "[A <filename>] to enqueue a new song file to the end of this playlist\n";
    finl += "[F <filename>] to load a new playlist from the given file\n";
    finl += "[L] to list all songs in the current playlist\n";
    finl += "[P] to start playing ALL songs in the playlist from the beginning\n";
    finl += "[P -t <Title>] to play all songs in the playlist starting from <Title>\n";
    finl += "[P -a <Artist>] to start playing only the songs in the playlist by Artist\n";
    finl += "[N] to play the next song\n";
    finl += "[Q] to stop playing music and quit the program\n";

    return finl;
  }


  /*
   * Stops playback of the current song (if one is playing) and advances to the next song in the
   * playlist.
   * 
   * @throws IllegalStateException - if the playlist is null or empty, or becomes empty at any time
   * during this method
   */
   public void playNextSong() throws IllegalStateException {
     //when to throw exceptions
    if (playlist == null) {
      throw new IllegalStateException("Playlist was null when calling the playNextSong method");
    }
    if (playlist.isEmpty()) {
      throw new IllegalStateException("Playlist was empty when calling the playNextSong method");
    }
    playlist.peek().stop();
    playlist.dequeue();
    if (playlist.isEmpty()) {
      throw new IllegalStateException("Playlist was empty when calling the playNextSong method");
    }
    if (filterPlay) {
      //keep going
      while (!playlist.isEmpty() && !playlist.peek().getArtist().equals(filterArtist)) {
        playlist.dequeue();
        if (playlist.isEmpty()) {
          throw new IllegalStateException("Playlist was empty");
        } else {
          break;
        }
      }
    }
    playlist.peek().play();

  }

  /*
   * Interactive method to display the MusicPlayer300 menu and get keyboard input from the user.See
   * writeup for details.
   */

  public void runMusicPlayer300(Scanner in) {
    System.out.println(getMenu());//show menu
    System.out.print("> ");
    String cur = in.nextLine();
    while (!cur.equalsIgnoreCase("Q")) {
      cur = cur.trim();
      if (cur.startsWith("A")) {
        System.out.println("Enter title: ");
        System.out.print(">");
        String title = in.nextLine();
        System.out.println("Enter artist: ");
        System.out.print(">");
        String artist = in.nextLine();
        String filename = cur.substring(2);
        System.out.println("filename: " + filename);
        Song toAdd = new Song(title, artist, filename);
        playlist.enqueue(toAdd);
      }
      if (cur.startsWith("F")) {//load in a new playlist
        File toAdd = new File(cur.substring(2));
        try {
          loadPlaylist(toAdd);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
      if (cur.startsWith("L")) {//display songs
        System.out.println(playlist.toString());
      }
      if (cur.startsWith("P")) {//play songs
        if (!cur.contains("-t") || !cur.contains("-a")) {
          playlist.peek().play();
        } else if (cur.contains("-t")) {
          String title = cur.substring(6);//split the song
          Song curr = playlist.peek();
          while (curr != null) {
            if (curr.getTitle().equals(title)) {
              curr.play();
              break;
            }
          }
        } else if (cur.contains("-a")) {
          filterPlay = true;
          filterArtist = cur.substring(6);
        }
        System.out.println(getMenu());
        while (playlist.peek() != null) {
          while (playlist.peek().isPlaying()) {

          }
          playlist.dequeue();
          if (filterPlay) {
            while (!playlist.peek().getArtist().equals(filterArtist)) {
              playlist.dequeue();
            }
          }
          if (playlist.peek() != null) {
            playlist.peek().play();
          }

        }


      }
      if (cur.startsWith("N")) {
        playNextSong();
      }
      if (cur.startsWith("Q")) {
        System.out.println("Thank you!");
        break;
      }
      System.out.println(getMenu());
      System.out.print(">");
      cur = in.nextLine();
    }
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub
  }

}
