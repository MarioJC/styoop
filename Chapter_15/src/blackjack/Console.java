import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * The Console singleton provides access to the command line.
 * @author  Tony Sintes STYOOP
 */
public class Console implements PlayerListener {

    // console singleton
    public final static Console INSTANCE = new Console();
    
    private BufferedReader in = 
        new BufferedReader( new InputStreamReader( System.in ) );
   
    public void printMessage( String message ) {
        System.out.println( message );
    }
  
    public String readInput( String default_input ) {
        String response;
        try {
            return in.readLine();
        } catch (IOException ioe) {
            return default_input;
        }
    }
    
    public void handChanged( Player player ) {
        printMessage( player.toString() );
    }
    
    // private to prevent instantiation
    private Console() {}
    
}
