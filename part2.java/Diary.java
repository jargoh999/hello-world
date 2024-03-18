package data.model;

import services.Exceptions.EntryNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private int id;
    private String userName;
    private String password;

    private  boolean isLocked = false;

    private List<Entry> entryList = new ArrayList<>();

    public Diary (){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lock(){
        this.isLocked = true;
    }

    public void unlock(String password){
        if(this.password.equals(password))this.isLocked = false;
    }

    public void addEntry(Entry entry){
        entryList.add(entry);
    }

    public Entry findEntry(Entry entry) throws EntryNotFoundException {
        if(entryList.contains(entry))return entry;
        throw new EntryNotFoundException("entry is not saved here");
    }

    public void deleteEntry(Entry entry) throws EntryNotFoundException {
         var entryToBeDeleted = findEntry(entry);
         entryList.remove(entryToBeDeleted);
    }

    public long getNumberOfEntry(){
        return entryList.size();
    }

}
