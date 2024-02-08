import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListMadeByMeTest {
    private static ArrayListMadeByMe list ;

    @BeforeEach
    public void setUp(){
        list = new ArrayListMadeByMe();
    }




    @Test
    public void testThatElementIsEmpty(){
        assertTrue(list.isEmpty());

    }

    @Test
    public void addNewElementToList(){
        assertTrue(list.isEmpty());
        list.add("G_String");
        assertFalse(list.isEmpty());

    }


    @Test
    public void addNewElementToList_RemoveElement(){
        assertTrue(list.isEmpty());
        list.add("G_String");
        assertFalse(list.isEmpty());

        list.remove("G_String");
        list.add("G_String");

        list.add("ayo");

        assertFalse(list.isEmpty());
        list.remove(1);
        list.add(1,"ayo");
        assertEquals(2,list.size());
        System.out.println(java.util.Arrays.toString(list.elements));
    }


    @Test
    public void testThatListHasSize(){
        String [] elem = new String[10];

       for(int i = 0; i < 10; i ++){
           list.add("ayo");
       }

     assertEquals(10,list.size());

        for(int i = 0; i < 10; i ++){
            list.add("tum");
        }
        assertEquals(20,list.size());
        System.out.println(java.util.Arrays.toString(list.elements));
    }
@Test
  public  void testThatYouCanGetElementOut_OfList(){
      for(int i = 0; i < 10; i ++){
          list.add("tum");
      }

      for(int i = 0; i < list.size(); i ++){
          System.out.print( list.get(i));
      }
       assertEquals(10,list.size());

  }



}