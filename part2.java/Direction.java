package turtle;

public enum Direction {
    EAST("NORTH","SOUTH"),
    SOUTH("WEST","EAST"),

    NORTH("SOUTH","WEST"),

    WEST("EAST","NORTH");

    private final String left;

    private final String right;

    Direction(String left,String right ){
       this.left = left;
       this.right = right;
    }



    public Direction turnLeft(){
        return Direction.valueOf(this.left);
    }

    public Direction turnRight(){
        return  Direction.valueOf(this.right);
    }




}
