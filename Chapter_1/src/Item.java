/**
 * The Item class represents an item as it might appear in an online shopping 
 * cart or in a cash register. This class demonstrates OOP class basics. 
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class Item {
    
    private double unit_price;
    private double discount;    // a percentage discount to apply to the price
    private int    quantity;    
    private String description;
    private String id;
    
    public Item( String id, String description, int quantity, double price ) {
        this.id = id;
        this.description = description;
        
        if( quantity >= 0 ) {
            this.quantity = quantity;
        }
        else {
            this.quantity = 0;
        }
            
        this.unit_price = price;
    }
    
    public double getAdjustedTotal() {
        double total = unit_price * quantity;
        double total_discount = total * discount;
        double adjusted_total = total - total_discount;
        
        return adjusted_total;
    }
    
    // applies a percentage discount to the price
    public void setDiscount( double discount ) {
        if( discount <= 1.00 ) {
            this.discount = discount;
        }
        else {
            this.discount = 0.0;
        }
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity( int quantity ) {
        if( quantity >= 0 ) {
            this.quantity = quantity;
        }
    }
    
    public String getProductID() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }

}
