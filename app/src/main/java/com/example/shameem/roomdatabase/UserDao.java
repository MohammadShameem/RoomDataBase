package com.example.shameem.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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

    @Query("select * from user where "+ ColumnNames.USER_ID+" =:userId ")
    UserModel getUserById(int userId);


    @Update
    void updateUser(UserModel userModel);



    @Query(" update user set "+ColumnNames.USER_NAME +" =:userName "+ ","+ColumnNames.USER_EMAIL+
            " =:email " + " where "+ColumnNames.USER_ID+" =:userId ")
    int updateUserDetails(String userName,String email,int userId);






}
