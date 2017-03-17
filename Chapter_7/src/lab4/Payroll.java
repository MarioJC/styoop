/**
 * Payroll illustrates two forms of polymorphism: inclusion and overloading.
 * @author  Tony Sintes STYOOP
 * @version 2.0
 */
public class Payroll {

    private int    total_hours;
    private int    total_sales;
    private double total_pay;
    
    public void payEmployees( Employee [] emps ) {
        for( int i = 0; i < emps.length; i ++ ) {
            Employee emp = emps[i];
            total_pay += emp.calculatePay();
            emp.printPaycheck();
        }
    }
    
    public void calculateBonus( Employee [] emps ) {
        for( int i = 0; i < emps.length; i ++ ) {
            Employee emp = emps[i];
            if( emp instanceof HourlyEmployee ) {
                System.out.println("Pay bonus to " + emp.getLastName() + ", " + emp.getFirstName() + " $100.00." );
            } else if ( emp instanceof CommissionedEmployee ) {
                int bonus = ( (CommissionedEmployee) emp ).getSales() * 100;
                System.out.println("Pay bonus to " + emp.getLastName() + ", " + emp.getFirstName() + " $" + bonus );
            } else {
                System.out.println( "unknown employee type" );
            }
        }
    }
    
    public void recordEmployeeInfo( CommissionedEmployee emp ) {
        total_sales += emp.getSales();
    }
    
    public void recordEmployeeInfo( HourlyEmployee emp ) {
        total_hours += emp.getHours();
    }
    
    public void printReport() {
        System.out.println( "Payroll Report:" );
        System.out.println( "Total Hours: " + total_hours );
        System.out.println( "Total Sales: " + total_sales );
        System.out.println( "Total Paid: $" + total_pay );
    }
    
}
