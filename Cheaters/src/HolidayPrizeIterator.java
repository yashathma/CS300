import java.util.Iterator;
import java.util.NoSuchElementException;

///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:  Liam Gaiden 
// Campus ID: 9084264275
// WiscEmail: gaiden@wisc.edu
////////////////////////////////////////////////////////////////////////////////
/**
 * @author lgaiden
 *
 */
public class HolidayPrizeIterator implements Iterator{
  private String[] names;
  private int size;
  int current;
  /**
   * 
   */
  public HolidayPrizeIterator(String[] names) {
    this.names = names;
    size = names.length;
    current = 0;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testMethod " + testMethod());

  }

  @Override
  public boolean hasNext() {
    if (size > 0) {
      return true;
    }
    return false;
  }

  @Override
  public String next() throws NoSuchElementException{
    if (hasNext() == false) {
      throw new NoSuchElementException("next: no next element exists for call to next()");
    }
    String answer = "";
    answer += names[current];
    answer += " is our next exclusive holiday prize.";
    current ++;
    size --;
    return answer;
  }
  
  public static boolean testMethod() {
    String[] arr = new String[4];
    arr[0] = "Trip to Mexico";
    arr[1] = "15 Fornite Card";
    arr[2] = "Computer";
    arr[3] = "Longboard";
    HolidayPrizeIterator testIterator = new HolidayPrizeIterator(arr);
    try {
      if (testIterator.hasNext() == false) {
        System.out.println("testMethod: hasNext does not return correctly after 0 calls of next");
        return false;
      }
      testIterator.next();
      if (testIterator.hasNext() == false) {
        System.out.println("testMethod: hasNext does not return correctly after 1 calls of next");
        return false;
      }
      testIterator.next();
      if (testIterator.hasNext() == false) {
        System.out.println("testMethod: hasNext does not return correctly after 2 calls of next");
        return false;
      }
      testIterator.next();
      if (testIterator.hasNext() == false) {
        System.out.println("testMethod: hasNext does not return correctly after 3 calls of next");
        return false;
      }
      testIterator.next();
    }
    catch (NoSuchElementException badThrow) {
      System.out.println("testMethod: unexpected NoSuchElementError thrown");
      System.out.println(badThrow.getMessage());
      return false;
    }
    try {
      testIterator.next();
      System.out.println("testMethod: next does not throw exception when expected");
      return false;
    }
    catch (NoSuchElementException expectedThrow) { 
    }
    if (testIterator.hasNext() == true) {
      System.out.println("testMethod: hasNext returns true on empty array");
      return false;
    }
    return true;
  }

}
