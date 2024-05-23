package com.example.aexpress.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aexpress.R;

public class options extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        // Find the "Continue as Customer" button and set a click listener
        Button customerButton = findViewById(R.id.customerButton);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CustomerActivity
                Intent intent = new Intent(options.this, customerlog.class);
                startActivity(intent);
            }
        });

        // Find the "Continue as Servant" button and set a click listener
        Button servantButton = findViewById(R.id.servantButton);
        servantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the ServantActivity
                Intent intent = new Intent(options.this,agentoption.class);
                startActivity(intent);
            }
        });
    }
}
