/**
 * This is the Class repsresentation of the card. There is no sense in having a 
 * different class for each suit of card. Cards only differ in their value of
 * the value and suit.
 * @author  Tony Sintes
 */
public class Card {

    private Rank rank;
    private Suit suit;
    private boolean face_up;
    
    public Card( Suit suit, Rank rank ) {        
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public void setFaceUp( boolean up ) {
        face_up = up;
    }
    
    public boolean isFaceUp() {
        return face_up;
    }
    
    public String toString() {
        if( !isFaceUp() ) {
            return "Hidden";
        }
        return rank.toString() + suit.toString();
    }
}
