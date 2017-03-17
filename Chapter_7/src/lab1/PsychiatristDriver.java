/**
 * This method tests your psychiatrist implementation.
 * @author  Tony Sintes
 * @version 1.0
 */
public class PsychiatristDriver {
    
    public static void main( String [] args ) {
        HappyObject happy = new HappyObject();
        SadObject sad = new SadObject();
        PsychiatristObject psychiatrist = new PsychiatristObject();
        
        // use inclusion polymorphism
        psychiatrist.examine( happy );
        psychiatrist.examine( sad );
        
        // use overloading so that we can observe the objects
        psychiatrist.observe( happy );
        psychiatrist.observe( sad );
    }
    
}
