import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack(5);

    }

    @Test
    public void testThatStackIsEmpty() {
        assertTrue(stack.isEmpty());

    }


    @Test
    public void testThatElementInStackCanBePeeked() {


        stack.push("ayo");
        stack.push("dayo");
        stack.push("susu");
        stack.push("chi");
        stack.push("pat");

        String peek = stack.peek();
        assertEquals("pat", peek);


    }


    @Test
    public void testThatElementCantExceedCapacity() {


        stack.push("ayo");
        stack.push("dayo");
        stack.push("susu");
        stack.push("chi");
        stack.push("pat");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push("pit"));
        assertEquals(5, stack.capacity());
        System.out.println(java.util.Arrays.toString(stack.elementsInStack));


    }

    @Test
    public void testThatElementsInStackCanBePoppedInOrder() {
        stack.push("ayo");
        stack.push("dayo");
        stack.push("susu");
        stack.push("chi");
        stack.push("pat");


        for (int i = 0; i < stack.capacity(); i++) {
            System.out.println(stack.pop());
            System.out.println(java.util.Arrays.toString(stack.elementsInStack));
        }
        assertEquals(0, stack.count());
        System.out.println(java.util.Arrays.toString(stack.elementsInStack));
        assertTrue(stack.isEmpty());

    }

    @Test
    public void testThatElementsInStackCanBePoppedInOrderAndNotEmpty() {
        stack.push("ayo");
        stack.push("dayo");
        stack.push("susu");
        stack.push("chi");
        stack.push("pat");


        for (int i = 0; i < stack.capacity() - 2; i++) {
            System.out.println(stack.pop());
            System.out.println(java.util.Arrays.toString(stack.elementsInStack));
        }

        assertEquals(2, stack.count());
        System.out.println(java.util.Arrays.toString(stack.elementsInStack));
        assertFalse(stack.isEmpty());

    }

    @Test
    public void testThatStackHasCapacity() {

        assertEquals(5, stack.capacity());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatStackCanCountElement(){
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.count());

        stack.push("ayo");
        assertEquals(1,stack.count());
    }

    @Test
    public void testThatStackCantBePoppedWhenEmpty(){
        assertTrue(stack.isEmpty());

        assertThrows(IllegalArgumentException.class,()->stack.pop());


    }


    @Test
    public void testThatElementCantBePeekedWhenEmpty(){
        assertTrue(stack.isEmpty());

        assertThrows(EmptyStackException.class,()-> stack.peek());

    }


    @Test
    public void testThatElementCanBeSearchedInStack(){

        stack.push("ayo");
        stack.push("dayo");
        stack.push("susu");
        stack.push("chi");
        stack.push("pat");


        assertEquals(3,stack.search("susu"));

    }

@Test
    public void testThatElementCanBeSearchedInAnEmptyStack() {
         assertTrue(stack.isEmpty());


         assertThrows(NoSuchElementException.class,()-> stack.search("hello"));

    }

}