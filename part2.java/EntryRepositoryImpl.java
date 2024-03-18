package repository;


import data.model.Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private final HashMap<String, Entry> entryRepository = new HashMap<>();
   private final HashMap<String, List<Entry>> entryToReturn= new HashMap<>();


    @Override
    public Entry save(Entry entry) {
         if(isNew(entry))assignKeyToEntry(entry.getAuthor(),entry);

        return addEntryToRepository(entry);
    }


    private Entry addEntryToRepository(Entry entry) {
        entryRepository.put(entry.getAuthor(),entry);
        return entry;
    }

    private void assignKeyToEntry(String author, Entry entry) {
          entry.setAuthor(author);
    }

    private boolean isNew(Entry entry) {
        return !entryRepository.containsValue(entry);
    }

    @Override
    public HashMap<String, Entry> findAll() {
        return entryRepository;
    }

    @Override
    public Entry findById(String author) {
          for(var entryKey : entryRepository.keySet())if(entryKey.equals(author))return entryRepository.get(entryKey);
          return null;
    }

    @Override
    public long count() {
        return entryRepository.size();
    }

    @Override
    public void delete(String authorName) {
         var entryToDelete = findById(authorName);
         entryRepository.remove(authorName,entryToDelete);
    }

    @Override
    public void delete(Entry entry) {
          entryRepository.remove(entry.getAuthor());
    }


    public HashMap<String, List<Entry>> entryWithSameOwner(String authorName,Entry...entries) {
                                 List<Entry> entryList = new ArrayList<>();
                                 for (var entry : entries){
                                    if(entry.getAuthor().equalsIgnoreCase(authorName))
                                        entryList.add(entry);
                                 }
                                 entryToReturn.put(authorName,entryList);
                                 return entryToReturn;
    }
}