public class ArrayBooleanTask {


        public static boolean [] modifyArray(int [] elements){
            boolean [] arrayToReturn = new boolean[elements.length];
            for (int element = 0; element < elements.length; element++) {
                if (elements[element] % 2 == 0){
                    arrayToReturn[element] = false;
                }
                else if (elements[element] % 2 != 0){
                    arrayToReturn[element] = true;
                }


            }
            return arrayToReturn;


        }




    }


