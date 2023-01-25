
// Full Name: Yash Athma
// Campus ID: 908 422 8698
// WiscEmail: athma@wisc.edu

import java.util.Iterator;
import java.util.NoSuchElementException;
public class HolidayShippingIterator implements Iterator<Double> {
  private Double[] list;
  
  private int i;
  

  public HolidayShippingIterator(Double[] d) {
    list = d;
    i = 0;
  }
  
  @Override
  public boolean hasNext() {
    return i < list.length;
  }
  
  @Override
  public Double next() {
    if(hasNext()==false) {
      throw new NoSuchElementException();
    }
    
    Double weightAtIndex = list[i]+0.1;
    
    i++;
    return weightAtIndex;
  }
  
  public static boolean Iteratortester() {
    Double[] inputData = {5.0,6.0,7.0,8.0};
    
    HolidayShippingIterator iterator = new HolidayShippingIterator(inputData);
    
    double finalVal = 0.0;
    
    while(iterator.hasNext()) {
      finalVal+=iterator.next();
    }
    

    return (finalVal==26.4);
  }
  
  public static void main(String[] args) {
    System.out.println(Iteratortester());
  }
  
}
