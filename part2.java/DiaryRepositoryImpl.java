package repository;

import data.model.Diary;

import java.util.HashMap;

public class DiaryRepositoryImpl implements DiaryRepository{
    private final HashMap<Integer,Diary> repository = new HashMap<>();
    private int id = 0;



    @Override
    public Diary save(Diary diary) {
         if(isNew(diary))assignIdToDiary(generateId(),diary);
         return addDiaryToRepository(diary);
    }

    private Diary addDiaryToRepository(Diary diary) {
        repository.put(diary.getId(),diary);
        return diary;
    }

    private boolean isNew(Diary diary) {
        return !repository.containsValue(diary);
    }

    private void assignIdToDiary(int id,Diary diary) {
              diary.setId(id);
    }

    private int generateId(){
        return ++id;
    }

    @Override
    public HashMap<Integer, Diary> findAll() {
        return repository;
    }

    @Override
    public Diary findById(String userName) {
      return repositoryContains(userName);
    }

    private Diary repositoryContains(String userName) {
        for (var key : repository.entrySet())
            if(key.getValue().getUserName().equalsIgnoreCase(userName))
                  return key.getValue();

        return null;
    }

    @Override
    public long count() {
        return repository.size();
    }

    @Override
    public void delete(String userName) {
         var diaryToRemove = findById(userName);
          repository.remove(diaryToRemove.getId(),diaryToRemove);
    }

    @Override
    public void delete(Diary diary) {
        if(repository.containsValue(diary))repository.remove(diary.getId(),diary);
    }

    @Override
    public void update(Diary diaryToUpdate, Diary diaryToBeUpdatedWith) {
        var diaryToBeUpdatedInRepo = findById(diaryToUpdate.getUserName());
           diaryToBeUpdatedInRepo.setUserName(diaryToBeUpdatedWith.getUserName());
           diaryToBeUpdatedInRepo.setPassword(diaryToBeUpdatedWith.getPassword());
    }
}

