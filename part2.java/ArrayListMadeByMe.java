

public class ArrayListMadeByMe {

    public String[] elements = new String[3];
    private int noOfElements;


    public boolean isEmpty() {
        if (noOfElements == 0) return true;
        return false;
    }

    public void add(String toAdd) {

            elements[noOfElements] = toAdd;
            noOfElements++;
        if (noOfElements == (elements.length - 1))
            extendLength();



    }


    public void add(int indexToBeAdded,String toAdd) {

        elements[indexToBeAdded] = toAdd;
        noOfElements++;
        if (noOfElements == (elements.length))
            extendLength();



    }

    public void remove(String toRemove) {
        for (int index = 0; index < elements.length; index++) {
            if (toRemove.equals(elements[index])) {
                elements[index] = null;
                noOfElements--;

            }

        }
    }


    public void remove(int indexToRemove){

        elements[indexToRemove] = null;
        noOfElements--;
        reArrangeElements();
    }

 private void extendLength(){
     String[] newElements = new String[elements.length + (elements.length/2) ];

     for(int index = 0; index < elements.length ; index++){
         newElements[index] =   elements[index];
        }
     this.elements = newElements;

     }

     private void reArrangeElements(){
         for (int i = 0; i < elements.length; i++) {
             for (int j = 0 ; j < i+ 1; j++) {
                 String temp = "";
                 if (elements[j] == null){
                     temp = elements[i];
                     elements[i] = elements[j];
                     elements[j] = temp;
                 }
             }
         }
     }



     public  int size(){

        return noOfElements;

     }


     public String get(int index){

        if(elements[index] != null) {
            return String.format("%s%n", elements[index]);
        }
        return "";
     }



}