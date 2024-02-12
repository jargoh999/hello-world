

public class MySet extends ArrayListMadeByMe  {

    private boolean isDuplicate(String theElement) {
        for (int checkAgain = 0; checkAgain < elements.length; checkAgain++) {
            if (theElement.equals(elements[checkAgain]))
                return true;
        }
        return false;

    }

    public void add(String toAdd){
    boolean condition = isDuplicate(toAdd);
        if (!condition) {
            elements[noOfElements] = toAdd;
            noOfElements++;
        }

        if (noOfElements == (elements.length - 1))
            extendLength();
    }

}
