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
    }


    @Test
    public void testThatListHasSize(){
       for(int i = 0; i < 10; i ++){
           list.add("ayo");
       }
     assertEquals(10,list.size());
        for(int i = 0; i < 10 ; i ++){
            list.add("tum");
        }
        assertEquals(20,list.size());
    }
@Test
  public  void testThatYouCanGetElementOut_OfList(){
      for(int i = 0; i < 10; i ++){
          list.add("tum");
      }
      for(int i = 0; i < list.size(); i ++){
          System.out.print(list.get(i));
      }
       assertEquals(10,list.size());
  }

  @Test
  public void testThatElementOutVerifyElementAndSize(){
      for(int i = 0; i < 2; i ++) list.add("tum");
        String result = "";
      for(int i = 0; i < 2; i ++)result += list.get(i);
      String expected ="tum  tum  ";
      assertEquals(expected,result);
      assertEquals(2,list.size());
  }


  @Test
  public void testThatElementCanBeAddedFirstToStack(){
      for(int i = 0; i < 2; i ++) list.add("tum");
      list.addFirst("ayo");
      assertEquals("ayo  ",list.get(0));
  }

  @Test
  public void testThatElementCanBeAddedLast(){
      for(int i = 0; i < 2; i ++) list.add("tum");
       list.addLast("dayo");
       assertEquals("dayo  ",list.get(list.size()-1));
  }
   @Test
    public void testThatElementsCanBeCleared(){
        for(int i = 0; i < 2; i ++)list.add("tum");
        list.clear();
        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
    }
    @Test
    public void testToCheckTheIndexOfAnElement(){
        for(int i = 0; i < 2; i ++)list.add("tum");
        list.add("ay");
        int index = list.indexOf("ay");
        assertEquals(2,index);
    }



    @Test
    public void testThatListContainsValue(){
        for(int i = 0; i < 2; i ++) list.add("tum");
        list.add("ay");
        assertTrue(list.contains("ay"));
    }

    @Test
    public void testThatYouCanObtainLastElement(){
        for(int i = 0; i < 2; i ++)list.add("tum");
        list.add("ay");
        assertTrue(list.contains("ay"));
        assertEquals("ay",list.getLast());
    }
@Test
public void testThatYouCanObtainFirstElement(){
        for(int i = 0; i < 2; i ++) list.add("tum");
        list.add("ay");
        assertTrue(list.contains("ay"));
        assertEquals("tum",list.getFirst());
    }




    @Test
    public void testThatWeCanGetLastIndexOf(){
        for(int i = 0; i < 4; i++) list.add("tum");
        list.add("ay");
        assertTrue(list.contains("ay"));
        assertEquals(3,list.getLastIndexOf("tum"));

    }


    @Test
    public void testThatListCanReturnAnUnmodifiableList(){

           String[] expected = list.of("ay");
            String[] result = {"ay"};
        assertArrayEquals(result,expected);
    }



}


