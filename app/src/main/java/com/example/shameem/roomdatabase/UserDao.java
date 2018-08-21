package com.example.shameem.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 *
 * The class created by shameem
* */

@Dao
public interface UserDao {

    @Insert
     void addUser(UserModel userModel);


    @Query("select * from user")
     List<UserModel> getAllUsers();

}
