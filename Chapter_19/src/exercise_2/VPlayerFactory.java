/**
 * The VPlayerFactory makes sure to construct the players and dealer with
 * the proper objects. This is an example of using a factory when you want 
 * a set of objects used together. This prevents you from using incompatible 
 * objects together (such as passing a Deckpile of Cards instead of VCards 
 * to a VBlackjackDealer.
 * @author  Tony Sintes STYOOP
 */
public class VPlayerFactory {

    private VBlackjackDealer dealer;
    private GUIPlayer human;
    private Deckpile pile;
    
    public VBlackjackDealer getDealer() {
        // only create and return one
        if( dealer == null ) {
            VHand dealer_hand = getHand();
            Deckpile cards = getCards();
            dealer = new VBlackjackDealer( "Dealer", dealer_hand, cards );
        }
        return dealer;
    }
    
    public GUIPlayer getHuman() {
        // only create and return one
        if( human == null ) {
            VHand human_hand = getHand();
            Bank bank = new Bank( 1000 );
            human = new GUIPlayer( "Human", human_hand, bank, getDealer() );
        }
        return human;
    }

    public Deckpile getCards() {
        // only create and return one
        if( pile == null ) {
            pile = new Deckpile();
            for( int i = 0; i < 4; i ++ ) {
                pile.shuffle();
                Deck deck = new VDeck();
                deck.addToStack( pile );
                pile.shuffle();
            }
        }
        return pile;
    }
    
    private VHand getHand() {
        return new VHand();
    }
    
}
