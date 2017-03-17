/**
 * EmployeeDriver instantiates and exercises CommissionedEmployee and HourlyEmployee
 * instances.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class EmployeeDriver {
    public static void main( String [] args ) {
        CommissionedEmployee c_emp = new CommissionedEmployee( "Mr.", "Sales", 25000.00, 1000.00);
        HourlyEmployee h_emp = new HourlyEmployee( "Mr.", "Minimum Wage", 6.50 );
        
        c_emp.addSales( 5 );
        h_emp.addHours( 40 );
        
        System.out.println( "Commissioned Employee Pay: $" + c_emp.calculatePay() );
        System.out.println( "Hourly Employee Pay: $" + h_emp.calculatePay() );
        System.out.println( c_emp.printPaycheck() );
        System.out.println( h_emp.printPaycheck() );
    }
}
