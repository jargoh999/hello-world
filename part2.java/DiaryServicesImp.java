package services;

import data.model.Diary;
import dto.UserInformation;
import repository.DiaryRepositoryImpl;
import repository.EntryRepositoryImpl;
import services.Exceptions.UserAlreadyExistException;

import java.util.ArrayList;
import java.util.List;

import static services.UserStatus.LOGGED_IN;
import static services.UserStatus.LOGGED_OUT;


public class DiaryServicesImp implements DiaryServices {
   private final List<Diary> diariesServices = new ArrayList<>();
    private final DiaryRepositoryImpl repository = new DiaryRepositoryImpl();
    private final EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();


    @Override
    public void registerUser(Diary diary ,UserInformation userInformation) throws UserAlreadyExistException {
        signUserUpIn(diary,userInformation);
    }

    private void signUserUpIn(Diary diary,UserInformation userInformation) throws UserAlreadyExistException {
           if(!isNew(diary,userInformation))throw new UserAlreadyExistException("invalid user number");
           diary.setPassword(userInformation.getPassword());
           diary.setUserName(userInformation.getUserName().toLowerCase());
           if(!repositoryContains(diary.getUserName()))throw new UserAlreadyExistException("invalid user number");
           diariesServices.add(diary);
           repository.save(diary);
    }

    @Override
    public void logIn(Diary diary,UserInformation userInformation) {
       if(diariesServices.contains(diary))changeUserStatusWith(diary,userInformation);
    }

    @Override
    public long numberOfUsers() {
        return repository.count();
    }

    @Override
    public void logOut(Diary diary, UserInformation userInformation) {
           userInformation.setUserStatus(LOGGED_OUT);
           afterUserLogsOutLock(diary,userInformation);
    }



    private void afterUserLogsOutLock(Diary diary , UserInformation userInformation) {
              if(userInformation.getUserStatus()==LOGGED_OUT)diary.lock();
    }

    private void changeUserStatusWith(Diary diary,UserInformation userInformation) {
        userInformation.setUserStatus(LOGGED_IN);
        logInToDiary(diary,userInformation);
    }

    private void logInToDiary(Diary diary, UserInformation userInformation) {
            if(userInformation.getUserStatus()==LOGGED_IN)diary.unlock(userInformation.getPassword());
    }

    private boolean isNew(Diary diary, UserInformation userInformation) {
        return !repository.findAll().containsValue(diary) && userInformation.getUserStatus()==LOGGED_OUT;
    }

     public  boolean repositoryContains(String username){
            for(var diary : diariesServices){
            if (repository.findAll().get(diary).getUserName().equalsIgnoreCase(username))return false;
        }
        return true;
    }

}
