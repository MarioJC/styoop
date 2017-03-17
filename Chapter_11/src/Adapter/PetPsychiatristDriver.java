/**
 * This method tests your psychiatrist implementation.
 * @author  Tony Sintes
 * @version 2.0
 */
public class PetPsychiatristDriver {
    
    public static void main( String [] args ) {
        HappyObject happy = new HappyObject();
        
        PetAdapter dog  = new PetAdapter( new Dog() );
        PetAdapter cat  = new PetAdapter( new Cat() );
        PetAdapter bird = new PetAdapter( new Bird() );
        
        PsychiatristObject psychiatrist = new PsychiatristObject();
        
        // use inclusion polymorphism
        psychiatrist.examine( happy );
        psychiatrist.examine( dog );
        psychiatrist.examine( cat );
        psychiatrist.examine( bird );
    }
    
}
