package services;

import data.model.Diary;
import dto.UserInformation;
import services.Exceptions.UserAlreadyExistException;

public interface DiaryServices {
    void registerUser(Diary diary, UserInformation userInformation) throws UserAlreadyExistException;
    void logIn(Diary diary,UserInformation userInformation);
    long numberOfUsers();
    void logOut(Diary diary ,UserInformation userInformation);

}
