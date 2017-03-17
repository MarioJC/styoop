/**
 * The DoubleKey is a class that is useful for a double key hash. Besides its
 * practicality, the class also demonstrates the use of noarg constructors, 
 * constructors with arguments, accessors, and mutators.
 * @author  Tony Sintes
 * @version 1.0
 */
public class DoubleKey {

    private String key1, key2;
    
    // a no args constructor
    public DoubleKey() {
        key1 = "key1"; 
        key2 = "key2";
    }

    // a constructor with arguments
    public DoubleKey( String key1, String key2 ) {
        this.key1 = key1;
        this.key2 = key2;
    }
    
    // accessor
    public String getKey1() {
        return key1;
    }
    
    // mutator
    public void setKey1( String key1 ) {
        this.key1 = key1;
    }
    
    // accessor
    public String getKey2() {
        return key2;
    }
    
    // mutator
    public void setKey2( String key2 ) {
        this.key2 = key2;
    }
    
    // the following two methods are required in order to properly work as a key
    // if passed to a HashMap or Hashtable
    public boolean equals( Object obj ) {
        
        if( this == obj ) {
            return true;
        }
        
        if( this.getClass() == obj.getClass() ) {
            DoubleKey dk = ( DoubleKey ) obj;
            if( getKey1().equals( dk.getKey1() ) && getKey2().equals( dk.getKey2() ) ) {
                return true;
            }
        }
        
        return false;
    }
    
    public int hashCode() {
        return key1.hashCode() + key2.hashCode();
    }
    
}
