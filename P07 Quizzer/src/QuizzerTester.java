//////////////// QuizzerTester Class //////////////////////////
//
// Title: QuizzerTester
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
import java.util.NoSuchElementException;

/**
 * Quizzer tester Class
 * 
 * @author tanviwadhawan
 * @author yash athma
 *
 */
public class QuizzerTester {
  /**
   * main method
   */
  public static void main(String[] args) {

    // runAllTests();
    // System.out.println(testMultipleChoiceQuestion());
    // System.out.println(runAllTests());
    try {
      runAllTests();
    } catch (Exception e) {
    }
  }

  /**
   * runs all Tests
   * 
   * @return true if all tests work, false if not
   */
  public static boolean runAllTests() {
    //Cheks all tests
    if (testMultipleChoiceQuestion() && testLinkedNode() && testAdd() && testAddFirst()
        && testAddLast() && testCorrectQuestionsIterator() && testInCorrectQuestionsIterator()
        && testQuizQuestionsIterator() && testRemove() && testRemoveFirst() && testRemoveLast()) {
      System.out.println("works");
      return true;
    }
    return false;



  }

  /**
   * tests MultipleChoiceQuestion
   * 
   * @return true if MultipleChoiceQuestion works, false if not
   */
  public static boolean testMultipleChoiceQuestion() {
    String[] ans = new String[3];
    ans[0] = "abc";
    ans[1] = "def";
    ans[2] = "xyz";

    String result1 = "1. " + ans[0] + "\n" + "2. " + ans[1] + "\n" + "3. " + ans[2];
    // testing getters

    MultipleChoiceQuestion test = new MultipleChoiceQuestion(null, null, ans, 2, 2);
    test.setTitle("title");
    test.setQuestion("question?");
    test.setCorrectAnswerIndex(2);
    test.setPointsPossible(2);
    test.setStudentAnswerIndex(2);


    String result = "QUESTION TITLE: " + "\"" + "title" + "\"" + "\n" + "Question:\n" + "question?"
        + "\n" + "Available Answers:\n" + result1;
    // System.out.println(result);

    // test exceptions
    try {
      MultipleChoiceQuestion test2 = new MultipleChoiceQuestion("title", "question?", ans, -2, -2);
      System.out.println("Invalid correct answer index");
    } catch (IllegalArgumentException e) {
      // e.printStackTrace();
    } catch (IndexOutOfBoundsException d) {
      // d.printStackTrace();
    }
    // //checks if the student answer is valid

    if (!test.getTitle().equals("title")) {// checks title
      System.out.println("t not working");
      return false;
    }
    if (!test.getQuestion().equals("question?")) {// checks question
      System.out.println("q not working");
      return false;
    }

    if (!test.getAnswers().equals(result1)) {// check answers
      System.out.println("res not working");
      return false;
    }
    if (test.getCorrectAnswerIndex() != 2) {// check correctAnsIndex
      System.out.println("getInd not working");
      return false;
    }
    if (test.getPointsPossible() != 2) {// check points possible
      System.out.println("pts possible not working");
      return false;
    }
    if (!test.isCorrect()) {// checks equality of student ans index and correct ans index
      System.out.println("isCorrect not working");
      return false;
    }
    if (test.getStudentAnswerIndex() != 2) {// checks student ans index System.out.println("t not
                                            // working");
      System.out.println("getAnsInd not working");
      return false;
    }
    if (!test.toString().equals(result)) {// checks toString
      System.out.println("toString not working");
      return false;
    }
    MultipleChoiceQuestion test2 = new MultipleChoiceQuestion("title", "question?", ans, 2, 2);
    if (!test.equals(test2)) {// check equals

      System.out.println("eq not working");
      return false;
    }
    MultipleChoiceQuestion test3 = test.copy();
    if (!test2.equals(test3)) {// check copy
      System.out.println("copy not working");
      return false;
    }
    return true;

  }

