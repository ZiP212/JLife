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
        if(height>0){
            this.height=height;
        }else{
            throw new ZeroNegativeBoundsException("Height = "+height);
        }
        if(width>0){
            this.width=width;
        }else{
            throw new ZeroNegativeBoundsException("Width = "+width);
        }
        field = new boolean[height][width];
    }

    public void flip(int x, int y) throws CellOutOfBounds{
        if(x<0 || y<0 || x==height || y==width){
            throw new CellOutOfBounds("x "+x+"; y "+y);
        }
        field[x][y] = !field[x][y];
    }

    public void step() throws CellOutOfBounds {

        boolean[][] nextStep = new boolean[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int count=0;
                if(field[x-1][y-1]==true)
                    count++;
                if(field[x][y-1]==true)
                    count++;
                if(field[x+1][y-1]==true)
                    count++;
                if(field[x-1][y]==true)
                    count++;
                if(field[x+1][y]==true)
                    count++;
                if(field[x-1][y+1]==true)
                    count++;
                if(field[x][y+1]==true)
                    count++;
                if(field[x+1][y+1]==true)
                    count++;                     // cчитаем кол-во соседей(хз что будет при выходе за границы, например, для угловых клеток)

                if (field [x][y]==false)       // условие рождения
                {
                    if(count==3)
                        flip(x,y);

                }
                else                           // условия смерти
                {
                     if(count<2||count>3)
                         flip(x,y);

                }
                //TODO: add checks
            }
        }

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                field[x][y]=nextStep[x][y];
            }
        }
    }

    public boolean[][] getField() {
        return field;
    }
}
