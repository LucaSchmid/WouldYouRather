package com.example.wouldyourather;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fragment_screen_slide_page1 extends Fragment implements View.OnClickListener {
    TextView WouldYouRather1_TV, WouldYouRather2_TV;
    Button buttonNext;
    DatabaseReference reff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =(ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page1, container, false);
        WouldYouRather1_TV = v.findViewById(R.id.EditText1);
        WouldYouRather2_TV = v.findViewById(R.id.EditText2);
        buttonNext = v.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);

        reff = FirebaseDatabase.getInstance().getReference().child("Questions").child("-MEqS9aJpDCvhv90YrYi");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String WouldYouRather1=snapshot.child("wouldYouRather1").getValue().toString();
                String WouldYouRather2=snapshot.child("wouldYouRather2").getValue().toString();
                WouldYouRather1_TV.setText(WouldYouRather1);
                WouldYouRather2_TV.setText(WouldYouRather2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonNext:
                Toast.makeText(getActivity(),
                        "Next Q", Toast.LENGTH_LONG).show();
                break;
        }
    }
}