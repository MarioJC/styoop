/**
 * This is the interface that a Class should implement if its instances need to
 * listen to a player.
 * @author  Tony Sintes STYOOP
 */
public interface PlayerListener {

    public void playerChanged( Player p );
    
    public void playerBusted( Player p );
    
    public void playerBlackjack( Player p );
    
    public void playerStanding( Player p );
 
    public void playerWon( Player p );
    
    public void playerLost( Player p );
    
    public void playerStandoff( Player p );
    
}
