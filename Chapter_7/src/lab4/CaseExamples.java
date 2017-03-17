/**
 * 
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class CaseExamples {

    public void day_of_the_week_if( int day ) {
        if ( day == 1 ) {
            System.out.println( "Sunday" );
        } else if ( day == 2 ) {
            System.out.println( "Monday" );
        } else if ( day == 3 ) {
            System.out.println( "Tuesday" );
        } else if ( day == 4 ) {
            System.out.println( "Wednesday" );
        } else if ( day == 5 ) {
            System.out.println( "Thursday" );
        } else if ( day == 6 ) {
            System.out.println( "Fridayday" );
        } else if ( day == 7 ) {
            System.out.println( "Saturday" );
        } else {
            System.out.println( day + " is not a valid day." );
        }
    }
    
    public void day_of_the_week_switch( int day ) {
        switch ( day ) {
            case 1:
                System.out.println( "Sunday" );
                break;
            case 2:
                System.out.println( "Monday" );
                break;
            case 3:
                System.out.println( "Tuesday" );
                break;
            case 4:
                System.out.println( "Wednesday" );
                break;
            case 5:
                System.out.println( "Thursday" );
                break;
            case 6:
                System.out.println( "Friday" );
                break;
            case 7:
                System.out.println( "Saturday" );
                break;
            default:
                System.out.println( day + " is not a valid day." );
                break;    
        }
        
    }
    
    public int calculate( String operation, int operand1, int operand2 ) {
        if ( operation.equals( "+" ) ) {
            return operand1 + operand2;
        } else if ( operation.equals( "*" ) ) {
            return operand1 * operand2;
        } else if ( operation.equals( "/" ) ) {
            return operand1 / operand2;
        } else if ( operation.equals( "-" ) ) {
            return operand1 - operand2;
        } else {
            System.out.println( "invalid operation: " + operation );
            return 0;
        }
    }
    
    public int calculate( Operation operation, int operand1, int operand2 ) {
        return operation.calculate( operand1, operand2 );
    }
}
