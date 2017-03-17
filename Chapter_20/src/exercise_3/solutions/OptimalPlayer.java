/**
 * OptimalPlayer follows the rules as stated in exercise 3 chapter 20.
 * @author  Tony Sintes STYOOP
 */
public class OptimalPlayer extends BettingPlayer {

    public OptimalPlayer( String name, Hand hand, Bank bank ) {
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
       
        if( total >= 17 ) {
            return false;
        }
        
        if( total == 16 ) {
            if( c.getRank() == Rank.SEVEN ||
                c.getRank() == Rank.EIGHT ||
                c.getRank() == Rank.NINE ) {
                return true;
            } else {
                return false;
            } 
        }
        if( total == 13 || total == 14 || total == 15 ) {
            if( c.getRank() == Rank.TWO   ||
                c.getRank() == Rank.THREE ||
                c.getRank() == Rank.FOUR  ||
                c.getRank() == Rank.FIVE  ||
                c.getRank() == Rank.SIX ) {
                return false;
            } else {
                return true;
            }
        }
        if( total == 12 ) {
            if( c.getRank() == Rank.FOUR ||
                c.getRank() == Rank.FIVE ||
                c.getRank() == Rank.SIX ) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
    
    public void bet() {
        getBank().place10Bet();
    }
    
}
