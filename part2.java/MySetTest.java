import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    MySet set ;

    @BeforeEach
   public void setUp() {
        set = new MySet();
    }

        @Test
        public void testThatElementIsEmpty(){
            assertTrue(set.isEmpty());
        }

        @Test
        public void addNewElementToList(){
            assertTrue(set.isEmpty());
            set.add("G_String");
            assertFalse(set.isEmpty());
        }


        @Test
        public void addNewElementToList_RemoveElement(){
            assertTrue(set.isEmpty());
            set.add("G_String");
            assertFalse(set.isEmpty());
            set.remove("G_String");
            set.add("G_String");
            set.add("ayo");
            assertFalse(set.isEmpty());
            set.remove(1);
            set.add(1,"ayo");
            assertEquals(2,set.size());
        }


        @Test
        public void testThatListHasSize(){
            for(int i = 0; i < 10; i ++){
                set.add("ayo");
            }
            assertEquals(1,set.size());
            for(int i = 0; i < 10 ; i ++){
                set.add("tum");
            }
            assertEquals(2,set.size());
        }
        @Test
        public  void testThatYouCanGetElementOut_OfList(){
            for(int i = 0; i < 10; i ++){
                set.add("tum");
            }
            for(int i = 0; i < set.size(); i ++){
                System.out.print(set.get(i));
            }
            assertEquals(1,set.size());
        }

        @Test
        public void testThatElementOutVerifyElementAndSize(){
            for(int i = 0; i < 2; i ++) set.add("tum");
            String result = "";
            for(int i = 0; i < 2; i ++)result += set.get(i);
            String expected ="tum  ";
            assertEquals(expected,result);
            assertEquals(1,set.size());
        }


        @Test
        public void testThatElementCanBeAddedFirstToStack(){
            for(int i = 0; i < 2; i ++) set.add("tum");
            set.addFirst("ayo");
            assertEquals("ayo  ",set.get(0));
        }

        @Test
        public void testThatElementCanBeAddedLast(){
            for(int i = 0; i < 2; i ++) set.add("tum");
            set.addLast("dayo");
            assertEquals("dayo  ",set.get(set.size()-1));
        }
        @Test
        public void testThatElementsCanBeCleared(){
            for(int i = 0; i < 2; i ++)set.add("tum");
            set.clear();
            assertEquals(0,set.size());
            assertTrue(set.isEmpty());
        }
        @Test
        public void testToCheckTheIndexOfAnElement(){
            for(int i = 0; i < 2; i ++)set.add("tum");
            set.add("ay");
            int index = set.indexOf("ay");
            assertEquals(1,index);
        }



        @Test
        public void testThatListContainsValue(){
            for(int i = 0; i < 2; i ++) set.add("tum");
            set.add("ay");
            assertTrue(set.contains("ay"));
        }

        @Test
        public void testThatYouCanObtainLastElement(){
            for(int i = 0; i < 2; i ++)set.add("tum");
            set.add("ay");
            assertTrue(set.contains("ay"));
            assertEquals("ay",set.getLast());
        }
        @Test
        public void testThatYouCanObtainFirstElement(){
            for(int i = 0; i < 2; i ++) set.add("tum");
            set.add("ay");
            assertTrue(set.contains("ay"));
            assertEquals("tum",set.getFirst());
        }




        @Test
        public void testThatWeCanGetLastIndexOf(){
            for(int i = 0; i < 4; i++) set.add("tum");
            set.add("ay");
            assertTrue(set.contains("ay"));
            assertEquals(0,set.getLastIndexOf("tum"));

        }


        @Test
        public void testThatListCanReturnAnUnmodifiableList(){

            String[] expected = set.of("ay");
            String[] result = {"ay"};
            assertArrayEquals(result,expected);
        }






    @Test
    public void testThatSetCantAddDuplicate(){
        assertTrue(set.isEmpty());
        set.add("ayo");
        set.add("dayo");
        set.add("Mavy");
        set.add("ayo");
       System.out.println(java.util.Arrays.toString(set.elements));
        assertEquals(3,set.size());

    }



}