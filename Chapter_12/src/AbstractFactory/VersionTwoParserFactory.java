/**
 * This factory returns instances of VersionTwoParser.
 * @author  Tony Sintes
 * @version 1.0
 */
public class VersionTwoParserFactory implements ParserFactory {
    public Parser createParser() {
        return new VersionTwoParser();
    }
}