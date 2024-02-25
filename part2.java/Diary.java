import java.util.ArrayList;
import java.util.List;

public class Diary {
    private int entryId = 1;
    private boolean isLocked ;
    private String password;
    private String userName;

    public List<Entry> entries = new ArrayList<>();

    public Diary(String userName, String password){
           this.password = password;
           this.userName = userName;
    }
    public Diary(){
        this(null,null);
    }
    public boolean isLocked() {
        return isLocked;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public void unlockDiary(String password) {
           if(isValid(password))this.isLocked = false;
          else{
              throw new IncorrectPasswordException("oga your password is incorrect");
          }
    }

    public boolean isValid(String password){
        return password.equals(this.password);
    }


    public void createEntry(String title, String body) {
            Entry entry = new Entry(entryId,title,body);
            entries.add(entry);
            entryId++;
    }

    public int getNumberOfEntryInDiary(){
        return entries.size();
    }

    public Entry findEntryById(int entryId) {
        for (var entry : entries) if(entry.getId() == entryId)return entries.get(entryId-1);
        throw new EntryIdNotFoundException("these id wey u enter no dey here oh oga");
    }

    public void deleteEntry(int entryId) {
       entries.remove(findEntryById(entryId));
    }

    public void updateEntry(int entryId,String newTitle,String newBody){
         var entryToUpdate = findEntryById(entryId);
           entryToUpdate.setBody(newBody);
           entryToUpdate.setTitle(newTitle);
    }
    public String getUserName(){
        return userName;
    }


    @Override
    public String toString() {
        return String.valueOf(entries);
    }
}
class testDiary{

    public static void main(String[] args) {
        Diary di = new Diary("AYO","PASSWORD");
        di.createEntry("title","body");
        di.createEntry("title1","body1");
        di.createEntry("title2","body2");
        Diaries dee = new Diaries();
        dee.addDiary(di);


        System.out.println(dee);
    }

}