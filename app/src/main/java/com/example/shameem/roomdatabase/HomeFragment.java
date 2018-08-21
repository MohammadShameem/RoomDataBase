package com.example.shameem.roomdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


   private Button  buttonAddUser,buttonReadData,buttonUpdateHome;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        buttonAddUser=view.findViewById(R.id.button_insert_data);
        buttonReadData=view.findViewById(R.id.button_read_data);
        buttonUpdateHome=view.findViewById(R.id.button_update_home);


        buttonAddUser.setOnClickListener(this);
        buttonUpdateHome.setOnClickListener(this);
        buttonReadData.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_insert_data:

                AddUserFragment addUserFragment= new AddUserFragment();
                ((MainActivity)getActivity()).loadFragment(addUserFragment);

                break;
            case R.id.button_read_data:

                ReadUsersFragment readUsersFragment= new ReadUsersFragment();
                ((MainActivity)getActivity()).loadFragment(readUsersFragment);

                break;

            case R.id.button_update_home:
                UpdateUserFragment updateUserFragment= new UpdateUserFragment();
                ((MainActivity)getActivity()).loadFragment(updateUserFragment);
                break;

        }

    }
}
