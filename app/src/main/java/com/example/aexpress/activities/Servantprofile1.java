package com.example.aexpress.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.example.aexpress.R;

import java.security.Provider;

public class Servantprofile1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servantprofile1);

        Button profileButton = findViewById(R.id.profileButton);
        Button paymentsButton = findViewById(R.id.paymentsButton);
        Button servicesButton = findViewById(R.id.servicesButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(Servantprofile1.this,profile.class);
                startActivity(profileIntent);
            }
        });

        paymentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the PaymentsActivity
                Intent paymentsIntent = new Intent(Servantprofile1.this, paymentsActivity.class);
                startActivity(paymentsIntent);
            }
        });

        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the ServicesActivity
                Intent servicesIntent = new Intent(Servantprofile1.this,services.class);
                startActivity(servicesIntent);
            }
        });
        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action
                // For example, navigate to the login screen
                Intent intent = new Intent(Servantprofile1.this, Servantlogin.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}
