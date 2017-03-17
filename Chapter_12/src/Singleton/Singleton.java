/**
 * An example of a generic singleton. This is the form that a singleton will
 * normally take in Java.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Singleton {

    // a class reference to the singleton instance
    private static Singleton instance;
    
    // the constructor must be hidden so that objects cannot instantiate
    // protected allows other classes to inherit from Singleton
    protected Singleton() {}
    
    // a class method used to retrieve the singleton instance
    public static Singleton getInstance() {
        if( instance == null ) {
            instance = new Singleton();
        }
        return instance;
    }
    
}
