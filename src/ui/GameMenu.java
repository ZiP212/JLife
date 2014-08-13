package ui;

import logic.Field;
import logic.ZeroNegativeBoundsException;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Сережа on 13.08.2014.
 */
public class GameMenu extends JMenuBar
{
    GameMenu()
    {
        JMenuItem Start = new  JMenuItem("Start");
        JMenuItem Stop = new JMenuItem("Stop");

       // Start.setPreferredSize(new Dimension(40, 20));
        //Stop.setPreferredSize(new Dimension(40, 20));

        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }

        });



        Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        add(Start);
        add(Stop);

    }
}
