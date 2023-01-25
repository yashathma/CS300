import java.util.Iterator;
import java.util.NoSuchElementException;

///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: Tanvi Wadhawan
// Campus ID: 9084764696
// WiscEmail: twadhawan@wisc.edu
////////////////////////////////////////////////////////////////////////////////
public class HolidaySaleIterator implements Iterator<Object> {
  private int[] arr;

  public HolidaySaleIterator(int[] arr) {// sale prices of rugs that are currently on sale.
    // it contains zero null references.
    this.arr = arr;
  }

  @Override
  public boolean hasNext() {
    if (arr.length == 0) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    int index = 0;
    if (!hasNext()) {
      throw new NoSuchElementException("No next");
    }
    int lessThan = arr[index];
    index++;
    return lessThan - 50;
  }

  public static boolean test() {
    int[] arr = {75, 66, 51, 80};
    int index = 0;
    HolidaySaleIterator test1 = new HolidaySaleIterator(arr);
    
    while (test1.hasNext()) {
      if ((Integer) test1.next() == arr[index] - 50) {
        System.out.println(test1.next());
      }
      index++;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(test());
  }

}
