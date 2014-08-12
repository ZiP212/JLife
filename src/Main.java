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
        try{
            Field f = new Field(5, 5);
            f.flip(0, 0);
            f.flip(0, 2);
            f.flip(1, 1);
            f.flip(1, 2);
            f.flip(2, 1);
            printBool(f.getField());
            System.out.println("step");
            f.step();
            printBool(f.getField());
            f.step();
            MainFrame m = new MainFrame();

//            System.out.println("step");
//            f.step();
//            for (boolean[] booleans : f.getField()) {
//                System.out.println(Arrays.toString(booleans));
//            }
//            System.out.println("step");
//            f.step();
//            for (boolean[] booleans : f.getField()) {
//                System.out.println(Arrays.toString(booleans));
//            }
//            System.out.println("step");
//            f.step();
//            for (boolean[] booleans : f.getField()) {
//                System.out.println(Arrays.toString(booleans));
//            }
        }catch (ZeroNegativeBoundsException z){
            System.out.println(z.getMessage());
        }
        catch (CellOutOfBounds c){
            System.out.println(c.getMessage());
        }
    }

    public static void printBool(boolean[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]){
                    System.out.print("+");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
