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

public class customerlog extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final EditText mobileno3= findViewById(R.id.mobileno1);
        final EditText Password3= findViewById(R.id.inputPassword1);
        final Button signin= findViewById(R.id.login1);
        final TextView signup= findViewById(R.id.SignUp1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customerlog.this,servantregistration.class));
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobile4= mobileno3.getText().toString();
                final String password4= Password3.getText().toString();

                if(mobile4.isEmpty()  || password4.isEmpty())
                {
                    Toast.makeText(customerlog.this,"Please Enter your mobile or Password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent((new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(mobile4) || snapshot.hasChild(password4))
                            {
                                final String getpassword=snapshot.child(mobile4).child(password4).getValue(String.class);
                                if(getpassword.equals(password4))
                                {
                                    Toast.makeText(customerlog.this, "Succcessfully Logged in",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(customerlog.this,profile.class));
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(customerlog.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(customerlog.this,"Wrong Passoword",Toast.LENGTH_SHORT).show();
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
