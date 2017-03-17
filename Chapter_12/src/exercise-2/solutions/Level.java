/**
 * The Level class is used to designate the severity of an error.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public final class Level {
 
    public final static Level NOISE   = new Level( 0, "NOISE" );
    public final static Level INFO    = new Level( 1, "INFO" );
    public final static Level WARNING = new Level( 2, "WARNING" );
    public final static Level ERROR   = new Level( 3, "ERROR" );
    
    private int    level;
    private String name;
    
    private Level( int level, String name ) {
        this.level = level;
        this.name  = name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public String getName() {
        return name;
    }
}