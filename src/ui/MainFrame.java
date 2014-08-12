package ui;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:14
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("JLife");
        GamePanel gp = new GamePanel();
        add(gp);
        setSize(100, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}