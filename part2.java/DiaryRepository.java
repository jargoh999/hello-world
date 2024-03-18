package repository;

import data.model.Diary;

import java.util.HashMap;

public interface DiaryRepository {

    Diary save(Diary diary);
    HashMap<Integer, Diary> findAll();
    Diary findById(String userName);
    long count();
    void delete(String userName);
    void delete(Diary diary);
    void update(Diary diaryToUpdate, Diary diaryToBeUpdatedWith);
}
