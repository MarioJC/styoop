/**
 * OptimalPlayer follows the rules as stated in exercise 2 chapter 20.
 * @author  Tony Sintes STYOOP
 */
public class OptimalPlayer extends BettingPlayer {

    public OptimalPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public boolean hit( Dealer dealer ) {
        
        int total = getHand().total();
        Card card = dealer.getUpCard();
       
        if( total >= 17 ) {
            return false;
        }
        
        if( total == 16 ) {
            if( card.getRank() == Rank.SEVEN ||
                card.getRank() == Rank.EIGHT ||
                card.getRank() == Rank.NINE ) {
                return true;
            } else {
                return false;
            } 
        }
        if( total == 13 || total == 14 || total == 15 ) {
            if( card.getRank() == Rank.TWO   ||
                card.getRank() == Rank.THREE ||
                card.getRank() == Rank.FOUR  ||
                card.getRank() == Rank.FIVE  ||
                card.getRank() == Rank.SIX ) {
                return false;
            } else {
                return true;
            }
        }
        if( total == 12 ) {
            if( card.getRank() == Rank.FOUR ||
                card.getRank() == Rank.FIVE ||
                card.getRank() == Rank.SIX ) {
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
