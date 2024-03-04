public enum value_in_cell {
    EMPTY("EMPTY"),
    X("X"),
    O("O");
    private final String value;
    value_in_cell(String value) {
        this.value = value;
    }

    public  String toString(){
        return value;
    }
}

