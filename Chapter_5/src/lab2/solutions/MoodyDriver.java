/**
 * MoodyDriver is a driver to test the MoodyObject and its subclasses.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class MoodyDriver {
    public final static void main( String [] args ) {
        //MoodyObject mo = new MoodyObject(); // can no longer instantiate MoodyObject
        SadObject   so = new SadObject();
        HappyObject ho = new HappyObject();
        
        //System.out.println( "How does the moody object feel today?" );
        //mo.queryMood();
        //System.out.println( "" );
        System.out.println( "How does the sad object feel today?" );
        so.queryMood(); // notice that overriding changes the mood
        so.cry();
        System.out.println( "" );
        System.out.println( "How does the happy object feel today?" );
        ho.queryMood(); // notice that overriding changes the mood
        ho.laugh();
        System.out.println( "" );
    }
}