package com.example.aexpress.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aexpress.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class agentregistration extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentregistration);

        final EditText agentfullname= findViewById(R.id.agentUsername);
        final EditText agentmobile= findViewById(R.id.agentinputmobileno);
        final EditText agentaddress= findViewById(R.id.agentaddress1);
        final EditText agentinputPassword= findViewById(R.id.agentinputPassword);
        final EditText agentPassword= findViewById(R.id.agentinputConformPassword);

        final Button agentregister= findViewById(R.id.agentRegister);
        final TextView agentsignin= findViewById(R.id.agentlreadyHaveAccount);


        agentsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        agentregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String agentname=agentfullname.getText().toString();
                final String agentcell=agentmobile.getText().toString();
                final String agentlocation=agentaddress.getText().toString();
                final String agentpass=agentinputPassword.getText().toString();
                final String agentconfirmpass=agentPassword.getText().toString();

                if(agentname.isEmpty() || agentcell.isEmpty() ||agentlocation.isEmpty() || agentpass.isEmpty() ||agentconfirmpass.isEmpty())
                {
                    Toast.makeText(agentregistration.this,"Please Fill up all the Details",Toast.LENGTH_SHORT).show();
                }
                else if (!agentpass.equals(agentconfirmpass))
                {
                    Toast.makeText(agentregistration.this,"Mis Match Confirm Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(agentcell))
                            {
                                Toast.makeText(agentregistration.this,"You Have Already Registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                databaseReference.child("users").child(agentcell).child("fullname").setValue(agentname);
                                databaseReference.child("users").child(agentcell).child("mobileno").setValue(agentmobile);
                                databaseReference.child("users").child(agentcell).child("password").setValue(agentinputPassword);

                                Toast.makeText(agentregistration.this,"Register Completed",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
    }
}