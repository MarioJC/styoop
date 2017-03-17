import junit.framework.TestCase;
import junit.framework.Assert;
/**
 * The Item unit test.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ItemTest extends TestCase {

    private Item item;
    
    // constants for constructor values
    private final static int ID             = 1;
    private final static int QUANTITY       = 10;
    private final static float UNIT_PRICE   = 100.00f;
    private final static float DISCOUNT     = 5.00f;
    private final static String DESCRIPTION = "ITEM_TEST";
    
    protected void setUp() {
        item = new Item( ID, QUANTITY, UNIT_PRICE, DISCOUNT, DESCRIPTION );
    }
    
    public void test_displayValues() {
        MockDisplayFormatter formatter = new MockDisplayFormatter();
        formatter.test_id( ID );
        formatter.test_quantity( QUANTITY );
        formatter.test_unitPrice( UNIT_PRICE );
        formatter.test_discount( DISCOUNT );
        formatter.test_description( DESCRIPTION );
        
        float adj_total = ( UNIT_PRICE * QUANTITY ) - ( DISCOUNT * QUANTITY );
        formatter.test_adjustedPrice( adj_total );
        
        item.display( formatter );
        
        formatter.verify();
    }
    
    public ItemTest( String name ) {
        super( name );
    }
}