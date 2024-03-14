public class SevenSegment {



public static String [][] segments = {
        {"# # # #", "#     #" + "\n#     # " + "\n" + "#     #", "# # # #"},
        {"#\n#", "#", "#"},
        {"# # # #", "      #" + "\n# # # #" + "\n#" + "", "# # # #"},
        {"# # # #", "      #" + "\n# # # #" + "\n      #" + "", "# # # #"},
        {"#     #", "#     #" + "\n# # # #" + "\n      #" + "", "      #"},
        {"# # # #", "#      " + "\n# # # #" + "\n      #" + "", "# # # #"},
        {"# # # #", "#      " + "\n# # # #" + "\n#     #" + "", "# # # #"},
        {"# # # #", "      #" + "\n      #" + "\n      #" + "", "      #"},
        {"# # # #", "#     #" + "\n# # # # " + "\n" + "#     #", "# # # #"},
        {"# # # #", "#     #" + "\n#  #  # " + "\n" + "      #", "# # # #"}
};

 public   static String[] possibleInputs = {
                "1111110",
                "0110000",
                "1101101",
                "1111001",
                "0110011",
                "1011011",
                "1011111",
                "1110000",
                "1111111",
                "1110011"
        };



        public static String collectBits(String bits) throws InvalidValueError {
            String compare = "";
            if (bits.length() > 8) {
                throw new InvalidValueError("your character length must not be greater than 7");
            }
            if (bits.charAt(bits.length() - 1) != '0'){
                for (int bit = 0; bit < bits.length() - 1; bit++) {
                    compare += bits.charAt(bit);
                }
                return compare;
            }
            if (bits.charAt(bits.length() - 1) == '0') {
                throw new InvalidValueError("illegal argument");
            }
            return compare;
        }

        public static int compare(String check) throws InvalidValueError {
            for (int index = 0; index < possibleInputs.length; index++) {
                if (check.equals(possibleInputs[index])) {
                    return index;
                }
            }
            throw new InvalidValueError("nothing to return here boss");
        }

        public static void display(int index) {
           for (int i= 0; i < 3; i++) {
               System.out.println(segments[index][i]);
           }
        }

    public static void main(String[] args) {
        display(8);
    }




}
