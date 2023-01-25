///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: Yash Athma
// Campus ID: 908 422 8698
// WiscEmail: athma@wisc.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

////////////////////////////////////////////////////////////////////////////////
//
// This file contains ONE class. You will need to complete the implementation
// this class with respect to the provided requirements in the TODO tags for
// full credit.
//
// When creating new exception objects, including messages within these objects
// is optional.
////////////////////////////////////////////////////////////////////////////////

/**
 * This class implements methods to manage the list of students waiting for their turn to get
 * assistance during consulting hours. The list of student requests is stored in an oversize array
 * defined by a reference to an array of strings which stores students requests and an int variable
 * which keeps track of the size of the array.
 * 
 * The array requests is an oversize array. This means it contains non null references from index 0
 * to index size-1. All references in the range of indexes size .. requests.length-1 MUST be null.
 * 
 * In this WaitingRoom class, new requests are added to the end of the array. Removal operations are
 * made from the beginning of the array.
 * 
 * All requests are represented by strings formatted as follows: "studentName: keyword". The
 * studentName refers to the name of the students asking for assistance and the keyword represents
 * the assistance topic. We assume that all requests are correctly formatted.
 * 
 * Samples of requests: "Mouna: p1", "Jeff: eclipse", "Michelle: java17"
 * 
 * All string comparisons are CASE-SENSITIVE.
 * 
 */
public class RequestList {

