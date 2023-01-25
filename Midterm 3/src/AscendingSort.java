///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: Yash Athma
// Campus ID: 908 422 8698
// WiscEmail: athma@wisc.edu
////////////////////////////////////////////////////////////////////////////////

/**
 * This is a static, utility class containing methods to accomplish a recursive
 * sort of an array of Song objects. You do NOT have to implement the Song class;
 * it is provided for you in its entirety at the bottom of this file.
 */
public class AscendingSort {

  /**
   * Finds the shortest Song using a recursive helper method.
   * 
   * @param playlist a full, perfect-size array of Songs with length >= 1
   * @return the Song from that playlist which is shorter than every other Song
   */
  public static Song getShortestSong(Song[] playlist) {
    // suppose the last element of the playlist is the shortest
    Song minSong = playlist[playlist.length-1];
    
    // get the smaller of minSong and the elements in the rest of the array
    return getShortestSongHelper(minSong, playlist, playlist.length-2);
  }
  
  /**
   * A recursive helper method to find the smaller of:
   *   - the argument minSong, and
   *   - the shortest Song in the rest of playlist, from 0 to index (inclusive)
   * 
   * @param minSong the minimum value over all indexes from index+1 to the end of the playlist
   * @param playlist a full, perfect-size array of Songs with length >= 1
   * @param index the last index of the un-searched part of the playlist. 
   *     valid values: -1 to playlist.length-2 (inclusive)
   *     If index == -1, the un-searched part of the playlist is empty.
   * @return the minimum value over all indexes
   */
  private static Song getShortestSongHelper(Song minSong, Song[] playlist, int index) {
    /////////// BASE CASE ///////////
    // TODO
    // 1. If the un-searched part of the shelf is empty, return the shortest song
    if(index==-1) {
      return minSong;
    }
    
    ///////// RECURSIVE CASE ////////
    // TODO
    // 2. Define the recursive case for this algorithm
    Song song = minSong;
    
    if(playlist[index].compareTo(song)<0) {
      song = playlist[index];
    }
    
    song = getShortestSongHelper(song, playlist, index-1);
   
    
    // 3. Return the shortest song
    return song; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /**
   * A tester method for getShortestSong, which you must complete. This method WILL be tested.
   * 
   * @return true if getShortestSong produces the expected result; false otherwise
   */
  public static boolean testGetShortestSong() {
    // TODO
    // 4. Create a Song[] array containing at least 3 Song objects with different titles and durations (see 
    //    testAscendingSort() below for examples)
    Song[] songs = new Song[] {new Song("songOne", 1, 45), new Song("songTwo", 2, 20), new Song("songThree", 3, 45)};
    
    // 5. Create a NEW Song object that matches the Song in the array that has the shortest duration
    Song shortest = new Song("songOne", 1, 45);
    
    // (e.g. for Songs with durations [5:32, 7:15, 4:56], you'd create a new Song with duration 4:56).
    
    // 6. Call getShortestSong() on your Song[] array and save the result
    Song testShortest = getShortestSong(songs);
    
    // 7. Compare this result against your expected value and return false if they do not match.
    // CAREFUL: the equals() method is NOT overridden in the Song class. To find equivalent Song
    // objects, use Song's compareTo() method.
    if(testShortest.compareTo(shortest)!=0) {
      return false;
    }
    
    // OPTIONAL: implement additional tests to verify the method works!
    
    // 8. Return true if all tests in this method are passed.
    return true; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////
  //                                                                                         //
  // Checkpoint: SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) and RUN THIS TEST before you continue. //
  //                                                                                         //
  /////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Returns a new array of size playlist.length-1 which contains every Song in playlist that is NOT
   * the Song to remove. The method should NOT make any changes to the contents of playlist.
   *
   * Note that while there is no equals() method defined in Song, equal Songs will have a compareTo() 
   * value of 0.
   * 
   * @param playlist a full, perfect-size array of Songs with length >= 1
   * @param toRemove the Song to remove from the playlist
   * @return an array containing every Song from playlist EXCEPT toRemove, and NO null values
   */
  public static Song[] remove(Song[] playlist, Song toRemove) {
    // TODO
    // 9. Create a new Song array of the correct size
    Song[] finalSongs = new Song[playlist.length-1];
    
    // 10. Iterate through the playlist and add all Songs that are NOT the Song toRemove
    //     (You may assume there are no duplicates.)
    int idx = 0;
    
    for(int i = 0; i<playlist.length; i++) {
      if(!(playlist[i].compareTo(toRemove)==0 && i==idx)) {
        finalSongs[idx] = playlist[i];
        idx+=1;
      }
    }
    // 11. Return the resulting array
    return finalSongs; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /**
   * A tester method for remove(), which you must complete. This method WILL be tested.
   * 
   * @return true if remove() produces the expected result; false otherwise
   */
  public static boolean testRemove() {
    // TODO
    // 12. Create a Song[] array containing at least 3 Song objects with different titles and durations (see 
    //     testAscendingSort() below for examples)
    Song[] songs = new Song[] {new Song("songOne", 1, 45), new Song("songTwo", 2, 20), new Song("songThree", 3, 45)};
    
    // 13. Create a NEW Song object that is identical to one of the Song objects from your array
    Song toRemove = new Song("songTwo", 2, 20);
    
    // 14. Call remove() on your array and Song object and save the result
    Song[] finalsongs = remove(songs, toRemove);
    
    
    // 15. Verify that the length of the result is 1 less than your input array, and that the Song
    //     you passed in the second argument is NOT present, and return false if either test does
    //     not pass.
    if(finalsongs.length!=2) {
      return false;
    }
    
    for(int i = 0; i<finalsongs.length;i++) {
      if(finalsongs[i].compareTo(toRemove)==0) {
        return false;
      }
    }
    
    // OPTIONAL: implement additional tests to verify the method works!
    
    // 16. Return true if all tests in this method are passed.
    return true; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////////
  // NOTE: THERE IS NO MORE CODE REQUIRED FROM YOU AFTER THIS POINT!
  //
  // What follows is another test for you to run locally to help assure you that your program
  // works as expected, and a main method. The Song class is included at the bottom of the file.
  //
  // SAVE YOUR CODE (Ctrl/Cmd + S) and RUN ALL TESTS, and SUBMIT YOUR FILE TO GRADESCOPE!!
  /////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * A recursive method to sort an array of Songs in-place.
   * 
   * @param playlist a full, perfect-size array of Songs with length >= 1
   */
  public static void ascendingSort(Song[] playlist) {
    /////////// BASE CASE ///////////
    // an array of length 1 is sorted
    if (playlist.length == 1) return;
    
    ///////// RECURSIVE CASE ////////
    
    // use the helper methods to pre-process the data
    Song minSong = getShortestSong(playlist);
    Song[] newPlaylist = remove(playlist, minSong);
    ascendingSort(newPlaylist);
    
    // copy the processed data back into the original shelf
    playlist[0] = minSong;
    for (int i=0; i<newPlaylist.length; i++) {
      playlist[i+1] = newPlaylist[i];
    }
  }
  
  /**
   * A tester method for ascendingSort, provided for you in its entirety. You may add code if you wish,
   * but you are not required to. This method will not be tested.
   * 
   * @return true if ascendingSort produces the expected result; false otherwise
   */
  public static boolean testAscendingSort() {
    // try sorting a one-song playlist:
    Song[] simplePlaylist = new Song[] {new Song("Anti-Hero", 3, 20)};
    Song contents = new Song("Anti-Hero", 3, 20);
    try {
      ascendingSort(simplePlaylist);
    } catch (NullPointerException npe) {
      System.err.println("ascendingSort() NullPointerException!");
      return false;
    }

    if (simplePlaylist.length != 1) return false;
    if (simplePlaylist[0] == null || simplePlaylist[0].compareTo(contents) != 0) return false;
    
    // try sorting a playlist with multiple songs:
    Song[] testPlaylist = new Song[] {new Song("Bejeweled", 3,14), 
        new Song("Snow on the Beach", 4,16), 
        new Song("Vigilante Shit", 2,44), 
        new Song("Question...?", 3,30)};
    Song[] expectedPlaylist = new Song[] {new Song("Vigilante Shit", 2,44), 
        new Song("Bejeweled", 3,14), 
        new Song("Question...?", 3,30), 
        new Song("Snow on the Beach", 4,16)};
    try {
      ascendingSort(testPlaylist);
    } catch (NullPointerException npe) {
      System.err.println("ascendingSort() NullPointerException!");
      return false;
    }
    
    if (testPlaylist.length != expectedPlaylist.length) return false;
    for (int i=0; i<expectedPlaylist.length; i++) {
      if (testPlaylist[i] == null || testPlaylist[i].compareTo(expectedPlaylist[i]) != 0) return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    System.out.println("getShortestSong test result: "+testGetShortestSong());
    System.out.println("remove test result: "+testRemove());
    System.out.println("ascendingSort test result: "+testAscendingSort());
  }
}

/**
 * The objects to be sorted by the AscendingSort class. DO NOT MODIFY THIS CLASS IN ANY WAY.
 */
class Song {
  private String title;
  private int duration;
  
  /**
   * Create a new Song object
   * @param title the title of the song
   * @param numMin the number of minutes in the duration, e.g. for a 4:23 song, this is 4
   * @param numSec the number of seconds in the duration, e.g. for a 4:23 song, this is 23
   */
  public Song(String title, int numMin, int numSec) {
    this.title = title;
    this.duration = numMin*60+numSec;
  }
  
  /**
   * Compare first on the basis of duration, and if the durations are the same, compare
   * on the title.
   * 
   * @param s the Song to compare this to
   * @return value less than 0 if this song is shorter/alphabetically before s, greater
   *    than 0 if this song is longer/alphabetically after s, and 0 if they have the same
   *    title and duration.
   */
  public int compareTo(Song s) {
    if (this.duration != s.duration) return this.duration - s.duration;
    return this.title.compareTo(s.title);
  }
  
  /**
   * For debugging purposes, a way to System.out.println(Song)
   * 
   * Results are formatted roughly as: "Title" (mm:ss)
   */
  @Override
  public String toString() {
    return "\""+this.title+"\" ("+(this.duration/60)+":"+(this.duration%60)+")";
  }
}
