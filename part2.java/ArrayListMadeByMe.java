import java.util.NoSuchElementException;

public class ArrayListMadeByMe {

    public String[] elements = new String[3];
    public int noOfElements;


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


    public void add(int indexToBeAdded, String toAdd) {

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
        reArrangeElements();
    }


    public void remove(int indexToRemove) {

        elements[indexToRemove] = null;
        noOfElements--;
        reArrangeElements();
    }

    public void extendLength() {
        String[] newElements = new String[elements.length + (elements.length / 2)];

        for (int index = 0; index < elements.length; index++) {
            newElements[index] = elements[index];
        }
        this.elements = newElements;

    }

    public void reArrangeElements() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                String temp = "";
                if (elements[j] == null) {
                    temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }


    public int size() {

        return noOfElements;

    }


    public String get(int index) {

        if (elements[index] != null) {
            return String.format("%s  ", elements[index]);
        }
        return "";
    }


    public void addFirst(String firstElement) {
        elements[0] = firstElement;
    }


    public void addLast(String lastElement) {

        elements[size() - 1] = lastElement;

    }

    public void clear() {
        String[] clearer = new String[size()];
        for (int element = 0; element < clearer.length; element++) {
            clearer[element] = null;
            noOfElements--;
        }

        this.elements = clearer;

    }


    public int indexOf(String elementToSearch) {
        for (int scan = 0; scan < elements.length; scan++) {
            if (elementToSearch.equals(elements[scan]))
                return scan;
        }

        throw new NoSuchElementException("oops sorry no value found");


    }

    public boolean contains(String elementToSearch) {
        for (int scan = 0; scan < elements.length; scan++) {
            if (elementToSearch.equals(elements[scan]))
                return true;
        }
        return false;
    }

    public String getFirst() {
        return elements[0];
    }


    public String getLast() {
        return elements[size() - 1];
    }


    public int getLastIndexOf(String lastIndexOf) {
        int scan;
        for (scan = elements.length -1; scan >= 0; scan--)
            if ( lastIndexOf.equals(elements[scan]) )
                 return scan;


        return -1;

    }

    public String[] of(String ... input) {
           String[] toReturn = new String[input.length];

         for(int index=0; index < input.length; index++)toReturn[index] = input[index];

         return toReturn;
    }
}
