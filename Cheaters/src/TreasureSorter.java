import java.util.Arrays;

///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:
// Campus ID:
// WiscEmail:
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// This file contains ONE utility class and ONE data type class. You will need to 
// complete the implementation of the utility class with respect to the provided 
// requirements in the TODO tags for full credit.
//
// You should not modify the data type class in any way.
// 
// You are not required to add error checking to any of these methods.
////////////////////////////////////////////////////////////////////////////////

/**
 *  This class contains a single public method: sortTreasure(), along with 
 *  several helper methods and two tests.  This public method uses the heap sort
 *  algorithm to sort treasure values in descending order.
 *  
 *  // TODO #1-9 below ask you to finish implementing the following methods
 *  (only make edits below each of these numbered TODOs, as described for each):
 *  DONE peekTreasure() - returns largest treasure value from the root position of the max-heap 
 *  percolateDown() - recursively enforces heap ordering down from specified index
 *  heapify() - iteratively moves values from a randomly-ordered array into heap order
 *  removeBestTreasure() - removes treasure value from root position in heap, and returns new size
 *  sortTreasure() - computes and returns a sorted array of treasure values
 *  
 *  Additionally, the following helper and test methods are provided:
 *  swap() - swaps the values at two different positions within an array
 *  bestOf() - returns the largest of its three string/null arguments
 *  testHeapify() - returns true when this test passes and false otherwise
 *  testSort() - returns true when this test passes and false otherwise
 *  main() - calls and prints out the value returned from test()
 */
public class TreasureSorter {
  
  /**
   * Returns treasure value from the root position in the max-heap (largest value) 
   * We suppose that the provided heap array is NOT empty.
   * 
   * @param heap a provided max-heap
   * @return treasure value from the root position in the max-heap 
   */
  private static Treasure peekTreasure(Treasure[] heap) {
    return heap[0];
  }
  
  /**
   * Recursive helper method which implements percolateDown operation to restore the
   * heap order property if it is violated at a given index position of a provided max-heap.
   * 
   * @param index position of the element to start the percolate-down operation from
   * @param heap a provided max-heap array
   * @param size of the heap
   */
  private static void percolateDown(int index, Treasure[] heap, int size) {
    if(index >= size) return; // cannot percolate further below bottom of heap
    // compute indexes of left and right children positions within heap
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;

    // store values from index, left, and right child positions into separate variables
    Treasure indexValue = heap[index];
    Treasure rightChildValueOrNull = null;
    
    if(rightChildIndex<size) 
      rightChildValueOrNull = heap[rightChildIndex];
    
    Treasure leftChildValueOrNull = null;
    
    if(leftChildIndex<size) 
      leftChildValueOrNull = heap[leftChildIndex];    
    
    // compute highest priority value between index and its left and right children
    Treasure best = bestOf(indexValue, rightChildValueOrNull, leftChildValueOrNull);
    
    if( best.equals(leftChildValueOrNull) ) {
      swap(heap, leftChildIndex, index);
      percolateDown(leftChildIndex, heap, size);
      
    } else if( best.equals(rightChildValueOrNull) ) {
      swap(heap, rightChildIndex, index);
      percolateDown(rightChildIndex, heap, size);
      
    }
  }
  
  /**
   * Reorganizes an array of Treasure values into a valid max heap.
   * This heapify operation does NOT operate in-place.
   * 
   * @param values a provided oversize array of values, in no particular order
   * @param size number of values in the provided oversize array
   * @return a DEEP COPY of the values array, in max-heap order
   */
  private static Treasure[] heapify(Treasure[] values, int size) {
    Treasure[] heap = Arrays.copyOf(values, size);
    
    int heapifyIndex = size - 1;
    
    while (heapifyIndex >= 0) {
      //move the value at heapifyIndex to the correct location
      swap(heap, 0, heapifyIndex);
      percolateDown(0, heap, size);
      
      //update heapifyIndex to continue the process
      heapifyIndex = heapifyIndex - 1;
    }
    
    return heap;
  }
  
  /**
   * Removes treasure value from root position in heap, and then return heap's new size.
   * Assume that the provided array is NOT empty and is a valid max-heap.
   * 
   * @param heap a provided max-heap
   * @param size of heap before removeTreasure is called.
   * @return size is the new size of heap after removeTreasure is performed
   */
  private static int removeBestTreasure(Treasure[] heap, int size) {
    // remove the root element from the provided heap, correct
    //          heap order violations, and then return the resulting heap size
    size = size - 1;
    heap[0] = heap[size];
    heap[size] = null;
    percolateDown(0, heap, size);
    return size;
  } 
  
