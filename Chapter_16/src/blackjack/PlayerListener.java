/**
 * This is the interface that a Class should implement if its instances need to
 * listen to a player.
 * @author  Tony Sintes STYOOP
 */
public interface PlayerListener {

    public void playerChanged( Player player );
    
    public void playerBusted( Player player );
    
    public void playerBlackjack( Player player );
    
    public void playerStanding( Player player );
 
    public void playerWon( Player player );
    
    public void playerLost( Player player );
    
    public void playerStandoff( Player player );
    
}
