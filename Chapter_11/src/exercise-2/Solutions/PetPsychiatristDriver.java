/**
 * This method tests your psychiatrist implementation.
 * @author  Tony Sintes
 * @version 2.0
 */
public class PetPsychiatristDriver {
    
    public static void main( String [] args ) {
        HappyObject happy = new HappyObject();
        
        MutableAdapter wrap  = new MutableAdapter( new Dog() );;
        
        PsychiatristObject psychiatrist = new PsychiatristObject();
        
        // use inclusion polymorphism
        psychiatrist.examine( happy );
        psychiatrist.examine( wrap );
        
	  wrap.setPet( new Cat() );
        psychiatrist.examine( wrap );

	  wrap.setPet( new Bird() );
        psychiatrist.examine( wrap );
    }
    
}
