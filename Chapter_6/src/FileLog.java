/**
 * FileLog inherits BaseLog. FileLog implements the log method and adds a close method.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class FileLog extends BaseLog {

      private java.io.PrintWriter pw;

      public FileLog( String filename ) throws java.io.IOException {
            pw = new java.io.PrintWriter( new java.io.FileWriter( filename ) );
      }

      protected void log( String message, String level, String time ) {
            pw.println( level + ": " + time + ": " + message );
            pw.flush();
      }

      public void close() {
            pw.close();
      }
}
