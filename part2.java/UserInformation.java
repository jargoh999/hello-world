package dto;
import data.model.Diary;
import data.model.Entry;
import services.Exceptions.DiaryIsLockedException;
import services.Exceptions.EntryNotFoundException;
import services.UserStatus;

import static services.UserStatus.LOGGED_OUT;
public class UserInformation {
    private String username;
    private String password;
    private UserStatus userStatus = LOGGED_OUT;
    public String getUserName() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserStatus getUserStatus() {
        return this.userStatus;
    }
    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
    public void addEntry(Diary diary,Entry entry) throws DiaryIsLockedException {
        if (diary.isLocked()) throw new DiaryIsLockedException("Diary is locked");
        diary.addEntry(entry);
    }
    public void deleteEntry( Diary diary,Entry entry) throws EntryNotFoundException, DiaryIsLockedException {
          if(diary.isLocked())throw new DiaryIsLockedException("Diary is locked");
          var entryToBeDeleted = diary.findEntry(entry);
          if(!diary.isLocked())diary.getEntryList().remove(entry);
    }

}
