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

    public void step(){
        boolean[][] nextStep = new boolean[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
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
