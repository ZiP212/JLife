package ui;

import javax.swing.*;
import java.awt.event.*;

public class OptionsDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSlider width;
    private JSlider height;
    private JSlider cellSize;
    private JSlider borderSize;
    private JSlider interval;
    private MainFrame parent;

    public OptionsDialog(MainFrame parent, int height, int width, int borderSize, int cellSize, int interval) {

        setTitle("Options");
        this.parent = parent;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.height.setValue(height);
        this.width.setValue(width);
        this.borderSize.setValue(borderSize);
        this.cellSize.setValue(cellSize);
        this.interval.setValue(interval);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        parent.resizeField(height.getValue(), width.getValue(), borderSize.getValue(), cellSize.getValue(), interval.getValue());
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
