/**
 * The BlackjackSim main. This main creates the dealer and the specified mix of players.
 * @author  Tony Sintes
 */
public class BlackjackSim {

    public static void main( String [] args ) {

        Console.INSTANCE.printMessage( "How many times should the simulator play?" );
        String response = Console.INSTANCE.readInput( "invalid" );
        int loops = Integer.parseInt( response );
        
        Deckpile cards = new Deckpile();
        for( int i = 0; i < 4; i ++ ) {
            cards.shuffle();
            Deck deck = new Deck();
            deck.addToStack( cards );
            cards.shuffle();
        }
        
        // create a dealer
        Hand dealer_hand = new Hand();
        BlackjackDealer dealer = new BlackjackDealer( "Dealer", dealer_hand, cards );
        
        // create a OneHitPlayer
        Bank one_bank = new Bank( 1000 );
        Hand one_hand = new Hand();
        Player oplayer = new OneHitPlayer( "OneHit", one_hand, one_bank );
        
        // create a SmartPlayer
        Bank smart_bank = new Bank( 1000 );
        Hand smart_hand = new Hand();
        Player smplayer = new SmartPlayer( "Smart", smart_hand, smart_bank );

        // create a SafePlayer
        Bank safe_bank = new Bank( 1000 );
        Hand safe_hand = new Hand();
        Player splayer = new SafePlayer( "Safe", safe_hand, safe_bank );

        // create a FlipPlayer
        Bank flip_bank = new Bank( 1000 );
        Hand flip_hand = new Hand();
        Player fplayer = new FlipPlayer( "Flip", flip_hand, flip_bank );

        // hook all of the players together
        dealer.addListener( Console.INSTANCE );
        oplayer.addListener( Console.INSTANCE );
        dealer.addPlayer( oplayer );
        splayer.addListener( Console.INSTANCE );
        dealer.addPlayer( splayer ); 
 
        smplayer.addListener( Console.INSTANCE );
        dealer.addPlayer( smplayer );
        fplayer.addListener( Console.INSTANCE );
        dealer.addPlayer( fplayer );
        
        int counter = 0;
        while( counter < loops ) {
            dealer.newGame();
            counter ++;
        }
    }
    
}
