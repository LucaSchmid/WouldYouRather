package com.example.wouldyourather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.getSystemServiceName;

public class newQuestion_Fragment extends Fragment implements View.OnClickListener {

    public newQuestion_Fragment() {
        // Required empty public constructor
    }
    private Button Button_AddQuestion, Button_Refresh;
    TextView textViewCheckConnection;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_question_, container, false);
        Button_AddQuestion = (Button) view.findViewById(R.id.ButtonAddQuestion);
        Button_Refresh = (Button) view.findViewById(R.id.ButtonRefresh);
        Button_AddQuestion.setOnClickListener(this);
        Button_Refresh.setOnClickListener(this);
        textViewCheckConnection = view.findViewById(R.id.textViewCheckConnection);

        checkConnection();

        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ButtonRefresh:
                checkConnection();
                break;
            case R.id.ButtonAddQuestion:
                if (checkConnection()) {
                    Toast.makeText(getActivity(),
                            "added to the DB", Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

    private boolean checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            Button_AddQuestion.setEnabled(true);
            textViewCheckConnection.setVisibility(View.INVISIBLE);
            Button_Refresh.setVisibility(View.INVISIBLE);
            return true;
        }
        else {
            Button_AddQuestion.setEnabled(false);
            textViewCheckConnection.setVisibility(View.VISIBLE);
            Button_Refresh.setVisibility(View.VISIBLE);
            return false;
        }
    }
}