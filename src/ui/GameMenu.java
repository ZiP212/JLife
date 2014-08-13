package ui;

import javax.swing.*;

/**
 * Created by Сережа on 13.08.2014.
 */
public class GameMenu extends JMenuBar {
    private JMenuItem start;
    private JMenuItem stop;

    GameMenu() {
        start = new JMenuItem("Start");
        stop = new JMenuItem("Stop");
        add(start);
        add(stop);
    }

    public JMenuItem getStart() {
        return start;
    }

    public JMenuItem getStop() {
        return stop;
    }
}
