/**
 * CountedObject uses a class variable to keep track of the number of CountedObject
 * instances created.
 * @author  Tony Sintes
 * @version 1.0
 */
public class CountedObject {

    private static int instances;
    
    /** Creates new CountedObject */
    public CountedObject() {
        instances++;
    }

    public static int getNumberInstances() {
        return instances;
    }
    
    public static void main( String [] args ) {
        CountedObject obj = null;
        for( int i = 0; i < 10; i++ ) {
            obj = new CountedObject();
        }
        System.out.println( "Instances created: " + obj.getNumberInstances() );
        // note that this will work too
        System.out.println( "Instances created: " + CountedObject.getNumberInstances() );
    }
}
