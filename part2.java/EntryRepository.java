package repository;
import data.model.Entry;

import java.util.HashMap;

public interface EntryRepository{
    Entry save(Entry entry);
    HashMap<String, Entry> findAll();
    Entry findById(String author);
    long count();
    void delete(String authorName);
    void delete(Entry entry);
}
