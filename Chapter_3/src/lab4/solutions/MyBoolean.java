/**
 * This is one possible solution to lab 4. This solution reproduces the entire
 * Boolean interface and adds a method that allows you to change the wrapped 
 * value.
 * @author  Tony Sintes
 * @version 1.0
 */
public class MyBoolean  {

    // some constants for convenience
    public static final Class TYPE = Boolean.TYPE;
    
    private boolean value;
    
    // no arg constructor - default to false
    public MyBoolean() {
        value = false;
    }

    // set the initial wrapped value to value
    public MyBoolean( boolean value ) {
        this.value = value;
    }
    
    public boolean booleanValue() {
        return value;
    }
    
    public void setBooleanValue( boolean value ) {
        this.value = value;
    }
    
    // for getBoolean and valueOf we can simply delegate to Boolean
    // you'll learn more about delegation in chapter 4
    public static boolean getBoolean( String name ) {
        return Boolean.getBoolean( name );
    }
    
    public static MyBoolean valueOf( String s ) {
        return new MyBoolean( Boolean.getBoolean( s ) );
    }
    
    // it is good practice to override equals, toString, and hashCode
    // you'll learn more about overriding in chapter 4
    public boolean equals( Object obj ) {
        if( obj == this ) {
            return true;
        }
        if( obj.getClass() == this.getClass() ) {
            MyBoolean bool = ( MyBoolean ) obj;
            if( bool.booleanValue() == this.booleanValue() ) {
                return true;
            }
        }
        
        return false;
    }
    
    public int hashCode() {
        if( value ) {
            return "true".hashCode();
        }
        
        return "false".hashCode();
    }
    
    public String toString() {
        if( value ) { 
            return "true";
        }
        return "false";
    }
}
