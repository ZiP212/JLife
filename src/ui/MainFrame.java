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
        GamePanel gp = new GamePanel();

        getContentPane().add(gp, BorderLayout.CENTER);
        pack();

       // setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}