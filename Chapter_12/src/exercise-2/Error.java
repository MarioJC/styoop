/**
 * The Error class is used to designate the severity of an event.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Error {

    // error levels
    public final static int NOISE   = 0;
    public final static int INFO    = 1;
    public final static int WARNING = 2;
    public final static int ERROR   = 3;
    
    private int level;
    
    public Error( int level ) {
        this.level = level;
    }
    
    public int getLevel() {
        return level;
    }
   
    public String toString() {
        switch (level) {
            case 0: return "NOISE";
            case 1: return "INFO"; 
            case 2: return "WARNING";
            default: return "ERROR";
        }
    }
}