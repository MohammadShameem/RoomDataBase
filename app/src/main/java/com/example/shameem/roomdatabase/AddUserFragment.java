package com.example.shameem.roomdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment implements View.OnClickListener {

    Button buttonSave;
    EditText editTextUserId,editTextName,editTextEmail;
    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        buttonSave=view.findViewById(R.id.button_save);
        editTextUserId=view.findViewById(R.id.edit_text_user_id);
        editTextName=view.findViewById(R.id.edit_text_name);
        editTextEmail=view.findViewById(R.id.edit_text_email);
        buttonSave.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_save:

               int userId= Integer.parseInt(editTextUserId.getText().toString());
               String userName=editTextName.getText().toString();
               String userEmail=editTextEmail.getText().toString();

               UserModel userModel=new UserModel();
               userModel.setUserId(userId);
               userModel.setUserName(userName);
               userModel.setUserEmail(userEmail);

               MyAppDatabase.getAppDatabase(getContext()).userDao().addUser(userModel);

                Log.d("user","user added successfully");





                break;
        }
    }
}
