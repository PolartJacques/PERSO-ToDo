package com.example.todo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RegisterFragment extends Fragment {

    private Button buttonToLogin;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // INITIALIZE VARIABLES
        buttonToLogin = view.findViewById(R.id.buttonToLogin);

        // ONCLICK
        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send data to the parent activity, here we send "login" to say that we want to go to the login form
                Bundle result = new Bundle();
                result.putString("bundleKey", "login");
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
    }
}