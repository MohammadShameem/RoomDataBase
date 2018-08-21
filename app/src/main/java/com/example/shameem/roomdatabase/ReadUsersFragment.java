package com.example.shameem.roomdatabase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ReadUsersFragment extends Fragment {

    TextView textView;

    public ReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_users, container, false);

        textView=view.findViewById(R.id.text_view_user);




        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<UserModel> userModelList=MyAppDatabase.getAppDatabase(getContext()).userDao().getAllUsers();

                String info="";
                for (UserModel userModel: userModelList){

                    int id=userModel.getUserId();
                    String name=userModel.getUserName();
                    String email=userModel.getUserEmail();
                    info=info+"\n"+id+"\n"+name+"\n"+email+"\n";
                }


                final String finalInfo = info;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText(finalInfo);
                    }
                });

            }
        });





        return view;
    }




}
