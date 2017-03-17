/**
 * The VCard holds onto an extra String attribute. This String references
 * a image file.
 * @author  Tony Sintes STYOOP
 */
public class VCard extends Card {

    private String image;
    
    public VCard( Suit suit, Rank rank, String image ) {
        super( suit, rank );
        this.image = image;
    }

    public String getImage() {
        if( isFaceUp() ) {
            return image;
        } else {
            return "/bitmaps/empty_pile.xbm";
        }
    }
    
}
