package com.example.wouldyourather;

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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class fragment_screen_slide_page2 extends Fragment implements View.OnClickListener {
    /////////////////////
    //Kategorie Neueste//
    /////////////////////

    TextView WouldYouRather1_TV, WouldYouRather2_TV, WouldYouRatherValue1_ID, WouldYouRatherValue2_ID;
    Button buttonNext;
    private DatabaseReference ref;
    private Query query1;
    ArrayList<String> IDlist=new ArrayList<String>();
    String futureUID = "";
    String futureUIDzuvor = "";
    int WouldYouRatherValue1, WouldYouRatherValue2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =(ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page1, container, false);
        WouldYouRather1_TV = v.findViewById(R.id.EditText1);
        WouldYouRather2_TV = v.findViewById(R.id.EditText2);
        WouldYouRatherValue1_ID = v.findViewById(R.id.WoulYourRatherValue1);
        WouldYouRatherValue2_ID = v.findViewById(R.id.WoulYourRatherValue2);
        buttonNext = v.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
        WouldYouRather1_TV.setOnClickListener(this);
        WouldYouRather2_TV.setOnClickListener(this);
        //WouldYouRatherValue1_ID.setVisibility(View.INVISIBLE);
        //WouldYouRatherValue2_ID.setVisibility(View.INVISIBLE);
        checkDB();

        return v;
    }

    public  void checkDB(){
        ref = FirebaseDatabase.getInstance().getReference().child("Questions");
        query1 = ref.orderByKey();
        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot supportItem: snapshot.getChildren()) {
                        futureUIDzuvor = futureUID;
                        futureUID =supportItem.getKey();
                        for(String ID:IDlist){
                            if (futureUID.equals(ID)) {
                                futureUID = futureUIDzuvor;
                                break;
                            }
                        }
                    }

                    if(futureUID.equals("")) {
                        futureUIDzuvor = "";
                        IDlist.clear();
                        return;
                    }
                    IDlist.add(futureUID);
                    query1 = ref.child(futureUID);
                    query1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String WouldYouRather1 = snapshot.child("wouldYouRather1").getValue().toString();
                            String WouldYouRather2 = snapshot.child("wouldYouRather2").getValue().toString();
                            WouldYouRatherValue1 = Integer.parseInt(snapshot.child("wouldYouRather1_value").getValue().toString());
                            WouldYouRatherValue2 = Integer.parseInt(snapshot.child("wouldYouRather2_value").getValue().toString());
                            WouldYouRather1_TV.setText(WouldYouRather1);
                            WouldYouRather2_TV.setText(WouldYouRather2);
                            WouldYouRatherValue1_ID.setText(Integer.toString(WouldYouRatherValue1));
                            WouldYouRatherValue2_ID.setText(Integer.toString(WouldYouRatherValue2));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonNext:
                //Toast.makeText(getActivity(),
                //      "Next Q", Toast.LENGTH_LONG).show();
                WouldYouRatherValue1_ID.setVisibility(View.INVISIBLE);
                WouldYouRatherValue2_ID.setVisibility(View.INVISIBLE);
                WouldYouRather1_TV.setClickable(true);
                WouldYouRather2_TV.setClickable(true);
                checkDB();
                break;
            case R.id.EditText1:
                Toast.makeText(getActivity(),
                        "EDT 1", Toast.LENGTH_LONG).show();
                WouldYouRatherValue1_ID.setVisibility(View.VISIBLE);
                WouldYouRatherValue2_ID.setVisibility(View.VISIBLE);

                DatabaseReference updateData = FirebaseDatabase.getInstance()
                        .getReference("Questions")
                        .child(futureUID);
                updateData.child("wouldYouRather1_value").setValue(WouldYouRatherValue1+1);
                WouldYouRather1_TV.setClickable(false);
                WouldYouRather2_TV.setClickable(false);
                break;
            case R.id.EditText2:
                Toast.makeText(getActivity(),
                        "EDT 2", Toast.LENGTH_LONG).show();
                WouldYouRatherValue1_ID.setVisibility(View.VISIBLE);
                WouldYouRatherValue2_ID.setVisibility(View.VISIBLE);

                updateData = FirebaseDatabase.getInstance()
                        .getReference("Questions")
                        .child(futureUID);
                updateData.child("wouldYouRather2_value").setValue(WouldYouRatherValue2+1);
                WouldYouRather1_TV.setClickable(false);
                WouldYouRather2_TV.setClickable(false);
                break;

        }
    }
}
