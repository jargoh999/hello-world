package turtle;

public class SketchPad {
    private int row;
    private int column;

    private final int [][] sketchPad;
    public SketchPad(int row , int column ){
              this.row = row;
              this.column =column;
             sketchPad = new int[row][column];
    }

    public int[][] getSketchPad() {
        return this.sketchPad;
    }



}
