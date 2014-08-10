package logic;

/**
 * Created with IntelliJ IDEA.
 * User: Pasha
 * Date: 10.08.14
 * Time: 20:18
 */
public class Field {
    int height;
    int width;
    boolean[][] field;

    public  Field(int height, int width) throws ZeroNegativeBoundsException {
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
}
