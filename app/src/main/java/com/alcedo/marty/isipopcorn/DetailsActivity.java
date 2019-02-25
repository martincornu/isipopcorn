package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // To retrieve object in second Activity
        Intent i = getIntent();
        MovieShowtime movieShowTime = (MovieShowtime)i.getSerializableExtra("movie_object");

    }
}
