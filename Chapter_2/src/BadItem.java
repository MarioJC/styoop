/**
 * Bad item demonstrates illustrates what happens when you do not properly
 * divide responsibility.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class BadItem {

    private double unit_price;
    private double adjusted_price;
    private double discount;    // a percentage discount to apply to the price
    private int    quantity;    
    private String description;
    private String id;

    public BadItem( String id, String description, int quantity, double price ) {
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

    public double getUnitPrice() {
      return unit_price;
    }

    // applies a percentage discount to the price
    public void setDiscount( double discount ) {
        if( discount <= 1.00 ) {
            this.discount = discount;
        }
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
    
    public String getProductID() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getAdjustedPrice() {
      return adjusted_price;
    }

    public void setAdjustedPrice( double price) {
      adjusted_price = price;
    }

}
