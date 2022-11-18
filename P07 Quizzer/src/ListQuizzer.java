//////////////// ListQuizzer Class //////////////////////////
//
// Title: ListQuizzer
// Course: CS 300 Fall 2022
//
// Author: Yash Athma
// Email: athma@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Tanvi Wadhawan
// Partner Email: twadhawan@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __x_ Write-up states that pair programming is allowed for this assignment.
// __x_ We have both read and understand the course Pair Programming Policy.
// __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * List Quizzer class This class models an iterable singly-linked list data structure which stores
 * elements of type MultipleChoiceQuestion.
 * 
 * @author tanviwadhawan
 *
 */
public class ListQuizzer implements Iterable<MultipleChoiceQuestion> {
  private LinkedNode<MultipleChoiceQuestion> head;// Head of this singly linked list
  private LinkedNode<MultipleChoiceQuestion> tail;// Tail of this singly linked list
  private int size;// Total number of MultipleChoiceQuestions stored in this ListQuizzer
  private ListingMode listingMode;// The listing mode of this list quizzer which defines
  // which questions are going to be listed while iterating through this list

  /**
   * this constructor creates a new empty instance of ListQuizzer which contains zero elements and
   * sets its listing mode to be ListingMode.ALL by default.
   */
  public ListQuizzer() {
    size = 0;
    head = null;
    tail = null;
    listingMode = ListingMode.ALL;

  }

  /**
   * Checks whether this list is empty
   * 
   * @return true if this list is empty and false otherwise
   */
  public boolean isEmpty() {
    // if(head==null) {//or size==0
    // return true;
    // }
    // return false;
    if (size == 0 && head == null & tail == null) {
      return true;
    }
    return false;
  }

  /**
   * Gets the size of this list
   * 
   * @return the size of this list
   */
  public int size() {
    return size;
  }

  /**
   * Sets the listing mode of this list to the one provided as input
   * 
   * @param listingMode - listing mode to set
   */
  public void switchMode(ListingMode listingMode) {
    this.listingMode = listingMode;
  }

  /**
   * Adds a specific MultipleChoiceQuestion to a given position of this list
   * 
   * @param index-    position index where to add the newQuestion to this list
   * @param question- some MultipleChoiceQuestion to add to this list
   * @throws NullPointerException      = - with a descriptive error message if newQuestion is null
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is OUT of the
   *                                   range 0 .. size() inclusive
   */
  public void add(int index, MultipleChoiceQuestion question)
      throws NullPointerException, IndexOutOfBoundsException {
    //Checks inputs
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException("Input Index is Out of Bounds");
    }

    if (index == 0 || this.isEmpty() == true) {
      this.addFirst(question);
      return;
    }

    if (index == size) {
      this.addLast(question);
      return;
    }



    LinkedNode<MultipleChoiceQuestion> left = head;
    LinkedNode<MultipleChoiceQuestion> right = head;


    //shifts
    for (int i = 0; i < index - 1; i++) {
      left = left.getNext();
    }

    right = left.getNext();

    LinkedNode<MultipleChoiceQuestion> Node =
        new LinkedNode<MultipleChoiceQuestion>(question, right);

    left.setNext(Node);