  /**
   * Sorts an array of treasure values into descending order using a max-heap. This sort operation 
   * does NOT operate in-place. Assume that the provided array is NOT empty.
   * 
   * @param values an array of values, not necessarily in heap order
   * @return reference to the sorted array
   */
  public static Treasure[] sortTreasure(Treasure[] values, int size) {
    int heapSize = size;
    // Sorted is an over sized array that will be filled with Treasure values 
    // in sorted (descending) order.  When it is full, it will be returned.
    Treasure[] heap = heapify(values, size);
    Treasure[] sorted = new Treasure[heap.length];
    int sortedIndex = 0;
    
    while(heapSize > 0) {
      // insert best element from heap into earliest free position in sorted array
      sorted[sortedIndex] = peekTreasure(heap);
      sortedIndex = sortedIndex + 1;
            
      // remove the best value from the heap (see helper methods above!)
      heapSize = removeBestTreasure(heap, heapSize);

    }
    
    return sorted;
  }
  
  //////////////////////////// UTILITY METHODS, PROVIDED ///////////////////////

  /**
   * Swaps the elements at indexes i and j in the provided array
   * @param array in which elements are being moved
   * @param i the first index being changed in that array
   * @param j the second index being changed in that array
   */
  private static void swap(Treasure[] array, int i, int j) {
    Treasure temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  
  /**
   * Returns the largest between the provided arguments.
   * Null arguments are ignored (considered smaller than Treasure).
   * @param a, b, c are the Treasures being compared
   * @return the largest of those Treasures
   * @throws IllegalArgumentException when all Treasures are null
   */
  private static Treasure bestOf(Treasure a, Treasure b, Treasure c) {
    if(a != null && 
        (b == null || a.compareTo(b) >= 0) && 
        (c == null || a.compareTo(c) >= 0))
        return a;
    else if(b != null && 
        (a == null || b.compareTo(a) >= 0) && 
        (c == null || b.compareTo(c) >= 0)) 
        return b;
    else if(c != null && 
        (a == null || c.compareTo(a) >= 0) && 
        (b == null || c.compareTo(b) >= 0))
      return c;
    else
      throw new IllegalArgumentException("All of the Treasures were null");
  }
  
  /**
   * One short and simple test for the heapfiy method.
   * @return true when this test passes, otherwise false
   */
  private static boolean testHeapify() {
    try {
      Treasure[] randomValues = new Treasure[] {
          new Treasure(3.1), 
          new Treasure(64.0), 
          new Treasure(1.6), 
          new Treasure(98.6), 
          new Treasure(32.0), 
          new Treasure(9.8)
      };
      Treasure[] heapOfTreasure = new Treasure[] {
          new Treasure(98.6), 
          new Treasure(64.0), 
          new Treasure(9.8), 
          new Treasure(3.1), 
          new Treasure(32.0), 
          new Treasure(1.6)
      };
      
      System.out.println("Expected: "+Arrays.deepToString(heapOfTreasure));
      System.out.println("Actual:   "+
             Arrays.deepToString(heapify(randomValues, randomValues.length)));
      
    } catch(Exception e) {
      return false;
    }
    
    return true;
  }
  
  /**
   * One short and simple test for the sortTreasure method.
   * @return true when this test passes, otherwise false
   */
  private static boolean testSort() {
    try {
      Treasure[] heapOfTreasure = new Treasure[] {
          new Treasure(98.6),
          new Treasure(32.0),
          new Treasure(64.0),
          new Treasure(1.6),
          new Treasure(3.1),
          new Treasure(9.8)     
      };
      Treasure[] sortedTreasure = new Treasure[] {
          new Treasure(98.6),
          new Treasure(64.0),
          new Treasure(32.0),
          new Treasure(9.8),
          new Treasure(3.1),
          new Treasure(1.6)
      };
      
      System.out.println("Expected: "+Arrays.deepToString(sortedTreasure));
      System.out.println("Actual:   "+
             Arrays.deepToString(sortTreasure(heapOfTreasure, heapOfTreasure.length)));
      
      if(!Arrays.deepEquals(sortTreasure(heapOfTreasure, heapOfTreasure.length), sortedTreasure))
        return false;
      
    } catch(Exception e) {
      return false;
    }
    
    return true;
  }

  /**
   * Driver for the test methods above.
   * @param args is unused
   */
  public static void main(String[] args) {
    System.out.println("testHeapify(): "+testHeapify());
    System.out.println("testSort(): "+testSort());
  }
}

/**
 * Object being sorted in our heapsort methods above
 */
class Treasure implements Comparable<Treasure> {
  private double value;
  public Treasure(double v) { this.value = v; }
  @Override
  public String toString() { return ""+this.value; }
  @Override
  public int compareTo(Treasure o) { return Double.compare(this.value, ((Treasure)o).value); }
  @Override
  public boolean equals(Object o) { 
    if (o instanceof Treasure) return ((Treasure)o).value == this.value; 
    return false;
  }
}