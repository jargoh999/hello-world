import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;

    @BeforeEach
    public void setDiary(){
        diary = new Diary("ayo","password");
    }

    @Test
    public void testThatDiaryIsUnlocked_isLockedIsFalse(){
        assertFalse(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanBeLocked_DiaryIsLocked(){
        assertFalse(diary.isLocked());
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanBeUnlocked_DiaryIsUnlocked(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testThatEntryCanBeCreated_entryIsCreated(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.createEntry("title","body");
        assertEquals(1,diary.getNumberOfEntryInDiary());
    }
   @Test
    public void testThatEntryCanBeFound(){
       diary.lockDiary();
       assertTrue(diary.isLocked());
       diary.unlockDiary("password");
       assertFalse(diary.isLocked());
       diary.createEntry("title","body");
       diary.createEntry("title1","body1");
       Entry entryToReturn = diary.findEntryById(2);
       assertEquals( diary.entries.get(1),entryToReturn);
       assertThrows(EntryIdNotFoundException.class,()-> diary.findEntryById(-1));
    }
    @Test
    public void testThatEntryCanBeDeleted(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.createEntry("title","body");
        diary.createEntry("title1","body1");
        diary.deleteEntry(2);
        assertEquals(1,diary.getNumberOfEntryInDiary());
    }
    @Test
    public void testThatEntryCanBeUpdated(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.createEntry("title","body");
        diary.createEntry("title1","body1");
        diary.updateEntry(1,"newTitle","newBody");
        assertEquals(diary.entries.get(0).getBody(),"newBody");
    }
    @Test
    public void testThatNegativeIdCantBeFound(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.createEntry("title","body");
        diary.createEntry("title1","body1");
        assertThrows(EntryIdNotFoundException.class,()-> diary.findEntryById(-1));
    }

    @Test
    public void addThreeEntryRemoveOne_findTheRemovedEntry(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.createEntry("title","body");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.deleteEntry(2);
        assertThrows(EntryIdNotFoundException.class,()-> diary.findEntryById(2));
    }
}