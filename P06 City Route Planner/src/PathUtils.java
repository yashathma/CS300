//////////////// Path Utils Class //////////////////////////
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
import java.nio.file.Paths;
import java.util.ArrayList;

public class PathUtils {
  /*
   * Finds the number of valid Paths between the given start and end Intersections. If it is not
   * possible to get from the start to the end intersection by moving up or right, then 0 should be
   * returned.
   * 
   * @param start - Intersection to start at
   * 
   * @param end - Intersection to end at
   * 
   * @return the number of valid Paths which start and end at the given Intersections
   */
  public static int countPaths(Intersection start, Intersection end) {
    //checks if possible to change x or y 
    if(start.getX()>end.getX() || start.getY()>start.getY()) {//base case
      return 0;
    }
    if (start.equals(end)) {//base case one path
      return 1;
    }else{
      if(start.getX()==end.getX()) {//if there's y movement then goNorth
        return countPaths(start.goNorth(),end);
      }
      else if(start.getY()==end.getY()) {//if x movement then goEast
        return countPaths(start.goEast(),end);
      }
      else {//there are multiple paths so add them to each other
        return countPaths(start.goNorth(), end) + countPaths(start.goEast(), end);
      }      
    }
  }
  

  /*
   * Finds all valid Paths between the given start and end Intersections. If it is not possible to
   * get from the start to the end intersection by moving up or right, then an empty ArrayList
   * should be returned.
   * 
   * @param start - Intersection to start at
   * 
   * @param end - Intersection to end at
   * 
   * @return an ArrayList containing all valid Paths which start and end at the given Intersections
   */

  public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
    ArrayList<Path> allPaths = new ArrayList<>();
    //base case, if not possible then return the empty ArrayList
    if(start.getX() > end.getX() || start.getY()>end.getY()) {
      return allPaths;
    }else {
      //fill arrayList with paths
      ArrayList<Path> finalPaths1= new ArrayList<Path>(countPaths(start,end));
      for(int i=0; i <countPaths(start,end); i++) {
        Path abc= new Path();
        abc.addHead(start);
        finalPaths1.add(abc);//add valid path
      }
      helper(finalPaths1, end);//use recursion to find more paths
      return finalPaths1;         
    }

  }
  /**
   * helper method for findAllPaths
   * @param paths arraylist containing the paths
   * @param end intersection to end at
   */
  public static void helper(ArrayList<Path> paths, Intersection end){
    if(paths.get(0).getTail().equals(end)) {//base case 
      return ;
    }
    //go through all the paths and have a currentTail intersections
    for(int i=0;i<paths.size();i++) {
      Intersection currTail= paths.get(i).getTail();
      if(currTail.getX()==end.getX()) {//check if it's equal to the end
        paths.get(i).addTail(currTail.goNorth());//check if it's equal to the end
      }else if(currTail.getY()==end.getY()) {//check if it's equal to the end
        paths.get(i).addTail(currTail.goEast()); //check if it's equal to the end
      }else {
        //find the amount of paths
        int x= countPaths(currTail.goEast(),end);
        int y= countPaths(currTail.goNorth(),end);
        //go through all the paths
        for(int j=0;j<x;j++) {
          paths.get(i).addTail(currTail.goEast());
          i++;
        }
        for(int k=0;k<y;k++) {
          paths.get(i).addTail(currTail.goNorth());
          i++;                              
        }
        i--;
      }
    }
    helper(paths,end);//recursive part
    
  }
}
