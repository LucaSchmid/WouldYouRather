package com.example.wouldyourather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getSystemService;

public class newQuestion_Fragment extends Fragment implements View.OnClickListener {

    public newQuestion_Fragment() {
        // Required empty public constructor
    }
    private Button Button_AddQuestion;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_question_, container, false);
        Button_AddQuestion = (Button) view.findViewById(R.id.ButtonAddQuestion);
        Button_AddQuestion.setOnClickListener(this);

        //Hier weiter machen
        //--TODO "getSystemService is not known"
        //ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),
                "added to the DB", Toast.LENGTH_LONG).show();
    }
}