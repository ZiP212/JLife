import logic.Field;
import logic.ZeroNegativeBoundsException;
import ui.MainFrame;

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
        }catch (ZeroNegativeBoundsException z){
            System.out.println(z.getMessage());
        }
    }
}
