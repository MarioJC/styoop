import junit.framework.TestCase;
import junit.framework.Assert;
/**
 * The SavingsAccountTest rewritten to take advantage of JUnit.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class SavingsAccountTest extends TestCase {
    
    private SavingsAccount acct;
    
    public void test_applyingInterest() {
        
        acct.addInterest();
   
        Assert.assertTrue( "interest applied incorrectly", acct.getBalance() == 10500.00 );
   
    }
    
    public void test_withdrawFunds() {
        
        acct.withdrawFunds( 500.00 );
        
        Assert.assertTrue( "incorrect amount withdrawn", acct.getBalance() == 9500.00 );
        
    }
    
    protected void setUp() {
        
        acct = new SavingsAccount( 10000.00, 0.05 );
  
    }
    
    public SavingsAccountTest( String name ) {
        super( name );
    }
    
}