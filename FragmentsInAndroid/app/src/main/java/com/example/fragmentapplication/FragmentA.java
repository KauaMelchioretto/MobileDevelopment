package com.example.fragmentapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import android.widget.Button;
import android.widget.EditText;


public class FragmentA extends Fragment {
    Button buttonSend;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        buttonSend = view.findViewById(R.id.buttonSend);
        editText = view.findViewById(R.id.editTextA);

        buttonSend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle b = new Bundle();
                b.putString("msg", editText.getText().toString());
                Fragment fragmentB = new FragmentB();
                fragmentB.setArguments(b);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, fragmentB);
                transaction.commit();
            }
        });
        return  view;
    }
}