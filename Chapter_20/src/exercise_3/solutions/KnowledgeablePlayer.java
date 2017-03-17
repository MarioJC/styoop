/**
 * KnowledgeablePlayer follows the rules as stated in exercise 3 chapter 20.
 * @author  Tony Sintes STYOOP
 */
public class KnowledgeablePlayer extends BettingPlayer {

    public KnowledgeablePlayer(String name,Hand hand,Bank bank) {
        super( name, hand, bank );
    }

    public boolean doubleDown( Dealer d ) {
        int total = getHand().total();
        if( total == 10 || total == 11 ) {
            return true;
        }
        return false;
    }
    
    public boolean hit( Dealer d ) {
        
        int total = getHand().total();
        Card c = d.getUpCard();
       
        // never hit, no matter what, if total > 15
        if( total > 15 ) {
            return false;
        }
        
        // always hit for 11 and less
        if( total <= 11 ) {
            return true;
        }
        
        // this leaves 11, 12, 13, 14
        // base decision on dealer
        
        if( c.getRank().getRank() > 7 ) {
            return true;
        }
        
        return false;
        
    }
    
    public void bet() {
        getBank().place10Bet();
    }
    
}