    size++;

  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the head of this list
   * 
   * @param question- some MultipleChoiceQuestion to add to the head of this list
   * @throws NullPointerException- with a descriptive error message if newQuestion is null
   */
  public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {
    if (question == null) {
      throw new NullPointerException("question cannot be null");

    }
    if (this.isEmpty()) {
      LinkedNode<MultipleChoiceQuestion> Node = new LinkedNode<MultipleChoiceQuestion>(question);
      head = Node;
      tail = Node;
      size++;
    } else {
      LinkedNode<MultipleChoiceQuestion> n =new LinkedNode<MultipleChoiceQuestion>(question, head);
      head = n;
      size++;
    }
  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the tail of this list
   * 
   * @param question- some MultipleChoiceQuestion to add to the tail of this list
   * @throws NullPointerException- with a descriptive error message if newQuestion is null
   */
  public void addLast(MultipleChoiceQuestion question) throws NullPointerException {
    if (question == null) {
      throw new NullPointerException("question cannot be null");
    }

    if (this.isEmpty()) {
      LinkedNode<MultipleChoiceQuestion> Node = new LinkedNode<MultipleChoiceQuestion>(question);
      head = Node;
      tail = Node;
      size++;

    } else {
      LinkedNode<MultipleChoiceQuestion> n = new LinkedNode<MultipleChoiceQuestion>(question);
      tail.setNext(n);
      tail = n;
      size++;
    }



  }

  /**
   * This method removes all the question from this list. The list should be empty after this 
   * method is called.
   */
  public void clear() {
    size = 0;
    head = null;
    tail = null;

  }

  /**
   * Returns the MultipleChoiceQuestion stored at the given index within this list
   * 
   * @param index- index of the MultipleChoiceQuestion to return
   * @return-the MultipleChoiceQuestion stored at the given index within this list
   * @throws IndexOutOfBoundsException-if index is out of the range 0 .. size()-1 inclusive
   */
  public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size() - 1) {
      throw new IndexOutOfBoundsException("Your Index is out of bounds");
    }

