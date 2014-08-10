import logic.CellOutOfBounds;
import logic.Field;
import logic.ZeroNegativeBoundsException;
import ui.MainFrame;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 19:50
 */
public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        try{
            Field f = new Field(10, 10);
            for (int i = 0; i < 10; i++) {
                f.populate(i, i);
            }
            for (boolean[] booleans : f.getField()) {
                System.out.println(Arrays.toString(booleans));
            }
        }catch (ZeroNegativeBoundsException z){
            System.out.println(z.getMessage());
        }
        catch (CellOutOfBounds c){
            System.out.println(c.getMessage());
        }
    }
}
