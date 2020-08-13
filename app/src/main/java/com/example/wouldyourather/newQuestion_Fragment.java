package com.example.wouldyourather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.getSystemServiceName;

public class newQuestion_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    public newQuestion_Fragment() {
        // Required empty public constructor
    }
    private Button Button_AddQuestion;
    TextView textViewCheckConnection;
    View view;
    EditText WouldYouRather1, WouldYouRather2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_question_, container, false);
        //
        WouldYouRather1 = (EditText) view.findViewById(R.id.EditText1);
        WouldYouRather2 = (EditText) view.findViewById(R.id.EditText2);
        //

        Button_AddQuestion = (Button) view.findViewById(R.id.ButtonAddQuestion);
        Button_AddQuestion.setOnClickListener(this);
        textViewCheckConnection = view.findViewById(R.id.textViewCheckConnection);

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        String [] values =
                {"Kategorie 1","Kategorie 2","Kategorie 3","Kategorie 4","Kategorie 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        checkConnection();
        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ButtonAddQuestion:
                addQuestion(view);
                break;
        }

    }

    private boolean checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            textViewCheckConnection.setVisibility(View.INVISIBLE);
            return true;
        }
        else {
            textViewCheckConnection.setVisibility(View.VISIBLE);
            return false;
        }
    }

    public void addQuestion(View view){
        if (checkConnection()) {
            Toast.makeText(getActivity(),
                    "added to the DB", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}