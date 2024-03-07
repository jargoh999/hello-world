import java.util.Arrays;

public class TicTacToe {

    private  value_in_cell[][] valueInCells = new value_in_cell[3][3];

    public TicTacToe() {
        Arrays.stream(valueInCells).forEach(row -> Arrays.fill(row, value_in_cell.EMPTY));
    }

    public void displayTile() {

        for (value_in_cell[] valueInCell : valueInCells) {
            System.out.println("--^--^--^--^--^--^--");
            for (value_in_cell value_in_cell : valueInCell) {
                System.out.print(value_in_cell + " | ");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++");
    }

    public boolean hasAWinner(int cell) {
        return checkRow(Integer.parseInt(String.valueOf(validateRowAndColumn(cell).charAt(0))))||checkCol(Integer.parseInt(String.valueOf(validateRowAndColumn(cell).charAt(1))))||checkDiagonal()||checkAntiDiagonal();
    }

    public boolean gameIsADraw(){
       return valueInCells[0][0]!=value_in_cell.EMPTY && valueInCells[0][1] != value_in_cell.EMPTY && valueInCells[0][2] != value_in_cell.EMPTY && valueInCells[1][0] != value_in_cell.EMPTY && valueInCells[1][1] != value_in_cell.EMPTY && valueInCells[1][2] != value_in_cell.EMPTY && valueInCells[2][0] != value_in_cell.EMPTY && valueInCells[2][1] != value_in_cell.EMPTY && valueInCells[2][2] != value_in_cell.EMPTY;
    }

    private String validateRowAndColumn(int cell){
        if(cell == 1)return "00";
        if(cell == 2)return "01";
        if(cell == 3)return "02";
        if(cell == 4)return "10";
        if(cell == 5)return "11";
        if(cell == 6)return "12";
        if(cell == 7)return "20";
        if(cell == 8)return "21";
        if(cell == 9)return "22";

     throw new IllegalArgumentException("invalid cell number ");

    }

    private boolean checkRow(int row) {
          return valueInCells[row][0] == valueInCells[row][1] && valueInCells[row][1] == valueInCells[row][2] && valueInCells[row][0] != value_in_cell.EMPTY;
    }

    private boolean checkCol(int column) {

        return valueInCells[0][column] == valueInCells[1][column] && valueInCells[1][column] == valueInCells[2][column] && valueInCells[0][column] != value_in_cell.EMPTY;
    }
    private  boolean checkDiagonal() {
           return valueInCells[0][0] == valueInCells[1][1] && valueInCells[1][1] == valueInCells[2][2] && valueInCells[0][0] != value_in_cell.EMPTY;
    }
    private  boolean checkAntiDiagonal() {
        return valueInCells[0][2] == valueInCells[1][1] && valueInCells[1][1] == valueInCells[2][0] && valueInCells[0][2] != value_in_cell.EMPTY;
    }

    public  value_in_cell[][] getValueInCells() {
        return valueInCells; 
    }



}