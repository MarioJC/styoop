/**
 * The Error class is used to designate the severity of an event.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Error {

    private Level level;
    
    public Error( Level level ) {
        this.level = level;
    }
    
    public Level getLevel() {
        return level;
    }
   
    public String toString() {
        return level.getName();
    }
}