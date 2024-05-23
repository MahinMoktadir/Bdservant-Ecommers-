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

public class servantregistration extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servantregistration);

        final EditText fullname1= findViewById(R.id.inputUsername);
        final EditText mobile1= findViewById(R.id.inputmobileno);
        final EditText service1= findViewById(R.id.servicecat);
        final EditText address1= findViewById(R.id.address1);
        final EditText nidno1= findViewById(R.id.nidno);
        final EditText inputPassword1= findViewById(R.id.inputPassword);
        final EditText inputConformPassword1= findViewById(R.id.inputConformPassword);

        final Button btnreg= findViewById(R.id.btnRegister);
        final TextView btnal1= findViewById(R.id.alreadyHaveAccount);


        btnal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=fullname1.getText().toString();
                final String mobile=mobile1.getText().toString();
                final String service=service1.getText().toString();
                final String address=address1.getText().toString();
                final String nid=nidno1.getText().toString();
                final String pass=inputPassword1.getText().toString();
                final String confirmpass=inputConformPassword1.getText().toString();

                if(name.isEmpty() || mobile.isEmpty() ||service.isEmpty() || address.isEmpty() ||nid.isEmpty() || pass.isEmpty() ||confirmpass.isEmpty())
                {
                    Toast.makeText(servantregistration.this,"Please Fill up all the Details",Toast.LENGTH_SHORT).show();
                }
                else if (!pass.equals(confirmpass))
                {
                    Toast.makeText(servantregistration.this,"Mis Match Confirm Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(mobile))
                            {
                                Toast.makeText(servantregistration.this,"You Have Already Registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                databaseReference.child("users").child(mobile).child("fullname").setValue(fullname1);
                                databaseReference.child("users").child(mobile).child("mobileno").setValue(mobile1);
                                databaseReference.child("users").child(mobile).child("password").setValue(inputPassword1);

                                Toast.makeText(servantregistration.this,"Register Completed",Toast.LENGTH_SHORT).show();
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