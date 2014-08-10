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
            Field f = new Field(9, 9);
            for (int i = 0; i < 9; i++) {
                f.flip(i, i);
                f.flip(8-i, i);
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
