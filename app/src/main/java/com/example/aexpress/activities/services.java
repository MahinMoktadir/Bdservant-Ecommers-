package com.example.aexpress.activities;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.aexpress.R;

public class services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        // Find the CardView for the header
        CardView headerCardView = findViewById(R.id.headerCardView);

        // You can set elevation and corner radius for the CardView here
        headerCardView.setCardElevation(4);
        headerCardView.setRadius(4);

        // You can also add content to the CardView if needed
        // For example, you can dynamically add views to the CardView
        // or set its content using a layout file.
    }
}
