import java.util.Iterator;
/**
 * The VDeck builds a deck of VCards. Please note that you could have written
 * a loop that would construct the correct image names. However, while ugly,
 * this is a much more straight forward approach.
 * @author  Tony Sintes STYOOP
 */
public class VDeck extends Deck {

    protected void buildCards() {

        // This is ugly, but it is better than the alternative loops/if/elseif
        Card [] deck = new Card[52];
        setDeck( deck );
        
        deck[0] = new VCard( Suit.HEARTS, Rank.TWO, "/bitmaps/h2" );
        deck[1] = new VCard( Suit.HEARTS, Rank.THREE, "/bitmaps/h3" ); 
        deck[2] = new VCard( Suit.HEARTS, Rank.FOUR, "/bitmaps/h4" );
        deck[3] = new VCard( Suit.HEARTS, Rank.FIVE, "/bitmaps/h5" );
        deck[4] = new VCard( Suit.HEARTS, Rank.SIX, "/bitmaps/h6" );
        deck[5] = new VCard( Suit.HEARTS, Rank.SEVEN, "/bitmaps/h7" );
        deck[6] = new VCard( Suit.HEARTS, Rank.EIGHT, "/bitmaps/h8" );
        deck[7] = new VCard( Suit.HEARTS, Rank.NINE, "/bitmaps/h9" );
        deck[8] = new VCard( Suit.HEARTS, Rank.TEN, "/bitmaps/h10" );
        deck[9] = new VCard( Suit.HEARTS, Rank.JACK, "/bitmaps/h11" );
        deck[10] = new VCard( Suit.HEARTS, Rank.QUEEN, "/bitmaps/h12" );
        deck[11] = new VCard( Suit.HEARTS, Rank.KING, "/bitmaps/h13" );
        deck[12] = new VCard( Suit.HEARTS, Rank.ACE, "/bitmaps/h1" );
        deck[13] = new VCard( Suit.DIAMONDS, Rank.TWO, "/bitmaps/d2" );
        deck[14] = new VCard( Suit.DIAMONDS, Rank.THREE, "/bitmaps/d3" ); 
        deck[15] = new VCard( Suit.DIAMONDS, Rank.FOUR, "/bitmaps/d4" );
        deck[16] = new VCard( Suit.DIAMONDS, Rank.FIVE, "/bitmaps/d5" );
        deck[17] = new VCard( Suit.DIAMONDS, Rank.SIX, "/bitmaps/d6" );
        deck[18] = new VCard( Suit.DIAMONDS, Rank.SEVEN, "/bitmaps/d7" );
        deck[19] = new VCard( Suit.DIAMONDS, Rank.EIGHT, "/bitmaps/d8" );
        deck[20] = new VCard( Suit.DIAMONDS, Rank.NINE, "/bitmaps/d9" );
        deck[21] = new VCard( Suit.DIAMONDS, Rank.TEN, "/bitmaps/d10" );
        deck[22] = new VCard( Suit.DIAMONDS, Rank.JACK, "/bitmaps/d11" );
        deck[23] = new VCard( Suit.DIAMONDS, Rank.QUEEN, "/bitmaps/d12" );
        deck[24] = new VCard( Suit.DIAMONDS, Rank.KING, "/bitmaps/d13" );
        deck[25] = new VCard( Suit.DIAMONDS, Rank.ACE, "/bitmaps/d1" );
        deck[26] = new VCard( Suit.SPADES, Rank.TWO, "/bitmaps/s2" );
        deck[27] = new VCard( Suit.SPADES, Rank.THREE, "/bitmaps/s3" ); 
        deck[28] = new VCard( Suit.SPADES, Rank.FOUR, "/bitmaps/s4" );
        deck[29] = new VCard( Suit.SPADES, Rank.FIVE, "/bitmaps/s5" );
        deck[30] = new VCard( Suit.SPADES, Rank.SIX, "/bitmaps/s6" );
        deck[31] = new VCard( Suit.SPADES, Rank.SEVEN, "/bitmaps/s7" );
        deck[32] = new VCard( Suit.SPADES, Rank.EIGHT, "/bitmaps/s8" );
        deck[33] = new VCard( Suit.SPADES, Rank.NINE, "/bitmaps/s9" );
        deck[34] = new VCard( Suit.SPADES, Rank.TEN, "/bitmaps/s10" );
        deck[35] = new VCard( Suit.SPADES, Rank.JACK, "/bitmaps/s11" );
        deck[36] = new VCard( Suit.SPADES, Rank.QUEEN, "/bitmaps/s12" );
        deck[37] = new VCard( Suit.SPADES, Rank.KING, "/bitmaps/s13" );
        deck[38] = new VCard( Suit.SPADES, Rank.ACE, "/bitmaps/s1" );
        deck[39] = new VCard( Suit.CLUBS, Rank.TWO, "/bitmaps/c2" );
        deck[40] = new VCard( Suit.CLUBS, Rank.THREE, "/bitmaps/c3" ); 
        deck[41] = new VCard( Suit.CLUBS, Rank.FOUR, "/bitmaps/c4" );
        deck[42] = new VCard( Suit.CLUBS, Rank.FIVE, "/bitmaps/c5" );
        deck[43] = new VCard( Suit.CLUBS, Rank.SIX, "/bitmaps/c6" );
        deck[44] = new VCard( Suit.CLUBS, Rank.SEVEN, "/bitmaps/c7" );
        deck[45] = new VCard( Suit.CLUBS, Rank.EIGHT, "/bitmaps/c8" );
        deck[46] = new VCard( Suit.CLUBS, Rank.NINE, "/bitmaps/c9" );
        deck[47] = new VCard( Suit.CLUBS, Rank.TEN, "/bitmaps/c10" );
        deck[48] = new VCard( Suit.CLUBS, Rank.JACK, "/bitmaps/c11" );
        deck[49] = new VCard( Suit.CLUBS, Rank.QUEEN, "/bitmaps/c12" );
        deck[50] = new VCard( Suit.CLUBS, Rank.KING, "/bitmaps/c13" );
        deck[51] = new VCard( Suit.CLUBS, Rank.ACE, "/bitmaps/c1" );
        
    }

}
