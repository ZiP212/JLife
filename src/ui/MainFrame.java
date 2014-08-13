package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:14
 */
public class MainFrame extends JFrame {
    private GamePanel gp;

    public MainFrame() {
        setTitle("JLife");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        gp = new GamePanel();
        GameMenu gm = new GameMenu();
        gm.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.timerStart();
            }
        });

        gm.getStop().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.timerStop();
            }
        });

        getContentPane().add(gp, BorderLayout.CENTER);
        getContentPane().add(gm, BorderLayout.NORTH);
        pack();

    }
}