package logic;

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

    public void flip(int y, int x){
        field[y][x] = !field[y][x];
    }

    public void step() {
        boolean[][] nextStep = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                int count = 0;

                if (y > 0 && x > 0 && field[y - 1][x - 1]) {
                    count++;
                }
                if (x > 0 && field[y][x - 1]) {
                    count++;
                }
                if (y < (height - 1) && x > 0 && field[y + 1][x - 1]) {
                    count++;
                }
                if (y > 0 && field[y - 1][x]) {
                    count++;
                }
                if (y < height - 1 && field[y + 1][x]) {
                    count++;
                }
                if (y > 0 && x < width - 1 && field[y - 1][x + 1]) {
                    count++;
                }
                if (x < width - 1 && field[y][x + 1]) {
                    count++;
                }
                if (y < height - 1 && x < width - 1 && field[y + 1][x + 1]) {
                    count++;
                }

                if (!field[y][x])       // условие рождения
                {
                    if (count == 3) {
                        nextStep[y][x] = true;
                    }

                } else                           // условия смерти
                {
                    if (count < 2 || count > 3) {
                        nextStep[y][x] = false;
                    }else{
                        nextStep[y][x] = true;
                    }

                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                field[y][x] = nextStep[y][x];
            }
        }
    }

    public boolean[][] getField() {
        return field;
    }
}