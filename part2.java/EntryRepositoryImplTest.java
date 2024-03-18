package repository;

import data.model.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntryRepositoryImplTest {



    @Test
    void testThatEntryCanBeSaved() {
        EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
        Entry entry = new Entry();
        entry.setAuthor("ayo");
        entry.setTitle("1234");
        entryRepository.save(entry);
        assertEquals(1,entryRepository.count());
    }

    @Test
    void testThatEntryCanBeFoundAll() {
        EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
        Entry entry = new Entry();
        entry.setAuthor("ayo");
        entry.setTitle("1234");
        entryRepository.save(entry);
        Entry entry1 = new Entry();
        entry1.setAuthor("ayo1");
        entry1.setTitle("12345");
        entryRepository.save(entry1);
        assertEquals(2,entryRepository.count());
        assertEquals(2,entryRepository.count());
    }

    @Test
    public void testThatWeCanFindById() {
        EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
        Entry entry = new Entry();
        entry.setAuthor("ayo");
        entry.setTitle("1234");
        entryRepository.save(entry);
        Entry entry1 = new Entry();
        entry1.setAuthor("ayo1");
        entry1.setTitle("12345");
        entryRepository.save(entry1);
        assertEquals( entryRepository.save(entry),entryRepository.findById("ayo"));
        assertEquals(2,entryRepository.count());
    }

    @Test
    void testThatUserCanGetNumberOfEntry() {
            EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
            Entry entry = new Entry();
            entry.setAuthor("ayo");
            entry.setTitle("1234");
            entryRepository.save(entry);
            Entry entry1 = new Entry();
            entry1.setAuthor("ayo1");
            entry1.setTitle("12345");
            entryRepository.save(entry1);
            assertEquals(2,entryRepository.count());
    }

    @Test
    void testThatUserCanDeleteEntry() {
        EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
        Entry entry = new Entry();
        entry.setAuthor("ayo");
        entry.setTitle("1234");
        entryRepository.save(entry);
        Entry entry1 = new Entry();
        entry1.setAuthor("ayo1");
        entry1.setTitle("12345");
        entryRepository.save(entry1);
        assertEquals(2,entryRepository.count());
        entryRepository.delete(entry.getAuthor());
        assertEquals(1,entryRepository.count());
    }

    @Test
    void testThatWeCanDeleteEntryWithEntry() {
            EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
            Entry entry = new Entry();
            entry.setAuthor("ayo");
            entry.setTitle("1234");
            entryRepository.save(entry);
            Entry entry1 = new Entry();
            entry1.setAuthor("ayo1");
            entry1.setTitle("12345");
            entryRepository.save(entry1);
            assertEquals(2,entryRepository.count());
            entryRepository.delete(entry);
            assertEquals(1,entryRepository.count());
    }

    @Test
    void testThatEntryCannotSaveWithSameOwner() {
        EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
        Entry entry = new Entry();
        entry.setAuthor("ayo");
        entry.setTitle("1234");
        entryRepository.save(entry);
        Entry entry1 = new Entry();
        entry1.setAuthor("ayo");
        entry1.setTitle("1234");
        entryRepository.save(entry1);
        assertEquals(1,entryRepository.count());
    }
}