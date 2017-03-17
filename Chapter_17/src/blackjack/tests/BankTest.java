package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Bank;

/**
 * This class tests the Bank.
 * @author  Tony Sintes STYOOP
 */
public class BankTest extends TestCase {

    private Bank bank;
    
    public void test_place100Bet_win() {
        bank.place100Bet();
        bank.win();
        Assert.assertTrue( bank.toString().equals( "$1100.00" ) );
    }
    
    public void test_place100Bet_lose() {
        bank.place100Bet();
        bank.lose();
    }
    
    public void test_place100Bet_blackjack() {
        bank.place100Bet();
        bank.blackjack(); 
    }
    
    public void test_place100Bet_standoff() {
        bank.place100Bet();
        bank.standoff();
    }
    
    public void test_place50Bet_win() {
        bank.place50Bet();
        bank.win();
    }
    
    public void test_place50Bet_lose() {
        bank.place50Bet();
        bank.lose();
    }
    
    public void test_place50Bet_blackjack() {
        bank.place50Bet();
        bank.blackjack(); 
    }
    
    public void test_place50Bet_standoff() {
        bank.place50Bet();
        bank.standoff();
    }
    
    public void test_place10Bet_win() {
        bank.place10Bet();
        bank.win();
    }
    
    public void test_place10Bet_lose() {
        bank.place10Bet();
        bank.lose();
    }
    
    public void test_place10Bet_blackjack() {
        bank.place10Bet();
        bank.blackjack(); 
    }
    
    public void test_place10Bet_standoff() {
        bank.place10Bet();
        bank.standoff();
    }
    
    protected void setUp() {
        bank = new Bank( 1000 );
    }
    
    public BankTest( String name ) {
        super( name );
    }

}
