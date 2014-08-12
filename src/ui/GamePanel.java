package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 12.08.14
 * Time: 16:23
 */
public class GamePanel extends JPanel {
    private int fieldWidth = 5;
    private int fieldHeight = 5;
    private int cellSize = 10;
    private int borderPx = 5;

    GamePanel(){
        setSize(fieldWidth * (cellSize + borderPx) + borderPx, fieldHeight * (cellSize + borderPx) + borderPx);
        setMinimumSize(getSize());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (int i = 0; i <=fieldHeight; i++) {
            g.fillRect(0, i*(borderPx+cellSize), fieldWidth * (cellSize + borderPx) + borderPx, borderPx);
        }
        for (int i = 0; i <=fieldWidth; i++) {
            g.fillRect(i*(borderPx+cellSize), 0, borderPx, fieldHeight * (cellSize + borderPx) + borderPx);
        }
    }

}
