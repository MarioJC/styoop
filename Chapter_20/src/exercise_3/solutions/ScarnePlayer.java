/**
 *
 * @author  Tony Sintes STYOOP
 */
public class ScarnePlayer extends BettingPlayer {

    public ScarnePlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public boolean doubleDown( Dealer d ) {
        int total = getHand().total();
        Card c = d.getUpCard();
        if( total == 11) {
            return true;
        }
        if( total == 10 ) {
            if( c.getRank().getRank() != Rank.TEN.getRank() &&
                c.getRank() != Rank.ACE ) {
                return true;
            }
            return false;
        }
        if( total == 9 ) {
            if( c.getRank() == Rank.TWO   ||
                c.getRank() == Rank.THREE ||
                c.getRank() == Rank.FOUR  ||
                c.getRank() == Rank.FIVE  ||
                c.getRank() == Rank.SIX ) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean hit( Dealer d ) {
        
        int total = getHand().total();
        Card c = d.getUpCard();
        Rank r = c.getRank();
        
        if( total >= 17 ) {
            return false;
        }
        
        if( r == Rank.FIVE || r == Rank.SIX ) {
            if( total >= 12 ) {
                return false;
            }
            return true;
        }
        
        if( r == Rank.TWO || r == Rank.THREE || r == Rank.FOUR ) {
            if( total >= 13 ) {
                return false;
            }
            return true;
        }
        
        if( r == Rank.ACE || r.getRank() == Rank.TEN.getRank() ) {
            if( total >= 16 ) {
                return false;
            }
            return true;
        }
        
        if( r == Rank.SEVEN || r == Rank.EIGHT || r == Rank.NINE ) {
            if( total > 16 ) {
                return false;
            }
            return true;
        }
        
        if( total < 11 ) {
            return true;
        }
        
        return false;
        
    }
    
    public void bet() {
        getBank().place10Bet();
    }
    
}
