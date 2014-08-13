package ui;

import logic.Field;
import logic.ZeroNegativeBoundsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private int interval = 1;
    private Field f;

    //TODO:кнопка запуска и остановки симуляции
    //TODO:подстройка размеров MainFrame под размеры поля (LayoutManager, метод pack())
    //TODO:реакция на клики.

    GamePanel(){
        try{
            f = new Field(fieldHeight, fieldWidth);

            setPreferredSize(new Dimension(fieldWidth * (cellSize + borderPx) + borderPx, fieldHeight * (cellSize + borderPx) + borderPx));
            f.flip(0, 0);
            f.flip(0, 2);
            f.flip(1, 1);
            f.flip(1, 2);
            f.flip(2, 1);
            Timer t = new Timer(interval*100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.step();
                    repaint();
                }
            });
            t.start();
        }catch (ZeroNegativeBoundsException z){
            z.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        boolean[][] data = f.getField();
        for (int i = 0; i <=fieldHeight; i++) {
            g.fillRect(0, i * (borderPx + cellSize), fieldWidth * (cellSize + borderPx) + borderPx, borderPx);
        }
        for (int i = 0; i <=fieldWidth; i++) {
            g.fillRect(i*(borderPx+cellSize), 0, borderPx, fieldHeight * (cellSize + borderPx) + borderPx);
        }
        for (int x = 0; x <fieldHeight; x++) {
            for (int y = 0; y < fieldWidth; y++) {
                if(data[x][y]){
                    g.setColor(Color.GREEN);
                }else{
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x*(borderPx+cellSize)+borderPx, y * (borderPx + cellSize) + borderPx, cellSize, cellSize);
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

    public Field getField() {return f;}
}
