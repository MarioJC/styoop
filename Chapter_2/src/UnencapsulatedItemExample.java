/**
 * This main demonstrates how UnencapsulatedItem can be left in an invalid state.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class UnencapsulatedItemExample extends Object {
    public static void main( String [] args ) {
        UnencapsulatedItem monitor = new UnencapsulatedItem( "electronics-012", "17\" SVGA Monitor", 1, 299.00 );
        
        monitor.discount = 1.25; // invalid, discount must be less than 100%!
        
        double price = monitor.getAdjustedTotal();
        
        System.out.println( "Incorrect Total: $" + price );
        
        monitor.setDiscount( 1.25 ); // invalid, however the setter will catch the error
        
        price = monitor.getAdjustedTotal();
        
        System.out.println( "Correct Total: $" + price );
    }
}
