/**
 * The psychiatrist object examines its patients using polymorphism.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class PsychiatristObject {

    // use inclusion polymorphism to examine all moody objects generically
    public void examine( MoodyObject obj ) {
        System.out.println( "Tell me, object, how do you feel today?" );
        obj.queryMood();
        System.out.println();
    }
    
    // use overloading to observe objects specifically, but with a generically named method
    public void observe( SadObject obj ) {
        obj.cry();
        System.out.println( "Hmm... very, very interesting. Something makes this object sad." );
        System.out.println();
    }
    public void observe( HappyObject obj ) {
        obj.laugh();
        System.out.println( "Hmm... very, very interesting. This object seems very happy." );
        System.out.println();
    }
}
