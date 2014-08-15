import ui.MainFrame;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 19:50
 */
public class Main {
    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        m.setVisible(true);
        m.repaint();


    }

    public static void printBool(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    System.out.print("+");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
