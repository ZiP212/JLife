package logic;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:18
 */
public class Field {
    private int height;
    private int width;
    private boolean[][] field;

    public Field(int height, int width) throws ZeroNegativeBoundsException {
        if (height > 0) {
            this.height = height;
        } else {
            throw new ZeroNegativeBoundsException("Height = " + height);
        }
        if (width > 0) {
            this.width = width;
        } else {
            throw new ZeroNegativeBoundsException("Width = " + width);
        }
        field = new boolean[height][width];
    }

    public void flip(int x, int y) throws CellOutOfBounds {
        if (x < 0 || y < 0 || x == width || y == height) {
            throw new CellOutOfBounds("x " + x + "; y " + y);
        }
        field[x][y] = !field[x][y];
    }

    public void step() throws CellOutOfBounds {
        long startTime = System.nanoTime();
        boolean[][] nextStep = new boolean[width][height];
        for (int x = 0; x < width; x++) {
            System.out.println();
            for (int y = 0; y < height; y++) {
                int count = 0;

                if (x > 0 && y > 0 && field[x - 1][y - 1]) {
                    count++;
                }
                if (y > 0 && field[x][y - 1]) {
                    count++;
                }
                if (x < (width - 1) && y > 0 && field[x + 1][y - 1]) {
                    count++;
                }
                if (x > 0 && field[x - 1][y]) {
                    count++;
                }
                if (x < width - 1 && field[x + 1][y]) {
                    count++;
                }
                if (x > 0 && y < height - 1 && field[x - 1][y + 1]) {
                    count++;
                }
                if (y < height - 1 && field[x][y + 1]) {
                    count++;
                }
                if (x < width - 1 && y < height - 1 && field[x + 1][y + 1]) {
                    count++;
                }
                System.out.print(count);

                if (field[x][y] == false)       // условие рождения
                {
                    if (count == 3) {
                        nextStep[x][y] = true;
                    }

                } else                           // условия смерти
                {
                    if (count < 2 || count > 3) {
                        nextStep[x][y] = false;
                    }else{
                        nextStep[x][y] = true;
                    }

                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                field[x][y] = nextStep[x][y];
            }
        }
        long endTime = System.nanoTime();
        System.out.println();
        System.out.println((startTime - endTime) / 1000000 + "ms");
    }

    public boolean[][] getField() {
        return field;
    }
}

//TODO: разобраться где X, где Y. X - вертикаль, Y - горизонталь. Внести соответствующие изменения.
//TODO: в main.java запилить годный вывод массива и начать отладку
