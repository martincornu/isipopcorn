package com.alcedo.marty.isipopcorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    public MovieShowtime mMovieShowTime;

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
        mMovieShowTime = movieShowTime;
        this.setTitle(mMovieShowTime.getOnShow().getMovie().getTitle());
        Toast.makeText(DetailsActivity.this, mMovieShowTime.getOnShow().getMovie().getTitle(), Toast.LENGTH_SHORT).show();

        if (mMovieShowTime.getOnShow().getMovie().getTrailer() == null) {
            return;
        }

        //Set UI values
        setUIValues();

        String link = mMovieShowTime.getOnShow().getMovie().getTrailer().getHref().replace("watch?v=", "embed/");
        String frameVideo = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" + link + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        displayYoutubeVideo.setWebChromeClient(new MyChrome());
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
    }

    //Set UI Values
    public void setUIValues() {
        TextView details_duration = (TextView) findViewById(R.id.details_duration);
        TextView details_category = (TextView) findViewById(R.id.details_category);
        TextView details_country = (TextView) findViewById(R.id.details_country);

        Integer totalSecs = this.mMovieShowTime.getOnShow().getMovie().getRuntime();
        Integer hours = totalSecs / 3600;
        Integer minutes = (totalSecs % 3600) / 60;
        details_duration.setText(hours + "h" + minutes);

        details_category.setText(this.mMovieShowTime.getOnShow().getMovie().getGenre().get(0).getName());
        details_country.setText(this.mMovieShowTime.getVersion().getName());
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


    //Use to enable full screen mode for trailer's web view
    class Browser_home extends WebViewClient {

        Browser_home() {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            setTitle(view.getTitle());
            super.onPageFinished(view, url);

        }
    }

    //Use to enable full screen mode for trailer's web view
    private class MyChrome extends WebChromeClient {

        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChrome() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
