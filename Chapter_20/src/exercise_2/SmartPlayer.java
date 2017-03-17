/**
 * SmartPlayer hits on any hand <= 11. The SmartPlayer stands on any hand > 11.
 * @author  Tony Sintes STYOOP
 */
public class SmartPlayer extends BettingPlayer {

    public SmartPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public boolean hit( Dealer dealer ) {
        if( getHand().total() > 11 ) {
            return false;
        }
        return true;
    }
    
    public void bet() {
        getBank().place10Bet();
    }
}