  /**
   * Adds a new request to the end of the requestList defined by requests and size. If requests
   * is full the new request won't be added to the requests array and the following message will be
   * printed: "Error! Full requests."
   * 
   * @param requests   an array which stores students assistance requests
   * @param size       number of requests stored in the requests array
   * @param newRequest new assistance request to be added to the requests array
   * @return the size of the oversize array after trying to insert newRequest to requests
   */
  public static int addLast(String[] requests, int size, String newRequest) {
    
    requests[size] = newRequest;
    
    size++;
    // TODO Complete the implementation of this method

    return size; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Gets the number of requests related to the topic passed as input.
   * 
   * @param requests an array which stores students assistance requests
   * @param size     total number of requests in the requests array
   * @param topic    a string representing a topic for an assistance request
   * @return the number of requests in requests which contain the string topic passed as input
   * @throws IllegalArgumentException if size is negative ( < 0)
   */
  public static int getRequestsCountByTopic(String[] requests, int size, String topic)
      throws IllegalArgumentException {
    // TODO implement this method

    int count = 0;
    try {
      // 2. compute the number of requests which contain the given topic within the requests array
      // default return statement added to avoid compiler errors. Feel free to change it.
      for(int i = 0; i<requests.length;i++) {
        if(requests[i]!=null) {
          if(requests[i].contains(topic)) {
            count++;
          }
        }
      }
      return count;
    } catch(Exception e){
      // 1. throw an IllegalArgumentException if size < 0
      System.out.println("IllegalArgumentException");
    }
    
    return count;

  }

  /**
   * Removes the student request stored at index zero of the oversize array defined by requests and
   * size.
   * 
   * If the array is empty (its size is zero), this method prints the following message:
   * 
   * "Error! Empty requests."
   * 
   * @param requests an array which stores student assistance requests
   * @param size     size of the requests array
   * @return the size of the oversize array after trying to remove the request at index 0.
   */
  public static int removeFirst(String[] requests, int size) {
 // TODO Complete the implementation of this method
    // Hint: Removing the element at index zero involves a shift operation
    
    if(size<=0) {
      System.out.println("Error! Empty requests.");
    }
    
    // For instance if the original array requests contained {e0, e1, e2, e3, null, null} and size
    // was 4, after calling removeFirst(requests, size) the array should contain {e1, e2, e3, null,

    
    for(int i = 0; i<size-1;i++) {
      requests[i] = requests[i+1];
    }
    
    for(int i = size-1; i<requests.length; i++) {
      requests[i]=null;
    }
    // null, null} and the returned value should be 3.
    size--;
    


    return size;
  }

  /**
   * Checks whether the correctness of the RequestList.removeFirst() method when passed a non-empty
   * oversize array.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSuccessfulRemoveFirst() {
    
    
    
    // TODO
    // 1. Create an NON-full oversize array of Strings which already contains 4 student requests.
     String[] check = new String[] {"Mouna: p1", "Jeff: eclipse", "Michelle: java17", "Yash: p3", null, null};
     int size = 4;
    // 2. Try to call RequestList.removeFirst() to remove the element at index 0 of requests
     size = RequestList.removeFirst(check, size);
    // 3. Check for bugs.
    // Expected behavior: Element at index 0 should have been removed as a result of a shift
    // operation and the method should return 3.
    // Check that the method removeFirst() did make the expected changes to the contents of the
    // original array passed as input
     
     if(size!=3) {
       System.out.println("The RequestList.removeFirst method did not return the right value when removing a value from the first index of the array");
       return false;
     }
     
     String[] realcheck = new String[] {"Jeff: eclipse", "Michelle: java17", "Yash: p3", null, null, null};
     if(!Arrays.deepEquals(check, realcheck)) {
       System.out.println("The RequestList.removeFirst method did not correctly remove the first value in the given array");
       return false;
     }

    // You DO NOT need to check for unexpected exceptions in this tester.

    // 4. This tester returns true if no bugs are detected

    return true; // default return statement added to avoid compiler errors. Feel free to change
                  // it.
  }

  /**
   * Checks whether the RequestList.addLast method works as expected when called to add a new
   * request to a non-full oversize array of strings
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddLast() {
    // create an non-full oversize array
    String[] requests = new String[] {"Michelle: p1", "Mouna: p2", "Hobbes: p2", "Ashley: quiz1-2",
        "Jeff: java17", null, null, null};
    int size = 5;
    // expected output and array after adding newRequest "Kushagra: zybookw03"
    String[] expectedrequests = new String[] {"Michelle: p1", "Mouna: p2", "Hobbes: p2",
        "Ashley: quiz1-2", "Jeff: java17", "Kushagra: zybookw03", null, null};
    int expectedOutput = 6;
    try {
      // add newRequest to the non-full list
      size = addLast(requests, size, "Kushagra: zybookw03");
      // check whether the returned size and the content of the array are correct
      if (size != expectedOutput)
        return false;
      if (!Arrays.deepEquals(requests, expectedrequests))
        return false;
    } catch (Exception e) {
      return false; // no exception is expected to be thrown
    }

    return true; // no bugs detected by this tester
  }

  /**
   * Checks the correctness of the implementation of the RequestList.getRequestsCountByTopic()
   * method when passed an non-full array containing a few students requests.
   * 
   * @return true if the method passes this test and false otherwise
   */
  public static boolean testGetRequestsCountByTopicNotFullList() {
    // test scenario: non-full oversize array of student assistance requests
    String[] requests = new String[] {"Mouna: p2", "Hobbes: javadocs", "Ashley: p2", "Jeff: p3",
        "Michelle: p2", null, null, null};
    int size = 5;
    int expectedOutput = 3; // topic: "p2"
    String[] originalRequests = new String[] {"Mouna: p2", "Hobbes: javadocs", "Ashley: p2",
        "Jeff: p3", "Michelle: p2", null, null, null};

    try {
      // call getRequestsCountByTopic() and check whether it returns the expected output
      int count = getRequestsCountByTopic(requests, size, "p2");
      if (count != expectedOutput) //
        return false; // bug! incorrect output
      // check that the method call has made no changes to the original requests

      if (!Arrays.deepEquals(requests, originalRequests)) // bug! changes made to the requests array
        return false;
    } catch (Exception e) { // catches any unexpected exception
      return false; // this scenario was not expected to throw any exception
    }
    return true; // no bugs detected by this tester
  }


  /**
   * Main method to call the test methods
   * 
   * @param args - input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(
        "testGetRequestsCountByTopicNotFullList()): " + testGetRequestsCountByTopicNotFullList());
    System.out.println("testSuccessfulRemoveFirst(): " + testSuccessfulRemoveFirst());
    System.out.println("testAddLast(): " + testAddLast());
  }
}
