/////////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
//// Full Name:Talon Vorpahl
//// Campus ID:9082781304
//// WiscEmail:tvorpahl2@wisc.edu
//////////////////////////////////////////////////////////////////////////////////
///**
//The constructor for this class should take an array of String references as its ONLY argument. The values in this array represent the names of the exclusive Holiday prizes. We assume that the provided array is a full perfect-size array, meaning that it contains zero null references. We also assume that all the string values are not valid (not blank). You DO NOT need to check for that.
//Have this class implement the java.util.Iterator Links to an external site. generic interface to return these String names. However, to make these strings more clear, each string returned from your next() method should start with a prize's name from the provided array, and end with the characters "  is our next exclusive holiday prize" (rather than returning only the prize names). For instance, if the element at index zero of the array is "Trip to Hawaii", the first call of the next() method is expected to return "Trip to Hawaii is our next exclusive holiday prize".
//
//Feel free to define any instance data field to help you implement this iterator. Any defined data field must be private.
//Note that only the hasNext() and next() methods should be overridden in the HolidayPrizeIterator class.
//
//The ONLY external libraries you may use in your submitted file are:
//    import java.util.Iterator;
//    import java.util.NoSuchElementException;
//
//To demonstrate that your class works, add one static test method to your class that takes no arguments, and returns a boolean value: true when the test passes and false otherwise. You can name this method whatever you would like. This test method should create a new HolidayPrizeIterator with a specific array of names, and then count how many times the next() method can be called before hasNext() becomes false. This test should only pass when next() is called the expected number of times before hasNext() returns false. Feel free to add further test scenarios if needed, but this is NOT required.
//You are welcome (but not required) to include a main method to try calling the test method from. */
//
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class HolidayPrizeIterator implements Iterator<String> {
//    private String[] theItems;
//    private int i;
//
//    public HolidayPrizeIterator (String[] in) {
//        theItems = in;
//        i = 0;
//    }
//    
//    @Override
//    public String next() {
//        if (i >= theItems.length || theItems[i] == null) {
//            throw new NoSuchElementException("no items left");
//        }
//        String result = theItems[i];
//        i = i + 1;
//        return result + " is our next exclusive holiday prize";
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !(i >= theItems.length || theItems[i] == null);
//    }
//
//    public static boolean holidayTester() {
//        String[] testIn = {"Trip to Hawaii", "Mouna", "Jeff", "Homes"};
//        HolidayPrizeIterator test = new HolidayPrizeIterator(testIn);
//        try {
//            for (int i = 0; i < testIn.length; i++) {
//                System.out.println(test.next());
//                if(!test.hasNext()) {
//                    if(i != testIn.length - 1) 
//                      return false;
//                }
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        
//        try {
//            test.next();
//            return false;
//        }
//        catch (NoSuchElementException e) {
//        }
//        catch (Exception e) {
//            return false;
//        }
//        
//        if(test.hasNext()) 
//          return false;
//        
//        return true;
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(holidayTester());
//        
//    }
//}
