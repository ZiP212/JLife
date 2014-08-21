package ui;

import logic.Field;
import logic.ZeroNegativeBoundsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 12.08.14
 * Time: 16:23
 */
public class GamePanel extends JPanel {
    private int fieldWidth = 25;
    private int fieldHeight = 25;
    private int cellSize = 20;
    private int borderPx = 5;
    private int interval = 3;  //!
    private Field f;
    private Timer t;
    private int turnNumber = 0;

    GamePanel() {
        try {
            f = new Field(fieldHeight, fieldWidth);
            setPreferredSize(new Dimension(fieldWidth * (cellSize + borderPx) + borderPx, fieldHeight * (cellSize + borderPx) + borderPx));
            t = new Timer(interval * 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.step();
                    turnNumber++;
                    repaint();
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    t.stop();
                    int x = e.getX() / (borderPx + cellSize);
                    int y = e.getY() / (borderPx + cellSize);
                    f.flip(x, y);
                    repaint();

                }
            });
        } catch (ZeroNegativeBoundsException z) {
            z.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        boolean[][] data = f.getField();
        for (int i = 0; i <= fieldHeight; i++) {
            g.fillRect(0, i * (borderPx + cellSize), fieldWidth * (cellSize + borderPx) + borderPx, borderPx);
        }
        for (int i = 0; i <= fieldWidth; i++) {
            g.fillRect(i * (borderPx + cellSize), 0, borderPx, fieldHeight * (cellSize + borderPx) + borderPx);
        }
        for (int x = 0; x < fieldHeight; x++) {
            for (int y = 0; y < fieldWidth; y++) {
                if (data[x][y]) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x * (borderPx + cellSize) + borderPx, y * (borderPx + cellSize) + borderPx, cellSize, cellSize);
            }
        }
    }


    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getBorderPx() {
        return borderPx;
    }

    public void timerStart() {
        t.start();
    }

    public void timerStop() {
        t.stop();
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getInterval() {
        return interval;
    }

    public void clearField() {
        try {
            f = new Field(fieldHeight, fieldWidth);
            t.stop();
            turnNumber=0;
            repaint();
        } catch (ZeroNegativeBoundsException e) {
            e.printStackTrace();
        }
    }

    public void resizeField(int fieldHeight, int fieldWidth) {
        try {
            this.fieldHeight = fieldHeight;
            this.fieldWidth = fieldWidth;
            f = new Field(fieldHeight, fieldWidth);
            setPreferredSize(new Dimension(fieldWidth * (cellSize + borderPx) + borderPx, fieldHeight * (cellSize + borderPx) + borderPx));
            turnNumber=0;
            repaint();
        } catch (ZeroNegativeBoundsException e) {
            e.printStackTrace();
        }
    }
}