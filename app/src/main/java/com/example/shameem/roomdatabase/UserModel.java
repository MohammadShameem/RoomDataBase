package com.example.shameem.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by shameem on 10/24/2017.
 */



@Entity(tableName = TableNames.USER)
public class UserModel {

    @PrimaryKey
    @ColumnInfo(name = ColumnNames.USER_ID)
    private int mUserId;

    @ColumnInfo(name = ColumnNames.USER_NAME)
    private String mUserName;

    @ColumnInfo(name = ColumnNames.USER_EMAIL)
    private String mUserEmail;

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public void setUserEmail(String mUserEmail) {
        this.mUserEmail = mUserEmail;
    }
}
