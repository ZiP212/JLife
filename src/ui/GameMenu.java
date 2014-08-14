package ui;

import javax.swing.*;

/**
 * Created by Сережа on 13.08.2014.
 */
public class GameMenu extends JMenuBar {
    private JMenuItem start;
    private JMenuItem stop;
    private JMenuItem options;
    private JMenuItem clear;


    GameMenu() {

        JMenu game = new JMenu("Game");
        start = new JMenuItem("Start");
        stop = new JMenuItem("Stop");
        JMenu optionsMenu = new JMenu("Options");
        options = new JMenuItem("Options");
        optionsMenu.add(options);
        JMenu load = new JMenu("Load");
        JMenu save = new JMenu("Save");
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        game.add(start);
        game.add(clear);
        game.add(stop);
        help.add(about);
        add(game);
        add(load);
        add(save);
        add(optionsMenu);
        add(help);

    }

    public JMenuItem getStart() {
        return start;
    }

    public JMenuItem getStop() {
        return stop;
    }

    public JMenuItem getOptions() {
        return options;
    }

    public JMenuItem getClear() {
        return clear;
    }
}
