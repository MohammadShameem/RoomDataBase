package com.example.shameem.roomdatabase;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment implements View.OnClickListener{

    Button buttonUpdate;
    EditText editTextUserId,editTextName,editTextEmail;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_user, container, false);

        buttonUpdate=view.findViewById(R.id.button_update_user);
        editTextUserId=view.findViewById(R.id.edit_text_user_id);
        editTextName=view.findViewById(R.id.edit_text_name);
        editTextEmail=view.findViewById(R.id.edit_text_email);
        buttonUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         showUserData();
    }

    private void showUserData(){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final UserModel  userModel= MyAppDatabase.getAppDatabase(getContext()).userDao().getUserById(2);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        editTextUserId.setText(String.valueOf(userModel.getUserId()));
                        editTextName.setText(userModel.getUserEmail());
                        editTextEmail.setText(userModel.getUserEmail());
                    }
                });

            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_update_user:

                final int userId= Integer.parseInt(editTextUserId.getText().toString());
                final String userName=editTextName.getText().toString();
                final String userEmail=editTextEmail.getText().toString();




                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {

                        //   final UserModel userModel=new UserModel();
                        final  UserModel  userModel1= MyAppDatabase.getAppDatabase(getContext()).userDao().getUserById(2);
                        userModel1.setUserId(userModel1.getUserId());
                        //  userModel1.setUserName(userName);
                        userModel1.setUserEmail(userEmail);

                      MyAppDatabase.getAppDatabase(getContext()).userDao().updateUser(userModel1);


                        //MyAppDatabase.getAppDatabase(getContext()).userDao().updateUserDetails(userName,userEmail,userId);

                    }
                });

                Log.d("user","user updated successfully");

                editTextUserId.setText("");
                editTextName.setText("");
                editTextEmail.setText("");

                break;
        }
    }
}
