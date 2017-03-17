/**
 * PointExample illustrates what happens when a child overrides a behavior.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class PointExample {
      public static void main( String [] args ) {
            TwoDimensionalPoint two = new TwoDimensionalPoint(1,2);
            ThreeDimensionalPoint three = new ThreeDimensionalPoint(1,2,3);

            System.out.println(two.toString());
            System.out.println(three.toString());
      }
}
