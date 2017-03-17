/**
 * This main demonstrates how to instantiate and manipulate objects.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class ItemExample {
    public static void main( String [] args ) {
        // create the items
        Item milk   = new Item( "dairy-011", "1 Gallon Milk", 2, 2.50 );
        Item yogurt = new Item( "dairy-032", "Peach Yogurt", 4, 0.68 );
        Item bread  = new Item( "bakery-023", "Sliced Bread", 1, 2.55 );
        Item soap   = new Item( "household-21", "6 Pack Soap", 1, 4.51 ); 
        
        // apply coupons
        milk.setDiscount( 0.15 );
        
        // get adjusted prices
        double milk_price   = milk.getAdjustedTotal();
        double yogurt_price = yogurt.getAdjustedTotal();
        double bread_price  = bread.getAdjustedTotal();
        double soap_price   = soap.getAdjustedTotal();
        
        // print receipt
        System.out.println( "Thank You For Your Purchase." );
        System.out.println( "Please Come Again!" );
        System.out.println( milk.getDescription()   + "\t $" + milk_price   );
        System.out.println( yogurt.getDescription() + "\t $" + yogurt_price );
        System.out.println( bread.getDescription()  + "\t $" + bread_price  );
        System.out.println( soap.getDescription()   + "\t $" + soap_price   );
        
        // calculate and print total
        double total = milk_price + yogurt_price + bread_price + soap_price;
        System.out.println( "Total Price\t $" + total );
    }
}
