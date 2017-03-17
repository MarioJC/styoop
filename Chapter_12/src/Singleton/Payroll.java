/**
 * Payroll illustrates the singleton pattern.
 * @author  Tony Sintes STYOOP
 * @version 4.0
 */
public class Payroll {

    // a class reference to the single singleton instance
    private static Payroll instance;
    
    private int    total_hours;
    private int    total_sales;
    private double total_pay;
    
    // hide the constructor so that other objects cannot instantiate
    protected Payroll() {}
    
    // note the use of static, you don't have an instance when you go to retrieve 
    // an instance, so the method must be a class method, thus static
    public static Payroll getInstance() {
        if( instance == null ) {
            instance = new Payroll();
        }
        return instance;
    }
    
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
            System.out.println("Pay bonus to " + emp.getLastName() + ", " + emp.getFirstName() + " $" + emp.calculateBonus() );
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