  /**
   * * tests LinkedNode
   * 
   * @return true if LinkedNode works, false if not
   */
  public static boolean testLinkedNode() {
    try {
      String[] ansr1 = {"a1", "a2", "a3", "a4", "a5"};
      MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("T", "Q", ansr1, 2, 5);

      String[] ansr2 = {"a1", "a2", "a3"};
      MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("T2", "Q2", ansr2, 1, 3);

      LinkedNode<MultipleChoiceQuestion> n1 = new LinkedNode<MultipleChoiceQuestion>(q1);
      LinkedNode<MultipleChoiceQuestion> n2 = new LinkedNode<MultipleChoiceQuestion>(q2, n1);
      System.out.println(n2.getData());
      if (!n2.getData().equals(q2)) {
        return false;
      }

      if (!n2.getNext().equals(n1)) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /*
   * Tester for ListQuizzer.add() method
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAdd() {
    ListQuizzer q = new ListQuizzer();
    
    //Creating
    q.addLast(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T5", "Q5", new String[] {"x"}, 0, 1));
    
    //Using add
    q.add(1, new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1));
    q.add(3, new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1));
    q.add(5, new MultipleChoiceQuestion("T6", "Q6", new String[] {"x"}, 0, 1));

    
    //testing each case
    if (!q.get(0).equals(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(1).equals(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(2).equals(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(3).equals(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(4).equals(new MultipleChoiceQuestion("T5", "Q5", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(5).equals(new MultipleChoiceQuestion("T6", "Q6", new String[] {"x"}, 0, 1))) {
      return false;
    }
    
    //no bugs found
    return true;
  }

  /*
   * Tester for ListQuizzer.addFirst() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddFirst() {
    try {
      {
        //Creatings
        ListQuizzer q = new ListQuizzer();
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("T", "Q", new String[] {"x"}, 0, 1);

         //Using addfirst
        q.addFirst(q1);
        if (!q.getFirst().equals(q1)) {
          return false;
        }
        if (!q.getLast().equals(q1)) {
          return false;
        }
      }

      ListQuizzer quiz = new ListQuizzer();
      MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("T", "Q", new String[] {"x"}, 0, 1);
      quiz.addFirst(q1);
      MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("T", "Q", new String[] {"x"}, 0, 1);
      quiz.addFirst(q2);

      if (!quiz.getFirst().equals(q2)) {
        return false;
      }

    } catch (Exception e) {
      System.out.println(e);
      return false;
    }


    return true;
  }

  /*
   * Tester for ListQuizzer.addLast() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddLast() {
    try {

      {
        //case 1
        ListQuizzer quiz = new ListQuizzer();
        MultipleChoiceQuestion q = new MultipleChoiceQuestion("T", "Q", new String[] {"x"}, 0, 1);
        quiz.addLast(q);

        if (!quiz.getLast().equals(q)) {
          return false;
        }

        if (!quiz.getFirst().equals(q)) {
          return false;
        }

      }

      {
        //case 2
        ListQuizzer quiz = new ListQuizzer();
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("T", "Q", new String[] {"x"}, 0, 1);
        quiz.addLast(q1);
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("x", "x", new String[] {"x"}, 0, 1);
        quiz.addLast(q2);

        if (!quiz.getLast().equals(q2)) {
          return false;
        }


      }

    } catch (Exception e) {
      System.out.println(e);
      return false;
    }

    return true;

  }

  /*
   * This method checks for the correctness of QuizQuestionsIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testQuizQuestionsIterator() {
    //Creating wuizzes
    MultipleChoiceQuestion q1 =
        new MultipleChoiceQuestion("T1", "Q1", new String[] {"a1", "CA", "a3"}, 1, 1);
    q1.setStudentAnswerIndex(1);
    MultipleChoiceQuestion q2 =
        new MultipleChoiceQuestion("T2", "Q2", new String[] {"a1", "a2", "CA"}, 2, 1);
    q2.setStudentAnswerIndex(0);
    MultipleChoiceQuestion q3 =
        new MultipleChoiceQuestion("T3", "Q3", new String[] {"CA", "a2", "a3"}, 0, 1);
    q3.setStudentAnswerIndex(0);
    
    //Creating the linked nodes
    LinkedNode<MultipleChoiceQuestion> n1 = new LinkedNode<MultipleChoiceQuestion>(q1);
    LinkedNode<MultipleChoiceQuestion> n2 = new LinkedNode<MultipleChoiceQuestion>(q2);
    LinkedNode<MultipleChoiceQuestion> n3 = new LinkedNode<MultipleChoiceQuestion>(q3);

    n1.setNext(n2);
    n2.setNext(n3);

    try {
      QuizQuestionsIterator<MultipleChoiceQuestion> test =
          new QuizQuestionsIterator<MultipleChoiceQuestion>(n1);

      if (!test.hasNext()) {
        return false;
      }

      if (!test.next().equals(q1)) {
        return false;
      }

      if (!test.next().equals(q2)) {
        return false;
      }

      if (!test.next().equals(q3)) {
        return false;
      }

      try {
        test.next();
      } catch (NoSuchElementException e) {
        return true;
      }

    } catch (Exception e) {
      System.out.println(e);
      return false;
    }


    return true;
  }

  /*
   * This method checks for the correctness of IncorrectQuestionsIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testInCorrectQuestionsIterator() {

    MultipleChoiceQuestion q1 =
        new MultipleChoiceQuestion("T1", "Q1", new String[] {"a1", "CA", "a3"}, 1, 1);
    q1.setStudentAnswerIndex(1);
    MultipleChoiceQuestion q2 =
        new MultipleChoiceQuestion("T2", "Q2", new String[] {"a1", "a2", "CA"}, 2, 1);
    q2.setStudentAnswerIndex(0);
    MultipleChoiceQuestion q3 =
        new MultipleChoiceQuestion("T3", "Q3", new String[] {"CA", "a2", "a3"}, 0, 1);
    q3.setStudentAnswerIndex(0);
    MultipleChoiceQuestion q4 =
        new MultipleChoiceQuestion("T4", "Q4", new String[] {"a1", "a2", "CA"}, 2, 1);
    q4.setStudentAnswerIndex(1);
    MultipleChoiceQuestion q5 =
        new MultipleChoiceQuestion("T5", "Q5", new String[] {"a1", "a2", "CA"}, 2, 1);
    q5.setStudentAnswerIndex(1);

    LinkedNode<MultipleChoiceQuestion> n1 = new LinkedNode<MultipleChoiceQuestion>(q1);
    LinkedNode<MultipleChoiceQuestion> n2 = new LinkedNode<MultipleChoiceQuestion>(q2);
    LinkedNode<MultipleChoiceQuestion> n3 = new LinkedNode<MultipleChoiceQuestion>(q3);
    LinkedNode<MultipleChoiceQuestion> n4 = new LinkedNode<MultipleChoiceQuestion>(q4);
    LinkedNode<MultipleChoiceQuestion> n5 = new LinkedNode<MultipleChoiceQuestion>(q5);

    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);

    try {
      IncorrectQuestionsIterator<MultipleChoiceQuestion> test =
          new IncorrectQuestionsIterator<MultipleChoiceQuestion>(n1);

      if (test.hasNext() != true) {
        return false;
      }

      if (!test.next().equals(q2)) {
        return false;
      }

      if (!test.next().equals(q4)) {
        return false;
      }

      if (!test.next().equals(q5)) {
        return false;
      }

      try {
        test.next();
      } catch (NoSuchElementException e) {
        return true;
      }


    } catch (Exception e) {
      return false;
    }

    return false;
  }

  /*
   * This method checks for the correctness of CorrectQuestionsIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testCorrectQuestionsIterator() {
    MultipleChoiceQuestion q1 =
        new MultipleChoiceQuestion("T1", "Q1", new String[] {"a1", "CA", "a3"}, 1, 1);
    q1.setStudentAnswerIndex(1);
    MultipleChoiceQuestion q2 =
        new MultipleChoiceQuestion("T2", "Q2", new String[] {"a1", "a2", "CA"}, 2, 1);
    q2.setStudentAnswerIndex(0);
    MultipleChoiceQuestion q3 =
        new MultipleChoiceQuestion("T3", "Q3", new String[] {"CA", "a2", "a3"}, 0, 1);
    q3.setStudentAnswerIndex(0);
    MultipleChoiceQuestion q4 =
        new MultipleChoiceQuestion("T4", "Q4", new String[] {"a1", "a2", "CA"}, 2, 1);
    q4.setStudentAnswerIndex(2);
    MultipleChoiceQuestion q5 =
        new MultipleChoiceQuestion("T5", "Q5", new String[] {"a1", "a2", "CA"}, 2, 1);
    q5.setStudentAnswerIndex(2);

    LinkedNode<MultipleChoiceQuestion> n1 = new LinkedNode<MultipleChoiceQuestion>(q1);
    LinkedNode<MultipleChoiceQuestion> n2 = new LinkedNode<MultipleChoiceQuestion>(q2);
    LinkedNode<MultipleChoiceQuestion> n3 = new LinkedNode<MultipleChoiceQuestion>(q3);
    LinkedNode<MultipleChoiceQuestion> n4 = new LinkedNode<MultipleChoiceQuestion>(q4);
    LinkedNode<MultipleChoiceQuestion> n5 = new LinkedNode<MultipleChoiceQuestion>(q5);

    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);
    
    //tests the cases
    try {
      CorrectQuestionsIterator<MultipleChoiceQuestion> test =
          new CorrectQuestionsIterator<MultipleChoiceQuestion>(n1);

      if (test.hasNext() != true) {
        return false;
      }

      if (!test.next().equals(q1)) {

        return false;
      }


      if (!test.next().equals(q3)) {

        return false;
      }

      if (!test.next().equals(q4)) {

        return false;
      }

      if (!test.next().equals(q5)) {

        return false;
      }

      try {
        test.next();
      } catch (NoSuchElementException e) {
        return true;
      }


    } catch (Exception e) {
      return false;
    }

    return false;
  }

  /*
   * Tester for ListQuizzer.remove() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    ListQuizzer q = new ListQuizzer();

    q.addLast(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T5", "Q5", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T6", "Q6", new String[] {"x"}, 0, 1));

      //removing the values
    MultipleChoiceQuestion r1 = q.remove(2);
    MultipleChoiceQuestion r2 = q.remove(2);
    MultipleChoiceQuestion r3 = q.remove(0);
    MultipleChoiceQuestion r4 = q.remove(2);

    if (!r1.equals(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!r2.equals(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!r3.equals(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!r4.equals(new MultipleChoiceQuestion("T6", "Q6", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(0).equals(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(1).equals(new MultipleChoiceQuestion("T5", "Q5", new String[] {"x"}, 0, 1))) {
      System.out.println("asdf");
      return false;
    }

    try {
      q.get(2);
    } catch (IndexOutOfBoundsException e) {
      return true;
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  /*
   * Tester for ListQuizzer.removeFirst() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveFirst() {
    ListQuizzer q = new ListQuizzer();

    q.addLast(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1));

    MultipleChoiceQuestion r1 = q.removeFirst();
    MultipleChoiceQuestion r2 = q.removeFirst();


    if (!r1.equals(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!r2.equals(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1))) {
      return false;
    }



    if (!q.get(0).equals(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(1).equals(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1))) {
      return false;
    }

    try {
      q.get(2);
    } catch (IndexOutOfBoundsException e) {
      return true;
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  /*
   * Tester for ListQuizzer.removeLast() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveLast() {
    ListQuizzer q = new ListQuizzer();

    q.addLast(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1));
    q.addLast(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1));

    MultipleChoiceQuestion r1 = q.removeLast();
    MultipleChoiceQuestion r2 = q.removeLast();


    if (!r1.equals(new MultipleChoiceQuestion("T4", "Q4", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!r2.equals(new MultipleChoiceQuestion("T3", "Q3", new String[] {"x"}, 0, 1))) {
      return false;
    }



    if (!q.get(0).equals(new MultipleChoiceQuestion("T1", "Q1", new String[] {"x"}, 0, 1))) {
      return false;
    }

    if (!q.get(1).equals(new MultipleChoiceQuestion("T2", "Q2", new String[] {"x"}, 0, 1))) {
      return false;
    }

    try {
      q.get(2);
    } catch (IndexOutOfBoundsException e) {
      return true;
    } catch (Exception e) {
      return false;
    }
    return false;
  }

}
