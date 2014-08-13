package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:14
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("JLife");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
        GameMenu gm = new GameMenu();

        getContentPane().add(gp, BorderLayout.CENTER);
        getContentPane().add(gm, BorderLayout.NORTH);
        pack();

    }
}