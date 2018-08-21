package com.example.shameem.roomdatabase;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   //  public static  MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





      //  myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userbd").allowMainThreadQueries().build();



        HomeFragment homeFragment=new HomeFragment();
        loadFragment(homeFragment);

    }


    public void loadFragment(Fragment fragment){

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
