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

public class customerreg extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bd-servant-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerreg);

        final EditText fullname2= findViewById(R.id.inputUsername2);
        final EditText email2= findViewById(R.id.inputEmail2);
        final EditText cellno2= findViewById(R.id.cellno);
        final EditText address2= findViewById(R.id.location);
        final EditText inputPassword2= findViewById(R.id.inputPassword1);
        final EditText Password= findViewById(R.id.inputConformPassword1);

        final Button btnreg2= findViewById(R.id.btnRegister1);
        final TextView btnal2= findViewById(R.id.alreadyHaveAccount);


        btnal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name2=fullname2.getText().toString();
                final String mail=email2.getText().toString();
                final String cell=cellno2.getText().toString();
                final String address1=address2.getText().toString();
                final String pass2=inputPassword2.getText().toString();
                final String confirmpass2=Password.getText().toString();

                if(name2.isEmpty() || mail.isEmpty() ||cell.isEmpty() || address1.isEmpty() ||pass2.isEmpty() || confirmpass2.isEmpty())
                {
                    Toast.makeText(customerreg.this,"Please Fill up all the Details",Toast.LENGTH_SHORT).show();
                }
                else if (!pass2.equals(confirmpass2))
                {
                    Toast.makeText(customerreg.this,"Mis Match Confirm Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(mail))
                            {
                                Toast.makeText(customerreg.this,"You Have Already Registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                databaseReference.child("users").child(mail).child("fullname").setValue(fullname2);
                                databaseReference.child("users").child(mail).child("mobileno").setValue(cellno2);
                                databaseReference.child("users").child(mail).child("password").setValue(inputPassword2);

                                Toast.makeText(customerreg.this,"Register Completed",Toast.LENGTH_SHORT).show();
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