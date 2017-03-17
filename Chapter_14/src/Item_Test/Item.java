/**
 * Item represents an item in the online web store.
 * @author  Tony Sintes STYOOP
 * @version 2.0
 */
public class Item {

    private int    id;
    private int    quantity;
    private float  unitPrice;
    private String description;
    private float  discount;
    
    /**
     *  Create a new item with the given quantity, price, 
     *  description, and unit discount.
     *  @param id the product id
     *  @param quantity the number of items selected
     *  @param unit_price the before discount price
     *  @param description the product description
     *  @param discount the dollar amount to subtract per item
     */
    public Item( int id, int quantity, float unitPrice, float discount, String desc ) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.description = desc;
    }

    public void display( ItemDisplayFormatter format ) {
    
        format.quantity( quantity );
        format.id( id );
        format.unitPrice( unitPrice );
        format.discount( discount );
        format.description( description );
        format.adjustedPrice( getTotalPrice() );
        
    }
    
    /**
     *  @return float the total price of the item minus any discounts
     */
    public float getTotalPrice() {
        return ( unitPrice * quantity ) - ( discount * quantity );
    }
    
}
