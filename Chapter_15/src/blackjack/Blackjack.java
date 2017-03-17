/**
 * The Blackjack main. This main creates the dealer, player, attaches the
 * objects, and starts the game.
 * @author  Tony Sintes
 */
public class Blackjack {

    public static void main( String [] args ) {
        
        Deckpile cards = new Deckpile();
        for( int i = 0; i < 4; i ++ ) {
            cards.shuffle();
            Deck deck = new Deck();
            deck.addToStack( cards );
            cards.shuffle();
        }
        
        Hand dealer_hand = new Hand();
        BlackjackDealer dealer = new BlackjackDealer( "Dealer", dealer_hand, cards );
        Hand human_hand = new Hand();
        Player player = new HumanPlayer( "Human", human_hand );
        dealer.addListener( Console.INSTANCE );
        player.addListener( Console.INSTANCE );
        dealer.addPlayer( player );
        
        dealer.newGame();
    }
    
}
