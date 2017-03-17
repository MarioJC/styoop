/**
 * This is the interface that all player states must implement. A PlayerState
 * listens to the Hand and provides an activity in its execute method.
 * @author  Tony Sintes STYOOP
 */
public interface PlayerState extends HandListener {

    public void execute( Dealer d );
    
}
