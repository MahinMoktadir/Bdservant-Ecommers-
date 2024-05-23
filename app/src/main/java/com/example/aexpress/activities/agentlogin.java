package com.example.aexpress.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aexpress.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class agentlogin extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final EditText agentmobilenumber= findViewById(R.id.agentmobileno);
        final EditText agentpass= findViewById(R.id.agentpassword);
        final Button agentsignin= findViewById(R.id.agentlogin);
        final TextView agentsignup= findViewById(R.id.agentSignUp);


        agentsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(agentlogin.this,servantregistration.class));
            }
        });
        agentsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String agentcell= agentmobilenumber.getText().toString();
                final String agentpassword1= agentpass.getText().toString();

                if(agentcell.isEmpty()  || agentpassword1.isEmpty())
                {
                    Toast.makeText(agentlogin.this,"Please Enter your mobile or Password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent((new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(agentcell) || snapshot.hasChild(agentpassword1))
                            {
                                final String getpassword=snapshot.child(agentcell).child(agentpassword1).getValue(String.class);
                                if(getpassword.equals(agentpassword1))
                                {
                                    Toast.makeText(agentlogin.this, "Succcessfully Logged in",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(agentlogin.this,profile.class));
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(agentlogin.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(agentlogin.this,"Wrong Passoword",Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }));
                }
            }
        });
    }
}
