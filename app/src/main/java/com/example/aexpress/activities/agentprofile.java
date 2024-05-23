package com.example.aexpress.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.example.aexpress.R;

import java.security.Provider;

public class agentprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentprofile);

        Button profileButton = findViewById(R.id.profileButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(agentprofile.this,agentprofile1.class);
                startActivity(profileIntent);
            }
        });
        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action
                // For example, navigate to the login screen
                Intent intent = new Intent(agentprofile.this, agentlogin.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}
