package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // To retrieve object
        Intent i = getIntent();
        MovieShowtime movieShowTime = (MovieShowtime)i.getSerializableExtra("movie_object");
        mMovie = movieShowTime.getOnShow().getMovie();
        Toast.makeText(DetailsActivity.this, mMovie.getTitle(), Toast.LENGTH_SHORT).show();
    }

    //Go back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
