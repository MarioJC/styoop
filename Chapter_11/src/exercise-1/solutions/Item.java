/**
 * Item represents an item in the online web store.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Item {

    private int    id;
    private int    quantity;
    private float  unit_price;
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
    public Item( int id, int quantity, float unit_price, float discount, String desc) {
        this.id = id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.discount = discount;
        this.description = desc;
    }

    /**
     *  @return int the item quantity 
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     *  @param quantity the new quantity
     */
    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
    
    /**
     *  @return the item unit price
     */
    public float getUnitPrice() {
        return unit_price;
    }
    
    /**
     *  @return float the total price of the item minus any discounts
     */
    public float getTotalPrice() {
        return ( unit_price * quantity ) - ( discount * quantity );
    }
    
    /**
     *  @return String the product description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     *  @return int the product id
     */
    public int getID() {
        return id;
    }
    
}
