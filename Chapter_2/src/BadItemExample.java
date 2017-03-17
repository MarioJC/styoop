/**
 * BadItemExmple shows how you have to program procedurally when an object does
 * not properly divide responsibility.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BadItemExample extends Object {
    public static void main( String [] args ) {
        // create the items
        BadItem milk   = new BadItem( "dairy-011", "1 Gallon Milk", 2, 2.50 );

        // apply coupons
        milk.setDiscount( 0.15 );

        // get adjusted prices
        double milk_price    = milk.getQuantity() * milk.getUnitPrice();
        double milk_discount = milk.getDiscount() * milk_price;
        milk.setAdjustedPrice( milk_price - milk_discount );

        System.out.println( "Your milk costs:\t $" + milk.getAdjustedPrice() );
    }
}