    LinkedNode<MultipleChoiceQuestion> arr = head;
    for (int i = 0; i < index; i++) {
      arr = arr.getNext();
    }
    return arr.getData();

  }

  /**
   * Gets the MultipleChoiceQuestion at the head of this list
   * 
   * @return-the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException-with a descriptive error message if this list is empty
   */
  public MultipleChoiceQuestion getFirst() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such element. The list is empty");
    }
    return head.getData();
  }

  /**
   * Gets the MultipleChoiceQuestion at the tail of this list
   * 
   * @return-the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException-with a descriptive error message if this list is empty
   */
  public MultipleChoiceQuestion getLast() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such element. The list is empty");
    }
    return tail.getData();
  }

  /**
   * Calculates the total points of the correctly answered questions of this ListQuizzer
   * 
   * @return the score of this ListQuizzer
   */

  public int calculateScore() {
    int result = 0;
    LinkedNode<MultipleChoiceQuestion> temp1 = head;// deep copy of MCQ
    // count amt of right points
    for (int i = 0; i < size() - 1; i++) {
      if (temp1.getData().isCorrect()) {
        result += temp1.getData().getPointsPossible();
      }
    }
    return result;
  }

  /**
   * Calculates the total possible points of this ListQuizzer
   * 
   * @return the score of this ListQuizzer
   * 
   */
  public int calculateTotalPoints() {
    int result = 0;
    for (int i = 0; i < size() - 1; i++) {
      result += head.getData().getPointsPossible();
      head = head.getNext();
    }
    return result;
  }

  /**
   * Returns a deep copy of this list. This method creates a copy of this list as a new ListQuizzer
   * and adds deep copies of each MultipleChoiceQuestion stored in this list to the deep copy.
   * 
   * @return a deep copy of this list.
   * 
   */
  public ListQuizzer copy() {
    ListQuizzer temp = new ListQuizzer();
    LinkedNode<MultipleChoiceQuestion> temp1 = head;// deep copy of MCQ
    for (int i = 0; i < size() - 1; i++) {
      if (i == 0) {
        temp.addFirst(temp1.getData());
      }
      temp.add(i, temp1.getData());// add it at index i
      temp1 = temp1.getNext();// move on to next head
    }
    return temp;
  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the given index
   * 
   * @param index- of the MultipleChoiceQuestion to remove
   * @returnthe removed MultipleChoiceQuestion
   * @throws IndexOutOfBoundsException-- with a descriptive error message if index is out of the
   *                                     range 0 .. size()-1 inclusive
   */
  public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException {
    if (this.isEmpty()) {
      throw new IndexOutOfBoundsException("Your list is empty");

    }
    if (index < 0 || index > size() - 1) {
      throw new IndexOutOfBoundsException("Your Index is out of bounds");
    }


    // ListQuizzer temp = new ListQuizzer();
    // LinkedNode <MultipleChoiceQuestion> result = temp.get(index).get;
    LinkedNode<MultipleChoiceQuestion> temp1 = head;

    if (size == 1 && index == 0) {
      LinkedNode<MultipleChoiceQuestion> prev = head;
      head = null;
      tail = null;
      size--;
      return prev.getData();
    }
    
    //Pulling top and bottom
    if (index == 0) {
      LinkedNode<MultipleChoiceQuestion> prev = head;
      head = head.getNext();
      size--;
      return prev.getData();
    }
    if (index == size - 1) {
      LinkedNode<MultipleChoiceQuestion> prev = head;
      for (int i = 0; i < size - 2; i++) {
        prev = prev.getNext();
      }
      LinkedNode<MultipleChoiceQuestion> tailN = tail;

      prev.setNext(null);
      tail = prev;
      size--;
      return tailN.getData();
    }


    // remove middle
    LinkedNode<MultipleChoiceQuestion> tempL = head;
    for (int i = 0; i < index - 1; i++) {
      tempL = tempL.getNext();
    }
    LinkedNode<MultipleChoiceQuestion> tempR = tempL.getNext();
    tempR = tempR.getNext();

    LinkedNode<MultipleChoiceQuestion> result = tempL.getNext();
    tempL.setNext(tempR);
    size--;
    return result.getData();



  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the head of this list
   * 
   * @return-the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public MultipleChoiceQuestion removeFirst() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("No Such element. The list is empty");
    }
    if (size == 1) {
      LinkedNode<MultipleChoiceQuestion> result = head;
      head = null;
      tail = null;
      size--;
      return result.getData();
    }
    LinkedNode<MultipleChoiceQuestion> result = head;
    size--;
    head = head.getNext();
    return result.getData();
  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the tail of this list
   * 
   * @return-the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public MultipleChoiceQuestion removeLast() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("No Such element. The list is empty");
    }
    if (size == 1) {
      LinkedNode<MultipleChoiceQuestion> result = head;
      head = null;
      tail = null;
      size--;
      return result.getData();
    }
    LinkedNode<MultipleChoiceQuestion> result = head;
    for (int i = 0; i < size - 2; i++) {
      result = result.getNext();
    }
    LinkedNode<MultipleChoiceQuestion> tailN = tail;
    tail = result;
    result.setNext(null);
    size--;
    return tailN.getData();
  }

  /**
   * Returns an iterator to iterate through this list with respect to the listingMode. If the
   * listingMode is ALL, the returned iterator is initialized to the head of this list. If the
   * listingMode is CORRECT, the returned iterator is initialized to the node carrying first
   * correctly answered question If the listingMode is INCORRECT, the returned iterator is
   * initialized to the node carrying first incorrectly answered question
   * 
   * @return an iterator to iterate through this list with respect to the listingMode of this list
   */
  public Iterator<MultipleChoiceQuestion> iterator() {
    if (listingMode == listingMode.ALL) {
      return new QuizQuestionsIterator<MultipleChoiceQuestion>(head);
    }
    if (listingMode == listingMode.CORRECT) {
      return new CorrectQuestionsIterator<MultipleChoiceQuestion>(head);
    }
    if (listingMode == listingMode.INCORRECT) {
      return new IncorrectQuestionsIterator<MultipleChoiceQuestion>(head);
    }
    return null;

  }

  /**
   * Loads MultipleChoiceQuestions from a file
   * 
   * @author Jeff and Mouna
   * 
   * @param file file to read
   * @return the number of added MultipleChoiceQuestions to this list
   * @throws FileNotFoundException if the file is not found
   */
  public int loadQuestions(File file) throws FileNotFoundException {
    int loadedCount = 0; // count of loaded multiple choice questions
    int answerCount = 0; // count of possible answers per question
    int indexCorrectAnswer = 0; // index of the correct answer
    int points = 0; // possible points for a multiple choice question
    // try to read the file
    Scanner reader = null; // scanner to read the file line by line
    int lineNumber = 0; // number of the last read line

    try {
      reader = new Scanner(file);
      // parse the file lines - while loop to read parts of each multiple choice question
      while (reader.hasNextLine()) { // no more lines to read
        // read title
        String title = reader.nextLine();
        lineNumber++;

        // read question stem
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String question = reader.nextLine();
        lineNumber++;

        // read possible answers count
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String count = reader.nextLine();
        lineNumber++;
        // check the validity of count
        try {
          answerCount = Integer.parseInt(count.trim());
          if (answerCount <= 0 || answerCount > 10) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // count invalid - print an error message and return
          System.out
              .println("Syntax error! A positive integer less or equal to 10 is expected at line "
                  + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid count -> create the answerList array
        String[] answerList = new String[answerCount];
        int index = 0;
        while (index < answerCount && reader.hasNextLine()) {
          String answer = reader.nextLine();
          lineNumber++;
          answerList[index] = answer;
          index++;
        }

        // read index of the correct answer
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String line = reader.nextLine();
        lineNumber++;
        try { // check the validity of the index of the correct answer
          indexCorrectAnswer = Integer.parseInt(line.trim());
          if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return
          System.out.println("Syntax error! A positive integer less than " + answerCount
             + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid index of the correct answer -> read possible points
        // read points
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        line = reader.nextLine();

        lineNumber++;
        try { // check the validity of the index of the correct answer
          points = Integer.parseInt(line.trim());

          if (points < 0) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // invalid points - print error message and return
          System.out.println("Syntax error! A positive integer for possible points "
              +" is expected at line " + lineNumber + (". Load questions operation interrupted!"));

          return loadedCount;
        }
        // create and add quizQuestion
        MultipleChoiceQuestion quizQuestion =
            new MultipleChoiceQuestion(title, question, answerList, indexCorrectAnswer, points);

        this.addLast(quizQuestion);
        loadedCount += 1;
        System.out.println("Question " + loadedCount + " loaded!");

      }
    } finally {
      if (reader != null)
        reader.close();
    }

    return loadedCount;
  }


  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep copy of this ListQuizzer.
   * This method should not make any changes to the contents of this ListQuizzer.
   * 
   * @author Jeff and Mouna
   * 
   * @return the instance of ListQuizzer taken by the user. It should include the user's responses.
   */
  public ListQuizzer takeQuiz() {

    ListQuizzer copy = this.copy();
    copy.switchMode(ListingMode.ALL);
    Scanner input = new Scanner(System.in);
    for (MultipleChoiceQuestion question : copy) {
      System.out.println(question);
      System.out.print("Enter your answer: ");
      int entry = input.nextInt();
      question.setStudentAnswerIndex(entry - 1);
      if (question.isCorrect()) {
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
      }
    }
    int correctPoints = copy.calculateScore();
    int totalPoints = copy.calculateTotalPoints();
    System.out.println("Your Score: " + correctPoints);
    System.out.println("Percentage: " + correctPoints / totalPoints);
    input.close();
    return copy;
  }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents as this ListQuizzer
   * 
   * @author Mouna
   *
   * @param o an object to compare with
   * @return true if o is instanceof ListQuizzer with the exact same contents as this ListQuizzer
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof ListQuizzer) {
      ListQuizzer other = (ListQuizzer) o;
      if (this.size() != other.size())
        return false;
      this.switchMode(ListingMode.ALL);
      other.switchMode(ListingMode.ALL);
      Iterator<MultipleChoiceQuestion> iterator = this.iterator();
      Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
      while (iterator.hasNext()) {
        if (!iterator.next().equals(otherIterator.next()))
          return false;
      }
      return true;
    }
    return false;
  }

}
