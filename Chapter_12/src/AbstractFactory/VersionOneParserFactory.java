/**
 * This factory returns instances of VersionOneParser.
 * @author  Tony Sintes
 * @version 1.0
 */
public class VersionOneParserFactory implements ParserFactory {
    public Parser createParser() {
        return new VersionOneParser();
    }
}