/**
 * PersonalityExample creates a number of different PersonalityObject. It then
 * uses them polymorphically.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class PersonalityExample {
      public static void main( String [] args ) {
            PersonalityObject personality = new PersonalityObject();
            PessimisticObject pessimistic = new PessimisticObject();
            OptimisticObject  optimistic  = new OptimisticObject();
            IntrovertedObject introverted = new IntrovertedObject();
            ExtrovertedObject extroverted = new ExtrovertedObject();

            // substitutability allows you to do the following
            PersonalityObject [] personalities = new PersonalityObject[5];
            personalities[0] = personality;
            personalities[1] = pessimistic;
            personalities[2] = optimistic;
            personalities[3] = introverted;
            personalities[4] = extroverted;

            // polymorphism makes PersonalityObject seem to have many different behaviors
            // remember - polymorphism is the multiple personalities disorder of the OO world
            System.out.println( "PersonalityObject[0] speaks: " + personalities[0].speak());
            System.out.println( "PersonalityObject[1] speaks: " + personalities[1].speak());
            System.out.println( "PersonalityObject[2] speaks: " + personalities[2].speak());
            System.out.println( "PersonalityObject[3] speaks: " + personalities[3].speak());
            System.out.println( "PersonalityObject[4] speaks: " + personalities[4].speak());
      }
}