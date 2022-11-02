//////////////// Tester Class //////////////////////////
//
// Title:    Intersection
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
//   _x__ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understand the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class PathUtilsTester {

  /*
   * Tests the case of countPaths() when there are no valid Paths. For example, when the start
   * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be
   * no valid Paths, so countPaths() should return 0.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsNoPath() {
    //checks for valid path if there's none
    if (PathUtils.countPaths(new Intersection(1, 1), new Intersection(0, 1)) != 0) { 
      return false;
    }
    return true;
  }

  /*
   * Tests the case of countPaths() when there is a single valid Path. For example, when the start
   * position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a
   * single Path, so countPaths() should return 1.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsOnePath() {
    //checks if there's one path
    if (PathUtils.countPaths(new Intersection(1, 1), new Intersection(1, 2)) != 1) {
      return false;
    }
    return true;
  }

  /*
   * Tests the case of countPaths() when there are multiple possible paths. For example, when the
   * start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there
   * should be three possible Paths, so countPaths() should return 3.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsRecursive() {
    //checks if multiple maths
    if (PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 2)) != 3) {
      return false;
    }
    return true;
  }

  /*
   * Tests the case of findAllPaths() when there are no valid Paths. For example, when the start
   * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be
   * no valid Paths, so findAllPaths() should return an empty ArrayList.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsNoPath() {
    //checks if there are no valid paths
    ArrayList<Path> test = PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(0, 1));

    if (!test.isEmpty()) {
      return false;
    }
    return true;
  }

  /*
   * Tests the case of findAllPaths() when there is a single valid Path. For example, when the start
   * position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a
   * single Path. For each of your cases, ensure that there is only a single path, and that the Path
   * exactly matches what you expect to see.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsOnePath() {
    //check if there is only one single path
    ArrayList<Path> test = PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(1, 2));
    if (test.size() != 1) {
      return false;
    }
    if (!test.get(0).toString().equals("(1,1)->(1,2)")) {
      return false;
    }

    return true;
  }

  /*
   * Tests the case of findAllPaths() when there are multiple possible paths. For example, when the
   * start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there
   * should be three possible Paths. For each of your cases, ensure that there is both the correct
   * number of Paths, and that the returned Paths exactly match what you expect to see. Remember:
   * The order the Paths appear in the output of findAllPaths() will not necessarily match your own
   * implementation.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsRecursive() {
    //checks findAllPaths if there are multiple possible paths
    ArrayList<Path> test = PathUtils.findAllPaths(new Intersection(0, 1), new Intersection(3, 2));
    if (test.size() != 4) {
      return false;
    }

    String first = "(0,1)->(1,1)->(2,1)->(3,1)->(3,2)";
    String second = "(0,1)->(1,1)->(2,1)->(2,2)->(3,2)";
    String third = "(0,1)->(1,1)->(1,2)->(2,2)->(3,2)";
    String fourth = "(0,1)->(0,2)->(1,2)->(2,2)->(3,2)";

    for (int i = 0; i < test.size(); i++) {
      if (!(test.get(i).toString().equals(first) || test.get(i).toString().equals(second)
          || test.get(i).toString().equals(third) || test.get(i).toString().equals(fourth))) {
        return false;
      }
    }

    return true;
  }


  /*
   * Main method which uses methods created in PathUtils, Path, and Intersection Java classes
   * 
   * @param String[] args
   * 
   * @auther Mauna
   */
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in)) {
      int startX, startY, endX, endY;
      String input = "Y";
      while (input.equalsIgnoreCase("Y")) {
        System.out.print("Enter starting X coordinate: ");
        startX = keyboard.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        startY = keyboard.nextInt();
        System.out.print("Enter ending X coordinate: ");
        endX = keyboard.nextInt();
        System.out.print("Enter ending Y coordinate: ");
        endY = keyboard.nextInt();
        Intersection start = new Intersection(startX, startY);
        Intersection end = new Intersection(endX, endY);
        System.out
            .println("Number of paths from start to end: " + PathUtils.countPaths(start, end));
        System.out.println("List of possible paths:");
        for (Path p : PathUtils.findAllPaths(start, end)) {
          System.out.println(p);
        }
        do {
          System.out.print("Try another route? (Y/N): ");
          input = keyboard.next();
        } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
      }
    }
    
  }



}
