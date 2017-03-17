/**
 * EmployeeDriver instantiates and exercises CommissionedEmployee and HourlyEmployee
 * instances.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class PayrollDriver {
    public static void main( String [] args ) {

        // create the payroll system
        Payroll payroll = new Payroll();
        
        // create and update some employees
        CommissionedEmployee emp1 = new CommissionedEmployee( "Mr.", "Sales", 25000.00, 1000.00);
        CommissionedEmployee emp2 = new CommissionedEmployee( "Ms.", "Sales", 25000.00, 1000.00);
        emp1.addSales( 7 );
        emp2.addSales( 5 );
        
        HourlyEmployee emp3 = new HourlyEmployee( "Mr.", "Minimum Wage", 6.50 );
        HourlyEmployee emp4 = new HourlyEmployee( "Ms.", "Minimum Wage", 6.50 );
        emp3.addHours( 40 );
        emp4.addHours( 46 );
        
        // use the overloaded methods
        payroll.recordEmployeeInfo( emp2 );
        payroll.recordEmployeeInfo( emp1 );
        payroll.recordEmployeeInfo( emp3 );
        payroll.recordEmployeeInfo( emp4 );
        
        // stick the employees in an array
        Employee [] emps = new Employee[4];
        emps[0] = emp1; emps[1] = emp2; emps[2] = emp3; emps[3] = emp4;
        
        payroll.payEmployees( emps );
        payroll.printReport();
    }
}
