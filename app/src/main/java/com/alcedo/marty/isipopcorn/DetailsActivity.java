package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    public Movie mMovie;

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
        this.setTitle(mMovie.getTitle());
        Toast.makeText(DetailsActivity.this, mMovie.getTitle(), Toast.LENGTH_SHORT).show();

        String frameVideo = "<html><body><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
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
