package com.example.todo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {

    // DECLARE VARIABLES
    Button buttonToRegister;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // INITIALIZE VARIABLES
        buttonToRegister = view.findViewById(R.id.buttonToRegister);

        // ONCLICK
        buttonToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send data to the parent activity, here we send "register" to say that we want to go to the register form
                Bundle result = new Bundle();
                result.putString("bundleKey", "register");
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
    }
}