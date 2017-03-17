/**
 * The Point class illustrates the 
 * dangers the inheritance can pose to encapsulation.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Point extends Object {
    public Point( int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point getLocation() {
        return new Point( x, y );
    }
    public void move( int x, int y ) {
        this.x = x;
        this.y = y;
    }
    public void setLocation( int x, int y ) {
        this.x = x;
        this.y = y;
    }
    public void setLocation( Point p ) {
        this.x = p.x;
        this.y = p.y;
    }
    public int x;
    public int y;
}
