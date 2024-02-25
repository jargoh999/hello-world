import java.util.ArrayList;
import java.util.List;

public class Diaries {

    private List<Diary>diaries = new ArrayList<>();
    public void addDiary(String userName,String password){
            Diary diary = new Diary(userName,password);
            diaries.add(diary);
    }

    public void addDiary(Diary diary){
        diaries.add(diary);
    }

    public Diary findDiaryByUsername(String userName){
        for(var diary : diaries) if(diary.getUserName().equals(userName))return diary;
        throw new NoSuchDiaryException("diary not found");
    }

    public void deleteDiary(String userName,String password){
       var diaryToDelete = findDiaryByUsername(userName);
        if (diaryToDelete.isValid(password)) diaries.remove(diaryToDelete);
    }

    @Override
    public String toString(){
      return this.diaries.toString();
    }
}