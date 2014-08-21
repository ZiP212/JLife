package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:14
 */
public class MainFrame extends JFrame {
    private GamePanel gp;
    private JLabel gs;

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

        gm.getClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.clearField();
            }
        });

        gm.getOptions().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callOptions();
            }
        });

        gm.getExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        gs = new JLabel();
        gs.setPreferredSize(new Dimension(100, 16));

        Timer t = new Timer(100 * gp.getInterval(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renewLabel();

            }
        });
        t.start();

        getContentPane().add(gp, BorderLayout.CENTER);
        getContentPane().add(gm, BorderLayout.NORTH);
        getContentPane().add(gs, BorderLayout.SOUTH);
        pack();
    }

    public void renewLabel() {
        this.gs.setText("Turn: " + gp.getTurnNumber());
    }

    public void resizeField(int width, int height)
    {
        gp.resizeField(width, height);
        gp.repaint();
        pack();
    }

    public void callOptions(){
        OptionsDialog dialog = new OptionsDialog(this);
        dialog.pack();
        dialog.setVisible(true);
    }
}