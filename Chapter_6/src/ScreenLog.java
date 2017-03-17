/**
 * ScreenLog inherits BaseLog. ScreenLog implements the log method.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ScreenLog extends BaseLog {
      protected void log( String message, String level, String time ) {
            System.out.println( level + ": " + time + ": " + message );
      }
}