/**
 * This is a simple implementation of a betting bank. This bank also has an
 * unlimited credit line. You can bet yourself into oblivion. - lucky you
 * @author  Tony Sintes
 */
public class Bank {

    private int total;
    private int bet;
    
    public Bank( int amount ) {
        total = amount;
    }

    public void place100Bet() {
        placeBet( 100 );
    }
    
    public void place50Bet() {
        placeBet( 50 );
    }
    
    public void place10Bet() {
        placeBet( 10 );
    }
    
    public void win() {
        total += ( 2 * bet );
        bet = 0;
    }
    
    public void lose() {
        // already taken out of total
        bet = 0;
    }
    
    public void blackjack() {
        total += ( ( ( 3 * bet ) / 2 ) + bet );
        bet = 0;
    }
    
    public void standoff() {
        total += bet;
        bet = 0;
    }
    
    public String toString() {
        return ( "$" + total + ".00" );
    }
    
    private void placeBet( int amount ) {
        bet = amount;
        total -= amount;
    }
    
}
