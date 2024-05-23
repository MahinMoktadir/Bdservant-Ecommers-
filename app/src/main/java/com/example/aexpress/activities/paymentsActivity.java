package com.example.aexpress.activities;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aexpress.R;

public class paymentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        // Find the LinearLayout that holds the delivery sections
        LinearLayout profileLayout = findViewById(R.id.profileLayout);

        // Find the delete buttons and set click listeners for each
        ImageView deleteButton1 = findViewById(R.id.deleteButton1);
        ImageView deleteButton2 = findViewById(R.id.deleteButton2); // Add more buttons as needed

        deleteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the delete button click for the first delivery section
                // You can remove or hide the corresponding delivery section here
                profileLayout.removeViewAt(0);
            }
        });

        deleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the delete button click for the second delivery section
                // You can remove or hide the corresponding delivery section here
                profileLayout.removeViewAt(1);
            }
        });

        // Add more click listeners for additional delete buttons if needed
    }
}
