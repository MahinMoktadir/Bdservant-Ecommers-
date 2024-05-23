package com.example.aexpress.activities;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aexpress.R;

public class profile extends Activity {

    private ImageView profilePicture;
    private Button changePictureButton;
    private EditText username;
    private EditText mobileNumber;
    private EditText address;
    private EditText nid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profilePicture = findViewById(R.id.profilePicture);
        changePictureButton = findViewById(R.id.changePictureButton);
        username = findViewById(R.id.username);
        mobileNumber = findViewById(R.id.mobileNumber);
        address = findViewById(R.id.address);
        nid = findViewById(R.id.nid);

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
