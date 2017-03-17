import junit.framework.TestCase;
import junit.framework.Assert;
/**
 * A unit test for HourlyEmployee
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class HourlyEmployeeTest extends TestCase {

    private HourlyEmployee emp;
    
    private static final String FIRST_NAME = "FNAME";
    private static final String LAST_NAME  = "LNAME";
    private static final double WAGE       = 500.00;
    
    protected void setUp() {
        emp = new HourlyEmployee( FIRST_NAME, LAST_NAME, WAGE );
    }
    
    public void test_calculatePay() {
        emp.addHours( 10 );
        
        double expected = WAGE * 10;
        assertTrue( "incorrect pay calculation", emp.calculatePay() == expected );
    }
    
    public HourlyEmployeeTest( String name ) {
        super( name );
    }
}