import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack {
    private int numberOfElementsInStack;

    private boolean isEmpty = true;
    private int size;


    public String[] elementsInStack;


    public MyStack(int size) {
        this.size = size;
        elementsInStack = new String[size];
    }


    public boolean isEmpty() {
        return isEmpty;

    }


    public String peek() {

        if(!isEmpty)return elementsInStack[count() - 1];


        throw new EmptyStackException();

    }

    public void push(String value) {

        isEmpty = false;
        elementsInStack[numberOfElementsInStack] = value;
        numberOfElementsInStack++;


        if (numberOfElementsInStack > capacity())
          throw new ArrayIndexOutOfBoundsException("elements in stack is out of bounds");
    }

    public int count() {
        return numberOfElementsInStack;
    }

    public int capacity() {

        return size;
    }


    private void shrinkStackAfterEveryPop(String elementTobePopped) {

        int size = elementsInStack.length - 1;
        ArrayList<String> newValue = new ArrayList<>(size);


        for (int i = 0; i < elementsInStack.length; i++) {
            if (elementTobePopped.equals(elementsInStack[i])) {
                continue;
            }
            newValue.add(elementsInStack[i]);
        }
        if (count() == 0) {
            isEmpty = true;
        }

        this.elementsInStack = newValue.toArray(new String[0]);

    }

    public String pop() {

        if (isEmpty)throw new IllegalArgumentException("you cant pop from an empty stack");


        numberOfElementsInStack--;
        String toBePopped = elementsInStack[numberOfElementsInStack];
        shrinkStackAfterEveryPop(toBePopped);
        return toBePopped;

    }


    public int search(String elementToSearch) {
        for (int scan = 0; scan < elementsInStack.length ; scan++) {
            if (elementToSearch.equals(elementsInStack[scan]))
                return  scan + 1;
        }

           throw new NoSuchElementException("oops sorry no value found");
        

    }
}
