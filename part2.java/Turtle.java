package turtle;

import java.util.Arrays;

import static turtle.Direction.EAST;

public class Turtle {

private boolean isPenUp;
private int currentTurtleRow = 0;
private int currentTurtleColumn = 0;
private Direction currentDirection = EAST;

    public boolean isPenUp() {
        return isPenUp;
    }

    public void penUp(){
        isPenUp = true;
    }

    public void penDown(){
        isPenUp = false;
    }

    public String getCurrentTurtleCoordinates() {
        return " ("+currentTurtleRow +","+ currentTurtleColumn +")" ;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnLeft(){
        currentDirection = currentDirection.turnLeft();
    }

    public void turnRight(){
        currentDirection = currentDirection.turnRight();
    }


    public void displaySketchPad(SketchPad sketchPad){
        Arrays.stream(sketchPad.getSketchPad()).map(Arrays::toString).forEach(System.out::println);
    }

    private void moveForward(int spaces,SketchPad sketchPad) {
        for (int i = 0; i < spaces; i++) {
            switch (getCurrentDirection()) {
                case NORTH -> {
                    if (currentTurtleRow >= 0) currentTurtleRow--;
                }
                case SOUTH -> {
                    if (currentTurtleRow < sketchPad.getSketchPad().length) currentTurtleRow++;
                }
                case WEST -> {
                    if (currentTurtleColumn >= 0)currentTurtleColumn--;
                }
                case EAST -> {
                    if (currentTurtleColumn < sketchPad.getSketchPad().length)currentTurtleColumn++;
                }
            }
            if (!isPenUp()) {
                sketchPad.getSketchPad()[currentTurtleRow][currentTurtleColumn] = 1;
            }
        }


    }
    public int [][] getSketchPad(SketchPad sketchPad){
        return sketchPad.getSketchPad();
    }
    public void showTurtleDrawingsOn(SketchPad sketchPad){
        for (int values= 0; values < sketchPad.getSketchPad().length; values++){
            for (int value = 0 ; value < sketchPad.getSketchPad()[values].length; value++)
                System.out.print((sketchPad.getSketchPad()[values][value] == 0 ? " ": "*")) ;

            System.out.println();
        }

    }
    public static void main(String[] args) {
        Turtle turt = new Turtle();
        SketchPad sketchPad = new SketchPad(30,30);

        turt.penDown();
        turt.moveForward(2,sketchPad);
        turt.turnRight();
        turt.moveForward(2,sketchPad);
        turt.turnLeft();
        turt.moveForward(2,sketchPad);
        turt.turnLeft();
        turt.moveForward(2,sketchPad);
        turt.moveForward(2,sketchPad);
        turt.penUp();
        turt.moveForward(5,sketchPad);
        turt.penDown();
        turt.moveForward(5,sketchPad);
        turt.displaySketchPad(sketchPad);

        System.out.println(turt.getCurrentTurtleCoordinates());
        turt.showTurtleDrawingsOn(sketchPad);
    }
}
