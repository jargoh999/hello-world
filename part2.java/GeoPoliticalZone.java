package GeoPolitical;

    public enum GeoPoliticalZone {

        NORTH_CENTRAL("BENUE", "FCT", "KOGI", "KWARA", "NASARAWA", "NIGER", "PLATEAU"),
        NORTH_EAST("ADAMAWA", "BAUCHI", "BORNO", "GOMBE", "TARABA", "YOBE"),

        NORTH_WEST("KADUNA", "KASTINA", "KANO", "KEBBI", "SOKOTO", "JIGAWA", "ZAMFARA"),

        SOUTH_EAST("ABIA", "ANAMBRA", "EBONYI", "ENUGU", "IMO"),

        SOUTH_SOUTH("AKWA-IBOM", "BAYELSA", "CROSS-RIVER", "DELTA", "EDO", "RIVERS"),

        SOUTH_WEST("EKITI", "LAGOS", "OSUN", "ONDO", "OGUN", "OYO");


        String[] states;

        GeoPoliticalZone(String... states) {
            this.states = states;
        }


        public String[] getStates() {

            return states;

        }

        public static GeoPoliticalZone getStatesInGeoPoliticalZone(String stateInZone) {
            for (var states : GeoPoliticalZone.values()) {
                for (int state = 0; state < states.getStates().length; state++) {
                    if (states.getStates()[state].equals(stateInZone)) {
                        return states;
                    }
                }
            }
            return null;
        }
    };

    class test{
    public static void main(String[] args) {
        String input = "ABIA";
        System.out.println(GeoPoliticalZone.getStatesInGeoPoliticalZone(input));


    }
}
