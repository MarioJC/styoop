/**
 * SmartPlayer hits on any hand <= 11. The SmartPlayer stands on any hand > 11.
 * @author  Tony Sintes STYOOP
 */
public class SafePlayer extends BettingPlayer {

    public SafePlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public boolean hit( Dealer dealer ) {
        return false;
    }
    
    public void bet() {
        getBank().place10Bet();
    }
}
