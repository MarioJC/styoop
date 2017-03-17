import junit.framework.Assert;
/**
 * This mock ItemDisplayFormatter check to be sure that the item properly
 * populates the formatter. You can use this mock formatter to test the 
 * Item.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class MockDisplayFormatter implements ItemDisplayFormatter {

    private int    test_quantity;
    private int    test_id;
    private float  test_unitPrice;
    private float  test_discount;
    private String test_description;
    private float  test_adjPrice;
    
    private int    quantity;
    private int    id;
    private float  unitPrice;
    private float  discount;
    private String description;
    private float  adjPrice;
    
    public void verify() {
        Assert.assertTrue( "quantity set incorrectly", test_quantity == quantity );
        Assert.assertTrue( "id set incorrectly", test_id == id );
        Assert.assertTrue( "unitPrice set incorrectly", test_unitPrice == unitPrice );
        Assert.assertTrue( "discount set incorrectly", test_discount == discount );
        Assert.assertTrue( "description set incorrectly", test_description == description );
        Assert.assertTrue( "adjPrice set incorrectly", test_adjPrice == adjPrice );
    }
    
    public void test_quantity( int quantity ) {
        test_quantity = quantity;
    }
    
    public void test_id( int id ) {
        test_id = id;
    }
    
    public void test_unitPrice( float unitPrice ) {
        test_unitPrice = unitPrice;
    }
    
    public void test_discount( float discount ) {
        test_discount = discount;
    }
    
    public void test_description( String description ) {
        test_description = description;
    }
    
    public void test_adjustedPrice( float total ) {
        test_adjPrice = total;
    }
    
    public void quantity( int quantity ) {
        this.quantity = quantity;
    }
    
    public void id( int id ) {
        this.id = id;
    }
    
    public void unitPrice( float unitPrice ) {
        this.unitPrice = unitPrice;
    }
    
    public void discount( float discount ) {
        this.discount = discount;
    }
    
    public void description( String description ) {
        this.description = description;
    }
    
    public void adjustedPrice( float total ) {
        this.adjPrice = total;
    }
    
    public String format() { // we're not testing formatter functionality
        return "NOT IMPLEMENTED";
    }
}