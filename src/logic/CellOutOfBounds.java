package logic;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:35
 */
public class CellOutOfBounds extends Exception{
    public CellOutOfBounds(String message) {
        super(message);
    }
}
