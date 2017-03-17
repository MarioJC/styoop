/**
 * The base parser wrapper.
 * @author  Tony Sintes
 * @version 1.0
 */
public interface Parser {
    public org.w3c.dom.Document parse( String document );
}