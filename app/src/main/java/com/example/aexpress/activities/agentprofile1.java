package com.example.aexpress.activities;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aexpress.R;

public class agentprofile1 extends Activity {

    private ImageView profilePicture;
    private Button changePictureButton;
    private EditText username1;
    private EditText mobileNumber1;
    private EditText address1;
    private EditText nid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profilePicture = findViewById(R.id.profilePicture);
        changePictureButton = findViewById(R.id.changePictureButton);
        username1= findViewById(R.id.username);
        mobileNumber1 = findViewById(R.id.mobileNumber);
        address1 = findViewById(R.id.address);
        nid1 = findViewById(R.id.nid);

        // Set an onClickListener for the profile picture and button
        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        changePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle change picture button click
                // You can implement your logic here, like opening a gallery to choose a picture.
            }
        });
    }
}
