package com.example.aexpress.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aexpress.R;

public class agentoption extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentoption);

        // Find the "Continue as Customer" button and set a click listener
        Button servant = findViewById(R.id.servantButton);
        servant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the CustomerActivity
                Intent intent = new Intent(agentoption.this, Servantlogin.class);
                startActivity(intent);
            }
        });

        // Find the "Continue as Servant" button and set a click listener
        Button agent = findViewById(R.id.agentbutton);
        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the ServantActivity
                Intent intent = new Intent(agentoption.this,agentlogin.class);
                startActivity(intent);
            }
        });
    }
}
