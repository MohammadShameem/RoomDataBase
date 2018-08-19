package com.example.shameem.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 *
 * The class created by shameem
* */

@Dao
public interface UserDao {

    @Insert
    public void addUser(UserModel userModel);

}
