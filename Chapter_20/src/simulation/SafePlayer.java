/**
 * SafePlayer always stands. He will never bust.
 * @author  Tony Sintes STYOOP
 */
public class SafePlayer extends BettingPlayer {

    public SafePlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public boolean hit() {
        return false;
    }
    
    public void bet() {
        getBank().place10Bet();
    }
}
