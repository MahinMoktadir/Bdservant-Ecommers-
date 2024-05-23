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

public class Servantlogin extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final EditText mobileno1= findViewById(R.id.mobileno);
        final EditText Password1= findViewById(R.id.inputPassword);
        final Button loginbtn= findViewById(R.id.login);
        final TextView registration= findViewById(R.id.SignUp);


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Servantlogin.this,servantregistration.class));
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobile= mobileno1.getText().toString();
                final String password= Password1.getText().toString();

                if(mobile.isEmpty()  || password.isEmpty())
                {
                    Toast.makeText(Servantlogin.this,"Please Enter your mobile or Password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent((new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(mobile) || snapshot.hasChild(password))
                            {
                                final String getpassword=snapshot.child(mobile).child(password).getValue(String.class);
                                if(getpassword.equals(password)) {
                                    Toast.makeText(Servantlogin.this, "Succcessfully Logged in",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Servantlogin.this,Servantprofile1.class));
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(Servantlogin.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(Servantlogin.this,"Wrong Passoword",Toast.LENGTH_SHORT).show();
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
