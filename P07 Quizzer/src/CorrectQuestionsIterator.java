//////////////// CorrectQuestionsIterator Class //////////////////////////
//
// Title: CorrectQuestionsIterator
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an iterator to iterate over correctly answered MultipleChoiceQuestion(s) stored in a
 * singly linked list defined by its head.
 * 
 * @author tanviwadhawan
 *
 */
public class CorrectQuestionsIterator<T extends MultipleChoiceQuestion>
    implements Iterator<MultipleChoiceQuestion> {
  // refers to a node in the singly linked list of MultipleChoiceQuestion to traverse
  private LinkedNode<MultipleChoiceQuestion> next;

  /**
   * Creates a new CorrectQuestionsIterator to start iterating through a singly linked list storing
   * MultipleChoiceQuestion elements
   * 
   * @param startNode- pointer to the head of the singly linked list
   */
  public CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
    next = startNode;

    if (this.hasNext()) {
      while (next.getNext() != null) {
        if (next.getData().isCorrect()) {//checks if is correct
          break;
        }
        next = next.getNext();
      }
    }

  }

  /**
   * Returns true if this iteration has more MultipleChoiceQuestion(s) answered correctly
   * 
   * @return true if there are more correct MultipleChoiceQuestion(s) in this iteration
   */
  @Override
  public boolean hasNext() {
    if (next != null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the next correct MultipleChoiceQuestion in this iteration
   * 
   * @return the next correct MultipleChoiceQuestion in this iteration
   * @throws NoSuchElementException- with a descriptive error message if there are no more correct
   *                                 questions in this iteration
   */
  @Override
  public MultipleChoiceQuestion next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("There is no such element");
    }
    LinkedNode<MultipleChoiceQuestion> result = next;

    while (true) {
      next = next.getNext();
      if (next == null || next.getData().isCorrect()) {
        break;
      }
    }
    return result.getData();

  }

}
